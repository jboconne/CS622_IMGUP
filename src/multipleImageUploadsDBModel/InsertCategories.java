package multipleImageUploadsDBModel;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCategories {
	
		private static void insert(Connection conn) throws SQLException{
			String sql = "INSERT INTO Category(category_name) VALUES (?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				pstmt.setString(1, "Client Portfolio");				
				pstmt.executeUpdate();
				pstmt.setString(1, "Asphalt Paving");
				pstmt.executeUpdate();
				pstmt.setString(1, "Specialty Work");
				pstmt.executeUpdate();
				pstmt.setString(1, "Grading & Excavating");
				pstmt.executeUpdate();
				pstmt.setString(1, "Shuttle Buggy Rental");
				pstmt.executeUpdate();
				
			}
		}	
		
		
		public static void main(String[] args) throws SQLException {
			String url ="jdbc:sqlite:C:/SQLite/ImageUploader.db";
			try (Connection conn = DriverManager.getConnection(url)){
				insert(conn);
				System.out.println("Rows Added to Category Table!");
	
			}
		}
	}