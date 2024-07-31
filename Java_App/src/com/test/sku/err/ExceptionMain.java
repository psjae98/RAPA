package com.test.sku.err;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {
static Scanner kb= new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 에러,예외
		 * Error:
		 * Exception: Mild Error
		 * 소프트웨어 에러(실행중 에러)
		 * 비정상 종료
		 */
		
		//error01();
		//error02();
		//error03();
		//error04();
//		try {
//			error05();
//		} catch (PasswordException e) {
//		System.err.println(e.getMessage());
//		
		try {
			error06();
		} catch (UserLoginException e1) {
			System.err.println(e1.getMessage());
		}
		}

	
private static void error01() 
{
	
	int a=5;
	int b=0;
	int c=0;
	try { 
		c=a/b;//b==0이면 비정상종료
		System.out.println("나눈 결과:"+c);
		}

	catch(ArithmeticException ae) {
	
		//System.err.println("error:"+ae.getMessage());
		System.out.println("0으로 나눌 수 없습니다");
		return;
	}
	finally //예외 발생과 무관하게 실행되는 블럭
	{
		System.out.println("finally 블럭");
	}
System.out.println("메소드 종료");
	
}
	
	private static void error02() {
		Scanner kb= new Scanner(System.in);
		int a;
		int b;
	
		while (true){
		try {
			System.out.println("정수 a:");
		 a= kb.nextInt();
			System.out.println("정수 b:");
		 b= kb.nextInt();
		//한번에 입력받기
		//System.out.println("정수 a b 입력:");
		//int a= kb.nextInt();
		//int b= kb.nextInt();
		
		int c= a/b;
		System.out.println(a+"/"+b+"="+c);
		break;
		}
//		catch(InputMismatchException me) 
//		{
//			System.err.println("정수형으로 입력해주세요");
//		}
//		catch(ArithmeticException e)
//		{
//			System.err.println("0으로 나눌 수 없습니다. b에 0을 넣지 마세요");
//		}
		catch(Exception e) {
			if (e instanceof InputMismatchException) {
				System.err.println("정수형으로 입력해주세요");
			}
			else if (e instanceof ArithmeticException) {
				System.err.println("0으로 나눌 수 없습니다. b에 0을 넣지 마세요");
		}
		}
		finally {
			kb.nextLine();
		}
	}
	System.out.println("프로그램 종료");
	}
	
	private static void error03() {
		//abc.txt파일을열고 그안에 저장된 텍스트를 화면에 표시
		String fpath="C:/test/abc.txt";
		BufferedReader br= null;
		try {
			 br= new BufferedReader(new FileReader(fpath));
			String line= null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("파일이없음");
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (br!=null)br.close();
			}
			catch(IOException e){
				e.printStackTrace();
				}
		}
		System.out.println("메소드 종료");
	}
	
	private static void error04() throws Exception{
		String fpath="C:/test/abc.txt";
		BufferedReader br= null;
		
			 br= new BufferedReader(new FileReader(fpath));
			String line= null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
	}
	private static void error05() throws PasswordException {
		System.out.println("id password:");
		String uid=kb.next();
		String pwd= kb.nextLine();
		
		if (pwd.length()<5) {
			throw new PasswordException("암호는 5자이상이여야 합니다");
		}
		else System.out.println("id:"+uid+"\t password:"+pwd);
		System.out.println("메소드 종료");
	}
	
//	private static void error06() throws UserLoginException{
//		//users.txt파일에 아이디 암호를 5개 저장하고
//		//키보드에서 로그인할 때 로그인 실패할 경우 UserLoginException 발생하도록 하고
//		//발생한 예외를 처리하여 이용자에게 적절한 메시지를 표시하여 다시 로그인할 수 있도록 반복로그인되게 작성
//		String fpath="C:/test/users.txt";
//		BufferedReader br= null;
//		while (true) {
//		try {
//			br= new BufferedReader(new FileReader(fpath));
//		
//			System.out.println("id:password 입력");
//			String login=kb.nextLine();
//			String line= null;
//		boolean success=false;
//				while ((line=br.readLine())!=null) 
//				{
//					if (login.equals(line))
//					{
//						System.out.println("로그인 성공");
//						success=true;
//						
//					}
//					if (success) break;
//					else throw new UserLoginException("로그인 실패");
//				}
//			}
//		 catch (FileNotFoundException e) {
//			System.err.println("파일을 찾지 못했음");
//			break;
//		}
//			catch (IOException e) {
//	
//			e.printStackTrace();
//			break;
//		}finally
//			{
//				try 
//				{if (br!=null)
//					br.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		}
//		kb.close();
//		System.out.println("메소드 종료");
//	}
//		
	 private static void error06() throws UserLoginException {
	        String fpath = "C:/test/users.txt";
	        BufferedReader br = null;

	        while (true) {
	            try {
	                br = new BufferedReader(new FileReader(fpath));

	                System.out.println("id:password 입력");
	                String login = kb.nextLine();
	                String line;
	                boolean success = false;

	                while ((line = br.readLine()) != null) {
	                    if (login.equals(line)) {
	                        success = true;
	                        break;
	                    }
	                }

	                if (success) {
	                    System.out.println("로그인 성공");
	                    break;  // 로그인 성공 시 루프 종료
	                } else {
	                    throw new UserLoginException("로그인 실패");
	                }

	            } catch (FileNotFoundException e) {
	                System.err.println("파일을 찾지 못했음");
	                break;  // 파일을 찾을 수 없으면 루프 종료
	            } catch (IOException e) {
	                e.printStackTrace();
	                break;  // IO 예외 발생 시 루프 종료
	            } catch (UserLoginException e) {
	                System.err.println(e.getMessage());
	            } finally {
	                try {
	                    if (br != null) {
	                        br.close();
	                    }
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        kb.close();
	        System.out.println("메소드 종료");
	    }
	
	}//클래스끝
