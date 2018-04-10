package com.ycxy.wdgj.config;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;

@Configuration
@AutoConfigureAfter(RabbitmqConfig.class)
public class TopicAmqpConfig {
	private static Logger logger=Logger.getLogger(TopicAmqpConfig.class);
	
	@Bean("topicTest1Container")
	public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
		SimpleMessageListenerContainer container=new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames("test");
		container.setMessageListener(exampleListener1());
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		return container;
	}
	
	@Bean("topicTest1Listener")
	public ChannelAwareMessageListener exampleListener1(){
		return new ChannelAwareMessageListener(){

			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				  System.out.println(String.format("topic:来消息啦:{%s}", new String(message.getBody())));
	                logger.debug(String.format("来消息啦:{%s}", new String(message.getBody())));
	                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			}
			
		};
	}
}
