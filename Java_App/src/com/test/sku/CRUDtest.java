package com.test.sku;

import java.util.Scanner;

public class CRUDtest {
	//Member Variables
//1.static variables (클래스변수): 프로그램 시작시 자동으로 로드되는 변수
//2.Instance variables (객체 변수):클래스에 인스턴스가 생성될 때 로드됨
static String[] name= new String[10];
static int[] num= new int[10];
static String[] phone= new String[10];

static Scanner kb= new Scanner(System.in);
static	int i=0;
static	int cnt=0;

public static void main(String[] args) {
	

	arrayCRUD();
	
}


public static void arrayCRUD() {

while(true) {
 System.out.printf("\n목록(s), 추가(a) 수정(e) 삭제(d) 검색(f) 종료(x)");
 Scanner kb= new Scanner(System.in);
 String menu=kb.nextLine();
 switch (menu) {
 case "s":	
list();
 
 break;
 case "a":
 add();
 
 break;
	 
 case "e":
    edit();
     break;
	 
 case "d":
    delete();
     break;
 
 case "f":
	find();
    
     break;

 case "x":
	 kb.close();
		 return;	
	}
	}
}
	public static void list() {
	 System.out.printf("\n***회원목록***\n");
 for(i=0;i<cnt;i++) {
	 System.out.print((i+1)+"회원번호:"+num[i]+" 회원명:"+ name[i]+ " 전화번호:"+ phone[i]+"\n");
 }
}

public static void add() {
 int n=-1;
 //do {
//	System.out.printf("회원번호를 입력하세요:");
 //String sNo= kb.nextLine();
 //	n= Integer.parseInt(sNo);
 //}
 //while(isFound(n)!=-1);
  while(true){
   System.out.print("번호");
   String sNo = kb.nextLine();
    n= Integer.parseInt(sNo);
   if(isFound(n)!=-1){
   System.err.println("\n이미 등록된 번호입니다");
   }else break;
   }
  

 System.out.printf("이름을 입력하세요:");
 String sName= kb.nextLine();

 
 System.out.printf("전화번호를 입력하세요:");
 String sPhone= kb.nextLine();
 // n 변수에 있는 번호가 이미 등록된 상태인지 확인하는 코드
 //이미 등록된 회원 번호라면 해당 인덱스를 리턴하고, 등록되지 않았으면 -1을 리턴한다
 

 num[cnt]=n;
 name[cnt]=sName;
 phone[cnt]=sPhone;
 cnt++;

}
public static void edit() {
	int n=-1;
	   System.out.print("번호");
	   String sNo = kb.nextLine();
	    n= Integer.parseInt(sNo);
	   if(isFound(n)!=-1){
	
  {
            System.out.printf("새로운 전화번호를 입력하세요: ");
            String newPhone = kb.nextLine();
            phone[i] = newPhone;
        
          
        }
        }
	   
    else {
        System.err.printf("존재하지 않는 회원 번호입니다.\n");
    	}
    
	 
}
public static void delete() {
	int idx=-1;
	int n=0;
	   System.out.print("삭제할 회원번호:");
	   String sNo = kb.nextLine();
	    n= Integer.parseInt(sNo);
	    idx=isFound(n);
	    while (true) {
	    if(idx==-1){
            System.err.println("\n"+n+"는 없는 번호입니다");
	    }
	    else break;

for (int j = idx; j < cnt - 1; j++) {
                num[j] = num[j + 1];
                name[j] = name[j + 1];
                phone[j] = phone[j + 1];
            }
            cnt--;
  
            System.out.println("삭제 완료");
         
        }
    
	   
}
	
	public static void find() {
 System.out.printf("회원번호로 검색은 n, 전화번호로 검색은 p를 눌러주세요");
	 int idx=-1;
	 String numorphone = kb.nextLine();
	 if (numorphone.equals("n")) {
		 idx= searchbynum();
         }
	 
	 else if (numorphone.equals("p")) {
idx= searchbyphone();
	 }
	 if (idx!=-1) {
		 System.out.print("\t\t 검색된 회원정보");
		 System.out.printf("%d\t%s\t%s\n",num[idx],name[idx],phone[idx]);
		 
	 }else {
		 System.err.println("\t\t 검색 실패");
	 }
}
/*public static int isDuplicate(int a) {
	int idx=-1;
	while(true) {
		for(int i=0;i<cnt;i++) {
			if(num[i]==a)
				 idx=i;
			else idx=-1;
		}break;

		
			
		}
		return idx;
	}
	*/
	private static int isFound(int n) {
		for (int i =0; i<num.length;i++) {
			if(num[i]==n) {
	
					return i;
			}
		}return -1;
	}
	private static int searchbynum() {
		while(true) {
		System.out.printf("회원번호를 입력하세요: ");
		
        String getnumfind = kb.nextLine();
        int checknumfind = Integer.parseInt(getnumfind);
        int idx=isFound(checknumfind);
        
            if (num[idx] == checknumfind) 
            {
           	 return idx;
           	
            }
            
            else {
            System.err.printf("해당 회원을 찾지 못했습니다.\n");
            return -1;
            }
	 }
        }
	
	private static int searchbyphone(){
		int idx=-1;
		
		 System.out.printf("전화번호를 입력하세요: ");
        String pn = kb.nextLine();
for(int i=0;i<cnt;i++) {
	if(phone[i].equals(pn)) {
		idx=i;
		break;
	}
}
	 return idx;
	 }
	 
	
	
	
	}

