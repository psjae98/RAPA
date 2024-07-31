package com.test.sku.Network;

import java.io.Serializable;

public class ChatMsg implements Serializable //직렬화할때 implements Serializable 해줘야함
{	String fname;
	byte[] fdata;
	String uid;
	String pwd;
	boolean login;
	boolean isFile;
	boolean isSecret;
	String from;
	String to;
	String msg;

	
	public ChatMsg() {}
	
	public ChatMsg(boolean login, String uid, String pwd) {
	this.login=login;
	this.uid=uid;
	this.pwd=pwd;
	}
	public ChatMsg(String from, String to, String msg) {
		this.from =from;
		this.to=to;
		this.msg=msg;
	}
	public ChatMsg(String from, String to, String msg, String fname) {
		this.from =from;
		this.to=to;
		this.msg=msg;
		this.fname=fname;
	}

}
