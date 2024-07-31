package com.test.sku.Network2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FileIO {
	 
static List<FileInfo> list = new ArrayList<>();

static String srcPath= "C:/test/";
static String uploadPath="C:/test/upload/";
static String savePath="C:/test/download/";
static String serPath = "C:/test/ser/fileinfo.ser";

private static void serialization(List<FileInfo> list) {
    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serPath));
        oos.writeObject(list);
        oos.close();
        System.out.println("리스트 직렬화파일에 저장");
    } catch (FileNotFoundException e) {
        System.err.println("파일이 없습니다");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("파일에 저장 실패");
        e.printStackTrace();
    }
}


public static List<FileInfo> deserialization() {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serPath));
        List<FileInfo> list = (List<FileInfo>) ois.readObject();
        ois.close();
        return list;
    } catch (Exception e) {
        System.out.println("파일 읽기 실패");
        e.printStackTrace();
        return new ArrayList<>();
    }
}


public static byte[] load(String fname) {
	File f= new File(srcPath+fname);
	if (!f.exists()) {
	System.err.println(f.getPath()+"파일이 없습니다");
		return null;
	}
	try {
		FileInputStream fin= new FileInputStream(f);
		byte[] buf = new byte[(int)f.length()];
		fin.read(buf);
		fin.close();
		return buf;
	} catch (Exception e) {
		e.printStackTrace();
	}return null;
}

public static  String saveFile(String fileName, String author, byte[] fileData, String description) {

	list = deserialization();
    int fileId= list.size()+1;			//
    File file	=new File(uploadPath+fileName);
    String res="";
    
    try{
    	FileOutputStream out = new FileOutputStream(file);
    	out.write(fileData);
    	
    	FileInfo fileinfo =new FileInfo(fileId,fileName,author,fileData.length,description);
    	list.add(fileinfo);
    	
    	serialization(list);
    	res="파일 저장 완료:"+fileName+"\n파일정보:"+fileinfo;
    	
    	}catch(Exception e) {
    		res=("파일 저장실패");
    		
    	e.printStackTrace();
    	}


return res;
}


public static List<FileInfo> listForFiles() {
	return deserialization();

}
public static String findFileInfo(int no) {
	
	String res="";
	list = deserialization();
	for (int i=0; i<list.size();i++) {
		if(list.get(i).getId()==no) {
		res= list.get(i).toString();
			return res;
		}
	}res="파일 찾기 실패";
	
	

	return res;
}
public static String upadteFileInfo(int no,String newName,String newDescription) {
	 list = deserialization();
	 String res="";
		for (int i=0; i<list.size();i++) 
		{
			if(list.get(i).getId()==no) 
			{
				FileInfo fileinfo= list.get(i);
				String ofn=fileinfo.getFileName();
				File oldFile = new File("C:/test/upload/" + ofn);
	            File newFile = new File("C:/test/upload/" + newName);
	            	oldFile.renameTo(newFile);
	            		fileinfo.setFileName(newName);
	            		fileinfo.setDescription(newDescription);
	
	            		serialization(list);
	            		res= "완료:"+fileinfo;
	            		return res;
	            	}
	            	else	res="파일 찾기 실패";
			}return res;
		}
	




public static String deleteFileInfo(int no) {
	 list = deserialization();
	 String fname="";
	 String res="";
		list = deserialization();
		for (int i=0; i<list.size();i++) {
			if(list.get(i).getId()==no) {
				FileInfo fileinfo= list.get(i);
				for (int j = i; j < list.size(); j++) {
	                list.get(j).setId(list.get(j).getId() - 1);
	            }
				fname=fileinfo.getFileName();
				deleteFile(fname);

				list.remove(i);

				serialization(list);
				
				res="삭제완료";
				return res;
			}
			res="해당번호의 파일이 없거나 삭제에 실패했습니다";
			}
	return res;
}
public static void deleteFile(String fileName) {
    File file = new File(uploadPath+ fileName);
    if (file.exists()) {
        if (file.delete()) {
            System.out.println("파일 삭제 성공: " + fileName);
        } else {
            System.out.println("파일 삭제 실패: " + fileName);
        }
    } else {
        System.out.println("파일이 존재하지 않습니다: " + fileName);
    }
}
		
}
//리스트로 만드는건 deserialization(List<FileInfo> list) 써서 역직렬화 하고 출력



