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

/*
public class NonHeadingFragment extends Category {
	
	public NonHeadingFragment() {
		super();
	}
	
	public NonHeadingFragment(String aString) {
		super(aString);
	}

	public void display() {
		System.out.println("\t" + fragmentText);			
	}	

	public void setText(String someText) {
		fragmentText = someText.substring(0, someText.length());
	}
	
	public String getText() {
		return fragmentText;
	}
	
	public String getType() {
		return "Non-heading fragment";
	}
	
}
*/
