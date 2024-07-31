package com.test.sku;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;
public class Day0705 {

	public static void main(String[] args) {
	/*
	boolean go = true;
	int i=0;
	while(go)
	{
	i++;
	go=i<10 ? true : false;
	System.out.println(i+" ");
	}
	*/
	 //RandomGugu();
		//sumuntil();
		//onefiveone();
		//incDec();
		//geteven5();
		//ifTest();
		//variableInt();
		idpw();
		//switchTest();
		//forloopTest();
	}

private static void incDecTest() //camel case, snake case
{
	//Increment, Decrement operator
	int v=0;
	v++;
	System.out.println(v);
	++v;
	System.out.println(v);
	
	System.out.println(v++); //후증가 연산자
	System.out.println(v);
	
	System.out.println(++v); //전증가 연산자
	System.out.println(v);
}
private static void printGugu()
{
	int i =5;
	int j=0;
	
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	System.out.printf("%d * %d = %d\n",i,++j,i*j);
	
	
	
	

}
private static void printGugu7()
{
	int dan =7;
	int i=1;
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);
	System.out.printf("%d * %d = %d\n",dan,i,dan*i++);



}
private static void inputDanPrint() {
	
Scanner dan= new Scanner(System.in);
System.out.printf("몇단을 해볼까요?");
int i= dan.nextInt();
int j = 1;
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
System.out.printf( "%d*%d=%d\n",i,j,i*j++);
	
}

private static void compare(){
	int i=5;
	int j=1;
	
System.out.println(i ==j);
System.out.println(i !=j);
System.out.println(i <j);
System.out.println(i >j);


}

//키보드에서 수를 입력 받아서 홀수인지 짝수인지

private static void compare2(){
	Scanner num= new Scanner(System.in);
	System.out.printf("수를 입력하세요");
	int i= num.nextInt();
	String result= i%2==0 ? "은(는) 짝수입니다." : "은(는) 홀수입니다.";
	System.out.printf("%d%s",i,result);
}
private static void logicAnd(){

	boolean res= true&& true;  //true
	res= true&& false;		   //false  
	res= false&&true;  			//false  &&는 앞에가  false면 뒤에거 검사안함(단축논리연산자)
	res= false&true;			//비단축논리AND
	res= true || true;		   //true
	res= true || false;		   //true,||는 앞에가  true면 뒤에거 검사안함(단축논리연산자)
	res= false || true;		   //true
	res= false || false;		//false
	res = true | false;  		//비단축논리OR
}

//무작위 정수 2개를 추출항 둘다 홀수라면 "유효한수"/"무효한수"
private static void logical(){
	Random rd= new Random();
	rd.nextInt(100);
	int i=rd.nextInt(100);
	int j=rd.nextInt(100);
	
	String res= i%2==1&&j%2==1 ? "유효한 수":"무효한 수";
	
	String msg= String.format("%d,%d는 %s",i,j,res);
	System.out.println(msg);
}
//무작위 정수 2개를 추출항 둘다 짝수가 아니라면 "유효한수"/"무효한수"(논리부정연산자(!), !true)
//키보드에서 아이디 패스워드를 입력 받아서 아이디가 smith 비번이 1234 가 맞으면 로그인 성공/아니면 로그인 실패
private static void logical2(){
	Scanner kb= new Scanner(System.in);
	System.out.printf("아이디:");
	String id= kb.next();

	System.out.printf("비밀번호:");
	String pw= kb.next();

	boolean idresult = id.equals("smith") ;
	boolean pwresult = pw.equals("1234") ;

	String res= !(idresult && pwresult) ? "로그인실패":"로그인 성공";
	
	
	System.out.println(res);

}
private static void bitshift() {
	int a=1;
	int b= a<<1;
	System.out.println(b);
	
	b= a<<2;
	System.out.println(b);
	
	b= a<<3;
	System.out.println(b);
	
}
private static void RandomGugu() {
	
	Random rd= new Random();
	rd.nextInt(8);
	int i=rd.nextInt(8)+2;
	int j=0;
	boolean go = true;
	while(go)
	{
	System.out.printf("%d*%d = %d\n",i,++j,i*j);
	go= j==9 ? false : true;
	}
	
}

