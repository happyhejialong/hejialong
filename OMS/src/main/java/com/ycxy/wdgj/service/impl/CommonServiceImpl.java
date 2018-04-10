package com.ycxy.wdgj.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.JSONUtils;
import com.ycxy.wdgj.common.utils.KdniaoUtils;
import com.ycxy.wdgj.dto.Express;
import com.ycxy.wdgj.dto.LogisticsInfo;
import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private TradeOrderServiceImpl tradeOrderService;
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender sender;

    /**
     * 查询物流信息
     * 
     * @param logisticsId
     *            运单号
     * @param expCode
     *            物流方式
     */
    @Override
    public LogisticsInfo findLogisticsInfo(String logisticsId, String expCode) throws Exception {
        String result = KdniaoUtils.query(expCode, logisticsId);
        LogisticsInfo logisticsInfo = objectMapper.readValue(result, LogisticsInfo.class);
        return logisticsInfo;
    }

    /***
     * 给指定的邮箱发送信息
     * 
     * @param emails
     *            邮箱
     * @param message
     *            发送的信息
     * @throws Exception
     */
    @Override
    public void sendEmail(String[] emails, String message, String subject) {
        for (String email : emails) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setSubject(subject);
            msg.setText(message);
            try {
                msg.setTo(emails);
                sender.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /***
     * 通过订单号智能选择物流
     * 
     * @param tradeId
     * @return
     * @throws OmsException
     */
    @Override
    public List<Express> intelSelectionLogistic(Long tradeId) throws Exception {
        if (ObjectUtils.isEmpty(tradeId)) {
            throw new OmsException("订单号不为空");
        }

        TradeOrderDto tradeOrderDto = tradeOrderService.findAll(tradeId);
        // 将订单信息传入requestData方便快递鸟查询合适的物流方式,获取返回的json
        String result = KdniaoUtils.getExpRecommendByJson(tradeOrderDto);
        System.out.println(result);
        JsonNode jsonNode = objectMapper.readTree(result).get("RecommendDetail").get(0).get("ExpressList");
        // 转换成对应的物流Dto的格式

        List<Express> expressList = Arrays.asList(JSONUtils.converStrToObject(jsonNode.toString(), Express[].class));
        return expressList;
    }

}
