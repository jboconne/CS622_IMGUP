package categories;

public abstract class Category {
		// (1) Variables/Attributes (2) Constructors (3) Methods
			
			// string parameter		
			protected String categoryText = "category not determined yet";
			
			//Default constructor
			public Category() {
			}
			
			//Constructor with string parameter as input
			public Category(String someText) {
				categoryText = someText;
			}
			
			// abstract methods.
			public abstract void display(); // display category
			public abstract String getText(); // getter for Category
			public abstract String getType(); // get Type of Category; TopLevel or SubLevel
			public abstract void setText(String someText); // setter for Category
}
