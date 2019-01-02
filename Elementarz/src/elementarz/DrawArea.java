/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Tomek
 */
public class DrawArea extends JComponent {
	 
	
	  private Image image;
	  private BufferedImage bi;
	  private static BufferedImage img = null;
	  private Graphics2D g2;
	  public int X, Y, oldX, oldY;
	  private int w;
	  private int h;
	  public int fontsize=10;//domyslna grubosc linii
	  static BufferedImage imgR = null;
	  private static int rgbPixel[] = new int [3];
	  public static int counter = 0;
	  public static int counter1 = 0;
	  public static int point = 0;
	  public static int points = 0;
	  private static boolean check = false;
	  public DrawArea() {
		  try {
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	            System.out.println("GIT");
	 
	        } catch (IOException e) {
	            System.out.println("Nie wczytano zdjęcia");
	        }
		 
	    setDoubleBuffered(false);
	    addMouseListener(new MouseAdapter() {
	      public void mousePressed(MouseEvent e) {
	        // zapisanie pozycji przemieszczenia
	        oldX = e.getX();
	        oldY = e.getY();
	      }
	    });
	 
	    addMouseMotionListener(new MouseMotionAdapter() {
	      public void mouseDragged(MouseEvent e) {
	        // pobieranie wspolrzendych
	        X = e.getX();
	        Y = e.getY();
	 
	        if (g2 != null) {
	        	rgbImage(X,Y);
	          g2.drawLine(oldX, oldY, X, Y);//rysowanie linii
	          g2.setStroke(new BasicStroke(fontsize));//grubosc linii
	          repaint();
	          oldX = X;
	          oldY = Y;
	        }
	      }
	    });
	  }
	    
		  
	  public static void rgbImage(int x, int y)
		{
			int rgb = img.getRGB(x,y);
			rgbPixel[0]=   (rgb >> 16) & 0xFF;
			rgbPixel[1] = (rgb >>  8) & 0xFF;
			rgbPixel[2] =  (rgb) & 0xFF;
			SwingPaint.textPane2.setText(Integer.toString(point));
			//System.out.println(rgbPixel[0] +" "+ rgbPixel[1] + " " +rgbPixel[2]);
			//SwingPaint.textPane.setText("(" + rgbPixel[0] + ", " + rgbPixel[1] + ", " + rgbPixel[2] + ")");
			//SwingPaint.textPane.setText("Postaraj się!!!!");
			if(rgbPixel[0] == 255 && rgbPixel[1] == 255 && rgbPixel[2] == 255) {
				counter++;
				point++;
				System.out.println(counter);
				
				if(counter == 100)
					check = true;
					SwingPaint.textPane.setText("Naciśnij przycisk 'Wyczyść' i spróbuj jeszcze raz");
			}
			
			if(rgbPixel[0] == 0 && rgbPixel[1] == 0 && rgbPixel[2] == 0) {
				System.out.println(point);
				if(check == false) {
					counter1++;
					point++;
				if(counter1 == 20) {
					SwingPaint.textPane.setText("DOBRZE");
					
					
					}
				if(counter1 == 200) {
				SwingPaint.textPane.setText("TAK TRZYMAJ :D");
				
				}
				if(counter1 == 500) {
					SwingPaint.textPane.setText("REWELACYJNIE !");
					
					}
				} else
				{
					
				}
			}
		}  

	  protected void paintComponent(Graphics g) { 
	    if (image == null) {
	      image = createImage(getSize().width, getSize().height);
	      g2 = (Graphics2D) image.getGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing
	      clear();
	    }
	    
	    g.drawImage(image, 0, 0, null); 
	   
	   
	  }
	  
	  public void clear() {
		counter =0;
		counter1 = 0;
		check = false;
	    g2.setPaint(Color.white);
	    g2.fillRect(0, 0, getSize().width, getSize().height);
	    g2.setPaint(Color.red);
	    try {
			  
			  System.out.println(Images.i);
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	            System.out.println("GIT");
	            repaint();
	 
	        } catch (IOException e) {
	            System.out.println("Nie wczytano zdjęcia");
	        }
	    g2.drawImage(Images.loadImage(Images.image[Images.i]), 0, 0, null);
		  repaint();
	    repaint();  
	  }
	 
	  public void red() {
	    g2.setPaint(Color.red);
	  }
	 
	  public void black() {
		  g2.setPaint(Color.black);
	  }
	 
	  public void magenta() {
	    g2.setPaint(Color.magenta);
	  }
	 
	  public void green() {
	    g2.setPaint(Color.green);
	  }
	 
	  public void blue() {
	    g2.setPaint(Color.blue);
	  }
	  public void zmien() {
		  Images.i++;
		  try {
			  
			  System.out.println(Images.i);
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	            System.out.println("GIT");
	            repaint();
	            counter =0;
	 
	        } catch (IOException e) {
	            System.out.println("Nie wczytano zdjęcia");
	        }
		  g2.drawImage(Images.loadImage(Images.image[Images.i]), 0, 0, null);
		  repaint();
		  }
	}