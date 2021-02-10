package imageDisplay;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageData<K, V> implements ImageInfo<K, V> {
	private K key;
    private V value;

    public ImageData(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
    
    
    public static void main(String[] args) {
    	ImageData<String, String>  img1 = new ImageData<String, String>("pepsibottling.jpg","Client Portfolio-Pepsi Bottling");
    	ImageData<String, String>  img2 = new ImageData<String, String>("walmart.jpg","Client Portfolio-Walmart");
    	ImageData<String, String>  img3 = new ImageData<String, String>("familyDollar.jpg","Client Portfolio-Family Dollar");
    	ImageData<String, String>  img4 = new ImageData<String, String>("krogerparking.jpg","Client Portfolio-Kroger");
    	System.out.println("Image Data FileName: " + img1.getKey() +  "\t\tImage Category: " + img1.getValue());
    	System.out.println("Image Data FileName: " + img2.getKey() +  "\t\tImage Category: " + img2.getValue());
    	System.out.println("Image Data FileName: " + img3.getKey() +  "\t\tImage Category: " + img3.getValue());
    	System.out.println("Image Data FileName: " + img4.getKey() +  "\t\tImage Category: " + img4.getValue());
	}
}
