package com.test.sku.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OracleJDBC 
{	static EMPDAO dao = new EMPDAO(); 
	static EnhancedEmpDAO edao= new EnhancedEmpDAO();
	static Scanner kb= new Scanner(System.in);
	  static enum MENU{ADD,LIST,FIND,DETAIL,UPDATE,BOARD,GROUP,PAGE,HIER,DELETE,EXIT};

   public static void main(String[] args) 
   {	boolean go=true;
	   while(true) {


switch(showMenu()) {
       case ADD:       addEmp();       break;
       case LIST:      list();      break;
       case FIND:      find();      break;
       case DETAIL:    showDetail(); break;
       case PAGE:		showpage(); break;
       case BOARD: 		showBoard();	break;
       case GROUP: 		showgroup(); break;
       case UPDATE:    updateSal();    break;
       case HIER:    showhierPage();    break;
       case DELETE:    delete();   break;
       case EXIT:   System.out.println("프로그램 종료");    return;   
       
       }
    }
    
 



   
   
   }//메인끝
 
   private static void showBoard() {
	   List<Map<String, String>> list;
	   list = BoardDAO.getBoard();

	
		System.out.printf("%s\t%s\t%s\n","글 번호","글 제목","첨부파일 수");
		
		for (int i=0; i<=list.size(); i++) {
			Map<String, String> map = list.get(i);
			 String sBid = map.get("BID");
	         String sTitle = map.get("TITLE");
	         String sAttCnt = map.get("ATTCNT");
			System.out.printf("%s\t%s\t%s\n",sBid,sTitle,sAttCnt);
			
		}
		
   }
   
private static void showgroup() {
	Map<Integer,String[]> map = dao.getEmpbyDeptno();
	System.out.printf("%s\t%s\n","부서번호","사원이름");
	
	for (int deptno=10; deptno<=40; deptno+=10) {
		String[] names= map.get(deptno);
		System.out.printf("%d \t %s\n",deptno,Arrays.toString(names));
		
	}
	
}

static MENU showMenu() {
	      System.out.print("추가(a), 목록(s), 검색(f), 부서 상세(JOIN 연습)(i),보드(b), 계층페이징(h), 수정(u),그룹(g), 페이지보기(p), 삭제(d), 종료(x):");
	      String m = kb.nextLine().trim();
	      MENU menu = null;
	      switch(m) 
	      {
	      	case "a": menu = MENU.ADD;     break;
	      	case "s": menu = MENU.LIST;    break;
	      	case "f": menu = MENU.FIND;    break;
	      	case "i": menu = MENU.DETAIL;  break;
	      	case "u": menu = MENU.UPDATE;  break;
	      	case "b": menu = MENU.BOARD; break;
	      	case "g": menu = MENU.GROUP; break;
	      	case "p": menu = MENU.PAGE;	 break;
	      	case "h": menu = MENU.HIER;	 break;
	      	case "d": menu = MENU.DELETE;  break;
	      	case "x": menu = MENU.EXIT;    break;
	      	default: 	System.err.println("잘못된입력입니다");  break;
	      }
	      return menu;
	   }


private static void showhierPage() {

	   System.out.println("페이지 번호:");
	   int page= kb.nextInt();kb.nextLine();
	   System.out.println("한페이지당 컬럼 수:");
	   int ipp= kb.nextInt();kb.nextLine();
	   
	   PageItem pi = edao.hierPaging(page,ipp);	
	   List<EmpVO> list = pi.getList();
	   int cp= pi.getCurrPage();
	   int tp= pi.getTotalPages();
	   System.out.printf("%d/%d\n",cp,tp);
	   for (int i=0;i<list.size();i++) 
	   		{
		   System.out.println(list.get(i));
	   		}
}

private static void showpage() {

	   System.out.println("페이지 번호:");
	   int page= kb.nextInt();kb.nextLine();
	   PageItem pi = edao.getPage3(page,3);	
	   List<EmpVO> list = pi.getList();
	   int cp= pi.getCurrPage();
	   int tp= pi.getTotalPages();
	   System.out.printf("%d/%d\n",cp,tp);
	   for (int i=0;i<list.size();i++) 
	   		{
		   System.out.println(list.get(i));
	   		}
   }

   private static void showDetail() {
	   System.out.println("상세검색할 부서번호 입력:");
	   int no= kb.nextInt();kb.nextLine();
	   List<Map<String,String>> results = edao.getJoinResult(no);	
	   for(Map <String, String> result: results) {				
		   System.out.println(result);
	   }
   }
   
	  private static void addEmp() {
		  EmpVO emp = new EmpVO();
		  System.out.println("추가할 직원의 사번입력");
			int newEmpno= kb.nextInt();kb.nextLine();
			System.out.println("추가할 직원의 이름입력");
	  		String newEname= kb.nextLine();
	  		System.out.println("추가할 직원의 급여입력");
	  		int newSal= kb.nextInt();kb.nextLine();
	  		System.out.println("추가할 직원의 부서번호입력");
	  		int newDeptno= kb.nextInt();kb.nextLine();
	  		System.out.println("추가할 직원의 직책입력");
	  		String newJob=kb.nextLine();
	  		System.out.println("추가할 직원의 입사일 입력(yyyy-MM-dd)");
	  		String newHiredate=kb.nextLine();
	  		
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		      java.util.Date _hiredate = null;
		      try {
		         _hiredate = sdf.parse(newHiredate);
		      } catch (ParseException e) {
		         e.printStackTrace();
		      }
		      java.sql.Date hiredate =  new java.sql.Date(_hiredate.getTime());

		   emp.setEmpno(newEmpno);
		   emp.setEname(newEname);
		   emp.setDeptno(newDeptno);
		   emp.setSal(newSal);
		   emp.setHiredate(hiredate);
		   emp.setJob(newJob);
		  
		boolean added=edao.addEmp(emp);
	  }
	  
	  private static void list() { 
	  List<EmpVO> list= edao.getList();
	  
		for(EmpVO listemp: list) {
	  System.out.println(listemp);
		}
	  }
	  
		private static void find() { 
		 System.out.println("검색할 직무 입력:");
		  String job=kb.nextLine();
		  List<EmpVO> findlist= edao.findByJob(job);
		   
		  for(EmpVO findemp : findlist) {
			  System.out.println(findemp);
		  }
	  }
		
		private static void updateSal() {
		System.out.println("수정할 직원의 사번입력");
  		int empno= kb.nextInt();kb.nextLine();
  		System.out.println("입력한 직원의 바뀐 급여 입력");
  		int newsal= kb.nextInt();kb.nextLine();
  		EmpVO updateemp = new EmpVO(empno);
  		updateemp.setSal(newsal);
   
  		boolean updated=edao.updateSal(updateemp);
  		System.out.println("수정 결과:"+updated);
		}
		
		private static void delete() 
		{
		 System.out.println("삭제할 직원의 사번입력");
	  		int delno= kb.nextInt();kb.nextLine();
		  	boolean deleted=edao.delete(delno);
		  	System.out.println("삭제 결과:"+deleted);
		  }
}//클래스끝