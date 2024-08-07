package com.test.sku.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnhancedEmpDAO 
{
   //오라클 접속기능, 접속해제 기능
   //목록보기, 부서정보, 상세정보 : Read
   //사원정보 추가, 사원정보 수정, 검색, 삭제
   private Connection conn;
   private PreparedStatement pstmt;
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
   public PageItem hierPaging(int page, int ipp) {
	      String sql = "SELECT * FROM\r\n"
	      		+ "	      		 (\r\n"
	      		+ "	      		        SELECT t2.*, TRUNC((RN-1)/?+1) AS PAGE FROM\r\n"
	      		+ "	      		      ( \r\n"
	      		+ "	      		           SELECT t.*, ROWNUM RN FROM\r\n"
	      		+ "	      		            (\r\n"
	      		+ "	      		               SELECT empno,LPAD(' ',(LEVEL-1)*3, ' ')|| ename ename, deptno, sal, mgr FROM emp\r\n"
	      		+ "                            START WITH  mgr IS NULL \r\n"
	      		+ "	      		                  CONNECT BY PRIOR  empno = mgr\r\n"
	      		+ "	      		                    ORDER SIBLINGS BY empno\r\n"
	      		+ "	      		            )t\r\n"
	      		+ "	      		       ) t2\r\n"
	      		+ "	      		)CROSS JOIN(SELECT CEIL(COUNT(*)/?) TOTAL FROM emp)  WHERE page =?" ;                              
	      conn = getConn();
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, ipp);
	         pstmt.setInt(2, ipp);
	         pstmt.setInt(3, page);
	         rs = pstmt.executeQuery();
	         List<EmpVO> list = new ArrayList<>();
	         PageItem pageItems = new PageItem();
	         int i = 0;
	         while(rs.next()) {
	            if(i==0) {
	               int currPage = rs.getInt("PAGE");
	               int totalPages = rs.getInt("TOTAL");
	               pageItems.setCurrPage(currPage);
	               pageItems.setTotalPages(totalPages);
	            }
	            int empno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	           // java.sql.Date hiredate = rs.getDate("HIREDATE");
//	            int total = rs.getInt("total");
	            int deptno = rs.getInt("DEPTNO");
	            int salary = rs.getInt("SAL");
	            int mgr = rs.getInt("MGR");
	            
	            EmpVO emp = new EmpVO();
	            emp.setEmpno(empno);
	            emp.setEname(ename);
	            emp.setDeptno(deptno);
	            //emp.setHiredate(hiredate);
	            emp.setSal(salary);
	            emp.setMgr(mgr);
	            
	            list.add(emp);
	            i++;
	         }
	         pageItems.setList(list);
	         return pageItems;
	      }catch(SQLException sqle) {
	         sqle.printStackTrace();
	      }
	      return null;
	   }
   
   public PageItem getPage3(int page, int ipp) {
	      String sql = "SELECT * FROM "
	               + "("
	               + "    SELECT t2.*, TRUNC((RN-1)/3+1) AS page FROM "
	               + "    ( "
	               + "        SELECT t.*, ROWNUM RN FROM "
	               + "        ( "
	               + "            SELECT * FROM emp2, "
	               + "            ( "
	               + "               SELECT CEIL(COUNT(*)/3) total FROM emp2 "
	               + "            ) "
	               + "        )t "
	               + "    )t2 "
	               + ") "
	               + "WHERE page=?";
	      conn = getConn();
	      try {
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setInt(1, page);
	         rs = pstmt.executeQuery();
	         List<EmpVO> list = new ArrayList<>();
	         PageItem pageItems = new PageItem();
	         int i = 0;
	         while(rs.next()) {
	            if(i==0) {
	               int currPage = rs.getInt("PAGE");
	               int totalPages = rs.getInt("TOTAL");
	               pageItems.setCurrPage(currPage);
	               pageItems.setTotalPages(totalPages);
	            }
	            int empno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	            java.sql.Date hiredate = rs.getDate("HIREDATE");
	            int deptno = rs.getInt("DEPTNO");
	            int salary = rs.getInt("SAL");
	            String job = rs.getString("JOB");
	            
	            EmpVO emp = new EmpVO();
	            emp.setEmpno(empno);
	            emp.setEname(ename);
	            emp.setDeptno(deptno);
	            emp.setHiredate(hiredate);
	            emp.setSal(salary);
	            emp.setJob(job);
	            
	            list.add(emp);
	            i++;
	         }
	         pageItems.setList(list);
	         return pageItems;
	      }catch(SQLException sqle) {
	         sqle.printStackTrace();
	      }
	      return null;
	   }
   
   public List<EmpVO> getPage2(int page, int ipp) {
	      String sql = "SELECT *FROM "
	      		+ "("                                    
	    		 +"" 
	    		 +"SELECT t2.*, TRUNC ((RN-1)/3+1) AS page FROM" 
	    		 +"("
	    		 	+"SELECT t.*, ROWNUM RN FROM"  
	    				 +"("
	    				    +"SELECT *FROM emp2"       
	    				 +")t"
	    			+")t2"
	    			+") WHERE page=?";
	      conn = getConn();
	      try {
	      pstmt = conn.prepareStatement(sql);
	      int p = page;
	      
	      pstmt.setInt(1, p);
	      rs = pstmt.executeQuery();
	      List<EmpVO> list = new ArrayList<>();
	      while(rs.next()) {
	         int empno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	            java.sql.Date hiredate = rs.getDate("HIREDATE");
	            int deptno = rs.getInt("DEPTNO");
	            int salary = rs.getInt("SAL");
	            String job = rs.getString("JOB");
	            
	            EmpVO emp = new EmpVO();
	            emp.setEmpno(empno);
	            emp.setEname(ename);
	            emp.setDeptno(deptno);
	            emp.setHiredate(hiredate);
	            emp.setSal(salary);
	            emp.setJob(job);
	            
	            list.add(emp);
	      }
	      return list;
	   } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }
	      
	      return null;
	   
	   }
   
   public List<EmpVO> getPage(int page, int ipp) {
	      String sql = "SELECT * FROM\r\n"
	                  + "(\r\n"
	               + "   SELECT t.*, ROWNUM RN FROM\r\n"
	               + "   (\r\n"
	               + "       SELECT * FROM emp2\r\n"
	               + "   )t\r\n"
	               + ") WHERE RN BETWEEN ? AND ?";
	      conn = getConn();
	      try {
	      pstmt = conn.prepareStatement(sql);
	      int end = page * ipp;
	      int start = end-(ipp-1);
	      pstmt.setInt(1, start);
	      pstmt.setInt(2, end);
	      rs = pstmt.executeQuery();
	      List<EmpVO> list = new ArrayList<>();
	      while(rs.next()) {
	         int empno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	            java.sql.Date hiredate = rs.getDate("HIREDATE");
	            int deptno = rs.getInt("DEPTNO");
	            int salary = rs.getInt("SAL");
	            String job = rs.getString("JOB");
	            
	            EmpVO emp = new EmpVO();
	            emp.setEmpno(empno);
	            emp.setEname(ename);
	            emp.setDeptno(deptno);
	            emp.setHiredate(hiredate);
	            emp.setSal(salary);
	            emp.setJob(job);
	            
	            list.add(emp);
	      }
	      return list;
	   } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }
	      
	      return null;
	   
	   }
   
   public List<EmpVO> getList() //empno,ename,sal,deptno,job,hiredate,mgr,comm
   {
      conn = getConn();
      try {
         pstmt = conn.prepareStatement("SELECT * FROM emp2"); //prepared에서는 여기에 sql문 줌
         rs = pstmt.executeQuery();	//이미 있는거 읽을때는 executeQuery 사용
         List<EmpVO> list = new ArrayList<>();
         while(rs.next())
         {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            int salary = rs.getInt("SAL");
            int deptno= rs.getInt("DEPTNO");
            EmpVO emp = new EmpVO();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setDeptno(deptno);
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
         pstmt = conn.prepareStatement("SELECT * FROM emp2 WHERE job='"+job+"'");
         rs = pstmt.executeQuery();	//이미 있는거 읽을때는 executeQuery 사용
         List<EmpVO> findlist = new ArrayList<>();
         while(rs.next())
         {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            int salary = rs.getInt("SAL");
            int deptno = rs.getInt("DEPTNO");
            EmpVO emp = new EmpVO();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setDeptno(deptno);
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
		   	String sql = "INSERT INTO emp2(empno, ename, deptno, sal, hiredate, job)"+ " VALUES (?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getEmpno());
			pstmt.setString(2,emp.getEname());
			pstmt.setInt(3,emp.getDeptno());
			pstmt.setInt(4,emp.getSal());
			pstmt.setDate(5,emp.getHiredate());
			pstmt.setString(6,emp.getJob());
		   		
		   	int rows=pstmt.executeUpdate();	//내용이 바뀌면 executeUpdate, pstmt면 괄호에 들어갈거없음
		   	return rows>0;						//바뀐게있으면true,없으면false
	   }catch(SQLException sqle){
		   sqle.printStackTrace();
	   }
	   return false;
   }

   
   public boolean updateSal(EmpVO emp) {
	      conn = getConn();
	      try {
	    	  String sqlString = "UPDATE emp2 SET sal=? WHERE empno=?";
	    	  pstmt = conn.prepareStatement(sqlString);
	    	  pstmt.setInt(1,emp.getSal());					//?값에 넣을 애들 세팅 
	    	  pstmt.setInt(2,emp.getEmpno());
	    	  int rows = pstmt.executeUpdate();
	    	  return rows>0;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
   public boolean delete(int empno) {
	      conn = getConn();
	      try {
	    	  String sqlString = "DELETE emp2 WHERE EMPNO=?";
	         pstmt = conn.prepareStatement(sqlString);
	         pstmt.setInt(1,empno);
	         int rows = pstmt.executeUpdate();
	         return rows>0;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   
   }

   public List<Map<String,String>> getJoinResult(int deptno){
	   String sql="SELECT empno, ename, e.deptno, dname,grade \"호봉\" "
	   		+ "FROM emp2 e join dept d on e.deptno=d.deptno join salgrade s on e.sal between s.losal and s.hisal WHERE e.deptno = ?"
			   +"ORDER BY 호봉 DESC";
	   conn= getConn();
	   try {
		pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);
		rs=pstmt.executeQuery();
		
		List<Map<String, String>> list= new ArrayList<>();
		Map<String, String> map = null;
		while(rs.next()) {
			map= new HashMap<>();
			int empno=rs.getInt("EMPNO");
			String ename= rs.getString("ENAME");
			int dno=rs.getInt("DEPTNO");
			String dname=rs.getString("DNAME");
			int grade=rs.getInt("호봉");
			
			map.put("EMPNO", ""+empno);	//map이<String,String> 형식이기 때문에 문자열화 해줘야한다
			map.put("ENAME", ename);
			map.put("DEPTNO", ""+dno);	//얘랑
			map.put("DNAME", dname);
			map.put("GRADE", ""+grade);	//얘도
	
			list.add(map);
			
		}
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	  
   }
   
   
   private void closeAll() {
      try {
         if(rs!=null) rs.close();
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

}
