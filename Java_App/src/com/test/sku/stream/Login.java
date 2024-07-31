package com.test.sku.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		//trylogin();
register();
	}//메인 끝 중괄호
	private static List<Users> listFromFile() { 

		try {
		FileReader fr= new FileReader("C:/test/users.txt");
		BufferedReader br= new BufferedReader(fr);
		List<Users> list= new ArrayList<>();
		
		String line = null;
		while ((line= br.readLine())!=null) {

				Users u = new Users();
				 u.setUser(line);
			list.add(u);
			}
		
		/*while((line=br.readLine())!=null) {
			
			list.add(new Member(line));
			
		}*/
		br.close();
		return list;

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Users> userList() {
		List <Users> list= listFromFile();
		for(int i=0;i<list.size();i++) {
		Users user= list.get(i);
		}
		return list;
	}

	
private static void trylogin() {
	System.out.println("아이디:비밀번호 입력하세요:");
	Scanner kb= new Scanner(System.in);
	String pressed=kb.nextLine();
	List<Users> list= userList();
	boolean res= false;
	for(int i=0;i<list.size();i++) {
 if (pressed.equals(list.get(i).getUser())) {
	 	System.out.println("로그인 성공");
	 res=true;
 }
	}
	if (res==false){
		System.out.println("로그인 실패");
	}
	kb.close();
}
	

private static void textWrite() {
//메모리에 문자열--> 파일에 기록(메모리에서 디스크로 데이터 이동)
//문자열을 파일(File)에 기록(Write) : FileWriter
	System.out.println(); //printStream.println()
	
try {
	String fname= "C:/test/mytext.txt";
	PrintWriter pw= new PrintWriter(new FileWriter(fname,true));
	pw.println("smith:1234");
	pw.println("scott:9876");
	pw.close();
	}
catch(IOException e){
	e.printStackTrace();
}
}
	
private static void register() {
    System.out.println("아이디 비밀번호 입력:");
    Scanner kb = new Scanner(System.in);
    String id = kb.next();
    String pwd = kb.next();
	kb.nextLine();
    // 입력 검증
 
        
        kb.close();
        
    
    

    Users user = new Users(id,pwd);
    
    boolean added = appendUser(user);
    if (added) {
        System.out.println("사용자 정보 추가 성공");
    } else {
        System.out.println("사용자 정보 추가 실패");
    }
    
    kb.close();
}

private static boolean appendUser(Users user) {
    try (PrintWriter pw = new PrintWriter(new FileWriter("C:/test/users.txt", true))) {
        pw.println(user.getId() + ":" + user.getPwd());
        pw.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}


//키보드에서 아이디 암호를 입력받아서 users.text 파일에 한 행으로 추가하는 기능
//아이디:암호
//회원정보 추가 성공, users.txt 파일의 목록을 화면에 표시해서 확인
}//클래스 끝 중괄호

class Users {
String user;
String id;
String pwd;
public Users(String[] token) {
	
	this.id=token[0];
	this.pwd=token[1];
}
public Users(String line) {
	String[]token = line.split("\\:");
	setId(token[0]);
	setPwd(token[1]);
}

public Users(String id, String pwd) {

		this.id= id;
		this.pwd= pwd;
}
	public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
	public Users() {

	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Users [user=" + user + "]";
	}

	@Override
public int hashCode() {
	return Objects.hash(user);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Users other = (Users) obj;
	return Objects.equals(user, other.user);
}
		
	
	
	}
	
	
	
	


