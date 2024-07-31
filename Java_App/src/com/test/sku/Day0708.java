package com.test.sku;

import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class Day0708 {
	public static void main(String[] args) {
	
	//forTest();
	//foronetenone();
	//randtenintodd();
	//arrayTest();
	//arrayCRUD();
		//int res= add2(7,15); //정수표현식
	 //System.out.println();
   //String msg= greet("박성재");
    //System.out.println(msg);
		
		//int[] arr= new int[] {1,2,3,4,3,4,5};
		//int res= sum(arr);
		//System.out.println("합계: "+res);
		//int [] arr= getNums(5);
		//int res= sum(arr);
		//System.out.println("합계: "+res);

		 int[] arr = getNums(10); // 길이가 10인 배열을 무작위로 생성
	        System.out.println("정렬 전 배열: " + Arrays.toString(arr));

	        sort(arr);

	        System.out.println("정렬 후 배열: " + Arrays.toString(arr));
	
	
	}
	
	private static void forTest() 
	{int i,j;
		for(i=0,j=10;i<=10;i++,j--)
		{
			System.out.print(i+" ");
			System.out.print(j+"\n");
		}
		
	}
	
	private static void foronetenone() 
	{
		for(int i=10, delta=-1;i<=10;i+=delta) // i가 작아졌다가 다시 10일때까지만 루프돌아야하므로 두번째에 i<=10; 써야함
		{
			System.out.print(i+" ");
			if(i==1) {
				delta=1;  //i가 1이되면 delta를 1로 바꿔서 증가하도록 변경
			}
			}

		
	}
// continue: while, for 문장에서 흐름을 다시 루프의 시작으로 돌린다
//break:  while for switch 문장에서 반복을 종료시키는 역할
	
	//무작위 정수 10개를 출력, 모두 홀수여야 한다
	private static void randtenintodd() 
	{
		Random rd= new Random();
		

		for(int i=0;i<10;i++)
		{int k= rd.nextInt(30);
			if (k%2==0) k=k+1;
			System.out.print(k+" ");
		}
		
	}
	
	//배열(Array)
	/*동일한 자료형의 데이터를 일련의 공간에 다수개를 순서대로 저장하는 가장 단순한 자료구조
	 * 자료구조 중에서 데이터를 순서대로 순회하면서 보여줄 때 가장 빠른 성능을 보여준다
	 * 한 학생의 모든 과목에 대한 점수를 저장하렴ㄴ 다수개의 정수 혹은 실수 저장공간이 요구된다
	 * 배열을 사용할때는 배열변수 선언, 메모리 할당, 초기화, 배열사용 순으로 해야한다
	 * */
	
	private static void arrayTest() {
		int[] nums;//배열변수 선언
		nums=new int[5]; // new=동적메모리할당연산자. 새로운 정수 5개배열의 공간을 확보(할당), int 5개이므로 20byte
		nums[0]=14; //색인번호(index)를 사용하여 배열의 각 원소를 순회할 수 있다
		nums[1]=25;
		nums[2]=33;
		nums[3]=414;
		nums[4]=52;
		for (int i=0;i<nums.length;i++) //CRUD(Create, Read, Update, Delete)
		{
			
			System.out.printf("%d ",nums[i]);
		}
		
		
	}
	
	//회원정보관리시스템
	//회원번호, 이름, 전화번호 저장
	//num, name, phone 배열 3개필요
	//키보드에서 회원정보 입력받아서 배열에 저장하고 회원의 목록을 표시하는 기능
	//프로그램 시작되면 번호,이름, 전화번호를 입력받고 
	//다수의 회원정보를 입력받을수 있어야함(이용자가 아무런값도 입력하지 않고 엔터를 치면 입력종료)
	//입력 종료시 지금까지 입력된 회원 목록을 화면에 표시
	//목록(s), 추가(a) 수정(u) 삭제(d) 검색(f) 종료(x);
	private static void arrayCRUD() {
String[] name= new String[10];
	name= new String[10];
	int[] num= new int[10];
	String[] phone= new String[10];
	
	Scanner kb= new Scanner(System.in);
	int i=0;
	int cnt=0;
	while(true) {
	 System.out.printf("\n목록(s), 추가(a) 수정(e) 삭제(d) 검색(f) 종료(x)");
	 String menu=kb.nextLine();
	 switch (menu) {
	 case "s":	
		 System.out.printf("\n***회원목록***\n");
	 for(i=0;i<cnt;i++) {
		 System.out.print((i+1)+"회원번호:"+num[i]+" 회원명:"+ name[i]+ " 전화번호:"+ phone[i]+"\n");
	 }
	 break;
	 case "a":
	 
		 System.out.printf("회원번호를 입력하세요:");
		 String sNo= kb.nextLine();
		
			 int n= Integer.parseInt(sNo);
			 num[cnt]=n;
		 
		
				 
		 System.out.printf("이름을 입력하세요:");
		 String sName= kb.nextLine();
		 name[cnt]=sName;
		 
		 System.out.printf("전화번호를 입력하세요:");
		 String sPhone= kb.nextLine();
		 phone[cnt]=sPhone;
		 cnt++;
	 break;
		 
	 case "e":
         System.out.printf("회원번호를 입력하세요: ");
         String getnumedit = kb.nextLine();
         int checknumedit = Integer.parseInt(getnumedit);
         boolean foundedit = false;
         for (int k = 0; k < cnt; k++) {   //여기서도 반복문 돌려줘야 num배열에서 일치하는 숫자를 찾을 수 있음
             if (num[k] == checknumedit) {
                 System.out.printf("새로운 전화번호를 입력하세요: ");
                 String newPhone = kb.nextLine();
                 phone[k] = newPhone;
                 foundedit = true;
                 break;
             }
         }
         if (!foundedit) {
             System.err.printf("존재하지 않는 회원 번호입니다.\n");
         }
         break;
		 
	 
	 case "d":
         System.out.printf("회원번호를 입력하세요: ");
         String getnumdel = kb.nextLine();
         int checknumdel = Integer.parseInt(getnumdel);
         boolean founddel = false;
         for (int k = 0; k < cnt; k++) {
             if (num[k] == checknumdel) {
                 for (int j = k; j < cnt - 1; j++) {
                     num[j] = num[j + 1];
                     name[j] = name[j + 1];
                     phone[j] = phone[j + 1];
                 }
                 cnt--;
                 founddel = true;
                 System.out.println("삭제 완료");
                 break;
             }
         }
         if (!founddel) {
             System.out.printf("존재하지 않는 회원 번호입니다.\n");
         }
         break;
	 
	 case "f":
		 System.out.printf("회원번호로 검색은 n, 전화번호로 검색은 p를 눌러주세요");
		 
		 String numorphone = kb.nextLine();
		 if (numorphone.equals("n")) {
			 System.out.printf("회원번호를 입력하세요: ");
	         String getnumfind = kb.nextLine();
	         int checknumfind = Integer.parseInt(getnumfind);
	         boolean numfind = false;
	         for (int l = 0; l < cnt; l++) {   //여기서도 반복문 돌려줘야 num배열에서 일치하는 숫자를 찾을 수 있음
	             if (num[l] == checknumfind) 
	             {
	            	 System.out.printf("회원번호:%d 이름:%s 전화번호:%s",num[l],name[l],phone[l]);
	            	 numfind=true;
	            	 break;
	             }
	             }
	          if (!numfind) {
                 System.err.printf("해당 회원을 찾지 못했습니다.\n");
                 break;
		 }
	         }
		 
		 else if (numorphone.equals("p")) {
			 System.out.printf("전화번호를 입력하세요: ");
	         String getphonefind = kb.nextLine();

	         boolean phonefind = false;
	         for (int m = 0; m < cnt; m++) {   //여기서도 반복문 돌려줘야 num배열에서 일치하는 숫자를 찾을 수 있음
	             if (phone[m].equals(getphonefind)) 
	             {
	            	 System.out.printf("회원번호:%d 이름:%s 전화번호:%s",num[m],name[m],phone[m]);
	            	 phonefind=true;
	            	 break;
	             }
	           
	             }
	          if (!phonefind) {
                 System.err.printf("해당 회원을 찾지 못했습니다.\n");
                 break;
		 }
		 }
        
         break;

	 case "x":
	 
		 return;	
	}
	}
}
	
	//메소드: 코드의 집합에 이름을 붙인것
	private static void hello() {   //function:함수,기능
		
		System.out.println("hello");
		
	}
	
	private static void add(int a, int b) {   //function:함수,기능

		
		System.out.printf("%d+%d=%d\n",a,b,a+b);
		
	}
	
private static int add2(int a, int b) {   //function:함수,기능

		
		//System.out.printf("%d+%d=%d\n",a,b,a+b);
		return a+b;
	}
	
private static String greet(String name) {
	return"Hello "+name;
}

	//sum이라는 이름의 메소드를 정의하고 배열을 받아서 그 배열의 합을 구하여 리턴하는 기능을 구현해라
	
private static int sum(int[] arr) {
	int suma=0;

		for(int i=0; i<arr.length; i++) {
		
		suma+=arr[i];
			
	
	}
	return suma;
	
}

//getNums 메소드를 호출하면 부작위 정수를 원소로 하는 배열이 리턴되도록해보세요
//파라미터로 전달하는 숫자만큼 배열의 원소 수를 지정하여 배열이 생성되도록
private static int[] getNums(int a) {
	Random rd= new Random();
	int arr[]= new int[a];
	
	for(int i=0; i<a;i++) {
		arr[i]=rd.nextInt(20);
		
	}
	return arr;
	
	
}

//선택정렬 알고리즘을 사용하여 무작위로 추출된 배열의 원소를 오름차순으로 정렬해보세요
private static void sort(int[] arr) {
int n=arr.length;
for (int i=0;i<n-1;i++) {
	int minIndex=i;
	for(int j=i+1;j<n ;j++) {
		if(arr[j]<arr[minIndex]) {
			minIndex=j;
		}
	}
	   int temp = arr[minIndex];
       arr[minIndex] = arr[i];
       arr[i] = temp;
   }
	
}
 


}
 






 


