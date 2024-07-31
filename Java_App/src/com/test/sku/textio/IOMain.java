package com.test.sku.textio;

public class IOMain {
/*프로그램 코드 분리의 예 --> 왜? 코드를 분리해놔야 문제 일어나는곳 파악하고 그 부분만 고칠수있음
 *  코드가 서로 너무 연관되어있으면 어디가 잘못되었는지 찾기 힘들고 유지보수도 힘듦
 * 
 * main loop, userID,DataIO,VO(Value object)
 * 
 * main loop: 프로그램 흐름 전체 관리
 * UserIO: 이용자로부터 입력 및 이용자에게 출력(키보드,모니터)
 * DataIO:데이터 파일 입출력 수정 삭제 검색
 * VO(Value object, DTO(Data transfer object)): 데이터모델
 * 
 * 게시판 프로그램
 * BoardVO(번호, 제목, 작성자, 히트 수 , 본문)
 * 
 */
	public static void main(String[] args) {
	
		
	boolean go = true;
	while (go)
	{
		//메뉴를 보여준다
		String m= UserIO.showMenu(); //UserIO에서 가져옴
		switch(m)
		{
		case "a": UserIO.add();		break;
			
		case "s":UserIO.show();		break;
			
		case "f":UserIO.find();		break;
				
		case "u":UserIO.update2();	break;
			
		case "d":UserIO.delete();	break;
			
		case "x" :go=false;			break;
		}
		//go=false;
	}
	System.out.println("프로그램 종료");

	}//main끝

}//클래스끝
