package multipleImageUploadsDBModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<Category> categories;
	
	public Database() {
		categories = new LinkedList<Category>();
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public void removeCategory(int index) {
		categories.remove(index);
	}	
	
	public List<Category> getCategories(){
		return Collections.unmodifiableList(categories);
	}
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Category[] categoryList = categories.toArray(new Category[categories.size()]);
		oos.writeObject(categoryList);
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Category[] categoryList = (Category[])ois.readObject();
			
			categories.clear();
			
			categories.addAll(Arrays.asList(categoryList));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ois.close();
	}
}
