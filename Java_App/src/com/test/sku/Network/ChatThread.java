package com.test.sku.Network;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatThread extends Thread{
    private Socket s;
	private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String uid;
    static Map<String, ObjectOutputStream> user= new HashMap<>();  //로그인 성공한 사람의 아이디와 출력스트림 저장
    
	public ChatThread() {}
	
	public ChatThread(String uid,Socket s,ObjectInputStream ois, ObjectOutputStream oos) {
		this.s= s;
        this.ois = ois;
        this.oos = oos;
	ChatMsg cm= new ChatMsg("서버","클라이언트","로그인 성공");
	try {
		oos.writeObject(cm);
		oos.flush();
	} catch (IOException e) {

		e.printStackTrace();
		}
	}
	
public void run() 
	{
	try
	{ 	
		while(true) 
		{
				 // 메시지를 읽기
              ChatMsg cm= (ChatMsg)ois.readObject(); //클라이언트 종료 시 SocketException발생(난 EOFException)

           
              if(cm.isSecret) {
            	 
            	String receiver = cm.to;
            	user.get(cm.to).writeObject(cm);
            	user.get(cm.fdata).writeObject(cm);
            	user.get(cm.to).flush();
            	
            	continue;
             }
              //접속한 모든 이용자에게 메시지 전달
              Set<String> idSet=user.keySet();
              Iterator <String> idIter=idSet.iterator();	//Set을 반복할수있게 Iterator 설정
              ObjectOutputStream userOut= null;				//outputstream 변수초기화
              String userid = null;							//userid 변수초기화
              while(idIter.hasNext()) {						//Iterator 반복문 실행
            	  userid= idIter.next();					//아이디 가져옴
            	  userOut= user.get(userid);				
            	  userOut.writeObject(cm);
            	  userOut.flush();
              }
              
              // oos.writeObject(cm);
             // oos.flush();
            
		}
	}catch(Exception e) {
			//InetAddress ia= s.getInetAddress();     //왜안댐!
			//System.err.println(ia+"(이)가 나갔습니다");	//왜안댐!
			//user map에서 퇴장한 이용자의 정보를 삭제한다
			user.remove(uid);
			//e.printStackTrace();
	}
	System.err.println("ChatThread Dead");
	
	
	
	
}

}
