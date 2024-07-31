package com.test.sku.pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class PetDataIO {
	static String serpath = "C:/test/pets";


	public static boolean addObj(PetBoardVO b) {
		List<PetBoardVO> list = getList();
		list.add(b);
		return overwrite(list);
		
		
	}
	
	private static boolean overwrite(List<PetBoardVO> list) {
		try {
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(serpath));
			oos.writeObject(list);
			oos.close();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		return false;
	}
	
	public static List<PetBoardVO> getList(){
		try {
			File ser= new File(serpath);
			if(!ser.exists()) {//직렬화파일이없으면
				List<PetBoardVO> list = new ArrayList<>();
				overwrite(list);
			}
			
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(serpath));
			List<PetBoardVO> list= (List<PetBoardVO>)ois.readObject();
			return list;
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}

	public static PetBoardVO findobj(int no) {
		getList();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(serpath));
			List<PetBoardVO> list= (List<PetBoardVO>)ois.readObject();
			if (list!=null)
			
			{ for(int i=0; i<list.size();i++) 
				{
					PetBoardVO b= list.get(i);
					if(b.getNo()==no)
					{
						return b;
					}
				ois.close();
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		return null;
	}

	public static boolean updateobj(int no, double newW) {
		List<PetBoardVO> list= getList();
		try {
		
		
			if (list!=null)
			
			{ for(int i=0; i<list.size();i++) 
				{
					PetBoardVO b= list.get(i);
					if(b.getNo()==no)
					{
						b.setWeight(newW);
						return overwrite(list);
						
					}
				
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return false;
	}

	public static boolean deleteobj(int no) {
		List<PetBoardVO> list= getList();
		try {
		
		
			if (list!=null)
			
			{ for(int i=0; i<list.size();i++) 
				{
					PetBoardVO b= list.get(i);
					if(b.getNo()==no)
					{
						list.remove(b);
						return overwrite(list);
						
					}
				
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return false;
	}
	
}//클래스끝
