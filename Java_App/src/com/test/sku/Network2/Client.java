package com.test.sku.Network2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.List;
import java.util.Scanner;

public class Client {
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Socket s= new Socket("localhost",1565);
			System.out.println("클라이언트 접속");
		
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
	        ObjectInputStream ois = new ObjectInputStream(in);
	        ObjectOutputStream oos = new ObjectOutputStream(out);
	            	
	       	//메뉴 읽어와서 출력
						
			         while (true) 
			         { ChatMsg cm= (ChatMsg) ois.readObject();
						System.out.println(cm.message);		
			        	  String m= kb.nextLine();
			        	  
						switch (m) 
						{
							case "a":
			                        System.out.println("파일명(파일형식도 입력(ex.sample.jpg)):");
			                        String fname = kb.nextLine();
			                        System.out.println("작성자:");
			                        String author = kb.nextLine();
			                        System.out.println("설명:");
			                        String description = kb.nextLine();
			                        
			                        ChatMsg cm2= new ChatMsg();
			                        cm2.upload=true;
			                        cm2.fname=fname;
			                        cm2.fdata=FileIO.load(fname);
			                        cm2.author=author;
			                        cm2.description=description;
			                        oos.writeObject(cm2);
			                        oos.flush();
			                        
			                        break;
						
							case "s": 
								ChatMsg cmlist= new ChatMsg();
								cmlist.list=true;
								cmlist.fileInfoList=FileIO.listForFiles();
								oos.writeObject(cmlist);
		                        oos.flush();
								break;
								
							case "f":	ChatMsg cmfind= new ChatMsg();
							
							//번호 검색받고 파일정보보여줌(userwork에서)
							System.out.println("찾을 파일의 번호 입력");
	                        int no = kb.nextInt();kb.nextLine();
	                        cmfind.find=true;
	                        cmfind.no=no;
							oos.writeObject(cmfind);
	                        oos.flush();
								break;
								
							case "u":
								ChatMsg cmupdate= new ChatMsg();	
								System.out.println("바꿀 파일의 번호 입력");
								int num = kb.nextInt();
								kb.nextLine();
								System.out.println("바꿀 파일의 파일이름 입력");
								String newName= kb.nextLine();
								System.out.println("바꿀 파일의 설명 입력");
								String newDescription = kb.nextLine();
								
								cmupdate.update=true;
								cmupdate.no=num;
								cmupdate.newName=newName;
								cmupdate.newDescription=newDescription;
								oos.writeObject(cmupdate);
		                        oos.flush();
		                        break;
		                        
							case "d":	ChatMsg cmdelete= new ChatMsg();
							System.out.println("찾을 파일의 번호 입력");
							int number = kb.nextInt();kb.nextLine();
							System.out.println("정말 삭제하시겠습니까?(y/n)");
							String yn = kb.nextLine();
	                        cmdelete.delete=true;//생성자 ChatMsg(boolean find, int no 가 있어서 ChatMsg(boolean delete,int no) 생성이 안됨)
	                        cmdelete.no=number;		//yesno 넣어서 삭제확인하는거 만들어서 새로운 생성자형식으로
	                        cmdelete.yesno=yn;
							oos.writeObject(cmdelete);
	                        oos.flush();
								break;
							case "x":
								return;
								
								default:
							
								break;
						}

			                // 서버로부터 응답 받기
			                ChatMsg response = (ChatMsg) ois.readObject();
			                System.out.println("서버 응답: " + response.message);
			         }
		}catch (Exception e) {
		 System.out.println("클라이언트 종료");
		e.printStackTrace();
	}
}

	
	
	
	
}//클래스끝