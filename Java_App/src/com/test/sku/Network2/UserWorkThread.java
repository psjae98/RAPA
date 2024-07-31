package com.test.sku.Network2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;




public class UserWorkThread extends Thread{
	static Scanner kb= new Scanner(System.in);
	private Socket s;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    
	public UserWorkThread() {}

		
	public UserWorkThread(Socket s) {
		this.s=s;
		try
		{	OutputStream out = s.getOutputStream();
			this.oos = new ObjectOutputStream(out);
			InputStream in = s.getInputStream();
			this.ois = new ObjectInputStream(in);
			
			while(true) {
				ChatMsg cm = new ChatMsg("서버", "클라이언트x", "업로드(a), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x)");
				oos.writeObject(cm);
				oos.flush();

				ChatMsg request= (ChatMsg) ois.readObject();
				if (request.upload){
					String res= FileIO.saveFile(request.fname, request.author, request.fdata, request.description);
	                    ChatMsg response = new ChatMsg("서버", "클라이언트", res);
	                    
	                    oos.writeObject(response);
	                    oos.flush();
				}else if (request.list){
					List<FileInfo> res= FileIO.deserialization();
					ChatMsg Response = new ChatMsg("서버", "클라이언트", "파일정보 목록:"+res);
	                Response.fileInfoList = res;
	                oos.writeObject(Response);
	                oos.flush();
				}else if(request.find) {
					int no= request.no;
					String res=FileIO.findFileInfo(no);
					ChatMsg Response = new ChatMsg("서버", "클라이언트", "파일정보:"+res);
	               oos.writeObject(Response);
	                oos.flush();
					
				}else if(request.update) {
					int no= request.no;
					String newName= request.newName;
					String newDescription= request.newDescription;
					String res=FileIO.upadteFileInfo(no,newName,newDescription);
					ChatMsg Response = new ChatMsg("서버", "클라이언트", "수정결과:"+res);
	               oos.writeObject(Response);
	                oos.flush();
				
				}else if(request.delete) {
					int no= request.no;
					String yn=request.yesno;
					if (yn.equals("y")) {
					String res= FileIO.deleteFileInfo(no);
					ChatMsg Response = new ChatMsg("서버", "클라이언트", " 삭제결과:"+res);
		               oos.writeObject(Response);
		                oos.flush();
					}
				} else continue;
				



			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.err.println("UserWorkThread Dead");
		
	}


}

