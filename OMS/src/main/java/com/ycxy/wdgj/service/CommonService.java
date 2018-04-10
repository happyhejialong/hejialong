package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.dto.Express;
import com.ycxy.wdgj.dto.LogisticsInfo;

public interface CommonService {

    LogisticsInfo findLogisticsInfo(String logisticsId, String expCode) throws Exception;

    /**
     * @param emails
     * @param message
     */
    void sendEmail(String[] emails, String message, String subject) throws Exception;

    /**
     * 智选物流
     * 
     * @param tradeId
     * @return
     */
    List<Express> intelSelectionLogistic(Long tradeId) throws Exception;

}
