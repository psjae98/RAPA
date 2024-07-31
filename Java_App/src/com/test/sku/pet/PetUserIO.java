package com.test.sku.pet;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 class PetUserIO {
	
	static Scanner kb= new Scanner(System.in);
	static String menu = "추가(a),목록(s),검색(f),수정(u),삭제(d),종료(x):";
	
	static String showMenu() {
	System.out.println(menu);
	String menu= kb.nextLine().trim();
	
	return menu;
	}

	public static void add() {
		System.out.println("번호:");
		int no= kb.nextInt(); kb.nextLine();
		System.out.println("품종:");
		String species= kb.nextLine();
		System.out.println("체중:");
		double weight= kb.nextDouble(); kb.nextLine();
		System.out.println("가격:");
		int price=kb.nextInt(); kb.nextLine();
		
		PetBoardVO b= new PetBoardVO();
		b.setNo(no);
		b.setSpecies(species);
		b.setWeight(weight);
		NumberFormat m= NumberFormat.getNumberInstance();
		String sprice=m.format(price);
		b.setPrice(price);
	
		//boolean saved= PetDataIO.addBoard(b);
		boolean added= PetDataIO.addObj(b);
		if (added) System.out.println("저장 성공");
		else System.err.println("저장 실패");
	
	}

	public static void show() {
		//List<PetBoardVO> list= PetDataIO.show();
		List<PetBoardVO> list=PetDataIO.getList();
		System.out.println();
		System.out.println("\t\t**애완동물 목록**");
		System.out.println("번호\t품종\t무게\t\t가격");
		Collections.sort(list);
		for (int i=0;i<list.size();i++) 
		{ PetBoardVO b = list.get(i);
			
        System.out.println(list.get(i));
		
	
			
		}
	}

	public static void findByNo() {
		System.out.println("찾을 애완동물의 번호:");
		int no= kb.nextInt();kb.nextLine();
		PetBoardVO b= PetDataIO.findobj(no);
		
		System.out.println("\t\t**"+no+"번의 정보**\n"+b);
	}

	public static void update() {
		System.out.println("바꿀 애완동물의 번호:");
		int no= kb.nextInt();kb.nextLine();
		System.out.println("바꿀 애완동물의 무게:");
		double newW= kb.nextDouble();kb.nextLine();
		 PetBoardVO b= PetDataIO.findobj(no);
		b.setWeight(newW);
		if(PetDataIO.updateobj(no,newW))
		{
			System.out.println("변경 성공");
		}
		else 
		{
			System.err.println("변경 실패");
		}
		
		System.out.println();
		
	}

	public static void delete() {
		System.out.println("삭제할 애완동물의 번호:");
		int no= kb.nextInt();kb.nextLine();
		 PetBoardVO b= PetDataIO.findobj(no);
		 if(PetDataIO.deleteobj(no))
		 {
				System.out.println("삭제 성공");
		 }
			else 
			{
				System.err.println("삭제 실패");
			}
	}
	
	
	
}//클래스끝
