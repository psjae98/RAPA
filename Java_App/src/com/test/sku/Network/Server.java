package com.test.sku.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try 
		{
			ServerSocket ss= new ServerSocket(1234);
			while(true) 
			{
			System.out.println("서버 대기중...");
			//Listens for a connection to be made to this socket and acceptsit.
			//The method blocks until a connection is made. 
			Socket s= ss.accept(); // 클라이언트가 접속하면 통신용 소켓을 리턴한다
			//접속한 이용자와 통신할 때 사용하는 소켓
			System.out.println("클라이언트 접속 성공");
			
			
			new LoginThread(s).start();
			
			
			
//			OutputStream out=s.getOutputStream();
//			//직렬화코드
//			ObjectOutputStream oos= new ObjectOutputStream(out); //오브젝트를 소켓을 통해 연결함. 클라이언트에게 오브젝트 보낼수있음
//			ChatMsg cm= new ChatMsg("서버","클라이언트","아이디 암호");
//			oos.writeObject(cm);
//			oos.flush();  //accept 이후로 쓰레드로 만들어야함
//			
//			InputStream in2 = s.getInputStream();
//			ObjectInputStream ois= new ObjectInputStream(in2);
//			ChatMsg cm2= (ChatMsg)ois.readObject();
//			System.out.printf("%s / %s \n",cm2.uid, cm2.pwd);//accept 이후로 쓰레드로 만들어야함
			
//			OutputStreamWriter osw= new OutputStreamWriter(out);
//			PrintWriter pout= new PrintWriter(osw);
//			pout.println("아이디 암호");
//			pout.flush();
			//클라이언트가 보내는 아이디 암호를 받는다
//			InputStream in2 = s.getInputStream();
//			InputStreamReader isr= new InputStreamReader(in2);
//			BufferedReader br= new BufferedReader(isr);
//			String line= br.readLine();
//			System.out.println(line);
			
//			InputStream in2 = s.getInputStream();
//			ObjectInputStream ois= new ObjectInputStream(in2);
//			ChatMsg cm2= (ChatMsg)ois.readObject();
//			System.out.printf("%s / %s \n",cm2.uid, cm2.pwd);

			}//while문 끝
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}System.out.println("서버 종료");
		
	}//메인끝
}//클래스끝
