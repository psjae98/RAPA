package com.test.sku.thread;

import java.util.Date;

public class DateThread extends Thread {
	public DateThread(String name) 
	{
		super(name);
	}
	@Override
	public void run() 
	{
		
		 for (int i=0;i<10;i++) {
			 System.out.println("현재 날짜 및 시간:"+new Date());
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		 }
	}

}
