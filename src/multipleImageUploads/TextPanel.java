package multipleImageUploads;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// This is the textPanel class that displays the category and sub category of the image the user will be uploading. This is called by 
			// imageUpload.MainFrame() class
			// Precondition 1 (Pre1) - Instantiates the JTextArea private variable textArea used by the MainFrame() class
			// Precondition 2 (Pre2) - setLayout for BorderLayout
			// Precondition 3 (Pre3) - add JScrollPane for textArea and border
			// Postcondition 1 (P1) -  Append Text to the textArea 
			// Postcondition 2 (P2) -  Clears out any text that exists from before 
			
	private JTextArea textArea; // Pre1
	public TextPanel() {
		textArea = new JTextArea(); // Pre1
		setLayout (new BorderLayout()); // Pre2
		add(new JScrollPane(textArea), BorderLayout.CENTER); // Pre3
	}

	public void appendText(String text) { // P1
		//textArea.setText(null); // P2
		textArea.append(text); // P1
	}
	
	

}
