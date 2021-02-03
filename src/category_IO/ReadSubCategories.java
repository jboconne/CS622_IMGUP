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
	 public static void main(String[] args) {
	      try {
	         //Using BufferedReader
	         readUsingBufferedReader("Client Portfolio");

	      } catch(IOException e) {
	         System.out.println(e.getMessage());
	      }
	   }

	   //reading a file using buffered reader line by line
	   public static void readUsingBufferedReader(String topLevelCat) throws IOException {
	      try(BufferedReader bufferReader 
	         = new BufferedReader( new InputStreamReader(  
	            new FileInputStream("subLevelCategories.txt") ) )) {
	         String line;
	         while( ( line = bufferReader.readLine() ) != null ) {
	            
	            //String topLevelCat = "Shuttle Buggy Rental"; //"Client Portfolio";//"Shuttle Buggy Rental";//"Grading & Excavating";//"Specialty Work";//"Asphalt Paving";	//--
	        	String[] topCat = line.trim().split("-");
	        	
	        	
	        	if(topCat[0].equals(topLevelCat)) {
	        		
	        		System.out.println(topCat[0]);
	        		if(topCat.length >= 2) {
	        			String[] subCats = topCat[1].trim().split(";");
	        			for (int i=0; i<subCats.length; i++) {
	        		        System.out.println("\t" + subCats[i]);
	        			}
	        		}
	        		else
	        		{
	        			System.out.println("\tNo Sub Level Categories Available!");
	        		}
	        	}
	            
	            
	            
	            
	            
	            
	         }
	      }
	   }	
}
