package imageUpload_test;
import javax.swing.SwingUtilities;

import imageUpload.MainFrame;


public class ImageUploaderGuiTest  {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			public void run() {				
				new MainFrame();				
			}			
		});		
	}
}
