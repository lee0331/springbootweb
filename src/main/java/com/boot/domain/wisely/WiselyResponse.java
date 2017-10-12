package com.boot.domain.wisely;

/**
 * 服务端向浏览器发送消息
 * @author xingwuzhao
 *
 */
public class WiselyResponse {
	
	private String responseMessage;
	
	public WiselyResponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
