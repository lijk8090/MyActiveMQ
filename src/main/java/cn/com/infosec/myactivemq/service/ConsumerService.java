package cn.com.infosec.myactivemq.service;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.infosec.myactivemq.entity.UserEntity;

@Component
public class ConsumerService {

	// 服务端
	@JmsListener(destination = "${spring.activemq.myqueue}")
	public void recvMsg(ActiveMQTextMessage obj) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		UserEntity user = mapper.readValue(obj.getText(), UserEntity.class);

		System.out.println("MyReceiver: " + user);
	}

	// 服务端
	@JmsListener(destination = "${spring.activemq.myqueue}")
	public void recvMsg1(ActiveMQTextMessage obj) throws Exception {

		System.out.println("MyReceiver1: " + obj.getText());
	}

	// 服务端
	@JmsListener(destination = "${spring.activemq.myqueue}")
	public void recvMsg2(ActiveMQTextMessage obj) throws Exception {

		System.out.println("MyReceiver2: " + obj.getText());
	}
}
