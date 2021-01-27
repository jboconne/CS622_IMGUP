package categories;


//To represent a category that's a top level category 

import java.util.ArrayList;

public class TopLevelCategory extends Category {

	
	private ArrayList<Category> theSubCategories = new ArrayList<Category>();
	
	public TopLevelCategory() {
		super();
	}
	
	public TopLevelCategory(String aString) {
		super(aString);
	}
	
	public void add(Category aCategory) {
		theSubCategories.add(aCategory);
	}
	
	public void display() {
		System.out.println(categoryText);		
	}	

	public void displayAll() {
	// Postcondition: All categories for which this is a TopLevel Category displayed per Category.display()

		display();  // the category itself
		
		// Top Level categories and their sub-categories displayed as per Category.display()
		for(Category category: theSubCategories) {
			if (category instanceof TopLevelCategory) {
				((TopLevelCategory)category).displayAll();  // Here's where we are downcasting with recursion
			}
			else {
				category.display();		
			}
		}
	}	

	public void setText(String someText) {
		categoryText = someText.substring(0, someText.length());
	}
	
	public ArrayList<Category> getSubCategories() {
		return theSubCategories;
	}
	
	public String getText() {
		return categoryText;
	}
	
	public String getType() {
		return "Top Level Category";
	}	
	
}