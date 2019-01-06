package elementarz;

import javax.swing.*;
import java.awt.*;


public class Images extends JFrame{

	public static int i = 0 ;
	public static String[] image;
	public static Icon back;
	public static Icon magenta;
	public static Icon red;
	public static Icon blue;
	public static Icon clear;
	public static Icon green;
	public static Icon next;
	public static Icon litery;
	public static Icon words;
	public static Icon sentences;
	
	
public static void loadInitialImages() {
	
	magenta= new ImageIcon("images/button_magenta.png");
    back = new ImageIcon("images/back.png");
    red= new ImageIcon("images/button_czerwony.png");
    blue= new ImageIcon("images/button_niebieski.png");
    clear= new ImageIcon("images/button_x.png");
    green= new ImageIcon("images/button_zielony.png");
    next= new ImageIcon("images/next.png");
    litery = new ImageIcon("images/button_litery.png");
    words = new ImageIcon("images/button_wyrazy.png");
    sentences = new ImageIcon("images/button_zdania.png");
    
	image= new String[52];
	image[0] = "images/A.jpg";
	image[1] = "images/B.jpg";
	image[2] = "images/C.jpg";
	image[3] = "images/D.jpg";
	image[4] = "images/E.jpg";
	image[5] = "images/F.jpg";
	image[6] = "images/G.jpg";
	image[7] = "images/H.jpg";
	image[8] = "images/I.jpg";
	image[9] = "images/J.jpg";
	image[10] = "images/K.jpg";
	image[11] = "images/L.jpg";
	image[12] = "images/M.jpg";
	image[13] = "images/N.jpg";
	image[14] = "images/O.jpg";
	image[15] = "images/P.jpg";
	image[16] = "images/R.jpg";
	image[17] = "images/S.jpg";
	image[18] = "images/T.jpg";
	image[19] = "images/U.jpg";
	image[20] = "images/W.jpg";
	image[21] = "images/Y.jpg";
	image[22] = "images/Z.jpg";///
	image[23] = "images/Ą.jpg";
	image[24] = "images/Ć.jpg";
	image[25] = "images/Ę.jpg";
	image[26] = "images/Ł.jpg";
	image[27] = "images/Ń.jpg";
	image[28] = "images/Ó.jpg";
	image[29] = "images/Ś.jpg";
	image[30] = "images/Ź.jpg";
	image[31] = "images/Ż.jpg";//
	image[32] = "images/Mama.jpg";
	image[33] = "images/Tata.jpg";
	image[34] = "images/Kotek.jpg";
	image[35] = "images/Dzban.jpg";
	image[36] = "images/Jabłko.jpg";
	image[37] = "images/Ptak.jpg";
	image[38] = "images/Szkoła.jpg";
	image[39] = "images/Sowa.jpg";
	image[40] = "images/Słoń.jpg";
	image[41] = "images/Pies.jpg";//
	image[42] = "images/Studiuję.jpg";
	image[43] = "images/Rano.jpg";
	image[44] = "images/Rodzynki.jpg";
	image[45] = "images/Palenie.jpg";
	image[46] = "images/Pije.jpg";
	image[47] = "images/Tam.jpg";
	image[48] = "images/My.jpg";
	image[49] = "images/Chodzę.jpg";
	image[50] = "images/Chcę.jpg";
	image[51] = "images/Ala.jpg";
    }

public static Image loadImage(String fileName) {
    return new ImageIcon(fileName).getImage();
}
}