package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class uploadJdbc {
	public Boolean uploadFileName(String fileName) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String sql = "insert into file value(?)";
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(query,user,pwd);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileName);
			i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
           } catch (Exception e) {
                e.printStackTrace();
           }
		}
		return false;
	}
}
