package com.test.sku.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginThread extends Thread {
	private Socket s;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String uid;
    public LoginThread(Socket s) {
        try {
            OutputStream out = s.getOutputStream();
            oos = new ObjectOutputStream(out); // oos를 초기화

            // 직렬화 코드
            ChatMsg cm = new ChatMsg("서버", "클라이언트", "아이디 암호");
            oos.writeObject(cm);
            oos.flush();

            InputStream in = s.getInputStream();
            ois = new ObjectInputStream(in);
            ChatMsg cm2 = (ChatMsg) ois.readObject();
            System.out.printf("%s/%s \n", cm2.uid, cm2.pwd);

            if (cm2.uid.length()>=3 && cm2.pwd.length()>=3) { //이용자 인증되면
                System.out.println("로그인 성공");
                ChatThread.user.put(cm2.uid,oos);
                // ChatThread 생성자 호출 시 oos와 ois를 전달
                new ChatThread(this.uid,this.s,this.ois,this.oos).start();	//채팅시작
            } else {
                System.err.println("로그인 실패");				//아니면 로그인실패
                System.err.println("LoginThread dead");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    System.err.println("LoginThread dead");
    }
}