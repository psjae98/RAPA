package com.test.sku.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class SerializeMain {

	public static void main(String[] args) {
		//문서관리시스템
		//문서를 업로드하여 다른 이용자가 목록을 보고 골라서 파일을 다운로드 할 수 있다
		//업로ㄷ,다운로드,검색,수정,삭제,종료
		//Socket, ServerSocket
		//직렬화
		//한 문서에 포함되는 속성: 제목,파일명,날짜,작성자,파일크기
		//List<Document>
		//디렉토리에 포함된 파일의 리스트 추출하는법
		//listForFiles();
		searchFile();
		//listSerialization();
		//deserialization();
		//updateList();
		//update02();
		//delete();
	}	//메인끝

	
	
	private static void listForFiles() {
		
		String path="C:/test";
		File f = new File(path);
		File [] files=f.listFiles();
		for(int i=0; i<files.length;i++) {
			System.out.println(files[i]);
			if (files[i].isDirectory()){
				System.out.println(files[i]+"->Dir");
			}
				else {
					System.out.println(files[i]+"->File");
				}
			}
		}
	private static void searchFile() {
		String key = "sample.txt";
		String path= "C:/test";
		File f= new File(path);
		File[] files= f.listFiles(); 
		for(int i=0; i<files.length;i++) {
			if(files[i].getName().equals(key)) {
				System.out.printf("%s\t %d",files[i].getName(), files[i].length());
			}
		}
		
	}	
	private static void listSerialization(){
		//List<String> names = List.of("강호동","이수근","안재현","은지원","송민호","피오","조규현");
		List<String> names= new ArrayList<>();
		names.add("송민호");
		names.add("은지원");
		names.add("이수근");
		names.add("피오");
		names.add("강호동");
		names.add("조규현");
		names.add("안재현");
		
		for(int i=0; i<names.size();i++) {
			System.out.println(names.get(i));
		}
		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("C:/test/list_names.ser"));
			oos.writeObject(names);
			oos.close();
			System.out.println("리스트 직렬화파일에 저장");
		} catch (FileNotFoundException e) {

			System.err.println("파일이없어용");
			e.printStackTrace();
		} catch (IOException e) {

			System.err.println("파일에 저장 실패");
				e.printStackTrace();
		}
	}
	private static void deserialization(){
		String path= "C:/test/list_names.ser";
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			List<String> list = (List<String>) ois.readObject();
			ois.close();
			
			System.out.println("\t 역직렬화 후의 리스트 내용 보기");
			for (int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
			e.printStackTrace();
		}
	}
	
	private static List<Emp> deSerialization1() {
		String path= "C:/test/emps.ser";
	      try {
	         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("path"));
	         List<Emp> list = (List<Emp>)ois.readObject();
	         ois.close();
	         System.out.println("\t역직렬화 후의 리스트 내용보기");
	         for(int i=0; i<list.size(); i++) {
	            System.out.println(list.get(i));
	         }
	         return list;
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("파일 읽기 실패");
	      }
	      return null;
	   }
	
	private static void updateList() {
		String path= "C:/test/list_names.ser";
		try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		List<String> list = (List<String>) ois.readObject();
		ois.close();
//		  List<String> mlist = new ArrayList<>(list);	//List<String>을 ArrayList로 바꿔줘야함
													//위에서 안해준거였어서 위에 고쳤으므로 다시 주석처리함
		System.out.println("\t 안재현을 이승기로 변경");
		for (int i=0;i<list.size();i++) {
			if (list.get(i).equals("안재현")) {
				list.set(i,"이승기");
			}
		}
		
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("C:/test/list_names.ser"));
		oos.writeObject(list);
		oos.close();
		System.out.println("리스트 다시 직렬화파일에 저장 성공");
		
		}catch(Exception e) {
			System.err.println("파일 변경 실패");
			e.printStackTrace();
		}
	}
	
	private static void update02() {
		String path= "C:/test/emps.ser";
		List<Emp> list= new ArrayList<>();
		Emp e1= new Emp(11,"Dr.Oc",20,400);
		Emp e2= new Emp(12,"Mary",20,250);
		Emp e3= new Emp(13,"Gwen",20,260);
		Emp e4= new Emp(14,"Sam",21,270);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//12번의 급여 +200
		Emp key= new Emp(12);
		if(list.contains(key)) {
			int idx=list.indexOf(key);
			Emp found=list.get(idx);
			found.setSal(found.getSal()+200);
		}
		//Gwen의 부서를 50번으로 변경
		Emp key2= new Emp(13);
		if(list.contains(key2)) {
			int idx2=list.indexOf(key2);
			Emp found=list.get(idx2);
			found.setDeptno(50);
		}

		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(list);
			oos.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			List<Emp> list2 = (List<Emp>) ois.readObject();
			ois.close();
			
			System.out.println("\t 역직렬화 후의 리스트 내용 보기");
			for (int i=0;i<list2.size();i++) {
				System.out.println(list2.get(i));
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
			e.printStackTrace();
		}
	}
	private static void delete() {
		File f= new File("C:/test/download/sample.jpg");
		if (f.exists()) {
			boolean deleted = f.delete();
			if (deleted) {
				System.out.println("삭제완료");
			}else
				System.err.println("삭제실패");
		}else
			System.err.println("파일없음");
		
		
		
		//DocClient, DocServer
		/*	1.DocServer만들기(무한대기할수있게)
		 * +"서버 대기중..."	
		 * +while문 안에
		 * 	+.(s.accept())
		 * 	+ "클라이언트 접속됨"
		 * 	2.DocClient
		 * + 서버에 접속(뉴 소켓)
		 * +클라이언트 종료(서버에 알림), 서버가 끝나는지 확인.(안끝나야됨)
		 */
	}
}//클래스끝
