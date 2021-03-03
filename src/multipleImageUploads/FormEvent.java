package multipleImageUploads;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;


/* This is the formEvent() class that gets called by the formPanel() and MainFrame() classes */

public class FormEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private String category;
	private String subCategory;
	private HashMap imagePaths;

	public FormEvent(Object source) {
		super(source);
	}
	/*  
	 	FormEvent constructor with parameters - This gets passed into the UploadedFileToServer classes which uploads 
	 	the selected images using myImageUploads HashMap and category hierarchy to the web server
	*/
	
		public FormEvent(Object source, String category, String subCategory, HashMap<String, String> myImageUploads  ) { 
		super(source);
		this.category = category;
		this.subCategory = subCategory;
		this.imagePaths = myImageUploads;		
	}
	
	/* Getters and Setters for FormEvents */ 

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	public HashMap<String, String> getHashMap() {
		return imagePaths;
	}

	public void setHashMap(HashMap<String, String> myImageUploads) {
		this.imagePaths = myImageUploads;
	}
}
