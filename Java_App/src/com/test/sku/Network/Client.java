package com.test.sku.Network;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
static Scanner kb= new Scanner(System.in);
	
	public static void main(String[] args) {
		// 클라이언트 소켓을 이용하여 서버에 접속한다
		try {
			Socket s= new Socket("localhost",1234);
			//localhost->ip주소로 변경
	
			   InputStream in = s.getInputStream();
	            ObjectInputStream ois = new ObjectInputStream(in);
	            ChatMsg cm = (ChatMsg) ois.readObject();
	            System.out.println(cm.msg + ":");

	            // 사용자 입력 받기
	            
	            String uid = kb.nextLine().trim(); // 입력 받은 아이디
	          
	            String pwd = kb.nextLine().trim(); // 입력 받은 비밀번호

	            // 서버로 객체 전송
	            OutputStream out = s.getOutputStream();
	            ObjectOutputStream oos = new ObjectOutputStream(out);
	            ChatMsg cm2 = new ChatMsg(true, uid, pwd);
	            oos.writeObject(cm2);
	            oos.flush();
	            cm=(ChatMsg) ois.readObject();
	            if(cm.msg.equals("로그인 성공")) {
	            	MsgReadThread msgReadThread = new MsgReadThread(ois);
					msgReadThread.start();				//스레드실행
	            	while (true) {
	            String msg=null;
	            String rec=null;
	            		//귓속말(s),공개메시지(p):
	            		System.out.println("귓속말(s),공개메시지(p),종료(x):");
	            		String m= kb.nextLine();
	            		 if (cm.msg.equalsIgnoreCase("x")) {
	            			System.out.println("채팅을 종료합니다");
	            			break;
	            		 }
	            		 
	            			else if (m.equals("s")) {
	            			System.out.println("보낼사람:");
		            		rec= kb.nextLine();
	            			System.out.println("메시지:");
		            		 msg= kb.nextLine();
		            			System.out.println("첨부파일:");
			            		String fname= kb.nextLine();
			            		cm= new ChatMsg();
			            		cm.uid=uid;
			            		cm.isSecret=true;
			            		cm.to=rec;
			            		cm.msg=msg;
			            		cm.fname=fname;
		            			if (fname!=null&&!fname.equals(""))
		            			{
		            				byte[] fdata= new FileIO().load(fname);
		            				if(fdata!=null) {
		            					cm.fname= fname;
		            					cm.fdata=fdata;
		            					System.out.println("첨부파일 전송 성공");
		            				}
		            				else {
		            					System.out.println("첨부파일없이 메시지만 전송");
		            				}
		            				
		            			}
			            		
			            		
			            		oos.writeObject(cm);
			            		oos.flush();
			            	
		            		 
	            		}
	            			else if (m.equals("p")) { 
	            				System.out.println("메시지:");
	            				msg= kb.nextLine();
	            		

	            		
	            				cm= new ChatMsg();
	            		
	            				cm.uid=uid;
	            				cm.msg=msg;
	            				cm.to=rec;
	            		
	            				oos.writeObject(cm);
	            				oos.flush();
	            			}
	            			else if (m.equals("y")) {
	            				String fname= MsgReadThread.chatMsg.fname;
	            				byte[] fdata= MsgReadThread.chatMsg.fdata;
	            				boolean saved = new FileIO().download(fname, fdata);
	            				if (saved) {
	            					System.out.println("다운로드 성공");
	            					
	            				}else System.err.println("다운로드 실패");
	            			}
	            }
	            		
//	            		MsgReadThread msgReadThread = new MsgReadThread();
//						msgReadThread.start();
//	                   	cm=(ChatMsg)ois.readObject();	//스레드로빼야됨
//	                	System.out.println(cm.msg);		//스레드로빼야됨
	            	
	            	
	            	
	            	oos.close();
	 	            ois.close();
	 	            //s.close();
	 	            System.out.println("클라이언트 스트림 종료");
	           }
	            else
	            	System.err.println("로그인 실패");

	            // 사용이 끝난 자원 정리
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            kb.close(); // Scanner 자원도 반납
	        }
			System.out.println("클라이언트 종료");
			
	    }
	}