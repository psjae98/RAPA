package com.test.sku.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OOPMain {
   static Scanner kb = new Scanner(System.in);
   static List<Member> mems = new ArrayList<Member>();

   public static void main(String[] args) {
     initMems();
	   //inputMember(); // 3인 정보 입력
      // 리스트에서 검색하여 번호가 11번인 회원 정보를 화면에 표시해보세요.
      list();
      //listSearch();
      //listRemove();
      //listUpdate2();
      removePhonebyNo2();
      System.out.println("\t\t프로그램 종료");
   }

   private static void inputMember() {
      while (true) {
         System.out.print("회원번호, 이름, 전화번호, 이메일 (빈 입력 시 종료): ");
         String input = kb.nextLine();
         if (input.equals("")) break;
         String[] token = input.split("\\s+");
         Member m = new Member(token); //(Constructor Overload)
         mems.add(m);
      }
      System.out.println("\t\t회원정보 추가 성공");
   }

   private static void list() {
      System.out.println("\t***회원목록***");
      for(int i = 0; i < mems.size(); i++) {
         System.out.println(mems.get(i));
      }
   }

   private static void listTest() {
      // List 사용하기(CRUD)
      List<String> sList = new ArrayList<>();
      sList.add("Hello"); // Create
      sList.add("World");
      sList.add("홍길동");
      sList.add("홍길동");

      for(int i = 0; i < sList.size(); i++) {
         String v = sList.get(i); // Read
         System.out.println(v);
      }

      System.out.println(sList.contains("World")); // true/false
      int idx = sList.indexOf("World");
      String value = sList.get(idx);
      System.out.println("검색 결과:" + value);

      sList.set(2, "임꺽정");
      System.out.println(Arrays.toString(sList.toArray()));

      sList.remove("홍길동");
      sList.remove(2);
      System.out.println(Arrays.toString(sList.toArray()));
   }


private static void listSearch() {

	Member memobj= new Member(11);
	if (mems.contains(memobj)) {
		int idx= mems.indexOf(memobj);
		Member found = mems.get(idx);
		System.out.println("11번 회원:"+found);
	}
	
}

private static void listRemove() {  // 잘못바꿨다

	Member memobj= new Member(11);
	Member key = new Member(11);
	boolean removed= mems.remove(key);
	System.out.println("삭제결과:"+removed);
	}

private static void listUpdate() {
	Member memobj= new Member(11);
	if (mems.contains(memobj)) {
		int idx= mems.indexOf(memobj);
		Member found = mems.get(idx);
		found.setPhone("010-9984-5216");
		System.out.println("11번 회원 번호 수정 완료:"+found);
	}
	
}

private static void listUpdate2() { // key value 써서
	Member key= new Member(11,"Laura","010-9984-5216","pjkart5@naver.com");
		if(mems.contains(key)) {
			Member rem= mems.set(mems.indexOf(key),key);
			if(rem!=null) {System.out.println("수정성공");}
			else {System.err.println("수정실패");}
		}
		list();
	}
	
private static void removePhonebyNo() {
    // 회원 번호 입력 받기
    System.out.print("수정할 회원 번호를 입력하세요: ");
    int memberId = kb.nextInt();
    kb.nextLine(); // 버퍼 비우기

    Member key = new Member(memberId); // 삭제할 회원을 생성
    if (mems.contains(key)) {
        int idx = mems.indexOf(key); // 회원 목록에서 해당 회원의 인덱스를 찾음

        // 기존 전화번호 출력
        Member found = mems.get(idx);
        System.out.println(memberId + "번 회원의 현재 전화번호는 " + found.getPhone() + "입니다.");

        // 새 전화번호 입력 받기
        System.out.print("새로운 전화번호를 입력하세요: ");
        String newPhoneNumber = kb.nextLine();

        // 전화번호 수정
        found.setPhone(newPhoneNumber);

        System.out.println(memberId + "번 회원의 전화번호가 수정되었습니다.");
        System.out.println("수정 후 정보: " + found); // 수정 후 회원 정보 출력
    } else {
        System.out.println(memberId + "번 회원이 존재하지 않습니다.");
    }
}
private static void removePhonebyNo2() {
    // 회원 번호 입력 받기
    System.out.print("수정할 회원 번호를 입력하세요: ");
    int no = kb.nextInt();
    kb.nextLine(); // 버퍼 비우기
    System.out.print("새로운 전화번호를 입력하세요: ");
    String phone = kb.nextLine();
    

    Member key= new Member(no,phone);
    if(mems.contains(key)) {
    	int idx= mems.indexOf(key);
    	mems.get(idx).setPhone(key.getPhone());
    	System.out.println("전화번호 변경 성공");
    	
    }
    else {
    	System.out.println("전화번호 변경 실패");
    }
 list();
}
private static void initMems() {
	mems.add(new Member(11,"smith","01099845216","pjkart5@naver.com"));
	mems.add(new Member(12,"sam","0109876542","pjkart5@gmail.com"));
}


}




class Member {
   int no;
   String name;
   String phone;
   String email;

   public Member(int no, String name, String phone, String email) {
      setNo(no);
      setName(name);
      setPhone(phone);
      setEmail(email);
   }
   public Member(int no, String phone) {
	      setNo(no);
	
	      setPhone(phone);
	   
	   }

   public Member(String[] token) {
      int no = Integer.parseInt(token[0]);
      String name = token[1];
      String phone = token[2];
      String email = token[3];

      setNo(no);
      setName(name);
      setPhone(phone);
      setEmail(email);
   }

   @Override
   public boolean equals(Object obj) {
      Member other = (Member)obj;
      return this.getNo() == other.getNo();
   }

   @Override
   public String toString() {
      String str = String.format("%d\t%s\t%s\t%s",
            this.getNo(),
            this.getName(),
            this.getPhone(),
            this.getEmail());
      return str;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   public Member(int no) {
	   
	   setNo(no);
	   
   }
   
}
