/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycxy.wdgj.common.OmsConstant;
import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.CalendarUtils;
import com.ycxy.wdgj.common.utils.CollectionUtils;
import com.ycxy.wdgj.common.utils.ConvertUtils;
import com.ycxy.wdgj.common.utils.IdMakerUtils;
import com.ycxy.wdgj.common.utils.LimitClauseUtils;
import com.ycxy.wdgj.common.utils.MathUtils;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.common.utils.TaoBaoClient;
import com.ycxy.wdgj.dao.CustomerMapper;
import com.ycxy.wdgj.dao.OnlineOrderMapper;
import com.ycxy.wdgj.dao.OnlineTradeMapper;
import com.ycxy.wdgj.dao.ShopMapper;
import com.ycxy.wdgj.dao.TradeCustomerMapper;
import com.ycxy.wdgj.dao.TradeGoodsMapper;
import com.ycxy.wdgj.dao.TradeOrderMapper;
import com.ycxy.wdgj.dao.TradeReceiverMapper;
import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.OptionDto.Series;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.dto.SrcDestTradeGoodsDto;
import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.model.Customer;
import com.ycxy.wdgj.model.Shop;
import com.ycxy.wdgj.model.TradeCustomer;
import com.ycxy.wdgj.model.TradeCustomerExample;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeGoodsExample;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.TradeOrderExample;
import com.ycxy.wdgj.model.TradeReceiver;
import com.ycxy.wdgj.model.TradeReceiverExample;
import com.ycxy.wdgj.service.ShopService;
import com.ycxy.wdgj.service.TradeOrderService;
import com.ycxy.wdgj.taobao.domain.OnlineOrder;
import com.ycxy.wdgj.taobao.domain.OnlineTrade;
import com.ycxy.wdgj.taobao.request.TradesSoldGetRequest;
import com.ycxy.wdgj.taobao.request.TradesSolgIncrementGetRequest;
import com.ycxy.wdgj.taobao.response.TradesSoldGetResponse;

/**
 * @since 2018年2月12日 下午1:29:13
 * @author hjl
 *
 */
@Service
public class TradeOrderServiceImpl implements TradeOrderService {
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Autowired
    private TradeGoodsMapper tradeGoodsMapper;
    @Autowired
    private TradeCustomerMapper tradeCustomerMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private TradeReceiverMapper tradeReceiverMapper;
    @Autowired
    private OnlineTradeMapper onlineTradeMapper;
    @Autowired
    private OnlineOrderMapper onlineOrderMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopService shopService;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 新增订单
     * 
     * @param tradeOrderDto
     *            订单所有信息
     * @throws Exception
     * 
     */
    @Override
    public void add(TradeOrderDto tradeOrderDto) throws Exception {
        addAll(tradeOrderDto);
    }

    public void addAll(TradeOrderDto tradeOrderDto) throws Exception {
        TradeOrder tradeOrder = tradeOrderDto.getTradeOrder();
        // 生成唯一的tradeId
        tradeOrder.setTradeId(IdMakerUtils.makeUniqueLong());
        // 设置订单状态
        tradeOrder.setTradeStatus((byte) 1);
        /** 插入主订单 **/
        // 插入是否成功标识
        int insertFlag = tradeOrderMapper.insert(tradeOrder);
        if (insertFlag != 1) {
            throw new OmsException("新建订单不为一，新建失败");
        }
        /** 插入子订单列表 **/
        // 插入子订单
        List<TradeGoods> tradeGoodsArr = tradeOrderDto.getTradeGoodsArr();
        if (ObjectUtils.isEmpty(tradeGoodsArr)) {
            throw new OmsException("商品列表不为空");
        }
        // 插入子订单
        for (int i = 0, j = tradeGoodsArr.size(); i < j; i++) {
            TradeGoods tradeGoods = tradeGoodsArr.get(i);
            if (tradeGoods == null) {
                continue;
            }
            tradeGoods.setTradeId(tradeOrder.getTradeId());
            tradeGoods.setSubTradeId(IdMakerUtils.makeUniqueLong());
            tradeGoodsMapper.insert(tradeGoods);
        }

        /** 插入客户档案交易快照与插入客户档案 **/
        TradeCustomer tradeCustomer = tradeOrderDto.getTradeCustomer();
        tradeCustomer.setTradeId(tradeOrder.getTradeId());
        // 若==null 则证明没有该客户的客户档案 则新建 若不为null 则有该客户档案只保存快照
        if (ObjectUtils.isEmpty(tradeCustomer.getCustomerId())) {
            tradeCustomer.setCustomerId(IdMakerUtils.makeUniqueLong());
            Customer customer = objectMapper.readValue(objectMapper.writeValueAsBytes(tradeCustomer), Customer.class);
            int insertCustomerFlag = customerMapper.insert(customer);
            if (insertCustomerFlag != 1) {
                throw new OmsException("插入客户档案失败");
            }
        }
        int tradeCustomerFlag = tradeCustomerMapper.insert(tradeCustomer);
        if (tradeCustomerFlag != 1) {
            throw new OmsException("插入订单交易快照失败");
        }
        /** 保存订单收货人信息 **/
        TradeReceiver receiver = tradeOrderDto.getTradeReceiver();
        receiver.setTradeId(tradeOrder.getTradeId());
        int insertTradeReceiverFlag = tradeReceiverMapper.insert(receiver);
        if (insertTradeReceiverFlag != 1) {
            throw new OmsException("插入订单收货人信息失败");
        }
        /** 保存支付信息 **/
    }

