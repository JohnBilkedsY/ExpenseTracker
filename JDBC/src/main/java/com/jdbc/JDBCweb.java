package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCweb {
	public static void main(String[] args) throws ClassNotFoundException{
		
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	   
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","OracleMysql1.1");
	   
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from countries");
	   
	while(rs.next()) {
	 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+
	  rs.getInt(3));
	}
	   
	con.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}}
