package com.test.sku.thread;

public class ThreadMain {

	public static void main(String[] args) {
		/*thread: VCPU(Virtual CPU)
		 * multitasking
		 *chat: 이용자가 메시지를 출력. 다른 컴퓨터에서 메시지를 입력하는것
		 * Thread 는 VCPU이므로 지정된 코드를 할당하여 실행할 수 있다
		 * Thread 는 VCPU이므로 자신만의 Stack을 가지고 지역변수를 생성한다
		 * Threadrk 실행할 수 있는 코드는 실행가능(Runnable) 인터페이스 구현체여야한다
		 * 
		 */
		//threadTest02();
		Counter cnt = new Counter();
		Producer prod= new Producer(cnt);
		Consumer cons= new Consumer(cnt);
		
		prod.start();
		cons.start();
		System.out.println("main프로그램 종료");
		
	}

	private static void threadTest01() 
	{
		Thread t1= new Thread(new RunnableImp01(),"수올리기 쓰레드");// ""에 있는 내용은 쓰레드 내용 설명ㄷㄷㄷㄷ
		t1.start();
		Thread t2= new Thread(new Run2(),"날짜 쓰레드");
		t2.start();
		
	}
	
	private static void threadTest02() 
	{	
		DateThread dt= new DateThread("날짜 스레드");
		NumThread nt= new NumThread("숫자 스레드");
		
		dt.start();
		nt.start();
	
		
	}
	
	
	
}
