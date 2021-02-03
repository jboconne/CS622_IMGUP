package category_IO_test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
	boolean exit;
	
	
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();		
	}
	
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}		
	}
	
	private void printHeader() {
		
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|               Welcome to the Image Uploader             |");
		System.out.println("|                   Category Application                  |");
		System.out.println("+---------------------------------------------------------+");
	}
	
	private void printMenu() {
		System.out.println("\n Please make a selection: ");
		System.out.println("1) Display the Current Image Category Hierarchy");
		System.out.println("2) Add a Top Level Category");
		System.out.println("3) Add a Sub Category");
		System.out.println("0) Exit the Application");
	}
	
	private int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice =-1;
		while(choice < 0 || choice >3) {
			try {
				System.out.println("\n Enter your choice: ");
				choice = Integer.parseInt(kb.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("Invalid selection. Please try again.");				
			}
		}		
		
		return choice;
	}
	
	private void performAction(int choice) {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Thank You For Using the ImageUploader Category Application!");
			break;
		case 1:
			displayCategoryHierarchy();
			break;
		case 2:
			addTopLevelCat();
			break;
		case 3:
			addSubCategory();
			break;
		default:
			System.out.println("An unknown error has occurred.");
		
		}		
		
	}
	
	private void displayCategoryHierarchy() {
		System.out.println("Tony, How can I use what I built in Assignment 1 here");
		
	}
	
	private void addTopLevelCat() {
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
		      System.out.println("An error occurred.");
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
		    		  if(existingTopCat.equals(newTopCat)) {
		    			  isNew = false;
		    			  //throw custom exception here
		    			  System.out.println("We already have this top level category: " + existingTopCat); 
		    		  }		    		 
		         }
		    	  if(isNew) 
		    	  {
		    		  System.out.println("\nNew Top Level Category is: " + newTopCat);  // Output user input
		    	  }
		      }		      
		      
		      
		      

			} catch (Exception e) {
			      System.out.println("An error occurred. " + e.toString() + e.getMessage());
			      e.printStackTrace();	      
			}
		    
	}
	
	private void addSubCategory() {
		System.out.println("In addSubCategory() Method");
	}

}
