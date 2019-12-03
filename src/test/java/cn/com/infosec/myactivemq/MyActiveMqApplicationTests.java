package cn.com.infosec.myactivemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.infosec.myactivemq.entity.UserEntity;
import cn.com.infosec.myactivemq.service.ProducerService;

@SpringBootTest
class MyActiveMqApplicationTests {

	@Autowired
	ProducerService producer;

	@Test
	void testSender() throws Exception {

		UserEntity user = new UserEntity();
		producer.sendMsg(user);

		user.setUuid(61616);
		producer.sendMsg(user);
	}

}
