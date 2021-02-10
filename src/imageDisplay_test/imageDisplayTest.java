package imageDisplay_test;
import java.awt.Container;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;

public class imageDisplayTest extends JFrame {

	private static final long serialVersionUID = 1234567L;

	
	public <K,V> imageDisplayTest(GraphicsConfiguration graphicsConfiguration) {
		
        initUI();
    }
	
	private void initUI() {       
        
//		ImageIcon ii = loadImage("src/images/pepsibottling.jpg" );
		ImageIcon ii = loadImage("src/images/walmart.jpg" );
//		ImageIcon ii = loadImage("src/images/familyDollar.jpg" );
//		ImageIcon ii = loadImage("src/images/kroger.jpg" );

        JLabel label = new JLabel(ii);

        createLayout(label);

//        setTitle("Client Portfolio-Pepsi Bottling");
        setTitle("Client Portfolio-Walmart");        
//        setTitle("Client Portfolio-Family Dollar");
//        setTitle("Client Portfolio-Kroger");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
	private ImageIcon loadImage(String imgPath ) {

        ImageIcon ii = new ImageIcon(imgPath);
        return ii;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }
    
    private static GraphicsConfiguration ImageData(Object key, Object value) {
//    	System.out.println("******* Begin Printing ImageData Items from Graphics Configuration **********" );
    	System.out.println("Key from GC: " + key + " " +"\t\tValue from GC: "+ value);
    	
//    	return ImageData(key,value);
    	return null;
    	}
    
    public static void main(String[] args) {
    	
    	Map<String, String> map=new HashMap<String, String>();  
//			map.put("pepsibottling.jpg","Client Portfolio-Pepsi Bottling");  
			map.put("walmart.jpg","Client Portfolio-Walmart");
//			map.put("familyDollar.jpg","Client Portfolio-Family Dollar");
//			map.put("kroger.jpg","Client Portfolio-Kroger");
//		
		
			//Now use Map.Entry for Set and Iterator  
			Set<Map.Entry<String,String>> set=map.entrySet();  
		  
			Iterator<Map.Entry<String,String>> itr=set.iterator();  
				while(itr.hasNext()){  
					Map.Entry e=itr.next();//no need to typecast  
					System.out.println("Key: " + e.getKey() + " " +"\t\tValue: "+ e.getValue());				
					
					EventQueue.invokeLater(() -> {
						imageDisplayTest ex = new imageDisplayTest(ImageData(e.getKey(), e.getValue()));
			            ex.setVisible(true);
			        });
				
				}
		 
				
			
    	
			
		
    }	
	

}
