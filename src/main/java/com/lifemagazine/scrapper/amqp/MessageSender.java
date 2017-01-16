package com.lifemagazine.scrapper.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifemagazine.scrapper.domain.CheckSchedLog;

@Service
public class MessageSender {

	private static final Logger LOG = LoggerFactory.getLogger(MessageSender.class);
	
	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public MessageSender(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(CheckSchedLog checkSchedLog) {
		LOG.debug("sending message...");
		this.rabbitTemplate.convertAndSend(MsgQueueConfig.queueName, checkSchedLog);
	}
}
