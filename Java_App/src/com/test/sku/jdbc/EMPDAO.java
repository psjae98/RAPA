package com.test.sku.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EMPDAO 
{
   //오라클 접속기능, 접속해제 기능
   //목록보기, 부서정보, 상세정보 : Read
   //사원정보 추가, 사원정보 수정, 검색, 삭제
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   
   private Connection getConn() 
   {
      try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn = DriverManager.getConnection(
                   "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
         return conn;
      }catch(Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   public List<EmpVO> getList() //empno,ename,sal,deptno,job,hiredate,mgr,comm
   {
      conn = getConn();
      try {
         stmt = conn.createStatement();
         rs = stmt.executeQuery("SELECT * FROM emp2");	//이미 있는거 읽을때는 executeQuery 사용
         List<EmpVO> list = new ArrayList<>();
         while(rs.next())
         {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            int salary = rs.getInt("SAL");
            
            EmpVO emp = new EmpVO();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setHiredate(hiredate);
            emp.setSal(salary);
            list.add(emp);
         }
         return list;
      }catch(SQLException sqle) {
         sqle.printStackTrace();
      }finally {
         closeAll();
      }
      return null;
   }
   public List<EmpVO> findByJob(String job) //empno,ename,sal,deptno,job,hiredate,mgr,comm
   {
      conn = getConn();
     
      try {
         stmt = conn.createStatement();
         rs = stmt.executeQuery("SELECT * FROM emp2 WHERE job='"+job+"'");	//이미 있는거 읽을때는 executeQuery 사용
         List<EmpVO> findlist = new ArrayList<>();
         while(rs.next())
         {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            int salary = rs.getInt("SAL");
            
            EmpVO emp = new EmpVO();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setHiredate(hiredate);
            emp.setSal(salary);
            findlist.add(emp);
         }
         return findlist;
      }catch(SQLException sqle) {
         sqle.printStackTrace();
      }finally {
         closeAll();
      }
      return null;
   }
   
   public boolean addEmp(EmpVO emp) {
	   conn= getConn();
	   try {
		   		stmt= conn.createStatement();
		   		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		   		String sDate= sdf.format(emp.getHiredate());
		   		String sql = "INSERT INTO emp2(empno, ename, deptno, sal, hiredate, job)"+ "VALUES ("
		   		+emp.getEmpno()+",'"+emp.getEname()+"',"+emp.getDeptno()+","+emp.getSal()+",'"+sDate+"','"+emp.getJob()+"')";
		   											//String 형식 sql형태로 작성할때는 작은따옴표로 감싸줘야함
		   		int rows=stmt.executeUpdate(sql);	//내용이 바뀌면 executeUpdate
		   		return rows>0;						//바뀐게있으면true,없으면false
	   }catch(SQLException sqle){
		   sqle.printStackTrace();
	   }
	   return false;
   }
//   public boolean add(EmpVO emp) {
//	   conn= getConn();
//	   PreparedStatement pstmt = null;
//	   try {
//		   	String sql = "INSERT INTO emp2(empno, ename, deptno, sal, hiredate, job) VALUES (?, ?, ?, ?, ?, ?)";
//		   	pstmt = conn.prepareStatement(sql);
//	        pstmt.setInt(1, emp.getEmpno());
//	        pstmt.setString(2, emp.getEname());
//	        pstmt.setInt(3, emp.getDeptno());
//	        pstmt.setInt(4, emp.getSal());
//	        pstmt.setString(5, (String)emp.getHiredate());
//	        pstmt.setString(6, emp.getJob());
//	        int rows = pstmt.executeUpdate();
//	        return rows > 0;
//	    } catch (SQLException sqle) {
//	        sqle.printStackTrace();
//	        return false;
//	    }
//	}
   
   /* board,attatch  테이블을 사용해서 글번호 제목 첨부파일 수 를 화면에 표시
    * BoardDAO 클래스 생성
    */
   
   
   
   public Map<Integer,String[]> getEmpbyDeptno() 
   {
      conn = getConn();
      try {
    	  PreparedStatement pstmt = null;
         
         String sql= "SELECT deptno, COUNT(empno)\"사원수\",LISTAGG(ename,',') WITHIN GROUP (ORDER BY deptno)\"NAMES\" from emp2\r\n"
         		+ "GROUP BY deptno ORDER BY deptno";
         pstmt = conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         Map<Integer,String[]> map= new HashMap<>();
         while(rs.next())
         {
            int deptno = rs.getInt("DEPTNO");
            int cnt = rs.getInt("사원수");
            String names = rs.getString("NAMES");
            map.put(deptno,names.split("\\,"));
        
            
         }
         return map;
      }catch(SQLException sqle) {
         sqle.printStackTrace();
      }finally {
         closeAll();
      }
      return null;
   }
   public boolean updateSal(EmpVO emp) {
	      conn = getConn();
	      try {
	         stmt = conn.createStatement();
	         String sqlString = "UPDATE emp2 SET sal="+emp.getSal()+"WHERE empno=" + emp.getEmpno();
	         int rows = stmt.executeUpdate(sqlString);
	         return rows>0;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
   public boolean delete(int empno) {
	      conn = getConn();
	      try {
	         stmt = conn.createStatement();
	         String sqlString = "DELETE emp2 WHERE EMPNO='"+empno+"'";
	         int rows = stmt.executeUpdate(sqlString);
	         return rows>0;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   
   }
   private void closeAll() {
      try {
         if(rs!=null) rs.close();
         if(stmt!=null) stmt.close();
         if(conn!=null) conn.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}
