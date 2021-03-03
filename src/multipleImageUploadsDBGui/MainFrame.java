package multipleImageUploadsDBGui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import multipleImageUploadsDBController.Controller;


public class MainFrame  extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/* This is the MainFrame() class that acts as a controller for our ImageUploader GUI application written using Java FX 
	   Here we create 2 private variables of the textPanel() and formPanel() classes. This basically defines the structure of the GUI. 
	   The formPanel is on the left hand side (WEST) of the JFrame and the textPanel on the right hand side of the JFrame 
	*/ 
	
	private TextPanel textPanel;
	private FormPanel formPanel;
	private Controller controller;
	private TablePanel tablePanel;
	
	/* We are using HashMap with the Key being a String type (filename of the image) and the Value being a string type (file path of the image to upload)
	 * we will use the HashMap as a Synchronized Map Object  */
	public static Map<String, String> imageUploaderSynchronizedMapObject = null;
		
	public MainFrame() { // MainFrame() Constructor
		super("Image Uploader");	// This will appear in the Title of the GUI	
		setLayout(new BorderLayout());	// Create Border Layout	
		
		//Instantiate the textPanel and formPanel objects
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		
		controller = new Controller();
		
		tablePanel.setData(controller.getCategories());
		
		tablePanel.setCategoryTableListener(new CategoryTableListener() {
			public void rowDeleted(int row) {
				controller.removeCategory(row);
			}
		});
		
		/* This is the formListener that works in conjunction with the formListener() class. It listens for events fired by the controls 
		 * on the formPanel and the events that they fire. The most important event calling the UploaderFileToServer.main(filePath, category, subCategory)
		 *  class on line 56 */
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e) {
				String category = e.getCategory();  // This is the Top Level Category we retrieve from the FormListener
				String subCategory = e.getSubCategory(); // This is the Sub Category we retrieve from the FormListener
				HashMap<String, String> imageMapPaths = e.getHashMap(); // This is the HashMap we retrieve from the FormListener
//				controller.addCategory(e);
//				tablePanel.refresh();
				try 
				{
					/* 
					   Used in conjunction with the SynchronizedMapObject and HashMap, we will use an iterator to get the filepath to use when we call the 
					   UploaderFileToServer() class on line 56
					*/
					Iterator<String> itr = imageMapPaths.keySet().iterator();
		         
			        //Using synchronized block is advisable
			        synchronized (imageMapPaths) 
			        {
			            while(itr.hasNext()) {
			                String filePath = imageMapPaths.get(itr.next());
			                UploaderFileToServer.main(filePath, category, subCategory);
			            }
			        }									
				} catch (Exception e1) {									
					e1.printStackTrace();
				} 
				 /* This is the text that gets written to the textPanel after multiple images are successfully uploaded to the web server */				
				StringBuilder str = new StringBuilder();				
				str.append("Category:           "+ category + "\nSub Category:    " + subCategory + 
						"\nThe Following Files were Successfully Saved to the Web Server: \n" );
				for (String key : imageMapPaths.keySet()) {
				    str.append("-"+key)
				       .append("\n");
				}
				textPanel.appendText(str.toString());				
				}

			@Override
			public void formEventOccurred(multipleImageUploads.FormEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Setting the BorderLayouts for each panel (formPanel and textPanel)
		add(formPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
//		add(tablePanel, BorderLayout.CENTER);

		// This is what displays the ImageUploader GUI. Here we determine the size of the JFrame, what to do when the user clicks the 'X" icon on the upper right toolbar and we set 
		//   the visibility on  
		setSize(1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

}
