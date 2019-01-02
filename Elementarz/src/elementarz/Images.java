package elementarz;

import javax.swing.*;
import java.awt.*;


public class Images extends JFrame{
	public static int i = 0 ;
	public static String[] image;
	public static Icon black, magenta, red, blue, clear, green, plus, minus;
public static void loadInitialImages() {
	image= new String[5];
	image[0] = "images/A.jpg";
	image[1] = "images/B.jpg";
	image[2] = "images/C.jpg";
	image[3] = "images/D.jpg";
	image[4] = "images/E.jpg";
	
	
    black= new ImageIcon("images/button_czarny.png");
    magenta= new ImageIcon("images/button_magenta.png");
    red= new ImageIcon("images/button_czerwony.png");
    blue= new ImageIcon("images/button_niebieski.png");
    clear= new ImageIcon("images/button_wyczysc.png");
    green= new ImageIcon("images/button_zielony.png");
    plus= new ImageIcon("images/+.png");
    minus= new ImageIcon("images/-.png");
    }//koniec loadInitialImages()
public static Image loadImage(String fileName) {
    return new ImageIcon(fileName).getImage();
}
}