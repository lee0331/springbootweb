package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.conf.ConfigSettings;

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
}
