package category_IO;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	 public static void main(String[] args) {
		    try 
		    {
		      FileWriter myTopCategory = new FileWriter("topLevelCategories.txt");
			  myTopCategory.write("Client Portfolio\n");
			  myTopCategory.write("Asphalt Paving\n");
			  myTopCategory.write("Specialty Work\n");
			  myTopCategory.write("Grading & Excavating\n");
			  myTopCategory.write("Shuttle Buggy Rental\n");
			  myTopCategory.close();
			  System.out.println("Successfully wrote to the file topLevelCategories.txt.");
		    } 
		    catch (IOException e) 
		    {
		    	System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }

}
