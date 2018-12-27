/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.IOException;
import javax.imageio.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Tomek
 */
public class DrawArea extends JComponent {
	 
	
	  private Image image;
	  private BufferedImage bi;
	  private BufferedImage img = null;

	  private Graphics2D g2;
	  public int X, Y, oldX, oldY;
	  public int fontsize=18;//domyslna grubosc linii
	 
	  public DrawArea() {
		 
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
	          g2.drawLine(oldX, oldY, X, Y);//rysowanie linii
	          g2.setStroke(new BasicStroke(fontsize));//grubosc linii
	          repaint();
	          oldX = X;
	          oldY = Y;
	        }
	      }
	    });
	  }
	    
		  
		  

	  protected void paintComponent(Graphics g) { 
	    if (image == null) {
	      image = createImage(getSize().width, getSize().height);
	      g2 = (Graphics2D) image.getGraphics();
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antialiasing
	      clear();
	      start();
	    }
	    
	    g.drawImage(image, 0, 0, null); 
	   
	   
	  }
	  public void start() {
		  g2.drawImage(Obraz.bgImage, 0, 0, null);
	  }
	  
	  public void clear() {
	    g2.setPaint(Color.white);
	    g2.fillRect(0, 0, getSize().width, getSize().height);
	    g2.setPaint(Color.black);
	    g2.drawImage(Obraz.bgImage, 0, 0, null);
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
		  g2.drawImage(Obraz.bgImage2, 0, 0, null);
		  repaint();
		  }
	}