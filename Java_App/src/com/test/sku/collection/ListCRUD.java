package com.test.sku.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;










public class ListCRUD {
	
	static Scanner kb= new Scanner(System.in);
	 static List<Employee> emps = new ArrayList<Employee>();


public static void main (String[] args) {
	Set<Employee> empSet= new HashSet<>();
	Employee emp1= new Employee(11);
	Employee emp2= new Employee(11);
	
	empSet.add(emp1);
	empSet.add(emp2);
	
	System.out.println("원소의 갯수"+empSet.size()); 
	initemps();
//사원: Employee(데이터 모델)	
//empno,ename,deptno,sal,hiredate
//추가(a) 목록(s) 검색(f) 수정(u) 삭제(d) 종료(x):
//private constructor setter getter Override Overload 사용
//기능 구현은 현재 클래스에 클래스 메소드 선언으로 해결
//날짜 다루기. java.util.Date;
// Date hireDate= new Date(); 현재날짜
//String sDate="2020-10-21";
//날짜를 처리할때는 문자열을 날짜로 변환해야함
//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
//sdf.parse(sDate);
//try{ Date hiredate= sdf.parse(sDate);
//    sDate= sdf.format(hiredate);}
//catch(ParseException e){
// e.printStackTrace();}
while (true) {
	
System.out.println("추가(a) 목록(s) 검색(f) 수정(u) 삭제(d) 종료(x):");
String menu=kb.nextLine();

switch (menu) {

case "a":
Empadd();
break;

case "s":
Empsearch();
break;

case "f":
	Empfind();
	break;
	
case "u":
	Empupdate();
	break;
	
case "d":
	Empdelete();
	break;
	
case "x":
	
		return;
	
	}	
	
}
}



private static void initemps() {
	try {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
emps.add(new Employee(11,"smith",15,300,sdf.parse("2022-04-15")));
emps.add(new Employee(12,"sam",16,350,sdf.parse("2019-01-06")));
emps.add(new Employee(13,"kim",16,330,sdf.parse("2021-09-16")));
emps.add(new Employee(14,"kang",17,360,sdf.parse("2018-12-15")));
emps.add(new Employee(15,"son",17,330,sdf.parse("2021-12-05")));
	}
	catch(ParseException e){
		e.printStackTrace();
	}
	}

private static void Empadd() {
    System.out.print("사번 이름 부서번호 월급 입사일(yyyy-MM-dd): ");
String input = kb.nextLine();
String[] tokens = input.split("\\s+");

if (tokens.length == 5) {
        Employee e = new Employee(tokens);
        emps.add(e);
        System.out.println("사원이 추가되었습니다.");

} else {
    System.err.println("올바른 형식으로 입력해주세요.");
    }
}



private static void Empsearch() {
    System.out.println("\t***회원목록***");
    for(int i = 0; i <emps.size(); i++) {
       System.out.println(emps.get(i));
    }
 }
private static void Empfind() {
	System.out.print("사원번호로 찾으려면 e 이름으로 찾으려면 n:");
String findwith=kb.nextLine();

if (findwith.equals("e")){// 회원 번호 입력 받기
System.out.print("찾으실 사원번호를 입력하세요: ");
int empno = Integer.parseInt(kb.nextLine()); // 버퍼 비우기


Employee key= new Employee(empno);
if (emps.contains(key)) {
    int idx = emps.indexOf(key);
    Employee foundEmployee = emps.get(idx); //override 해라
    System.out.println(empno + "번의 사원정보: " + foundEmployee.toString());
} else {
    System.out.println(empno + "번의 사원을 찾을 수 없습니다.");
}
}
else if (findwith.equals("n")){
	System.out.print("찾으실 이름을 입력하세요: ");
    String ename = kb.nextLine(); // 버퍼 비우기
    

    Employee key= new Employee(ename);
    if (emps.contains(key)) {
        int idx = emps.indexOf(key);
        Employee foundEmployee = emps.get(idx); //override 해라
        System.out.println(ename + "의 사원정보: " + foundEmployee.toString());
    } else {
        System.out.println(ename + " 사원을 찾을 수 없습니다.");
	    }

	}
}


private static void Empupdate() {
	System.out.print("변경하실 사원번호를 입력하세요: ");
   int empno = kb.nextInt();
    kb.nextLine(); // 버퍼 비우기
 
    Employee key= new Employee(empno);
    if (emps.contains(key)) {
        int idx = emps.indexOf(key);
        
        Employee foundEmployee = emps.get(idx); //override 해라
        System.out.print(empno+"번 사원의 변경된 부서번호 월급 ");
        String input = kb.nextLine();
        String[] tokens = input.split("\\s+");

        if (tokens.length == 2) {
        	int newDeptno = Integer.parseInt(tokens[0]);
            int newSal = Integer.parseInt(tokens[1]);
            
            emps.get(idx).setDeptno(newDeptno);
            emps.get(idx).setSal(newSal);
                System.out.println("사원정보가 변경되었습니다.");

        } else {
            System.err.println("올바른 형식으로 입력해주세요.");
        }
    } else {
        System.out.println(empno + "번의 사원을 찾을 수 없습니다.");
	    }
	
	
	
	
}

private static void Empdelete() {
	System.out.println("삭제할 사원 번호:");
int empno=kb.nextInt();
kb.nextLine();

Employee memobj= new Employee(empno);
Employee key = new Employee(empno);
boolean removed= emps.remove(key);
System.out.println("삭제결과:"+removed);
	
	
	
	
}
}


