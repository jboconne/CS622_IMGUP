package multipleImageUploadsDBModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetImageCountByCategory 
{
	
	
	private static void query(Connection conn) throws SQLException{
		String sql = "select c.category_name, COUNT(*) AS [Number of Images] from Images i\r\n"
				+ "	inner join Category c on c.category_id = i.category_id\r\n"
				+ "	inner join Subcategory s on s.subcategory_id = i.subcategory_id\r\n"
				+ "	Group By category_name";
		
		try (	Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			System.out.printf("%-30.30s  %-30.30s%n", "Category","Image Count");
			System.out.println("");
			while (rs.next()) {
				System.out.printf("%-30.30s  %-30.30s%n",rs.getString(1), rs.getString(2));
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String url ="jdbc:sqlite:C:/SQLite/ImageUploader.db";
		try (Connection conn = DriverManager.getConnection(url)){
			query(conn);			
		}
	}

}