private static void sumuntil() {
	Random rd= new Random();
	rd.nextInt(10);
int i=rd.nextInt(10);
int start= i;
int sum=0;

while (i<=10) {
	sum+=i;
	i=i+1;

	
}
System.out.printf("%d부터 10까지 합산:%d\n",start,sum);	
	
}
private static void onefiveone() {
	int i =1;
	while(i<5) {
	System.out.printf("%d ",i++);
	}
	while(i>0) {
		System.out.printf("%d ",i--);
	}
}
private static void incDec() {
	int i =1;
	int delta=1;
	int cnt=0;
	
	while(i>0) {
		System.out.printf("%d ",i);
		cnt++;
		delta=cnt>=5 ? -1 : 1 ;
		i+=delta;
	}
}
//while문 사용하여 무작위 수 중에서 짝수 5개 출력하기
private static void geteven5() {
	Random rd= new Random();
	rd.nextInt(20);

	
	int evencount=0;
	
	while(evencount<5) {
		int i=rd.nextInt(20)+1;
		String s=i%2==0 ?i+" " :"" ; 
		System.out.print(s);
		evencount=i%2==0 ? ++evencount : evencount ;
		
	}
}
private static void ifTest() {
	Calendar cal = Calendar.getInstance();
	int y= cal.get(Calendar.YEAR);
	int M =cal.get(Calendar.MONTH);
	int d =cal.get(Calendar.DAY_OF_MONTH);
	int wd =cal.get(Calendar.DAY_OF_WEEK);
	String wdk=null;
	int h =cal.get(Calendar.HOUR);
	int m =cal.get(Calendar.MINUTE);
	int s =cal.get(Calendar.SECOND);
	
	switch(wd)
	{
	case 1:
		wdk="일";
		break;

	case 2:
		wdk="월";
		break;
		
	case 3:
		wdk="화";
		break;
		
	case 4:
		wdk="수";
		break;
		
	case 5:
		wdk="목";
		break;
		
	case 6:
		wdk="금";
		break;
	
	case 7:
		wdk="토";
		break;
	}
	/*if (wd==1) {
		wdk="일";
	}
	else if (wd==2) {
		wdk="월";		
	}	
	else if (wd==3) {
		wdk="화";
	}
	else if (wd==4) {
		wdk="수";
	}
	else if (wd==5) {
		wdk="목";
	}
	else if (wd==6) {
		wdk="금";
	}
	else if (wd==7) {
		wdk="토";
	}*/
	
	System.out.printf("%d년 %d월 %d일 (%s요일) %d시%d분%d초",y,M+1,d,wdk,h,m,s);
	
	
	}

private static void variableInt() {
	
	int v=0;
	String s= null;
	String str="";
 String St= null;
 boolean res= St.equals("");
 System.out.println(res);
}


private static void idpw() {
 int cnt=0;

 Scanner kb= new Scanner(System.in);
 
 
 while (true) {
	 System.out.printf("아이디를 입력하세요:");
	 String id= kb.next();
	 
	 System.out.printf("비밀번호를 입력하세요:");
	 String pw= kb.next();
	 if(id.equals("smith")&&pw.equals("1234")) {
		 System.out.println("로그인 성공");
		 break;
	 }
	 else {
	 
	 cnt++;
	 if (cnt==3) {
		 System.out.println("로그인 3회 실패, 10분뒤 재시도");
		 
	 }
	 else {
		 System.out.println("로그인 실패, 3회 실패시 10분뒤 재시도");
	 }
	 }
	 
 }
 System.out.println("프로그램 종료");

}

private static void switchTest()
{
	int n=2;
 switch(n)	{
 
 case 0:
	 System.out.println("n은 0이다");
	 break;
 case 1:
	 System.out.println("n은 1이다");
	 break;
	 
 case 2:

	 System.out.println("n은 2다");
	 break;
 case 3:

	 System.out.println("n은 3이다");
	 break;
 default:
	 
	 break;
 
 }



}
private static void forloopTest()
{
for( int i=0;i<10;i++) {
	System.out.println(i);
}	

}
}
