package imageUpload;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import category_IO.ReadSubCategories;

/* 	Here’s the FormPanel() class that contains the majority of user interactions on the ImageUploader GUI form.
  	It defines the controls of the FormPanel() class and the events that they fire as well as the layout of the form using the 
  	GridBagLayout and the GridBagConstraints settings.  
*/

public class FormPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// This is the class that defines the formPanel class that gets called by imageUpload.MainFrame() class
	// Precondition 1 (Pre1) - Create all private form controls and form listener
	// Precondition 2 (Pre2) - Create static string for JFileChooser default directory
	// Precondition 3 (Pre3) - Create Dimension setting calling getPreferredSize() method of Java FX. Sets preferred width of the formPanel
	// Precondition 4 (Pre4) - Create layout of components for formPanel. Calls layoutComponents() method using GridBagLayout
	
	
	// Postcondition 1 (P1) - Assign ActionListener for when Browse button is clicked
	// P2 - When JFileChooser control is used to select image file to be uploaded, assign filePath and fileName variables to JLabel controls 
	// P3 - Assign ActionListener for when UploadImage button is clicked 
	// P4 - Create FormEvent variable called 'ev' as input parameter and pass to FormEvent() class passing in the values we retrieved from actionPerformed() method */
	// P5 - formListener.formEventOccurred method gets called with 'ev' input parameter but only if formListener object is not */
	// P6 - setFormListener(FormListener listener) class gets called by MainFrame controller class when an event is fired

	
	/* Pre1 */
	private JLabel categoryLabel;
	private JLabel subCategoryLabel;
	private JLabel fileSelectedLabel;
	private JLabel fileSelectedPathLabel;
	private JButton selectImageBtn;
	private JButton uploadBtn;
	private FormListener formListener;
	private JComboBox catCombo;
	private JComboBox subCatCombo;
	
	public static String dirpath="./src/images"; // Pre2
	
	public FormPanel() {
		
		/* Pre3 */
		Dimension dim = getPreferredSize();	
		dim.width=350;
		setPreferredSize(dim);
		
		/* Instantiate formPanel controls */
		categoryLabel = new JLabel("Category: ");
		subCategoryLabel = new JLabel("Sub Category: ");
		fileSelectedLabel = new JLabel("");
		fileSelectedPathLabel = new JLabel("");
		catCombo = new JComboBox();
		subCatCombo = new JComboBox();
		
		// Setup Combo Box Top Level Categories
		DefaultComboBoxModel catComboModel = new DefaultComboBoxModel();
		catComboModel.addElement("Select Top Level Category...");
		catComboModel.addElement("Client Portfolio");
		catComboModel.addElement("Asphalt Paving");
		catComboModel.addElement("Specialty Work");
		catComboModel.addElement("Grading & Excavating");
		catComboModel.addElement("Shuttle Buggy Rental");
		catCombo.setModel(catComboModel);
		catCombo.setSelectedIndex(0);
		
		
		// Create an Array List of sub categories to use sort with lambda		
		String[] arrSubCats = {"Pepsi Bottling","Walmart", "Family Dollar", "Kroger"};
		
		// Sort ArrayList using lambda calling function stringCompare defined in ReadSubCategories class
		Arrays.sort(arrSubCats, (firstSubCategory, secondSubCategory) -> 
        {  
           return ReadSubCategories.stringCompare(firstSubCategory, secondSubCategory);
        });
		
		// Setup Combo Box Sub Categories
		DefaultComboBoxModel subCatComboModel = new DefaultComboBoxModel();
		subCatComboModel.addElement("Select Sub Category...");
		
		// Loop through array of sorted sub Categories and assign to subCatComboModel
		for (String strSubCat : arrSubCats){
			subCatComboModel.addElement(strSubCat);
		}
		subCatCombo.setModel(subCatComboModel);
		subCatCombo.setSelectedIndex(0);
		
		selectImageBtn = new JButton("Browse");		
		uploadBtn = new JButton("Upload Image");
		
		/* P1 - Assign ActionListener for when Browse button is clicked */ 
		selectImageBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	JFileChooser fileChooser = new JFileChooser(dirpath); // Pre3 
		    	fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png")); // Filter for these types of images only
		    	fileChooser.setAcceptAllFileFilterUsed(true);
		    	 
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION)
		        {
		            /* Assign filePath and fileNname variables for file selected from JFileChooser control*/ 
		        	File selectedFile = fileChooser.getSelectedFile();
		            String fileNameSelected = selectedFile.getName();
		            fileSelectedLabel.setText(fileNameSelected); // P2
		            fileSelectedPathLabel.setText(selectedFile.toString()); // P2
		            System.out.println(fileSelectedPathLabel.getText());
		        }
		    }
		});
		
		/* P3 - Assign ActionListener for when UploadImage button is clicked. Here we call actionPerformed method with ActionEvent e */
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = (String)catCombo.getSelectedItem();
				String subCategory = (String)subCatCombo.getSelectedItem();	
				String filePath = fileSelectedPathLabel.getText(); 
				String imageFileName = fileSelectedLabel.getText();
				
				/* P4 - Create FormEvent variable called 'ev' as input parameter to formListener passing in the values we retrieved from actionPerformed() method above */
				FormEvent ev = new FormEvent(this, category, subCategory, filePath, imageFileName);
				
				/* P5 - if formListener object is Not Null, call formListener.formEventOccurred method with 'ev' input parameter  */
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		}); 
		
		/* Set Dual Borders for the formPanel giving it a beveled border look */
		Border innerBorder = BorderFactory.createTitledBorder("Select Image");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents(); // Pre4
	}
	
	
	/* Pre4 - The layout of formPanel controls using GridBagLayout() */
	public void layoutComponents() {
		
		setLayout(new GridBagLayout());		
		GridBagConstraints gc = new GridBagConstraints();		
		
		/*   First Row  */
		gc.gridy=0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx=0;
				
		gc.fill=GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(categoryLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(catCombo, gc);
		
		/*   Next Row  */
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(subCategoryLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(subCatCombo, gc);
		
		/*   Next Row  */
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(fileSelectedLabel, gc);		
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(selectImageBtn, gc);
		
		/*   Next Row  */
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(uploadBtn, gc);
	}
	
	/* P6 - The class gets called by the MainFrame() controller class when an event is fired */ 
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}
