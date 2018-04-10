package com.ycxy.wdgj.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ycxy.wdgj.common.utils.IdMakerUtils;

@Component
public class RabbitMqSender implements RabbitTemplate.ConfirmCallback {
	private static Logger logger=Logger.getLogger(RabbitMqSender.class);
	
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	public RabbitMqSender(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate=rabbitTemplate;
		this.rabbitTemplate.setConfirmCallback(this);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean arg1, String arg2) {
		  logger.info("confirm: " + correlationData.getId());
		
	}
	/***
	 * 发送到 指定routekey的指定queue
	 * @param routeKey
	 * @param obj
	 */
	public void sendRabbitmqDirect(String routeKey, Object obj){
		CorrelationData correlationData=new CorrelationData(IdMakerUtils.makeUniqueString());
		logger.info("send: " + correlationData.getId());
		this.rabbitTemplate.convertAndSend("amq.direct", routeKey, obj, correlationData);
	}
	/***
	 * 发送到 指定routekey的指定queue
	 * @param routeKey
	 * @param obj
	 */
	public void sendRabbitmqTopic(String routeKey, Object obj){
		CorrelationData correlationData=new CorrelationData(IdMakerUtils.makeUniqueString());
		logger.info("send: " + correlationData.getId());
		this.rabbitTemplate.convertAndSend("amq.topic", routeKey, obj, correlationData);
	}
}
