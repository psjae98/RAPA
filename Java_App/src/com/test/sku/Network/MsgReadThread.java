package com.test.sku.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MsgReadThread extends Thread{
	ObjectInputStream ois;
	static ChatMsg chatMsg;
	public MsgReadThread() {}

	public MsgReadThread(ObjectInputStream ois) 
	{
			this.ois=ois;
	}

	@Override
	public void run() {
		 
		try {
		
			while(true) {
				ChatMsg cm=(ChatMsg)ois.readObject();	
				System.out.println("["+cm.uid+"]"+cm.msg);	
			
				if(cm.fdata!=null&&cm.fdata.length>0) {
					chatMsg=cm;
					System.out.println("첨부파일("+cm.fname+") 다운로드(y/n):");
				}
			
			}
		} catch (Exception e) {
		//e.printStackTrace();
		}
		 System.err.println("MsgReadThread dead");
	
		
	}


		
		
		
	
}
