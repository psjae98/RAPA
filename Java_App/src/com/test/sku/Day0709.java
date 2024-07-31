package com.test.sku;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Day0709 {
	public static void main(String[] args) {

		//System.out.println(Arrays.toString(sortIntArr(10)));
		
		System.out.println(getidpw());
		//getidpw2();
		
	}
	
	//파라미터로 정수를 전달하면 파라미터가 의미하는 갯수만큼 정수 배열을 생성하고 정렬하여 정렬된 배열을 리턴하는 메소드를 선언하고 호출하여 그 리턴값을 화면에 표시
	//선택정렬 알고리즘을 구현한 메소드를 selctionSort로 선언하고 sortIntArr을 활용해라.
	private static int[] selectionSort(int[] arr) {
		int n=arr.length;
		for (int i=0;i<n-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<n ;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			   int temp = arr[minIndex];
		       arr[minIndex] = arr[i];
		       arr[i] = temp;
		   }
			return arr;
		}
	
	private static int[] sortIntArr(int a) {
		Random rd= new Random();
		int arr[]= new int[a];
		
		for(int i=0; i<arr.length;i++) {
			arr[i]=rd.nextInt(20);
			
		}
		return selectionSort(arr);
		}

	//키보드에서 아이디 암호를 입력받아서 로그인하고 그 결과를 로그인 성공 로그인 실패로 표시하는 기능을 작성해보라.
	//boolean login(String id, String pwd) 활용
	
	private static boolean login(String id, String pwd) {
		if (id.equals("smith")&&pwd.equals("1234")) {
			return true;
		}
		else return false;
	}
	
	private static String getidpw() {
		String id="";
		String pwd="";
		System.out.println("아이디를 입력하세요:");
		Scanner kb= new Scanner(System.in);
		id=kb.nextLine();
		System.out.println("비밀번호를 입력하세요:");
		pwd=kb.nextLine();
		
		if(login(id,pwd)==true) {
			return "로그인 성공";
		}
		
		else {
			return "로그인 실패";
		}
		
	}
	
	private static void getidpw2() {
		String id="";
		String pwd="";
		Scanner kb= new Scanner(System.in);
		System.out.println("아이디 비밀번호:");
		String input=kb.nextLine().trim();
		String[] arr= input.split("\\s+");
		String result= login(arr[0],arr[1])?"로그인 성공" :"로그인 실패";
		
		System.out.println(result);
		
	}
	
	
	
	
	
}