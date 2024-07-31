package com.test.sku.Network2;

import java.io.Serializable;
import java.util.List;

public class ChatMsg implements Serializable{
	String yesno;
	boolean delete;
	String newName;
	String newDescription;
	int no; 
	String fname;
     byte[] fdata;
	String message;
	String from;
	String to;
    String menu;
    String author;
    boolean upload;
    boolean list;
    boolean find;
    boolean update;
    String description;
    List<FileInfo> fileInfoList;
    public ChatMsg() {}
    
    public ChatMsg(String from, String to, String message) {
		this.from =from;
		this.to=to;
		this.message=message;
	}
    public ChatMsg(String menu) {
    	this.menu=menu;
	}
    public ChatMsg(String from, String to, String message, String fname) {
		this.from =from;
		this.to=to;
		this.message=message;
		this.fname=fname;
	}
	public ChatMsg(boolean upload, String fname,byte[] fdata ,String author,String description) {
	this.upload=upload;
	this.fname=fname;
	this.fdata=fdata;
	this.author=author;
	this.description=description;
	}

	public ChatMsg(String from, String to, List<FileInfo> fileInfoList) {
		this.from =from;
		this.to=to;
		this.fileInfoList=fileInfoList;
	}
	public ChatMsg(boolean find, int no) {
		this.find =find;
		this.no=no;
	}
	public ChatMsg(boolean update, int no, String newName, String newDescription) {
		this.update=update;
		this.no=no;
		this.newName=newName;
		this.newDescription=newDescription;
	}
	public ChatMsg(boolean delete, int no,String yesno) {
		this.delete =delete;
		this.no=no;
		this.yesno=yesno;
		
	}
}
