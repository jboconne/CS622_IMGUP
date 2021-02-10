package imageDisplay_test;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageTest<T> {
	
	
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
		final ImageTest<String> testerString = new ImageTest<>();
	    testerString.reverse("string");

	    final ImageTest<ImageIcon> testerImageIcon = new ImageTest<>();
	    testerImageIcon.reverse(new ImageIcon());
	    
	    final ImageTest<JFrame> testerJFrame = new ImageTest<>();
	    testerJFrame.reverse(new JFrame());
	}
}
