package category_IO;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFiles {
	public static void main(String[] args) {
	    try {
	    	
	    // First Create an array of File names with only two elements
	      String[] fileNamePrefix = new String[2];
	      fileNamePrefix[0] ="top";
	      fileNamePrefix[1] ="sub";
	      
	      for(int j=0; j < fileNamePrefix.length; j++)
	      {
		      File myObj = new File(fileNamePrefix[j] + "LevelCategories.txt");
		      if (myObj.createNewFile()) {
		    	  
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File " +  myObj.getName() + " already exists.");
		      }		      
	      } // End for loop
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}


