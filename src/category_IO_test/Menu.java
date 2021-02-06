// See main() for purpose of Menu Class
package category_IO_test;

import category_IO.*;
import categories.*;
import categories_test.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//CLASS INVARIANTS ==========================================

	// C1 (exit): boolean value that will keep the console menu running unless choice 0 is selected. 
	//	Default value = false
	// C2 (choice): integer variable that will hold the menu option selected by the user 
public class Menu {
	boolean exit; //C1
	
	
	public static void main(String[] args) {
		/* 
		 * Precondition 1: topLevelCategories.txt contains the top level image categories (see category_IO.CreateFiles())
		 * Pre2: subLevelCategories.txt contains the desired top level image categories and their sub categories 
		 *   (see category_IO.CreateFiles())
		 * 
		 * Postcondition 1 (Display Console Menu): Instantiate menu object and call runMenu() method of object
		 * Post2 (printHeader): Print header for console menu
		 * Post3 (printMenu): Display the menu options
		 * Post4 (getInput): Method that gets the users input from the console menu and assigns to C2 variable
		 * Post5 (performAction): The action that is executed when the user selects an option from the menu 
		 */	
		
		Menu menu = new Menu(); //P1
		menu.runMenu();		 //P1
	}
	
	// METHODS ===================================================
	
	public void runMenu() { //P1
		// Initial method called when running the menu class
		// the menu will continue to run while exit (C1) is false
		printHeader(); //P2
		while(!exit) { 
			printMenu(); //P3
			int choice = getInput(); // C2 & P4
			performAction(choice); // P5 & C2
		}	// End While	
	}
	
	private void printHeader() { //P2
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|               Welcome to the Image Uploader             |");
		System.out.println("|                   Category Application                  |");
		System.out.println("+---------------------------------------------------------+");
	}
	
	private void printMenu() { //P3
		System.out.println("\n Please make a selection: ");
		System.out.println("1) Display the Current Image Category Hierarchy");
		System.out.println("2) Add a Top Level Category");
		System.out.println("3) Add a Sub Category");
		System.out.println("0) Exit the Application");
	}
	
	private int getInput() { //P4
		// Prompt user for menu choice and return to caller C2
		Scanner kb = new Scanner(System.in);
		int choice =-1; // initiate C2 to -1 integer value
		while(choice < 0 || choice >3) { // Display the menu while these conditions are true, C2 will be valid and 
										 //   returned if value in (0,1,2,3), the four menu options
			try {
				System.out.println("\n Enter your choice: ");
				choice = Integer.parseInt(kb.nextLine()); // Prompt for choice assign integer value to C2
			}
			catch(NumberFormatException e){ // Specific type of exception when option is not an integer
				System.out.println("Invalid selection. Please try again.");		// prompt user to select an option from menu 		
			}
		}		
		
		return choice; // return C2 when exiting from while loop 
	}
	
