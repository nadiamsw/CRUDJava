package oracle;

import java.sql.*;

public class UpdateSql {
	
	public static Connection updateSql() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","p@ssword");
					if(conn != null) {
						System.out.println("Mari kita coba update!");
						
						String sql = "Update actor set first_name = ? where actor_id =?";
						PreparedStatement stmt = conn.prepareStatement(sql);
						
						stmt.setString(1, "nadiaa");
						stmt.setInt(2, 201);
						
						int masuk = stmt.executeUpdate();
						if(masuk > 0) {
							System.out.println("Berhasil nge update data");
						}
					}
		}catch(SQLException e) {
			e.printStackTrace();
			}
		return conn;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updateSql();

	}

}
