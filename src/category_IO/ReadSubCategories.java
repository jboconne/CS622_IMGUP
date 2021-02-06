package category_IO;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadSubCategories {
	// Displays all top level categories and sub categories, if any. This is called by 
	//  category_IO_test.Menu.displayCategoryHierarchy()
	// Precondition 1 - topCategory input parameter supplied by calling method
	// Postcondition 1 - Calls readUsingBufferedReader passing in Pre1 with an actual 
	// string value or null
	 public static void main(String topCategory) {
	      try {
	         //Using BufferedReader
	         readUsingBufferedReader(topCategory); // P1

	      } catch(IOException e) {
	         System.out.println(e.getMessage());
	      }
	   }

	   //reading a file using buffered reader line by line
	   public static void readUsingBufferedReader(String topLevelCat) throws IOException {	      
		   //Method that reads the subLevelCategories.txt file line by line
		   try(BufferedReader bufferReader 
	         = new BufferedReader( new InputStreamReader(  
	            new FileInputStream("subLevelCategories.txt") ) )) {
	         String line; // Variable for storing the value of each line
	         while( ( line = bufferReader.readLine() ) != null ) { // while loop as long 
	        	 // as we have a line
	            
	        	// Create string array to split each line using "-" delimiter. Left side 
	        	 // of delimiter is the Top Level Category 
	           String[] topCat = line.trim().split("-");
	        	// Here's where we determine if the input parameter Pre 1 is null or has an 
	           //   actual string value. If the latter, we only 
	            //   display the top level category passed in and any of its sub categories 
	        	if (topLevelCat != null ) 
	        	{
	        		if(topCat[0].equals(topLevelCat)) {
		        		// We have a match with the input parameter
		        		System.out.println(topCat[0]);
		        		// Check if the array is greater than or equal to 2, if so, then we 
		        		// have sub categories 
		        		if(topCat.length >= 2) {
		        			// Create string array to split each line using ";" delimiter. 
		        			// Right side of topCat array with each sub category
		        			String[] subCats = topCat[1].trim().split(";");
		        			// loop through the string array of sub categories, and print out
		        			// the value indented from the top level category 
		        			for (int i=0; i<subCats.length; i++) {
		        		        System.out.println("\t" + subCats[i]);
		        			}
		        		}
		        		else // if we topCat array is less than 2, we have no sub categories yet
		        		{
		        			System.out.println("\tNo Sub Level Categories Available!");
		        		}
		        	}
	        	}
	        	else // Pre 1 is null, so print all top level categories & sub categories, if any 
	        	{
	        		//Print all Top Level Categories and sub categories if any, input parameter 
	        		//  Pre 1 is null
	        		// we are still in while loop
	        		System.out.println(topCat[0]);
	        		if(topCat.length >= 2) {
	        			String[] subCats = topCat[1].trim().split(";");
	        			for (int i=0; i<subCats.length; i++) {
	        		        System.out.println("\t" + subCats[i]);
	        			}
	        		}
	        	}
	         }
	      }
	   }	
}