    /***
     * 通过主订单号查询订单全部信息
     * 
     * @param tradeId
     * @return
     * @throws Exception
     */
    public TradeOrderDto findAll(Long tradeId) throws Exception {
        TradeOrderDto tradeOrderDto = new TradeOrderDto();
        // 通过订单流水Id查询主订单信息
        TradeOrder tradeOrder = findTradeOrderByTradeId(tradeId);
        tradeOrderDto.setTradeOrder(tradeOrder);
        // 通过主订单id查询子订单
        List<TradeGoods> tradeGoodsArr = findTradeGoodsArrByTradeId(tradeId);
        tradeOrderDto.setTradeGoodsArr(tradeGoodsArr);
        // 通过主订单id查询订单收货人信息
        TradeReceiver tradeReceiver = findTradeReceiverByTradeId(tradeId);
        tradeOrderDto.setTradeReceiver(tradeReceiver);
        // 通过主订单id查询订单客户档案
        TradeCustomer tradeCustomer = findTradeCustomerByTradeId(tradeId);
        tradeOrderDto.setTradeCustomer(tradeCustomer);
        return tradeOrderDto;
    }

    /***
     * 通过订单流水id查询所有订单信息
     * 
     * @param id
     *            主订单流水id
     * @throws Exception
     */

    @Override
    public TradeOrderDto findAll(Integer id) throws Exception {
        TradeOrderDto tradeOrderDto = new TradeOrderDto();
        // 通过订单流水Id查询主订单信息
        TradeOrder tradeOrder = findTradeOrderByPrimaryKey(id);
        tradeOrderDto.setTradeOrder(tradeOrder);
        // 通过主订单id查询子订单
        List<TradeGoods> tradeGoodsArr = findTradeGoodsArrByTradeId(tradeOrder.getTradeId());
        tradeOrderDto.setTradeGoodsArr(tradeGoodsArr);
        // 通过主订单id查询订单收货人信息
        TradeReceiver tradeReceiver = findTradeReceiverByTradeId(tradeOrder.getTradeId());
        tradeOrderDto.setTradeReceiver(tradeReceiver);
        // 通过主订单id查询订单客户档案
        TradeCustomer tradeCustomer = findTradeCustomerByTradeId(tradeOrder.getTradeId());
        tradeOrderDto.setTradeCustomer(tradeCustomer);
        return tradeOrderDto;
    }

    /****
     * 通过主订单id查询订单客户档案快照
     * 
     * @param tradeId
     *            主订单id
     * @return
     * @throws OmsException
     */
    public TradeCustomer findTradeCustomerByTradeId(Long tradeId) throws OmsException {
        TradeCustomerExample example = new TradeCustomerExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        TradeCustomer tradeCustomer = CollectionUtils.getFirst(tradeCustomerMapper.selectByExample(example));
        if (ObjectUtils.isEmpty(tradeCustomer)) {
            throw new OmsException("客户档案交易快照为空");
        }
        return tradeCustomer;
    }

