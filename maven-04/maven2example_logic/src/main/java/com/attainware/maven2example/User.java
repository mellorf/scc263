package com.attainware.maven2example;

public class User {
	private int code;
	private String name;

	public User() {
		this.code = 0;
		this.name = null;
	}

	public void setCode(int code) { this.code = code; }
	public void setName(String name) { this.name = name; }

	public int getCode() { return this.code; }
	public String getName() { return this.name; }
}
