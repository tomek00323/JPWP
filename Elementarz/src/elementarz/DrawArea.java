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
 * Klasa DrawArea zawierająca implementację panelu graficznego, algorytm przetwarzania
 * grafiki rastowej oraz kontrolująca przebieg gry.
 * @author Tomek Bojarski
 */
public class DrawArea extends JComponent {
	  /**  Obiekt typu Image przechowujący grafikę rastową  */
	  private Image image;
	  /**  Obiekt typu BufferedImage przechowujący grafikę rastową  */
	  private BufferedImage bi;
	  /**  Pomocniczy obiekt typu BufferedImage przechowujący grafikę rastową  */
	  private static BufferedImage img = null;
	  /**  Obiekt Graphics2D inicjalizujący metody graficzne  */
	  private Graphics2D g2;
	  /**  Zmienna typu int przechowująca wartość współdzędnej panelu graficznego  */
	  public int X;
	  /**  Zmienna typu int przechowująca wartość współdzędnej panelu graficznego  */
	  public int Y;
	  /**  Zmienna typu int przechowująca wartość współdzędnej panelu graficznego  */
	  public int oldX;
	  /**  Zmienna typu int przechowująca wartość współdzędnej panelu graficznego  */
	  public int oldY;
	  /**  Zmienna typu int przechowująca wartość długości grafiki rastowej */
	  private int w;
	  /**  Zmienna typu int przechowująca wartość szerokości grafiki rastowej */
	  private int h;
	  /**  Zmienna typu int przechowująca wartość grubości krzywej */
	  public int fontsize=8;
	  /**  Pomocniczy obiekt typu BufferedImage przechowujący grafikę rastową  */
	  static BufferedImage imgR = null;
	  /**  Tablica typu int zawierająca wartości RGB grafiki rastowej  */
	  private static int rgbPixel[] = new int [3];
	  /**  Zmienna typu int przechowująca wartość zakreślonych białych pikseli */
	  public static int counter = 0;
	  /**  Zmienna typu int przechowująca wartość zakreślonych czarnych pikseli */
	  public static int counter1 = 0;
	  /**  Zmienna typu int przechowująca wartość zdobytych punktów */
	  public static int point = 0;
	  /**  Pomocnicza zmienna typu int przechowująca wartość zdobytych punktów */
	  public static int points =0;
	  /**  Zmienna typu boolean przechowująca wartość logiczną stanu gry */
	  public static boolean check = false;
	  /**  Zmienna typu int przechowująca wartość wszystkich zdobytych punktów */
	  public static int Sum = 0;
	  
