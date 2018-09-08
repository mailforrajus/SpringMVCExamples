package com.nt.command;

public class UserCommand {
	private String username;
	private String password;
	
	public UserCommand() {
		System.out.println("UserCommand:0-param constructor");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
