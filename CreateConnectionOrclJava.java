package oracle_oop;

import java.sql.*;

public class CreateConnectionOrclJava {
	
	public static  Connection getConnection() {
		Connection conn = null;
		
		String url 	= "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "oracle";
		String pass	= "p@ssword";
		
		try {
			conn = DriverManager.getConnection(url,user, pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void main(String[] args) {
		if (getConnection() != null) {
			System.out.println("Connected!");
		}
		

	}

}
