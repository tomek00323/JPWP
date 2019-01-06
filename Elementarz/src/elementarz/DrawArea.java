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
	  public int fontsize=8;//domyslna grubosc linii
	  static BufferedImage imgR = null;
	  private static int rgbPixel[] = new int [3];
	  public static int counter = 0;
	  public static int counter1 = 0;
	  public static int point = 0;
	  public static boolean check = false;
	  public static int Suma = 0;
	  public DrawArea() {
		  
		  try {
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	 
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
	        	rgbImage(X,Y);//wywołanie metody pobierającej wartości 
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
			int rgb = img.getRGB(x,y);//pobranie wartości RGB piksela
			rgbPixel[0]=   (rgb >> 16) & 0xFF;
			rgbPixel[1] = (rgb >>  8) & 0xFF;
			rgbPixel[2] =  (rgb) & 0xFF;


			
			if(rgbPixel[0] == 255 && rgbPixel[1] == 255 && rgbPixel[2] == 255) {//polorowanie białych pikseli
				counter++;//zmienna zliczająca ilość pokolorowanych białych pikseli
				System.out.println(counter);
				
				if(GUI.level ==3) {//zdania
					if(counter == 370) {
						check = true;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
					}
				}else if (GUI.level ==1) {//litery
					if(counter == 100) {
						check = true;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
					}	
				}else if (GUI.level ==2) {//wyrazy
					if(counter == 200) {
						check = true;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
					}	
				}
			}
			
				
			
			if(rgbPixel[0] == 0 && rgbPixel[1] == 0 && rgbPixel[2] == 0) {//pokorowanie czarnych pikseli
			//	System.out.println(counter1);
				if(check == false) {
					counter1++;
					
				if(counter1 == 20) {
					
					point = 1*GUI.level;
					Suma = Suma + point;
					GUI.textPane.setText("Dobrze");
					GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
					}
				if(counter1 == 300) {
				
				point = 1*GUI.level;
				Suma = Suma + point;
				GUI.textPane.setText("Tak trzymaj :D");
				GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
				}
				if(counter1 == 900) {
					point = 1*GUI.level;
					Suma = Suma + point;
					GUI.textPane.setText("Rewelacyjnie!");
					GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
					
					}
				if(GUI.level ==1) {
					if(counter1 == 950) {
						point = 1*GUI.level;
						Suma = Suma + point;
						GUI.textPane.setText("Brawo! Ładnie piszesz litery!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
				}
				}
				if(GUI.level ==2) {
					if(counter1 == 1200) {
						point = 1*GUI.level;
						Suma = Suma + point;
						GUI.textPane.setText("Brawo! Ładnie piszesz wyrazy!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
				}
				}
				if(GUI.level ==3) {
					if(counter1 == 1400) {
						point = 1*GUI.level;
						Suma = Suma + point;
						GUI.textPane.setText("Brawo! Ładnie piszesz zdania!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Suma));
				}
				}
			}
			}
		}

	  protected void paintComponent(Graphics g) { 
	    if (image == null) {
	      image = createImage(getSize().width, getSize().height);
	      g2 = (Graphics2D) image.getGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing
	      clear();
	      GUI.textPane.setText("Zaczynamy :D  Wybierz kolor i pisz według wzoru!");
	    }
	    
	    g.drawImage(image, 0, 0, null); 
	   
	   
	  }
	  
	  public void clear() {
		counter =0;
		counter1 = 0;
		check = false;
	    g2.setPaint(Color.white);
	    g2.fillRect(0, 0, getSize().width, getSize().height);
	    lastcolor();
	    GUI.textPane.setText("Wybierz kolor i pisz według wzoru!");
	    
	    try {
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
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
	 
	  public void magenta() {
	    g2.setPaint(Color.magenta);
	  }
	 
	  public void green() {
	    g2.setPaint(Color.green);
	  }
	 
	  public void blue() {
	    g2.setPaint(Color.blue);
	  }
	  
	  public void back() {
		  if (check == false) {
		  counter =0;
		  counter1 = 0;
		 // check = false;
		  Images.i--;
		  
		  if(GUI.level ==1) {
			  if(Images.i == -1) {
			  Images.i = 31;
		  }
		  }else if(GUI.level ==2) {
			  if(Images.i == 31) {
			  Images.i = 41;
		  } 
		  }else if (GUI.level ==3) {
			  if(Images.i == 41) {
			  Images.i = 51;
		  }  
		  }
		  
		  try {
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	            repaint();
	            counter =0;
	 
	        } catch (IOException e) {
	            System.out.println("Nie wczytano zdjęcia");
	        }
		  g2.drawImage(Images.loadImage(Images.image[Images.i]), 0, 0, null);
		  repaint();
		  GUI.textPane.setText("Wybierz kolor i pisz według wzoru!");
		  }
	  }
	  public void next() {
		  if(check == false) {
		  counter =0;
			counter1 = 0;
			//check = false;
		  Images.i++;
		  
		  if(GUI.level ==1) {
			  if(Images.i == 32) {
			  Images.i = 0;
		  }
		  }else if(GUI.level ==2) {
			  if(Images.i == 42) {
			  Images.i = 32;
		  } 
		  }else if (GUI.level ==3) {
			  if(Images.i == 52) {
			  Images.i = 42;
		  }  
		  }
		  
		  try {
	            img = ImageIO.read(new File(Images.image[Images.i]));
	            w = 1024;
	            h = 768;
	            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	            Graphics g = bi.getGraphics();
	            g.drawImage(img, 0, 0, null);
	            repaint();
	            counter =0;
	 
	        } catch (IOException e) {
	            System.out.println("Nie wczytano zdjęcia");
	        }
		  g2.drawImage(Images.loadImage(Images.image[Images.i]), 0, 0, null);
		  repaint();
		  GUI.textPane.setText("Wybierz kolor i pisz według wzoru!");
		  }
	  }
	  public void lastcolor(){
		  if(GUI.color == 1) {
			  red();
		  }
		  else if (GUI.color == 2) {
			  blue();
		  }
		  else if (GUI.color == 3) {
			  green();
		  }
		  else if (GUI.color == 4) {
			  magenta();
		  }
	  }
	}