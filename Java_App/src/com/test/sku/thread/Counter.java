package com.test.sku.thread;

public class Counter 
{
	int cnt=5;
	/*cnt의 값이 항상 5~10을 유지하도록 스레드를 제어
	 * cnt==5 가 되면 소비를 멈추고 생산이 되어야함
	 * cnt==10 이 되면 생산을 멈추고 소비가 되어야함
	 * cnt가 5가되면 소비 스레드는 기다려야 한다(wait();)
	 * cnt가 10이되면 생산 스레드는 기다려야 한다(wait();)
	 * cnt가 5가되면 생산자에게 통지를 전해야 한다(notify();)
	 * 
	 * 
	 */
	public synchronized void increase() //synchronized 쓰면 하나 실행될동안 나머지 실행안됨(lock flag)
	{
		if (cnt>=10)
		try {
			this.notify();
			this.wait();	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		System.out.println("올리기 전:"+cnt);
		cnt++;
		System.out.println("올린 후:"+cnt);
		

	}
	//setPriority
	public synchronized void decrease() 
	{if (cnt<=5)
		try {
			this.notify();
			this.wait();		//cnt가 5이하면 대기
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	
		
		System.out.println("내리기 전:"+cnt);
		cnt--;
		System.out.println("내린 후:"+cnt);
		

	}
}
