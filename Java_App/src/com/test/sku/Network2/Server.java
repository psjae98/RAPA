package com.test.sku.Network2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
//DocClient, DocServer
/*	1.DocServer만들기(무한대기할수있게)
 * +"서버 대기중..."	
 * +while문 안에
 * 	+.(s.accept())
 * 	+ "클라이언트 접속됨"
 * 	2.DocClient
 * + 서버에 접속(뉴 소켓)
 * +클라이언트 종료(서버에 알림), 서버가 끝나는지 확인.(안끝나야됨)
 * 3.업로드(a) 목록(s) 검색(f) 수정(u) 삭제(d) 종료(x)
 * +업로드
 * -파일명:sample.jpg
 * -파일 메모리에 로드(byte[]),파일명 (fname) ==> ChatMsg
 * -서버에 전송(writeObject), boolean upload=true,fname,fdata 필요
 * 4. 파일 업로드 성공시마다 속성들을 파일에 저장한다.
 * + 번호 파일명 작성자 파일크기 날짜 설명
 * +Fileinfo 클래스
 * +List<FileInfo> 구조로 파일에 저장(직렬화)
 * +파일명:list_fileinfo.ser
 * 5. if (cm.upload){
 * 	//파일수신 하고 서버시스템에 저장
 * } 
 * else if (cm.list){
 * list_fileinfo.ser을 로드하여 fileList 변수에 할당
 * }
 * else if(cm.find){
 * 클라이언트가 검색하려는 경우 
 * .
 * .
 * .
 * 수정삭제까지
 * }
 */
public class Server {

	
	public static void main(String[] args) 
	{
		try 
		{	
			ServerSocket ss= new ServerSocket(1565);
			while(true) 
			{
				System.out.println("서버 대기중...");
				Socket s= ss.accept();
				System.out.println("클라이언트 접속 성공");
				
				new UserWorkThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	

}
