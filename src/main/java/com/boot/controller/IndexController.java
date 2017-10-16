package com.boot.controller;

//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.conf.ConfigSettings;
import com.boot.domain.wisely.WiselyMessage;
import com.boot.domain.wisely.WiselyResponse;
import com.boot.msg.MsgJMS;

@Controller
public class IndexController {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private ConfigSettings configSettings;
//	@Autowired
//	private JmsTemplate jmsTemplate;
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping("/index")
	public @ResponseBody String index() {
		String str = "bookAuthor: " + bookAuthor + ",bookName is " + bookName;
		str += "[configSettings]: " + configSettings.getAuthor() + ", " + configSettings.getName();
		return str;
	}
	
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage wiselyMessage) throws InterruptedException {
		Thread.sleep(3000);
		return new WiselyResponse("welcome to here! " + wiselyMessage.getName());
	}
	
//	@RequestMapping("/jmsSend")
//	public @ResponseBody String jmsSend() {
//		jmsTemplate.send("my-jms-destination", new MsgJMS());
//		return "sendJms";
//	}
//	
//	@RequestMapping("/rabbitSend")
//	public @ResponseBody String rabbitSend() {
//		rabbitTemplate.convertAndSend("rabbit-queue", "来自rabbitMq的问候");
//		return "sendRabbit";
//	}
}
