package oracle;

import java.io.*;
import java.sql.*;

public class ImportCSVfile {
	
	public static Connection importCSVactor() {
		Connection conn = null;
		
		String actorPath = "F:/Assessment/DataInput/actor.csv";
		
		//buat connection dulu
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle", "p@ssword");
			System.out.println("Mari di import!");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		try {
			//set dulu untuk sql nya
				String importActor = "Insert into actor (actor_id, first_name, last_name, last_update) Values (?,?,?,?)";
				
				//create prepared statement untuk mengeksekusi sql diatas
				PreparedStatement pstmt = conn.prepareStatement(importActor);
				
				//untuk membaca setiap hurufnya yang ada di actorpath untuk nantinya di input
				BufferedReader lineReader = new BufferedReader(new FileReader(actorPath));
				//set lineText jadi null untuk nantinya di looping
				String lineText = null;
				
				lineReader.readLine();
				
				//proses looping memasukkan setiap data yang di baca, untuk actor_id di nomer 0
				while((lineText = lineReader.readLine()) != null) {
					String [] data 		= lineText.split(";");
					String actor_id 	= data[0].replace("\"",""); //.replace untuk menghapus double qoutes
					String first_name 	= data[1].replace("\"","");
					String last_name 	= data[2].replace("\"","");
					String last_update 	= data[3].replace("\"","");
					
					//penempatannya dimana, harus sesuai karna kalo tidak bisa kewulak walek
					pstmt.setString(1, actor_id);
					pstmt.setString(2, first_name);
					pstmt.setString(3, last_name);
					pstmt.setString(4, last_update);
					
					//menambahakan setiap statement ke batch
					//jika tidak ada ini, statement yang di executebatch tidak akan di proses.
					pstmt.addBatch();
					}
				lineReader.close();
			
				pstmt.executeBatch();
			}catch(IOException e) {
			//catch system err io
				System.err.println(e);
			}catch(SQLException e) {
				//catch sqlexception e
				e.printStackTrace();
				}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//memanggil method
		if(importCSVactor() !=null) {
			System.out.println("Berhasil yay!");
		}

	}

}

