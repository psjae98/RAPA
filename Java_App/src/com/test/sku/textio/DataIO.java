package com.test.sku.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataIO {
	static String fpath="C:/test/board.txt";
	
	public static boolean saveBoard(BoardVO b) 
	{
		//파일에 한 행으로 추가
		try {
			PrintWriter pw= new PrintWriter(new FileWriter(fpath,true));
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			String sDate= sdf.format(b.getRegdate());
			String line= String.format("%d|%s|%s|%s|%d|%s",
					b.getNo(),b.getTitle(),b.getAuthor(),sDate,b.getHits(),b.getContent());
			pw.println(line);
			pw.close();
			return true;
			}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void showBoard() { //list안씀
		File textFile= new File("C:/test/board.txt");	
		int len= (int)textFile.length();
		try {
			FileInputStream fin= new FileInputStream(textFile);
			byte[] buf= new byte[len]; // 파일 크기만큼의 메모리 공간 준비
			fin.read(buf);
			String str= new String(buf);
			System.out.println(str);
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static List<BoardVO> show() {
	try {
		BufferedReader br= new BufferedReader(new FileReader(fpath));
		String line = null;
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		List<BoardVO> list= new ArrayList<>();
		while((line=br.readLine())!=null) {
			BoardVO b= new BoardVO(line);
			list.add(b);
		}

		br.close();
		return list;
}
	catch(Exception e){
		e.printStackTrace();
	}
		return null;
	}
	
	public static void incHits(BoardVO b, List<BoardVO> list) 
	{
		b.setHits(b.getHits()+1);
		saveToFile(list);
	}
	
	public static BoardVO findBoard(int no) 
	{

			
		List<BoardVO> list= show();
			if (list!=null) 
			{
				for (int i=0;i<list.size();i++) 
				{
					BoardVO b = list.get(i);
					if (b.getNo()==no) 
					{
						incHits(b,list);
						return b;
					}
	
				}

			}return null;
	}
	
	public static BoardVO findBoard2(String title) {

		
		List<BoardVO> list= show();

	for (int i=0;i<list.size();i++) 
	{
		BoardVO b = list.get(i);
		if (b.getTitle().contains(title)) 
		{
			incHits(b,list);
			return b;
		}

	}

return null;
}
	
	
	public static boolean updateBoard(int no,String newcontent) 
	{
	
		
			List<BoardVO> list= show(); //list 불러옴
			if (list!=null) {
				for (int i=0;i<list.size();i++) //list 중에서 찾음
				{
					BoardVO b = list.get(i);
					if (b.getNo()==no) {	//번호가 일치하면
						b.setContent(newcontent);	//본문을 변경함
						if (saveToFile(list)) {
							return true;
						}
						else return false;
					}
	
				}
	
			}
			return false;
	}
	
	
		
	public static boolean updateBoard2(String title,String newcontent) 
	{

		
		List<BoardVO> list= show(); //list 불러옴
			
				for (int i=0;i<list.size();i++) //list 중에서 찾음
					{
						BoardVO b = list.get(i);
							
							if (b.getTitle().contains(title)) //제목을 포함하면
							{	
								b.setContent(newcontent);	//본문을 변경함
								if (saveToFile(list)) {
									return true;
								}
								else return false;
							}

					}
return false;
			
	}
	
	 private static boolean saveToFile(List<BoardVO> list) {
		 try {
			PrintWriter pw = new PrintWriter(new FileWriter(fpath));
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0; i<list.size();i++)
				{
				BoardVO b= list.get(i);
				String sDate= sdf.format(b.getRegdate());
				String line = String.format("%d|%s|%s|%s|%d|%s"
											,b.getNo(),b.getTitle(),b.getAuthor(),sDate,b.getHits(),b.getContent());
				pw.println(line);
				}
			pw.close();
			return true;
		} 
		 catch (Exception e)
		 {
	
			e.printStackTrace();
			return false;
		}
	
	 }
		public static boolean deleteBoard(int no) 
		{

			
			List<BoardVO> list= show(); //list 불러옴
	if (list!=null) 
	{
		for (int i=0;i<list.size();i++) //list 중에서 찾음
		{
			BoardVO b = list.get(i);
			if (b.getNo()==no) {	//번호가 일치하면
				list.remove(i);		//메모리에서 삭제함
				if (saveToFile(list)) {
					return true;
				}
				else return false;
			}

		}

	}return false;
		}
}
