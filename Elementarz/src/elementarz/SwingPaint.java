/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarz;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import java.io.IOException;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
/**
 *
 * @author Tomek
 */
public class SwingPaint {
	 
	  JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn, plus, minus, zmien;
	  DrawArea drawArea;
	  Obraz obraz;
	  ColorDetection colordetection;
	  private static final JTextPane textPane = new JTextPane();
//	  public static Image iconimage = Toolkit.getDefaultToolkit().getImage("/images/+.png");
	  
	  public static void main(String[] args) {
		    new SwingPaint().show();//utworzenie okna
		  }
	  //ActionListener do przyciskow
	  ActionListener actionListener = new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == clearBtn) {
	        drawArea.clear();
	      } else if (e.getSource() == blackBtn) {
	        drawArea.black();
	      } else if (e.getSource() == blueBtn) {
	        drawArea.blue();
	      } else if (e.getSource() == greenBtn) {
	        drawArea.green();
	      } else if (e.getSource() == redBtn) {
	        drawArea.red();
	      } else if (e.getSource() == magentaBtn) {
	        drawArea.magenta();
	      }else if(e.getSource()== plus) {
	    	if(drawArea.fontsize>=1 & drawArea.fontsize<10) {
	    	  drawArea.fontsize++;}
	    	else {
	    		  System.out.println("STOP");//zablokowanie przekroczenia wielkosci fontu
	    	  }
	      }else if(e.getSource()== minus) {
	    	 if (drawArea.fontsize>1 & drawArea.fontsize<=10) {
		    	  drawArea.fontsize--;}
	    	 else {
		    		  System.out.println("STOP");//zablokowanie przekoczenia wielkosci fontu
		    	  }
	      }else if(e.getSource()== zmien) {
	    	  drawArea.zmien();
	      }
	    }
	  };
	 
	
	  public void show() {
		  Obraz.loadInitialImages();
	    // utworz ramke
	    JFrame frame = new JFrame("Elementarz");
	    Container content = frame.getContentPane();
	    Container content2 = frame.getContentPane();
	    // ustaw layout
	    content.setLayout(new BorderLayout());
	    content2.setLayout(new BorderLayout());
	    // utworz panel do rysowania
	    drawArea = new DrawArea();
	    colordetection.init();
	    // dodanie do panelu 
	    content.add(drawArea, BorderLayout.CENTER);
	    content2.add(drawArea, BorderLayout.CENTER);
	    // przyciski
	    JPanel controls = new JPanel();
	    JPanel info = new JPanel();
	    clearBtn = new JButton ("Wyczyść");
	    clearBtn.addActionListener(actionListener);
	  //  clearBtn.setIcon(obraz.icon1);
	    //clearBtn.ImageIcon(getClass().getResource("/images/button_wyczysc.png"));
	//    clearBtn.setForeground(obraz.icon1);
	    blackBtn = new JButton("Czarny");
	    blackBtn.addActionListener(actionListener);
	    blueBtn = new JButton("Niebieski");
	    blueBtn.addActionListener(actionListener);
	    greenBtn = new JButton("Zielony");
	    greenBtn.addActionListener(actionListener);
	    redBtn = new JButton("Czerwony");
	    redBtn.addActionListener(actionListener);
	  //  redBtn.setIcon(redimage);
	    magentaBtn = new JButton("Magenta");
	    magentaBtn.addActionListener(actionListener);
	    plus = new JButton("plus");
	    plus.addActionListener(actionListener);
	    minus = new JButton("minus");
	    minus.addActionListener(actionListener);
	    zmien = new JButton ("zmien");
	    zmien.addActionListener(actionListener);
	    // dodanie przyciskow do kontenera
	    controls.add(blackBtn);
	    controls.add(redBtn);
	    controls.add(blueBtn);
	    controls.add(greenBtn);
	    controls.add(magentaBtn);
	    controls.add(clearBtn);
	    controls.add(plus);
	    controls.add(minus);
	    controls.add(zmien);
	    textPane.setBackground(null);
	    Font nFont = new Font("SansSerif", Font.BOLD, 20);
	    textPane.setFont(nFont);
	    textPane.setText("Punkty : ");
	    info.add(textPane);
	    info.add(colordetection.textPane);
	    info.add(colordetection.textPane2);
	    // dodanie kontenera do panelu
	    content.add(controls, BorderLayout.PAGE_START);
	    content2.add(info, BorderLayout.PAGE_END);
	    frame.setSize(1024, 768);//rozmiar okna
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykanie okna
	    frame.setVisible(true);//widocznosc okna
	    
	  }
	 
	}