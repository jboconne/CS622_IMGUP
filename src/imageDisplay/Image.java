package imageDisplay;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image<T> {
	
	
	public T reverse(final T value) {
	    T result = null;
	    while (true) {
	        if (value instanceof String) {
	            System.out.println("Category of Image");
	            result = value;
	            break;
	        }
	        if (value instanceof ImageIcon) {
	            System.out.println("Image Icon Object");
	            result = value;
	            break;
	        }
	        if (value instanceof JFrame) {
	            System.out.println("JFrame Object");
	            result = value;
	            break;
	        }
	        throw new RuntimeException("ProgramCheck: Missing handler for type " + value.getClass().getSimpleName());
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		final Image<String> testerString = new Image<>();
	    testerString.reverse("string");

	    final Image<ImageIcon> testerImageIcon = new Image<>();
	    testerImageIcon.reverse(new ImageIcon());
	    
	    final Image<JFrame> testerJFrame = new Image<>();
	    testerJFrame.reverse(new JFrame());
	}
}