	private void performAction(int choice)  {// P5
		// Precondition C2 has integer value
		// Postconditions performs action based on C2 input parameter
		// P1 - User wants to exit the console menu
		// P2 - User selects 'Display the Current Image Category Hierarchy' menu option 
		// P3 - User selects 'Add a Top Level Category' menu option
		// P4 - User selects 'Add a Sub Category' menu option
		switch(choice) { //C2
		case 0: // C2=0, P1
			exit = true; // C1 User wants to exit the menu
			System.out.println("Thank You For Using the ImageUploader Category Application!");
			break;
		case 1: // C2=1, P2
			displayCategoryHierarchy(); // Go to this method
			break;
		case 2: // C2=2, P3
			try {
				addTopLevelCat();// Go to this method
			} catch (CategoryExistsExceptionClass exc) {
				// TODO Auto-generated catch block
				exc.printStackTrace();
			}
			break;
		case 3:	// C2=3, P4		
			try {
				addSubCategory();// Go to this method
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break; // Something bad happened and we did not get a value for C2
		default:
			System.out.println("An unknown error has occurred.");
		
		}		
		
	}
	
	void displayCategoryHierarchy() {
		// Simply displays all top level categories and sub categories, if any
		// Postcondition 1 - Calls category_IO.ReadSubCategories() passing in a null value
		System.out.println("Current Image Category Hierarchy");
		System.out.println("");
		ReadSubCategories.main(null); //P1
		System.out.println("");
	}
	
	private void addTopLevelCat() throws CategoryExistsExceptionClass {
		System.out.println("Here are the Current Top Level Categories\n");
		
		// list of lines
		List<String> list = new ArrayList<>();
		
		
		try {
		     			
				BufferedReader br = new BufferedReader(new FileReader("topLevelCategories.txt"));
		    	    
	    	    // convert stream into list
	    	    list = br.lines().collect(Collectors.toList());
	
	    	    // print all lines
	    	    list.forEach(System.out::println);
		
	    	    // close the reader
	    	    br.close();  	      
		      
			} catch (Exception e) {
		      System.out.println("An error occurred1.");
		      e.printStackTrace();		      
		    }
		try {   
			  Scanner myNewCat = new Scanner(System.in);  // Create a Scanner object
		      System.out.println("\nEnter New Top Level Category: ");
		      
		      String newTopCat = myNewCat.nextLine();  // Read user input
		      
		      // Check to see if we already have this Top Level Category
		      if (newTopCat != null) {
		    	  boolean isNew = true;
		    	  //list.forEach(System.out::println);  
		    	  for (String existingTopCat : list) { 
		    		  if(existingTopCat.toLowerCase().equals(newTopCat.toLowerCase())) {
		    			  isNew = false;
		    			  //throw custom exception here
		    			  throw new CategoryExistsExceptionClass("We already have this top level category: " + existingTopCat); 
		    		  }		    		 
		         }
		    	  if(isNew) 
		    	  {
		    		  //Insert New TopLevel Category into topLevelCategories.txt I/O Write    		  
		    		  	String textToAppend = newTopCat;
		    		     
		    		    FileWriter fileWriter = new FileWriter("topLevelCategories.txt", true); //Set true for append mode
		    		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    		    printWriter.println(textToAppend);  //New line
		    		    printWriter.close();
		    		  
		    		  //Insert New TopLevel Category and dash into subLevelCategories.txt I/O Write
		    		    
		    		    String subTextToAppend = newTopCat+"-";
		    		     
		    		    FileWriter fileWriterSub = new FileWriter("subLevelCategories.txt", true); //Set true for append mode
		    		    PrintWriter printWriterSub = new PrintWriter(fileWriterSub);
		    		    printWriterSub.println(subTextToAppend);  //New line
		    		    printWriterSub.close();
		    		    
		    		  System.out.println("\nNew Top Level Category Created is: " + newTopCat);  // Output user input
		    	  }
		      }		      
		      
		      
			} catch (CategoryExistsExceptionClass ex) {
			     System.out.println("A Custom User Defined Exception Occurred! "  + ex.getMessage()); 
			}  

			 catch (Exception e) {
			      System.out.println("An error occurred. " + e.toString() + e.getMessage());
			      e.printStackTrace();	      
			}
		    
	}
	
	private void addSubCategory() throws FileNotFoundException {		
		// This is the method that gets called when the user wants to add a sub category.
		// A dynamic menu is displayed to the user containing all output of the top level categories 
		//  read from the stopLevelCategories.txt file 
		  
		// Postcondition 1 - Calls category_IO.ReadSubCategories() passing in a topCategory selected 
		//  from the Top Level Category menu
		// P2 - Prompt user for new sub category
		// P3 - Get topCategory selected string value
		String topCategory = null;
		int topChoice=0;
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|               Select a Top Level Category               |");
		System.out.println("+---------------------------------------------------------+");		
		
		
		int lineNumber = 1; 
		
		// We create an arrayList to store the top level categories (this will help us with the sub menu of top 
		//    level categories  
		ArrayList<String> topCats = new ArrayList<String>();
		
			Scanner s = new Scanner(new File("topLevelCategories.txt")).useDelimiter(System.lineSeparator());
			while (s.hasNextLine()){
				String line = s.nextLine();
			    System.out.println(lineNumber + ": " + line);
			    topCats.add(line);
			    lineNumber++;			
			}
			s.close();
			Scanner myNewTopCat = new Scanner(System.in);  // Create a Scanner object
			System.out.println("\nSelect an Existing Top Level Category: ");
			// Get users selected Top Level Category integer value  
			topChoice = Integer.parseInt(myNewTopCat.nextLine());
			// This gets the string value of the top level category selected using the arrayList
			System.out.println("Selected Choice: " + topCats.get(topChoice-1));
			myNewTopCat.close();
			// Assign 
			topCategory= topCats.get(topChoice-1);
		
		
		System.out.println("");
		
		// P1 with P3 as input parameter
		ReadSubCategories.main(topCategory);
		// P2 - Prompt user to enter new sub category for the P3 selected
		Scanner myNewSubCat = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("\nEnter New Sub Category: ");
	      
	    String newSubCat = myNewSubCat.nextLine();  // Read user input
	    System.out.println("Selected Sub Category Choice: " +newSubCat);
	    myNewSubCat.close();
	    
	    
	    // Note: I kept getting an error here. I think it had something to do with the sub menu
	    // I intended to do the same type of comparison for checking if the sub category for the 
	    //  top level category entered by the user was existing, then throw the same User Defined 
	    //  Exception CategoryExistsExceptionClass
	}

}
