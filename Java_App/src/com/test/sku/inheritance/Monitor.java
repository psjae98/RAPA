package com.test.sku.inheritance;

import java.util.Date;

public class Monitor extends Item {
double size;

	public Monitor() {
		
	}
	
public Monitor(String name, String made, int price, Date pDate, double size  ) {
	super(name,made,price,pDate);
	setSize(size);
	}


public Monitor(String name, String made, int price, String sDate, double size  ) {
	super(name,made,price,sDate);
	setSize(size);
}

private void setSize(double size) {
this.size= size;	
}
public double getSize() {
	return size;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString()+"\t"+size+"인치";
}



}


