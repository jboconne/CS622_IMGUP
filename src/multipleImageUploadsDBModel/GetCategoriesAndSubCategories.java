package multipleImageUploadsDBModel;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class GetCategoriesAndSubCategories {
	
	private static void query(Connection conn) throws SQLException{
		String sql = "select c.category_id, c.category_name,s.subcategory_name from Category c "
				+    "inner join SubCategory s on s.category_id = c.category_id order by category_name, subcategory_name";
		
		try (	Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
		
			String oldCat="";
			while (rs.next()) {
								
				String currentCat = rs.getString("category_name");
				String subCat = rs.getString("subcategory_name");
				if(!oldCat.equals(currentCat)) {
					oldCat = currentCat;
					System.out.println(currentCat);
					System.out.println("\t" + subCat);
				}
				else
				{
					System.out.println("\t" + subCat);
				}	
				
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

