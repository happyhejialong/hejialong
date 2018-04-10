package com.ycxy.wdgj.controller;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.dto.Express;
import com.ycxy.wdgj.dto.LogisticsInfo;
import com.ycxy.wdgj.service.CommonService;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @GetMapping("/findLogisticsInfo")
    public OmsResponse<LogisticsInfo> findLogisticsInfo(@NotEmpty String logisticsId, @NotEmpty String expCode) {
        OmsResponse<LogisticsInfo> or = new OmsResponse<LogisticsInfo>();
        try {
            // BindingResultHelper.cacheExceptions(result);
            LogisticsInfo logisticsInfo = commonService.findLogisticsInfo(logisticsId, expCode);
            or.getResult().setData(logisticsInfo);
            new WebSocketController().sendMessage("helloworld");
        } catch (Exception e) {
            or.setCode(e.hashCode());
            or.setMsg("查询物流信息失败:" + e.getMessage());
        }
        return or;
    }

    /***
     * 发送邮件
     * 
     * @param emails
     *            目标的email
     * @param message
     *            右键内容
     * @param subject
     *            主题
     * @return
     */
    @PostMapping("/sendEmail")
    public OmsResponse<Object> sendEmail(String emails, String message, String subject) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            commonService.sendEmail(emails.split(","), message, subject);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /***
     * 通过订单号智能选择物流
     * 
     * @param tradeId
     * @return
     */
    @GetMapping("/getExpRecommend")
    public OmsResponse<List<Express>> intelSelectionLogistic(Long tradeId) {
        OmsResponse<List<Express>> or = new OmsResponse<List<Express>>();
        try {
            List<Express> expressList = commonService.intelSelectionLogistic(tradeId);
            or.getResult().setData(expressList);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }
}
