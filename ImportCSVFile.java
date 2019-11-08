package oracle;

import java.io.*;
import java.sql.*;

public class importCsvFileAutoBanyak {
	
	public static Connection banyakAn() {
		Connection conn = null;
		
		String actorPath		= "F:/Assessment/DataInput/actor.csv";
		
		//buat connection dulu
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle", "p@ssword");
			System.out.println("Mari di import!");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
