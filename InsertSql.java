package oracle;

import java.sql.*;

public class InsertSql {
	
	public static Connection insertSql() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","p@ssword");
			if (conn != null ) {
				System.out.println("Mari kita insert!");
			}
			String sql = "Insert into actor (actor_id, first_name, last_name, last_update) Values (?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 201);
			stmt.setString(2, "Nadia");
			stmt.setString(3, "Musawa");
			stmt.setString(4, "idk when");
			
		int masuk = stmt.executeUpdate();
		if (masuk > 0) {
			System.out.println("Data berhasil masuk");
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertSql();
		

	}

}
