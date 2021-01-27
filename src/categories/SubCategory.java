package categories;

public class SubCategory extends Category{
	
	public SubCategory() {
		super();
	}
	
	public SubCategory(String aString) {
		super(aString);
	}

	public void display() {
		System.out.println("\t" + categoryText);			
	}	

	public void setText(String someText) {
		categoryText = someText.substring(0, someText.length());
	}
	
	public String getText() {
		return categoryText;
	}
	
	public String getType() {
		return "Sub Category";
	}

}