package oracle;

import java.sql.*;

public class SelectSql {
	
	public static Connection selectSQL() {
		Connection conn = null;
		//i know menuliskan ini lebih ribet but let's just try it
		String url 	= "jdbc:oracle:thin:@localhost:1521:xe";
		String user	= "oracle";
		String pass = "p@ssword";
		try {
			conn = DriverManager.getConnection(url,user,pass);
			
			String sql = "Select * from actor";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int actor_id		= rs.getInt("actor_id");
				String first_name 	= rs.getString("first_name");
				String last_name 	= rs.getString("last_name");
				String last_update 	= rs.getString("last_update");
				
				System.out.println(actor_id + " " + first_name + " " + last_name +" "+ last_update + " ");
			}stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ini datanya!");
		selectSQL();

	}

}
