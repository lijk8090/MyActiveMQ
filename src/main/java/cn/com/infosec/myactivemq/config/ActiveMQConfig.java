package cn.com.infosec.myactivemq.config;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class ActiveMQConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.activemq.myqueue}")
	private String myqueue;

	@Bean
	public Topic topic() {
		logger.info("topic");

		return new ActiveMQTopic(myqueue);
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory factory) {
		logger.info("jmsTemplate");

		JmsTemplate jmsTemplate = new JmsTemplate(factory);
		jmsTemplate.setPubSubDomain(true);

		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		jmsTemplate.setMessageConverter(converter);

		return jmsTemplate;
	}
}
