package imageUpload;

import java.util.EventObject;

/* This is the formEvent() class that gets called by the formPanel() and MainFrame() classes */

public class FormEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private String category;
	private String subCategory;
	private String filePath;
	private String imageFileName;
	
	public FormEvent(Object source) {
		super(source);
	}
	/*  
	 	FormEvent constructor with parameters - This gets passed into the UploadedFileToServer classes which uploads 
	 	the selected image and category hierarchy to the web server
	*/ 
	public FormEvent(Object source, String category, String subCategory, String filePath, String imageFileName) {
		super(source);
		this.category = category;
		this.subCategory = subCategory;
		this.filePath = filePath;
		this.imageFileName = imageFileName;
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
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setIamgeFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	
}
