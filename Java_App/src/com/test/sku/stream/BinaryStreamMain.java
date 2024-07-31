package com.test.sku.stream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinaryStreamMain {

	public static void main(String[] args)
	{
		//text, non-text
		
		/*Character Stream: 문자를 다루는 스트림
		 *+Reader,Writer
		 * Binary Stream(Byte Stream)
		 * +InputStream,OutputStream
		 * 
		 * 변환스트림
		 * +InputStreamReader: 바이너리 데이터를 문자 데이터로 변환
		 *  +OutputStreamWriter: 문자 데이터를 바이너리 데이터로 변환
		 *  
		 *  네트워크 통신
		 *  +문자 메시지 --> 바이트 데이터 --> 문자 데이터
		 *  
		 *  
		 */
//		binaryTest1();
//		binaryTest2();
//		binaryTest3();
//		binaryTest4();		
		//binaryTest5();
		//conversionTest1();
		//conversionTest2();
		conversionTest3();
	}//메인끝
	private static void binaryTest1() {
	String imgpath = "C://test/img/sample.jpg";
	//byte(1) short(2) int(4) long (8)
	try {
		FileInputStream fin= new FileInputStream(imgpath);
		while (true) {
		int data=fin.read();
		
			if (data==-1) break;
			System.out.print(data+",");
		}	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(IOException e1) {
		e1.printStackTrace();
	}
	
	
	
	}
	private static void binaryTest2() {
	String imgpath = "C:\\test\\img\\sample.jpg";
	//byte(1) short(2) int(4) long (8)
	try {
		FileInputStream fin= new FileInputStream(imgpath);
	
		byte[] imgdata=fin.readAllBytes();
		
			System.out.print("이미지 읽기 완료. 이미지 파일 크기:"+imgdata.length);
			} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(IOException e1) {
		e1.printStackTrace();
	}
	
	
	
	}
	
	private static void binaryTest3() {
		String imgpath = "C:\\test\\img\\sample.jpg";
		//byte(1) short(2) int(4) long (8)
		try {
			FileInputStream fin= new FileInputStream(imgpath);
		
			byte[] imgdata=fin.readAllBytes();
			fin.close();
			String imgdest= "C:\\test\\img\\sample_cpy.jpg";
			FileOutputStream fout= new FileOutputStream(imgdest);
			fout.write(imgdata);
			fout.close();
				System.out.print("이미지 복사 완료");
				}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e1) 
		{
			e1.printStackTrace();
		}
		}
	
	private static void binaryTest4() {
		String imgpath = "C:\\test\\img\\sample.jpg";
		String imgdest= "C:\\test\\img\\sample_cpy2.jpg";
		//byte(1) short(2) int(4) long (8)
		try {
			FileInputStream fin= new FileInputStream(imgpath);
			FileOutputStream fout= new FileOutputStream(imgdest);
			byte[] buf = new byte[256];
			while (true) 
			{
				int cnt=fin.read(buf);
				if (cnt==-1) break;
				fout.write(buf,0,cnt);
				
			}
			
			fin.close();
			fout.close();
				System.out.print("이미지 복사 완료");
				}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e1) 
		{
			e1.printStackTrace();
		}
		}
	
	private static void binaryTest5() {
		String imgpath = "C:\\test\\img\\sample.jpg";
		String imgdest= "C:\\test\\img\\sample_cpy3.jpg";
		//이미지를 반복하여 읽어서 메모리에 데이터를 누적한다
		try {
			FileInputStream fin= new FileInputStream(imgpath);
			FileOutputStream fout= new FileOutputStream(imgdest);
			//ByteArrayInputStream bin = new ByteArrayInputStream();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(); // 바이트배열에 출력
			byte[] buf = new byte[256];
			while (true) 
			{
				int cnt=fin.read(buf);
				if (cnt==-1) break;
				bout.write(buf,0,cnt);
				
			}
			byte[] img=bout.toByteArray();
			fout.write(img);
			bout.close();
			fin.close();
			fout.close();
				System.out.print("이미지 복사 완료");
				}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e1) 
		{
			e1.printStackTrace();
		}
		}
	
	private static void conversionTest1()
	{Scanner kb= new Scanner(System.in);
	String fpath="C:/test/conv.txt";
		//키보드에서 문자열을 받아서 파일에 저장할 때 문자스트림이 아닌 바이트 스트림을 사용한다
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(fpath));
		
			// 반복하여 키보드에서 입력을 받고 그 데이터를 파일에 누적한다
			//이용자가 그냥 엔터를 치면 입력 완료로 간주하고 그간 누적된 텍스트파일을 읽어서 화면에 표시한다
			while (true) {
				System.out.println("뭔가입력하세요. 그냥엔터키 누르면 종료:");
				String line= kb.nextLine();
				if (line.equals("")) 
				 break;
				pw.println(line);
			}
			pw.close();
			BufferedReader br= new BufferedReader(new FileReader (fpath));
			
			String line=null;
			while(true){
			line= br.readLine();
			if (line==null) break;
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void conversionTest2()
	{
		Scanner kb= new Scanner(System.in);
		String fpath="C:/test/members.txt";
		try {
		InputStreamReader isr= new InputStreamReader(new FileInputStream (fpath)); //바이트데이터를 텍스트로읽어줌
		BufferedReader br= new BufferedReader(isr);								
		
		String line=null;
		while(true){
		line= br.readLine();
		if (line==null) break;
			System.out.println(line);
		}
		br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void conversionTest3() 
	{Scanner kb= new Scanner(System.in);
		String fpath="C:/test/conv.txt";
	
	//키보드에서 문자열을 받아서 파일에 저장할 때 문자스트림이 아닌 바이트 스트림을 사용한다
	try {OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fpath));
		PrintWriter pw = new PrintWriter(osw);
	
		// 반복하여 키보드에서 입력을 받고 그 데이터를 파일에 누적한다
		//이용자가 그냥 엔터를 치면 입력 완료로 간주
		while (true) {
			System.out.println("뭔가입력하세요. 그냥엔터키 누르면 종료:");
			String line= kb.nextLine();
			if (line.equals("")) 
			 break;
			pw.println(line);
		}
		pw.close();
	}
	catch(Exception e) {
		e.printStackTrace();
		}
	}
}//클래스끝
