package multipleImageUploads_test;
import javax.swing.SwingUtilities;


public class ImageUploaderGuiTest  {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			public void run() {				
				new multipleImageUploads.MainFrame();				
			}			
		});		
	}
}