    /****
     * 通过主订单编号查询订单收货人信息
     * 
     * @param tradeId
     *            主订单id
     * @return
     * @throws OmsException
     */
    public TradeReceiver findTradeReceiverByTradeId(Long tradeId) throws OmsException {
        TradeReceiverExample example = new TradeReceiverExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        TradeReceiver tradeReceiver = CollectionUtils.getFirst(tradeReceiverMapper.selectByExample(example));
        if (ObjectUtils.isEmpty(tradeReceiver)) {
            throw new OmsException("订单收货人信息为空");
        }
        return tradeReceiver;
    }

    /***
     * 通过主订单流水id查询主订单信息
     * 
     * @param id
     *            流水id
     * @throws OmsException
     */
    public TradeOrder findTradeOrderByPrimaryKey(Integer id) throws Exception {
        TradeOrder tradeOrder = tradeOrderMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(tradeOrder)) {
            throw new OmsException("查无此主订单");
        }
        return tradeOrder;
    }

    /***
     * 通过主订单id查询子订单列表
     * 
     * @param tradeId
     *            主订单id
     * @return
     * @throws Exception
     */
    @Override
    public List<TradeGoods> findTradeGoodsArrByTradeId(Long tradeId) throws Exception {
        TradeGoodsExample tradeGoodsExample = new TradeGoodsExample();
        tradeGoodsExample.createCriteria().andTradeIdEqualTo(tradeId);
        List<TradeGoods> tradeGoodsArr = tradeGoodsMapper.selectByExample(tradeGoodsExample);
        if (ObjectUtils.isEmpty(tradeGoodsArr)) {
            throw new OmsException("该主订单无商品列表");
        }
        return tradeGoodsArr;
    }

    /***
     * 通过订单流水id逻辑删除订单
     * 
     * @param id
     *            订单流水id
     * @throws OmsException
     * 
     */
    @Override
    public void delete(Integer id) throws OmsException {
        // TODO Auto-generated method stub
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setId(id);
        tradeOrder.setIsDelete(OmsConstant.DELETE);
        int updateFlag = tradeOrderMapper.updateByPrimaryKeySelective(tradeOrder);
        if (updateFlag != 1) {
            throw new OmsException("订单下载失败，flag不为1");
        }
    }

    /***
     * 订单修改
     * 
     */
    public void update(TradeOrderDto tradeOrderDto) throws OmsException {
        TradeOrder tradeOrder = tradeOrderDto.getTradeOrder();
        // 修改主订单信息
        if (!ObjectUtils.isEmpty(tradeOrder)) {
            updateTradeOrder(tradeOrder);
        }
        // 修改订单商品列表信息
        List<TradeGoods> tradeGoodsArr = tradeOrderDto.getTradeGoodsArr();
        if (!ObjectUtils.isEmpty(tradeGoodsArr)) {
            for (TradeGoods tradeGoods : tradeGoodsArr) {
                updateTradeGoods(tradeGoods);
            }
        }
        // 修改收货人信息
        TradeReceiver tradeReceiver = tradeOrderDto.getTradeReceiver();
        if (!ObjectUtils.isEmpty(tradeReceiver)) {
            updateTradeReceiver(tradeReceiver);
        }
        // 修改订单客户快照
        TradeCustomer tradeCustomer = tradeOrderDto.getTradeCustomer();
        if (!ObjectUtils.isEmpty(tradeCustomer)) {
            updateTradeCustomer(tradeCustomer);
        }
    }

    /***
     * 修改主订单信息
     * 
     * @param tradeOrder
     *            主订单信息
     * @throws OmsException
     */
    public void updateTradeOrder(TradeOrder tradeOrder) throws OmsException {
        int updateTradeOrderFlag = tradeOrderMapper.updateByPrimaryKey(tradeOrder);
        if (updateTradeOrderFlag != 1) {
            throw new OmsException("主订单修改不为1");
        }
    }

    /***
     * 修改子订单信息
     * 
     * @param tradeGoods
     *            子订单信息
     * @throws OmsException
     */
    public void updateTradeGoods(TradeGoods tradeGoods) throws OmsException {
        int updateTradeGoodsFlag = tradeGoodsMapper.updateByPrimaryKey(tradeGoods);
        if (updateTradeGoodsFlag != 1) {
            throw new OmsException("子订单修改不为1");
        }
    }

    /***
     * 修改订单收货人信息
     * 
     * @throws OmsException
     * 
     */
    public void updateTradeReceiver(TradeReceiver tradeReceiver) throws OmsException {
        int updateTradeReceiverFlag = tradeReceiverMapper.updateByPrimaryKey(tradeReceiver);
        if (updateTradeReceiverFlag != 1) {
            throw new OmsException("订单收货人修改不为1");
        }
    }

    public void updateTradeCustomer(TradeCustomer tradeCustomer) throws OmsException {
        int updateTradeCustomerFlag = tradeCustomerMapper.updateByPrimaryKey(tradeCustomer);
        if (updateTradeCustomerFlag != 1) {
            throw new OmsException("订单客户档案快照修改不为1");
        }
    }

    /***
     * 通过条件查询订单
     * 
     * @param conditionDto
     *            条件+分页
     */
    @Override
    public List<TradeOrder> list(ConditionDto conditionDto) {
        TradeOrderExample example = handleTradeOrderExample(conditionDto);
        if(example!=null){
        	example.setOrderByClause("gmt_modified");
        }
        List<TradeOrder> tradeOrderList = tradeOrderMapper.selectByExample(example);
        return tradeOrderList;
    }

    /***
     * 订单审核
     * 
     * @param id
     *            订单流水id[]
     * @throws Exception
     */
    @Override
    public void verify(Integer[] ids) throws Exception {
        if (ObjectUtils.isEmpty(ids)) {
            throw new OmsException("请勾选id");
        }
        TradeOrderExample example = new TradeOrderExample();
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setTradeStatus((byte) 2);
        example.createCriteria().andIdIn(Arrays.asList(ids));
        int updateTradeOrderFlag = 0;
        // for (Integer id : ids) {
        // example.createCriteria().andIdEqualTo(id);
        // updateTradeOrderFlag += tradeOrderMapper.updateByExampleSelective(tradeOrder, example);
        // }

        updateTradeOrderFlag = tradeOrderMapper.updateByExampleSelective(tradeOrder, example);
        if (updateTradeOrderFlag != ids.length) {
            throw new OmsException("修改记录数与实际记录数不匹配");
        }

    }

    /**
     * 通过主订单号来查询订单信息
     * 
     * @param tradeId
     *            主订单号
     * @throws OmsException
     */
    @Override
    public TradeOrder findTradeOrderByTradeId(Long tradeId) throws Exception {
        TradeOrderExample example = new TradeOrderExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        TradeOrder tradeOrder = CollectionUtils.getFirst(tradeOrderMapper.selectByExample(example));
        if (ObjectUtils.isEmpty(tradeOrder)) {
            throw new OmsException("库中无该订单，请检查订单号是否正确");
        }
        return tradeOrder;
    }

    /****
     * 通过tradeOrder 生成条件
     * 
     * @param tradeOrder
     * @return
     */
    public TradeOrderExample getTradeOrderExampleByTradeOrder(TradeOrder tradeOrder) {
        TradeOrderExample example = new TradeOrderExample();
        if (tradeOrder != null) {
            if (tradeOrder.getTradeStatus() != null) {
                example.createCriteria().andTradeStatusEqualTo(tradeOrder.getTradeStatus());
            }
        }
        return example;
    }

    /****
     * 发货确认
     * 
     * @throws Exception
     */
    @Override
    public void send(Long tradeId, Double postFee) throws Exception {
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setTradeStatus((byte) 4);
        tradeOrder.setPostFee(postFee);
        TradeOrderExample example = new TradeOrderExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        int updateTradeStateFlag = tradeOrderMapper.updateByExampleSelective(tradeOrder, example);
        if (updateTradeStateFlag != 1) {
            throw new OmsException("修改订单状态不为1");
        }

    }

    /****
     * 下载淘系订单
     * 
     * @throws Exception
     */
    @Override
    public void install(Shop shop, TradesSoldGetRequest request) throws Exception {
        // TODO 对部分结果进行封装 request.set
        request.setDefaultValue("test");
        request.setSession("610101426d00383ef83bac1449df1302b7cc6fa5197e7082054718218");
        // 获取淘宝订单的信息
        TradesSoldGetResponse response = getTradesSoldGetJson(request.getTextParams());
        // 将淘宝订单插入数据库中
        insertOnlineTrade(response);
        // 将淘宝订单转换为需要的订单管家平台的订单信息
        List<TradeOrderDto> tradeOrderDtoList = ConvertUtils.convert(response);
        // 将转换好的订单插入到数据库中
        for (TradeOrderDto tradeOrderDto : tradeOrderDtoList) {
            addAll(tradeOrderDto);
        }

    }

    /****
     * 增量订单
     * 
     * @throws Exception
     */
    public void increment(Shop shop, TradesSolgIncrementGetRequest request) throws Exception {
        // TODO 对部分结果进行封装 request.set
        request.setTimestamp(format.format(new Date()));

        // 获取淘宝订单的信息
        TradesSoldGetResponse response = getTradesSoldGetJson(request.getTextParams());
        // TODO 判断 =》有则修改 无则新增
        // 将淘宝订单插入数据库中
        // insertOnlineTrade(response);

        // 将淘宝订单转换为需要的订单管家平台的订单信息
        List<TradeOrderDto> tradeOrderDtoList = ConvertUtils.convert(response);

        // TODO 判断 =》有则修改 无则新增
        // 将转换好的订单插入到数据库中
        for (TradeOrderDto tradeOrderDto : tradeOrderDtoList) {
            addAll(tradeOrderDto);
        }

    }

    /****
     * 从淘宝给的官方接口获取对应返回的json信息 并将其返回为对应的repsonse格式
     * 
     * @throws Exception
     */
    public TradesSoldGetResponse getTradesSoldGetJson(Map<String, String> params) throws Exception {
        TaoBaoClient client = new TaoBaoClient("test", "test", "taobao.trades.sold.get", "http://gw.api.tbsandbox.com/router/rest");
        String result = client.doHttpPost(params);

        TradesSoldGetResponse test = JSON.parseObject(result).getObject("trades_sold_get_response", TradesSoldGetResponse.class);
        TradesSoldGetResponse response = JSON.parseObject(result, TradesSoldGetResponse.class);
        return response;
    }

    /****
     * 将淘系订单插入其对应的数据库表中
     * 
     * @param response订单的所有信息
     *            一个订单一个订单的插入
     */
    public void insertOnlineTrade(TradesSoldGetResponse response) throws Exception {
        for (OnlineTrade trade : response.getTrades()) {
            int insertOnlineTradeFlag = onlineTradeMapper.insert(trade);
            if (insertOnlineTradeFlag != 1) {
                throw new OmsException("插入线上主订单失败，请稍后重试");
            }
            for (OnlineOrder order : trade.getOrders()) {
                int insertOnlineOrderFlag = onlineOrderMapper.insert(order);
                if (insertOnlineOrderFlag != 1) {
                    throw new OmsException("插入线上子订单失败，请稍后重试");
                }
            }
        }
    }

    /****
     * 订单拆分
     * 
     * @throws Exception
     */
    @Override
    public void split(SrcDestTradeGoodsDto srcDestTradeGoodsDto) throws Exception {
        // 主订单id
        Long tradeId = srcDestTradeGoodsDto.getSrcTradeGoodsArr()[0].getTradeId();
        // 原订单全部信息
        TradeOrderDto srcTradeOrderDto = findAll(tradeId);
        // 原订单货品列表
        TradeGoods[] srcTradeGoods = srcDestTradeGoodsDto.getSrcTradeGoodsArr();
        // 新订单货品列表
        TradeGoods[] destTradeGoods = srcDestTradeGoodsDto.getDestTradeGoodsArr();

        // 新的TradeOrderDto信息
        TradeOrderDto destTradeOrderDto = new TradeOrderDto();

        // 将原用户订单客户档案快照保存给目标
        srcTradeOrderDto.getTradeCustomer().setId(null);
        destTradeOrderDto.setTradeCustomer(srcTradeOrderDto.getTradeCustomer());
        // 将原用户订单收货信息快照保存给目标
        srcTradeOrderDto.getTradeReceiver().setId(null);
        destTradeOrderDto.setTradeReceiver(srcTradeOrderDto.getTradeReceiver());
        // 将原订单主订单信息赋值给新订单
        Integer srcId = srcTradeOrderDto.getTradeOrder().getId();
        TradeOrder tradeOrder = new TradeOrder();
        srcTradeOrderDto.getTradeOrder().setTradeId(null);
        srcTradeOrderDto.getTradeOrder().setId(null);
        srcTradeOrderDto.getTradeOrder().setGmtCreate(null);
        BeanUtils.copyProperties(srcTradeOrderDto.getTradeOrder(), tradeOrder);

        // 修改原订单货品列表信息
        List<TradeGoods> destTradeGoodsList = new ArrayList<TradeGoods>();
        List<TradeGoods> srcTradeGoodsList = new ArrayList<TradeGoods>();
        for (TradeGoods tradeGoods : srcTradeOrderDto.getTradeGoodsArr()) {
            tradeGoods.setId(null);
            // 目标 destTradeGoods
            for (TradeGoods destGoods : destTradeGoods) {
                if (tradeGoods.getGoodsId().equals(destGoods.getGoodsId())) {
                    TradeGoods cloneTradeGoods = new TradeGoods();
                    BeanUtils.copyProperties(tradeGoods, cloneTradeGoods);
                    cloneTradeGoods.setId(null);
                    if (destGoods.getSellCount() >= tradeGoods.getSellCount()) {
                        destTradeGoodsList.add(cloneTradeGoods);
                        srcTradeGoodsList.add(destGoods);
                        // srcTradeOrderDto.getTradeGoodsArr().remove(destGoods);
                    } else {
                        cloneTradeGoods.setSellCount(destGoods.getSellCount());
                        cloneTradeGoods.setBuyNum(destGoods.getSellCount());
                        cloneTradeGoods.setSellTotal(destGoods.getSellTotal());
                        destTradeGoodsList.add(cloneTradeGoods);
                        tradeGoods.setSellCount(tradeGoods.getSellCount() - destGoods.getSellCount());
                        tradeGoods.setBuyNum(tradeGoods.getSellCount());
                        tradeGoods.setSellTotal(tradeGoods.getSellTotal() - cloneTradeGoods.getSellTotal());
                    }
                }
            }
        }
        srcTradeOrderDto.getTradeGoodsArr().removeAll(srcTradeGoodsList);
        double totalMoney = 0;
        for (TradeGoods tradeGoods : destTradeGoodsList) {
            totalMoney = MathUtils.getAdd(totalMoney, tradeGoods.getSellTotal());
        }
        destTradeOrderDto.setTradeGoodsArr(destTradeGoodsList);
        // TODO
        tradeOrder.setTotalMoney(totalMoney);
        tradeOrder.setTaxFee(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getTaxFee(), new Double(2)));
        tradeOrder.setPostFee(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getPostFee(), new Double(2)));
        tradeOrder.setPayment(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getPayment(), new Double(2)));
        destTradeOrderDto.setTradeOrder(tradeOrder);
        // 将新订单信息插入
        addAll(destTradeOrderDto);
        // 删除原订单的主订单信息 然后再 新增原订单信息
        TradeOrder srcTradeOrder = srcTradeOrderDto.getTradeOrder();
        // TODO
        srcTradeOrder.setTotalMoney(MathUtils.getSub(srcTradeOrderDto.getTradeOrder().getTotalMoney(), totalMoney));
        srcTradeOrder.setTaxFee(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getTaxFee(), new Double(2)));
        srcTradeOrder.setPostFee(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getPostFee(), new Double(2)));
        srcTradeOrder.setPayment(MathUtils.divid(srcTradeOrderDto.getTradeOrder().getPayment(), new Double(2)));

        addAll(srcTradeOrderDto);
        updateTradeStatus(srcId, (byte) 50);

    }

    /****
     * 修改订单状态
     */
    public void updateTradeStatus(Integer id, Byte status) {
        TradeOrderExample example = new TradeOrderExample();
        example.createCriteria().andIdEqualTo(id);
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setTradeStatus(status);
        tradeOrderMapper.updateByExampleSelective(tradeOrder, example);
    }

    /***
     * 订单合并
     * 
     * @param 合并订单的id
     * @throws Exception
     */
    @Override
    public void merge(Integer[] ids) throws Exception {
        // TODO 校验规则
        TradeOrderDto srcTradeOrderDto1 = findAll(ids[0]);
        TradeOrderDto srcTradeOrderDto2 = findAll(ids[1]);
        TradeOrderDto destTradeOrderDto = new TradeOrderDto();

        List<TradeGoods> srcTradeGoodsArr1 = srcTradeOrderDto1.getTradeGoodsArr();
        List<TradeGoods> srcTradeGoodsArr2 = srcTradeOrderDto2.getTradeGoodsArr();

        // 重写equals方法 判断两个货品列表是否有相同的货品 有则改变数量 无责直接添加入srcTradeGoodsArr2中
        for (TradeGoods tradeGoods : srcTradeGoodsArr1) {
            if (srcTradeGoodsArr2.contains(tradeGoods)) {
                // 获取订单货品列表中的那个相同的对象
                System.out.println(srcTradeGoodsArr2.indexOf(tradeGoods));
                TradeGoods destTradeGood = srcTradeGoodsArr2.get(srcTradeGoodsArr2.indexOf(tradeGoods));
                destTradeGood.setSellCount(MathUtils.getAdd(destTradeGood.getSellCount(), tradeGoods.getSellCount()));
                destTradeGood.setBuyNum(destTradeGood.getSellCount());
                destTradeGood.setSellTotal(MathUtils.getAdd(tradeGoods.getSellTotal(), destTradeGood.getSellTotal()));
            } else {
                srcTradeGoodsArr2.add(tradeGoods);
            }
        }
        for (TradeGoods tradeGoods : srcTradeGoodsArr2) {
            tradeGoods.setId(null);
            tradeGoods.setTradeId(null);
            tradeGoods.setSubTradeId(null);
            tradeGoods.setSourceTradeNo(null);
            tradeGoods.setGmtCreate(null);
            tradeGoods.setGmtModified(null);
        }
        // 复制值
        BeanUtils.copyProperties(srcTradeOrderDto2, destTradeOrderDto);
        TradeOrder tradeOrder = destTradeOrderDto.getTradeOrder();
        destTradeOrderDto.getTradeCustomer().setId(null);
        destTradeOrderDto.getTradeReceiver().setId(null);
        // 将id部分设置为Null
        int srcId2 = tradeOrder.getId();
        tradeOrder.setId(null);
        // tradeOrder.setTradeId(null);
        tradeOrder.setTradeNo(null);
        tradeOrder.setSourceTradeId(null);
        tradeOrder.setSourceTradeNo(null);
        // 将金额部分全部累加
        tradeOrder.setPayment(MathUtils.getAdd(srcTradeOrderDto1.getTradeOrder().getPayment(), srcTradeOrderDto2.getTradeOrder().getPayment()));
        tradeOrder.setPostFee(MathUtils.getAdd(srcTradeOrderDto1.getTradeOrder().getPostFee(), srcTradeOrderDto2.getTradeOrder().getPostFee()));
        tradeOrder.setTaxFee(MathUtils.getAdd(srcTradeOrderDto1.getTradeOrder().getTaxFee(), srcTradeOrderDto2.getTradeOrder().getTaxFee()));
        tradeOrder.setTotalMoney(MathUtils.getAdd(srcTradeOrderDto1.getTradeOrder().getTotalMoney(), srcTradeOrderDto2.getTradeOrder().getTotalMoney()));
        tradeOrder.setGmtCreate(null);
        tradeOrder.setGmtModified(null);
        // 将新订单插入
        addAll(destTradeOrderDto);
        // 将之前的订单状态位设置为60=>合并
        updateTradeStatus(srcTradeOrderDto1.getTradeOrder().getId(), (byte) 60);
        updateTradeStatus(srcId2, (byte) 60);
    }

    /***
     * 查看单个店铺的一周情况
     */
    public Series countOneShop(Long shopId) {
        OptionDto optionDto = new OptionDto();
        Shop shop = shopService.detail(shopId);
        int days = CalendarUtils.getDayOfWeekBefore(new Date());
        Series tempSeries = new Series();
        Double[] totalMoneys = new Double[days];
        for (int i = 0; i < days; i++) {
            Double totalMoney = tradeOrderMapper.selectShopCount(i, shop.getShopId());
            totalMoneys[i] = totalMoney == null ? 0 : totalMoney;
        }
        tempSeries.setName(shop.getShopName());
        tempSeries.setTotalMoney(totalMoneys);

        return tempSeries;
    }

    /***
     * 订单统计一周
     */
    @Override
    public OptionDto count() {
        OptionDto optionDto = new OptionDto();

        // TradeOrderExample tradeOrderExample = new TradeOrderExample();
        // tradeOrderExample.createCriteria().andGmtCreateBetween(dates[0], dates[1]);
        int days = CalendarUtils.getDayOfWeekBefore(new Date());

        List<Shop> shopList = shopService.findShopList(132456789L);
        List<Series> series = optionDto.getSeries();
        for (int j = 0; j < shopList.size(); j++) {
            Series tempSeries = new Series();
            Double[] totalMoneys = new Double[days];
            int index = 0;
            for (int i = days - 1; i > -1; i--) {
                Double totalMoney = tradeOrderMapper.selectShopCount(i, shopList.get(j).getShopId());
                totalMoneys[index++] = totalMoney == null ? 0 : totalMoney;
            }
            tempSeries.setName(shopList.get(j).getShopName());
            tempSeries.setTotalMoney(totalMoneys);
            series.add(tempSeries);
        }
        optionDto.setxAxisData(CalendarUtils.getDaysOfWeek(new Date()));
        optionDto.setSeries(series);
        return optionDto;
    }
    /**
     * 将conditionDto条件封装
     * @param conditionDto
     * @return
     */
    public TradeOrderExample handleTradeOrderExample(ConditionDto conditionDto){
    	if(ObjectUtils.isEmpty(conditionDto)){
    		return null;
    	}
    	TradeOrderExample tradeOrderExample=new TradeOrderExample();
    	PageInfo pageInfo=conditionDto.getPageInfo();	
    	if(pageInfo!=null){
    		tradeOrderExample.setLimitByClause(LimitClauseUtils.limit(pageInfo.getPageIndex(), pageInfo.getPageSize()));
    	}
    	TradeOrder tradeOrder=conditionDto.getTradeOrder();
    	
    		if(conditionDto.getOneTimeBegin()!=null && conditionDto.getOneTimeEnd()!=null){
    			tradeOrderExample.createCriteria().andGmtCreateBetween(conditionDto.getOneTimeBegin(), conditionDto.getOneTimeEnd());
    		}else if(conditionDto.getOneTimeBegin()!=null){
    			tradeOrderExample.createCriteria().andGmtCreateGreaterThanOrEqualTo(conditionDto.getOneTimeBegin());
    		}else if(conditionDto.getOneTimeEnd()!=null){
    			tradeOrderExample.createCriteria().andGmtCreateLessThan(conditionDto.getOneTimeEnd());
    		}
    		
    		//TODO  没有付款时间字段
    		if(conditionDto.getTwoTimeBegin()!=null && conditionDto.getTwoTimeEnd()!=null){
    			tradeOrderExample.createCriteria().andPayTimeBetween(conditionDto.getTwoTimeBegin(), conditionDto.getTwoTimeEnd());
    		}else if(conditionDto.getTwoTimeBegin()!=null){
    			tradeOrderExample.createCriteria().andGmtCreateGreaterThanOrEqualTo(conditionDto.getTwoTimeBegin());
    		}else if(conditionDto.getTwoTimeEnd()!=null){
    			tradeOrderExample.createCriteria().andGmtCreateLessThan(conditionDto.getTwoTimeEnd());
    		}
    		if(tradeOrder!=null){
	    		if(tradeOrder.getTradeType()!=null){
	    			tradeOrderExample.createCriteria().andTradeTypeEqualTo(tradeOrder.getTradeType());
	    		}
	    		
	    		if(tradeOrder.getShopId()!=null){
	    			tradeOrderExample.createCriteria().andShopIdEqualTo(tradeOrder.getShopId());
	    		}
	    		
	    		if(tradeOrder.getLogisticsid()!=null){
	    			tradeOrderExample.createCriteria().andLogisticsidEqualTo(tradeOrder.getLogisticsid());
	    		}
	    		
	    		if(tradeOrder.getTradeStatus()!=null){
	    			tradeOrderExample.createCriteria().andTradeStatusEqualTo(tradeOrder.getTradeStatus());
	    		}
    		}
    		if(conditionDto.getLikeField()!=null){
    			StringBuilder likeFiled=new StringBuilder(" ( ");
    			likeFiled.append(conditionDto.getLikeField().getLikeFieldName()+" like '%");
    			likeFiled.append(conditionDto.getLikeField().getLikeFieldValue()+"%' )");
    			//tradeOrderExample.setLikeByClause(likeFiled.toString());
    		}
    	
    	return tradeOrderExample;
    }

}
