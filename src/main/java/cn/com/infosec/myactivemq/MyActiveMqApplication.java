package cn.com.infosec.myactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class MyActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyActiveMqApplication.class, args);
	}

}
