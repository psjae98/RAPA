package com.test.sku.inheritance;

import java.util.Date;

public class Mouse extends Item 
{

	String wireless;
	
	public Mouse() {}
	
	public Mouse(String name, String made, int price, Date pDate, String wireless) 
	{
		super(name,made,price,pDate);//super():상위클래스의 생성자  super.:부모에게 있는 메소드
		setWireless(wireless);
	}
	
	public Mouse(String name, String made, int price, String sDate, String wireless) {
		super(name,made,price,sDate);
		setWireless(wireless);
	}

	public String getWireless() {
		return wireless;
	}

	public void setWireless(String wireless) {
		this.wireless = wireless;
	}

	@Override
	public String toString() {
		
		return super.toString()+"\t"+wireless;
	}
	
}
