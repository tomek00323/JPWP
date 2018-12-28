package elementarz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;





public class ColorDetection {
	private int pixelRgb [] = new int [3];
	private Vector<String> colorName= new Vector<String>();
	private Vector<Double> distances = new Vector<Double>();
	private int [][] storedRgb;
	public static BufferedImage imgR ;
	private String imagePath;
	private Color myColor = new Color (255, 255, 255);
	public static final JTextPane textPane = new JTextPane();
	public static final JTextPane textPane2 = new JTextPane();
	public static final JTextPane colorTextP = new JTextPane();
	public static int rgbPixel[] = new int [3];
	DrawArea drawArea;
	ColorDetection(int rgb[])
	{
		rgbImage(drawArea.X, drawArea.Y);
		pixelRgb = rgb.clone(); //clones array
		/*read file and extract names + r g b values from the file*/
	//	readFile();
		
		/*Find distance of the given pixel to all the ones in file*/
		for(int i=0; i<storedRgb.length; i++)
			distances.add(colorDistance(storedRgb[i]));
		
		/*Select the pixel which is closest to the given pixel and display it and its name*/
		double min = Collections.min(distances);
		int i = distances.indexOf(min);
		/*JFrame stuff*/
		changeColor(storedRgb[i][0],storedRgb[i][1], storedRgb[i][2]);
		changeText("(" + storedRgb[i][0] + ", " + storedRgb[i][1] + ", " + storedRgb[i][2] + ")", colorName.elementAt(i).toUpperCase());
		
		
	}
	 public void init() {
		 File imageFile = new File("/image/A.jpg");
			if(imageFile != null){
			     imagePath = imageFile.getPath();
			     readImage();
			}
		 
	 }
	public void readImage()
	{
		try {
			imgR = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
        }
	}
	//public static void changeColor(int r, int g, int b)
//	{
	//	but2.changeColor(r, g, b);
	//	but2.repaint();
	//}
	public static void changeText(String text, String ctext)
	{	
		textPane2.setText(text);
		colorTextP.setText(ctext);
	}
	public double colorDistance(int otherRgb[])	
	{
		long rmean = ( (long)pixelRgb[0] + (long)otherRgb[0] ) / 2;
		long r = (long)pixelRgb[0] - (long)otherRgb[0];
		long g = (long)pixelRgb[1] - (long)otherRgb[1];
		long b = (long)pixelRgb[2] - (long)otherRgb[2];
		return Math.sqrt((((512+rmean)*r*r)>>8) + 4*g*g + (((767-rmean)*b*b)>>8));
	}
	
	public void changeColor(int r, int g, int b){
	   		myColor = new Color (r,g,b);
	}
	public static void rgbImage(int x, int y)
	{
		/*Gets rgb of selected pixel at the selected coordinate*/
		int rgb = imgR.getRGB(x,y);
		/*Extracts to r g b values*/
		rgbPixel[0]=   (rgb >> 16) & 0xFF;
		rgbPixel[1] = (rgb >>  8) & 0xFF;
		rgbPixel[2] =  (rgb      ) & 0xFF;
		
		/*Display color + RGB value*/
	//	but1.changeColor(rgbPixel[0], rgbPixel[1], rgbPixel[2]);
	//	but1.repaint();
		textPane.setText("(" + rgbPixel[0] + ", " + rgbPixel[1] + ", " + rgbPixel[2] + ")");
		ColorDetection detect = new ColorDetection(rgbPixel);
	}
}
