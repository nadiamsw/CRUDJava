package oracle;

import java.sql.*;

public class DeleteSql {
	
	public static Connection deleteSql() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","p@ssword");
			
			if(conn != null) {
				System.out.println("Sekarang kita coba delete!");
			}
			
			String sql = "Delete from Actor where actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 201);
			
			int kedelete = stmt.executeUpdate();
			if (kedelete > 0) {
				System.out.println("Data berhasil ke delete");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteSql();

	}

}
