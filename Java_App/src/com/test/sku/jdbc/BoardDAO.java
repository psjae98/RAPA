package com.test.sku.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDAO { 
private static Connection conn;
private static Statement stmt;
private static ResultSet rs;

private static Connection getConn() 
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
private static void closeAll() {
    try {
       if(rs!=null) rs.close();
       if(stmt!=null) stmt.close();
       if(conn!=null) conn.close();
    }catch(Exception e) {
       e.printStackTrace();
    }
 }

public static List<Map<String,String>> getBoard() 
{
   conn = getConn();
   try {
 	  PreparedStatement pstmt = null;
      
      String sql= "SELECT b.bid, b.title, " +
              "(SELECT COUNT(*) FROM attatch a WHERE a.bid = b.bid) AS attcnt " +
              "FROM board b " +
              "ORDER BY b.bid";
      pstmt = conn.prepareStatement(sql);
      rs=pstmt.executeQuery();
      List<Map<String,String>> list= new ArrayList<>();
      while(rs.next())
      {
         int bid = rs.getInt("BID");
         String title = rs.getString("TITLE");
         int attcnt = rs.getInt("ATTCNT");
         Map<String,String> map = new HashMap<>();
         map.put("BID",bid+"");
         map.put("TITLE",title);
         map.put("ATTCNT",attcnt+"");
         list.add(map);
      }
      return list;
   }catch(SQLException sqle) {
      sqle.printStackTrace();
   }finally {
      closeAll();
   }
   return null;
}



}
