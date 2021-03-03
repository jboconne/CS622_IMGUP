package multipleImageUploadsDBGui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import multipleImageUploadsDBModel.Category;

public class CategoryTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Category> db;
	
	private String[] colNames = {"ID" , "Category Name"};
	
	public CategoryTableModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	public void setData(List<Category> db) {
		this.db = db;
	} 
	
	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Category category = db.get(row);
		
		switch (col) {
		case 0:
			return category.getId();
		case 1:
			return category.getName();		
		}
		return null;
	}

}
