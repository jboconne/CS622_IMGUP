package multipleImageUploadsDBModel;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateImageUploaderTables {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlite:C:/SQLite/ImageUploader.db";
	              
	      try (Connection connection = DriverManager.getConnection(connectionUrl);
	    		  Statement statement1 = connection.createStatement();
	    		  Statement statement2 = connection.createStatement();
	    		  Statement statement3 = connection.createStatement();) {
	         String sql = 
					"CREATE TABLE Category (" +
					"category_id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"category_name VARCHAR(64) NOT NULL)";
			  statement1.executeUpdate(sql);
	          sql = 
				   "CREATE TABLE SubCategory (" +
				   "subcategory_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "subcategory_name VARCHAR(64) NOT NULL," +
				   "category_id INTEGER NOT NULL REFERENCES Category(category_id))";
	          statement2.executeUpdate(sql);
	          sql = 
				  "CREATE TABLE Images (" +
				  "image_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
				  "file_name VARCHAR(64) NOT NULL," +
				  "category_id INTEGER NOT NULL REFERENCES Category(category_id)," +
				  "subcategory_id INTEGER NOT NULL REFERENCES SubCategory(subcategory_id))";
		      statement3.executeUpdate(sql);
	      }
	      catch (SQLException e) {
	          e.printStackTrace();
	      }	
	      System.out.println("Tables Created");
	}
}
