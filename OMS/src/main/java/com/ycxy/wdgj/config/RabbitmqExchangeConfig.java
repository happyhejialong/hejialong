package com.ycxy.wdgj.config;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 交换机配置类
 * @author TF
 *
 */
@Configuration
@AutoConfigureAfter(RabbitmqConfig.class)
public class RabbitmqExchangeConfig {
	private Logger logger=Logger.getLogger(RabbitmqExchangeConfig.class);
	
	/***
	 * 主题交换机
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin){
		TopicExchange contractTopicExchange=new TopicExchange("amq.topic");
		rabbitAdmin.declareExchange(contractTopicExchange);
		logger.info("主题交换机Bean初始化");
		return contractTopicExchange;
	}
	/**
	 * 直连交换机
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	DirectExchange contractDirectExchnageDurable(RabbitAdmin rabbitAdmin){
		DirectExchange contractDirectExchange=new DirectExchange("amq.direct");
		rabbitAdmin.declareExchange(contractDirectExchange);
		logger.info("完成直连交换机Bean初始化");
		return contractDirectExchange;
	}
	/***
	 * 测试队列实例化完成
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	Queue queue1(RabbitAdmin rabbitAdmin){
		Queue queue=new Queue("test",true);
		rabbitAdmin.declareQueue(queue);
		logger.info("测试队列初始化完成");
		return queue;
	}
	
	/***
	 * 测试队列绑定直连交换机路由key为test
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingQueueExchange(Queue queue,DirectExchange exchange){
		Binding binding=BindingBuilder.bind(queue).to(exchange).with("test");
		return binding;
	}
	
	/***
	 * 测试队列绑定主题交换机路由key为test
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingQueueExchange(Queue queue,TopicExchange exchange){
		Binding binding=BindingBuilder.bind(queue).to(exchange).with("test");
		return binding;
	}
}
