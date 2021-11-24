package com.airhacks.beans;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MessageGenerator {
	public String getMessage() {
		String returnMessage = "jakukaku";
		return returnMessage;
	}
}
