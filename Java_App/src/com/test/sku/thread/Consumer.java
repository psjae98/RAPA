package com.test.sku.thread;

public class Consumer extends Thread {
	
	private Counter counter;
	public Consumer(Counter counter) {
		super("소비자");	
		this.counter=counter;
		this.setPriority(MAX_PRIORITY);// 우선순위 배정, 2개일땐 별 의미없음
	}
	@Override
	public void run() 
	{
		while (true) {
			counter.decrease();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
