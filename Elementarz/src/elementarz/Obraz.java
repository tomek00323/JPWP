package elementarz;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obraz extends JFrame{
	public static Image bgImage, bgImage2;
//	public static  icon1;
	public static Image icon1;
public static void loadInitialImages() {
        
        bgImage = loadImage("images/A.jpg");
        bgImage2 = loadImage("images/B.jpg");
       icon1= loadImage("images/+.png");
      //  menuGameImage=loadImage("images/gra_1024.png");
     //   logoImage=loadImage("images/domestic_logo_url.png");
     //   cursorImage=loadImage("images/target_32_r.png");


    //    balloons= new Image[5];
    //    balloons[0]=loadImage("images/b_blue_300.png");
    //    balloons[1]=loadImage("images/b_red_300.png");
    //    balloons[2]=loadImage("images/b_violet_300.png");
     //   balloons[3]=loadImage("images/b_brown_300.png");
     //   balloons[4]=loadImage("images/b_green_300.png");
    }//koniec loadInitialImages()
public static Image loadImage(String fileName) {
    return new ImageIcon(fileName).getImage();
}
	
protected void paintComponent(Graphics g) { 
  g.drawImage(Obraz.bgImage, 0, 0, null);
  }	
	
	
	
	
}