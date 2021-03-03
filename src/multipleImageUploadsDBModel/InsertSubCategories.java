package multipleImageUploadsDBModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSubCategories {
	
	private static void insert(Connection conn) throws SQLException{
		String sql = "INSERT INTO SubCategory(subcategory_name,category_id) VALUES (?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			int totalCount=0;
			pstmt.setString(1, "Pepsi Bottling");
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, "Walmart");
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, "Family Dollar");
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, "Kroger");
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, "Streets");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Airport Ramps");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Subdivisions");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Parking Lots");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Driveways");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Paths");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "Pavement Milling");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Dust Control");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Pavement Fabric Installation");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Utility Cut Patching");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Asphalt Curbs");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Golf Cart Paths");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Gabeon Baskets");
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, "Grading SubCat1");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Excavating SubCat1");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Grading SubCat2");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Excavating SubCat2");
			pstmt.setInt(2, 4);
			pstmt.setString(1, "Grading SubCat3");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Excavating SubCat3");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Grading SubCat4");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Excavating SubCat4");
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, "Rental SubCat1");
			pstmt.setInt(2, 5);
			pstmt.setString(1, "Rental SubCat2");
			pstmt.setInt(2, 5);
			pstmt.executeUpdate();
			pstmt.setString(1, "Rental SubCat3");
			pstmt.setInt(2, 5);
			pstmt.executeUpdate();
			
			System.out.println(" Rows Added to SubCategory Table!");
		}
	}	
	
	
	public static void main(String[] args) throws SQLException {
		String url ="jdbc:sqlite:C:/SQLite/ImageUploader.db";
		try (Connection conn = DriverManager.getConnection(url)){
			insert(conn);		

		}
	}

}
