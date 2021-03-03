package multipleImageUploadsDBModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertImages {
	private static void insert(Connection conn) throws SQLException{
		String sql = "INSERT INTO images(file_name, category_id, subcategory_id) VALUES (?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, "pepsibottling.jpg");
			pstmt.setInt(2,2);
			pstmt.setInt(3,8);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "walmart.jpg");
			pstmt.setInt(2,2);
			pstmt.setInt(3,8);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "kroger.jpg");
			pstmt.setInt(2,2);
			pstmt.setInt(3,8);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "familyDollar.jpg");
			pstmt.setInt(2,2);
			pstmt.setInt(3,8);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "pepsibottling.jpg");
			pstmt.setInt(2,1);
			pstmt.setInt(3,1);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "walmart.jpg");
			pstmt.setInt(2,1);
			pstmt.setInt(3,2);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "kroger.jpg");
			pstmt.setInt(2,1);
			pstmt.setInt(3,4);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "familyDollar.jpg");
			pstmt.setInt(2,1);
			pstmt.setInt(3,3);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "specialty.jpg");
			pstmt.setInt(2,3);
			pstmt.setInt(3,11);
			pstmt.executeUpdate();
			
			pstmt.setString(1, "shuttleBuggy.jpg");
			pstmt.setInt(2,4);
			pstmt.setInt(3,25);
			pstmt.executeUpdate();
		}
	}
	
	private static void query(Connection conn) throws SQLException{
		String sql = "SELECT person_id, first_name, last_name, birth_date From Person";
		try (	Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
		
			while (rs.next()) {
				System.out.printf("%d\t%-10s\t%-10s\t%tD%n",
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			}
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		String url ="jdbc:sqlite:C:/SQLite/ImageUploader.db";
		try (Connection conn = DriverManager.getConnection(url)){
			insert(conn);
			//query(conn);
			System.out.println("Rows Added to Images Table!");

		}
	}
}
