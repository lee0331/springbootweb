package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.conf.ConfigSettings;
import com.boot.domain.wisely.WiselyMessage;
import com.boot.domain.wisely.WiselyResponse;

@Controller
public class IndexController {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private ConfigSettings configSettings;
	
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
}
