package multipleImageUploads;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* Here’s where we read the binary image file in from filePath storing it in a buffered image using a 
	ByteArrayOutPutStream that gets written to the byte array called bytes */

public class UploaderFileToServer {
	
		// This is the class that receives the FilePath , category and sub category of the image the user will be uploading. This is called by 
		// imageUpload.MainFrame() class
		// Precondition 1 (Pre1) - MainFrame() GUI controller passes in filePath for image, category and sub category
		// Postcondition 1 (P1) - Reads binary image file from filePath
		// P2 - Writes to  ByteArrayOutputStream 
		// P3 - ByteArrayOutputStream gets written to BufferedImage as jpg
		// P4 - ByteArrayOutputStream gets assigned to  byte array called bytes
		// P5 - Byte[] bytes gets assigned to ImageIcon of JFrame object 
	public static void main(String filePath,  String Category, String SubCategory) throws Exception{ //Pre1
	     
		
		  String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now());   
		  
		  // create object of Path 
	      Path path = Paths.get(filePath); 
	  
	      // call getFileName() and get FileName path object 
	      Path fileName = path.getFileName(); 
		  BufferedImage img = null;
		  
	      img = ImageIO.read(new File(filePath)); //P1
	      
		  ByteArrayOutputStream baos = new ByteArrayOutputStream(); //P2
			 
		  ImageIO.write(img, "jpg", baos); //P3
		  baos.flush();
			 
		  byte[] bytes = baos.toByteArray(); //P4
		  baos.close();
		  
		  /*    Typically, we would have server code here to pass the byteArray to the input stream, but I could not get it to work
		   *    so I commented out lines 28-42 below and just assign the Byte Array to ImageIconat at line 55	   * 
		   */
		  		/*
				  InputStream in = new ByteArrayInputStream(bytes);
			      DataInputStream dis = new DataInputStream(in);
		
			      int len = dis.readInt();
			      System.out.println("Image Size: " + len/1024 + "KB");
			      
			      byte[] data = new byte[len];
			      dis.readFully(data);
			      dis.close();
			      in.close();
		
			      InputStream ian = new ByteArrayInputStream(data);
			      BufferedImage bImage = ImageIO.read(ian);
	 			*/
	      
	      int len2 = bytes.length;
	      System.out.println("");
	      System.out.println("File Name: " + fileName);
	      System.out.println("File Path: " + filePath);
	      System.out.println("Size of bytes: " + len2);	      
	      System.out.println("Image Size: " + len2/1024 + "KB");	     
	      System.out.println("TimeDate/Time Saved: " +s);
	      
	      // Here's where I just assigned the Byte[] bytes to the ImageIcon of the JFrame 
	      // This will simulate the image being uploaded to the web server with a preview of the image showing in the right panel of 
	      // the ImageUploader GUI built in Java FX
	      
	      JFrame f = new JFrame(Category+" - "+ SubCategory);
	      ImageIcon icon = new ImageIcon(bytes); //P5
	      JLabel l = new JLabel();
	      
	      l.setIcon(icon);
	      f.add(l);
	      f.pack();
	      f.setVisible(true);
	      
	      /*
	          Note: I could not get the server aspect of the application to work yet. In essence, I will be uploading the image 
	                and selected category hierarchy to the web server. For illustrative purposes, I read the binary image file 
	                selected by the user
	      */ 
	      
	   }
}
