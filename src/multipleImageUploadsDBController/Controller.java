package multipleImageUploadsDBController;


import java.util.List;

import multipleImageUploadsDBGui.FormEvent;
import multipleImageUploadsDBModel.Category;
import multipleImageUploadsDBModel.Database;

public class Controller {
	
	Database db = new Database();
	
	public List<Category> getCategories(){
		return db.getCategories();
	}
	
	public void removeCategory(int index) {
		db.removeCategory(index);
	}
	
 public void addCategory(FormEvent ev) {
	 String name = ev.getCategory();
	 
	 Category category = new Category(name);
	 db.addCategory(category);
 }
}
