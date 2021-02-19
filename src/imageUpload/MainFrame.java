package imageUpload;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame  extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/* This is the MainFrame() class that acts as a controller for our ImageUploader GUI application written using Java FX 
	   Here we create 2 private variables of the textPanel() and formPanel() classes. This basically defines the structure of the GUI. 
	   The formPanel is on the left hand side (WEST) of the JFrame and the textPanel on the right hand side of the JFrame 
	*/ 
	
	private TextPanel textPanel;
	private FormPanel formPanel;
		
	public MainFrame() { // MainFrame() Constructor
		super("Image Uploader");	// This will appear in the Title of the GUI	
		setLayout(new BorderLayout());	// Create Border Layout	
		
		//Instantiate the textPanel and formPanel objects
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		/* This is the formListener that works in conjunction with the formListener() class. It listens for events fired by the controls 
		 * on the formPanel and the events that they fire. The most important event calling the UploaderFileToServer.main(filePath, category, subCategory)
		 *  class on line 34 */
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String category = e.getCategory();
				String subCategory = e.getSubCategory();
				String filePath =e.getFilePath();
				String imageFileName = e.getImageFileName();
				try {
					UploaderFileToServer.main(filePath, category, subCategory);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				 /* This is the text that gets written to the textPanel after the image is successfully uploaded to the web server */
				textPanel.appendText("Category:           "+ category + "\nSub Category:    " + subCategory + "\nFile:"+ imageFileName +" was Succesfully Saved to the Web Server\n");
			}
		});
		
		// Setting the BorderLayouts for each panel (formPanel and textPanel)
		add(formPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);

		// This is what displays the ImageUploader GUI. Here we determine the size of the JFrame, what to do when the user clicks the 'X" icon on the upper right toolbar and we set 
		//   the visibility on  
		setSize(1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

}
