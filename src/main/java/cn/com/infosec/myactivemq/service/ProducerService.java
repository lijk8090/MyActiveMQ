package cn.com.infosec.myactivemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Value("${spring.activemq.myqueue}")
	private String myqueue;

	@Autowired
	private JmsTemplate jmsTemplate;

	// 客户端
	public void sendMsg(Object obj) throws Exception {

		System.out.println("MySender: " + obj);
		jmsTemplate.convertAndSend(myqueue, obj);
	}

}
