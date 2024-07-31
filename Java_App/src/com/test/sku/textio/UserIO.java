package com.test.sku.textio;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserIO {

	static Scanner kb= new Scanner(System.in);
	static String menu = "추가(a),목록(s),검색(f),수정(u),삭제(d),종료(x):";
	
	static String showMenu() {
	System.out.println(menu);
	String m= kb.nextLine().trim();
	
	return m;
	}

	public static void add() { //입력->파일에 저장 -> 성공/실패 매시지
	 System.out.print("글 번호:");
	 int no=kb.nextInt(); kb.nextLine();
	 
	 System.out.print("글 제목:");
	 String title=kb.nextLine();
	 
	 System.out.print("작성자:");
	 String author=kb.nextLine();
	 
	// System.out.print("작성일:");
	 //String date =kb.nextLine(); -->사용자가 입력하는거아님
	 
	 System.out.print("글 내용:");
	 String content=kb.nextLine();
	 
	 Date regDate= new Date();
	 
	 //VO에 담아서 파일에 저장하도록 한다(VO, DataIO)
	 BoardVO board= new BoardVO();
	 board.setNo(no);
	 board.setTitle(title);
	 board.setAuthor(author);
	 board.setContent(content);
	 board.setRegdate(regDate);
	 //히트수는 멤버 변수에서 초기화하지 않았으니 안해도 0이다
	 board.setHits(0);
	 
	 boolean saved= DataIO.saveBoard(board);
	 if (saved) System.out.println("\t\t게시글 저장 성공");
	 else System.err.println("\t\t게시글 저장 실패");
	}

//	public static void show() {
//		DataIO.showBoard();
//		 
//	}
public static void show() {
	List<BoardVO> list= DataIO.show();
	System.out.println();
	System.out.println("\t\t**게시글 목록**");
	for (int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	
}
	 public static void find() {
	        System.out.print("찾을 글 번호:");
	        int no = kb.nextInt();
	        kb.nextLine();

	        BoardVO board = DataIO.findBoard(no);
	        if (board != null) {
	            System.out.println("게시글을 찾았습니다:");
	            System.out.println(board);
	        } else {
	            System.err.println("해당 글 번호의 게시글이 없습니다.");
	        }
	    }

	public static void update() {
		System.out.print("바꿀 글 번호:");
		 int no=kb.nextInt(); kb.nextLine();
		 BoardVO board= DataIO.findBoard(no); // 번호에 해당하는 글 찾음
		 if(board !=null) {
			 System.out.println("본문을 다시 입력해주세요:");
	       String newcontent= kb.nextLine();
	       board.setContent(newcontent);		//내용 업데이트
	       DataIO.updateBoard(no,newcontent);
	       if (DataIO.updateBoard(no,newcontent)){
	    	   
	       
	       System.out.println("업데이트 완료");
	       }
	       else System.err.println("업데이트 실패, 해당 번호 없음");
		 }
			
		
	}
	public static void update2() {
		System.out.print("바꿀 글 제목:");
		 String title =kb.nextLine();
		 BoardVO board= DataIO.findBoard2(title); // 제목에 해당하는 글 찾음
		 if(board !=null) {
			 System.out.println("본문을 다시 입력해주세요:");
	       String newcontent= kb.nextLine();
	       board.setContent(newcontent);		//내용 업데이트
	       if (DataIO.updateBoard2(title,newcontent)){
	    	   
	       
	       System.out.println("업데이트 완료");
	       }
	       else System.err.println("업데이트 실패, 해당 제목 없음");
		 }
			
		
	}
	public static void delete() {
		System.out.print("삭제할 글 번호:");
		 int no =kb.nextInt(); kb.nextLine();
		 BoardVO board= DataIO.findBoard(no); // 번호에 해당하는 글 찾음
		if (DataIO.deleteBoard(no))
		 System.out.print("삭제완료\n");
		else System.err.println("업데이트 실패, 해당 번호 없음");
	}
} //클래스끝