class Employee{
	int empno;
	String ename;
	int deptno;
	int sal;
	Date hiredate;
	String sDate;
	 public Employee(int empno, String ename, int deptno, int sal, Date hiredate) {
	      setEmpno(empno);
	      setEname(ename);
	      setDeptno(deptno);
	      setSal(sal);
	      setHiredate(hiredate);
	   }
	 public Employee(String ename) {
		 setEname(ename);
		 
	 }
	 public Employee(int empno, String ename, int deptno, int sal, String sDate) {
	      setEmpno(empno);
	      setEname(ename);
	      setDeptno(deptno);
	      setSal(sal);

	 
	 }
	 
	 public Employee(int empno) {
		 
		 setEmpno(empno);
	 }
	 
	 public Employee(String[] token) {
	      int empno = Integer.parseInt(token[0]);
	      String ename = token[1];
	      int deptno = Integer.parseInt(token[2]);
	      int sal = Integer.parseInt(token[3]);
	      												//Date 값 받기 yyyy-mm-dd, -기준으로 나눔?
      SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    Date hiredate=null;
   	try{
   		 hiredate= sdf.parse(token[4]);
   	    }
   	catch(ParseException e){
   	 e.printStackTrace();
   	 }

      setEmpno(empno);
      setEname(ename);
      setDeptno(deptno);
      setSal(sal);
      setHiredate(hiredate);
   }
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public Date getHiredate() {
	return hiredate;
}
public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
}


   public String toString() {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String hireDateString = sdf.format(this.getHiredate());
	      String str = String.format("%d\t%s\t%d\t%d\t%s",
		            this.getEmpno(),
		            this.getEname(),
		            this.getDeptno(),
		            this.getSal(),
		            hireDateString);
		      return str;
		   }
	
   @Override
public int hashCode() {
	   
	return Objects.hash(this.getEmpno());
}
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Employee)) return false;
    Employee other = (Employee) obj;
    
    // empno가 같거나 ename이 같은 경우에 true를 반환
    if (this.empno == other.empno) return true;
    
    // ename이 null인 경우를 처리
    if (this.ename == null || other.ename == null) return false;
    
    // 대소문자 구분 없이 비교하고, 공백을 제거하여 비교합니다
    return this.ename.trim().equalsIgnoreCase(other.ename.trim());
}
	

	
	
	
	
	
}