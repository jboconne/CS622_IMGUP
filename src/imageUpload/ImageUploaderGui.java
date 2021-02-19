package imageUpload;
import javax.swing.SwingUtilities;

public class ImageUploaderGui  {
	/* This is the class that gets called to run the MainFrame() class of the ImageUploader application
	 *  it runs the MainFrame() class which is the main controller of the ImageUploader GUI application 
	 *  written in JAVA FX
	*/
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			public void run() {				
				new MainFrame();				
			}			
		});		
	}
}