	  /**
	     * Metoda rysuje grafikę rastową na panelu oraz implementuje algorytm detekcji próbek RGB oraz analizuje stan aktualnej
	     * gry. Ponadto metoda posiada przypisaną metodę MouseListener
	     */
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
	          rgbImage(X,Y);//wywołanie metody pobierającej wartości RGB grafiki
	          g2.drawLine(oldX, oldY, X, Y);//rysowanie linii
	          g2.setStroke(new BasicStroke(fontsize));//grubosc linii
	          repaint();
	          oldX = X;
	          oldY = Y;
	        }
	      }
	    });
	  }
	    
	  /**
	     * Metoda rgbImage wykrywająca wartości RGB grafiki rastowej oraz kontrolująca przebieg gry.
	     */  
	  public static void rgbImage(int x, int y)
		{
			int rgb = img.getRGB(x,y);//pobranie wartości RGB piksela
			rgbPixel[0]=   (rgb >> 16) & 0xFF;
			rgbPixel[1] = (rgb >>  8) & 0xFF;
			rgbPixel[2] =  (rgb) & 0xFF;


			
			if(rgbPixel[0] == 255 && rgbPixel[1] == 255 && rgbPixel[2] == 255) {//polorowanie białych pikseli
				counter++;//zmienna zliczająca ilość pokolorowanych białych pikseli
				
				if(GUI.level ==3) {//zdania
					if(counter == 370) {
						check = true;
						Sum = Sum -points;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
					}
				}else if (GUI.level ==1) {//litery
					if(counter == 100) {
						check = true;
						Sum = Sum -points;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
					}	
				}else if (GUI.level ==2) {//wyrazy
					if(counter == 200) {
						check = true;
						Sum = Sum -points;
						GUI.textPane.setText("Naciśnij przycisk 'X' i spróbuj jeszcze raz");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
					}	
				}
			}
			
				
			
			if(rgbPixel[0] == 0 && rgbPixel[1] == 0 && rgbPixel[2] == 0) {//pokorowanie czarnych pikseli
				
				if(check == false) {
					counter1++;
					
				if(counter1 == 20) {
					
					point = 1*GUI.level;
					points = points +point;
					Sum = Sum + point;
					GUI.textPane.setText("Dobrze");
					GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
					}
				if(counter1 == 300) {
				
				point = 1*GUI.level;
				Sum = Sum + point;
				points = points +point;
				GUI.textPane.setText("Tak trzymaj :D");
				GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
				}
				if(counter1 == 900) {
					point = 1*GUI.level;
					Sum = Sum + point;
					points = points +point;
					GUI.textPane.setText("Rewelacyjnie!");
					GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
					
					}
				if(GUI.level ==1) {
					if(counter1 == 950) {
						point = 1*GUI.level;
						Sum = Sum + point;
						points = points +point;
						GUI.textPane.setText("Brawo! Ladnie piszesz litery!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
				}
				}
				if(GUI.level ==2) {
					if(counter1 == 1200) {
						point = 1*GUI.level;
						Sum = Sum + point;
						points = points +point;
						GUI.textPane.setText("Brawo! Ladnie piszesz wyrazy!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
				}
				}
				if(GUI.level ==3) {
					if(counter1 == 1800) {
						point = 1*GUI.level;
						Sum = Sum + point;
						points = points +point;
						GUI.textPane.setText("Brawo! Ladnie piszesz zdania!");
						GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
				}
				}
			}
			}
		}
	  
	  /**
	     * Metoda paintComponent rysująca grafikę rastową na panelu graficznym
	     */ 
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
	  
	  /**
	     * Metoda czyszcząca panel graficzny oraz inicjalizująca powowne rysowanie grafiki rastowej
	     */ 
	  public void clear() {
		  if (check == false) {
			  Sum = Sum -points;
			  GUI.textPane2.setText("Punkty : " + Integer.toString(Sum));
		  }
		counter =0;
		counter1 = 0;
		check = false;
		points =0;
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
	  
	  /**
	     * Metoda red ustawiająca kolor krzywej jako czerwony
	     */ 
	  public void red() {
	    g2.setPaint(Color.red);
	  }
	  
	  /**
	     * Metoda magenta ustawiająca kolor krzywej jako magenta
	     */ 
	  public void magenta() {
	    g2.setPaint(Color.magenta);
	  }
	  
	  /**
	     * Metoda green ustawiająca kolor krzywej jako zielony
	     */ 
	  public void green() {
	    g2.setPaint(Color.green);
	  }
	  
	  /**
	     * Metoda blue ustawiająca kolor krzywej jako niebieski
	     */ 
	  public void blue() {
	    g2.setPaint(Color.blue);
	  }
	  
	  /**
	     * Metoda back zmieniająca grafikę rastową na panelu graficznym
	     */ 
	  public void back() {
		  if (check == false) {
		  counter =0;
		  counter1 = 0; 
		  points = 0;
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
	  
	  /**
	     * Metoda next zmieniająca grafikę rastową na panelu graficznym
	     */ 
	  public void next() {
		  if(check == false) {
		  counter =0;
		  counter1 = 0;
		  points = 0;
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
	  
	  /**
	     * Metoda lastcolor zapamiętująca ostatnio wybrany kolor krzywej
	     */ 
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