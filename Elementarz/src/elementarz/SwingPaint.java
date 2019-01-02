/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Tomek
 */
public class SwingPaint {
	 
	  JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn, plus, minus, zmien;
	  DrawArea drawArea;
	  Images images;
	  public static final JTextPane textPane = new JTextPane();
	  public static final JTextPane textPane2 = new JTextPane();
	  
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
		Images.loadInitialImages();
	    // utworz ramke
	    JFrame frame = new JFrame("Elementarz");
	    Container content = frame.getContentPane();
	    Container content2 = frame.getContentPane();
	    // ustaw layout
	    content.setLayout(new BorderLayout());
	    content2.setLayout(new BorderLayout());
	    // utworz panel do rysowania
	    drawArea = new DrawArea();
	    // dodanie do panelu 
	    content.add(drawArea, BorderLayout.CENTER);
	    content2.add(drawArea, BorderLayout.CENTER);
	    // przyciski
	    JPanel controls = new JPanel();
	    JPanel info = new JPanel();
	    clearBtn = new JButton ("Wyczyść");
	    blackBtn = new JButton("Czarny");
	    blueBtn = new JButton("Niebieski");
	    greenBtn = new JButton("Zielony");
	    redBtn = new JButton("Czerwony");
	    magentaBtn = new JButton("Magenta");
	    plus = new JButton("Plus");
	    minus = new JButton("Minus");
	    zmien = new JButton ("Zmień");
	    
	    clearBtn.addActionListener(actionListener);
	    blackBtn.addActionListener(actionListener);
	    blueBtn.addActionListener(actionListener);
	    greenBtn.addActionListener(actionListener);
	    redBtn.addActionListener(actionListener);
	    magentaBtn.addActionListener(actionListener);
	    plus.addActionListener(actionListener);
	    minus.addActionListener(actionListener);
	    zmien.addActionListener(actionListener);
	   // blackBtn.setBounds(0);
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
	    //controls.setLayout(null);
	   // controls.setVisible(true);
	    textPane.setBackground(null);
	    textPane2.setBackground(null);
	    Font nFont = new Font("SansSerif", Font.BOLD, 20);
	    textPane.setFont(nFont);
	    textPane2.setFont(nFont);
	    info.add(textPane2);
	    info.add(textPane);
	   // info.add(textPane);
	    content.add(controls, BorderLayout.PAGE_START);
	    content2.add(info, BorderLayout.PAGE_END);
	    frame.setSize(1024, 768);//rozmiar okna
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykanie okna
	    frame.setLocationRelativeTo(null);//wysrodkowanie okna
	    frame.setVisible(true);//widocznosc okna
	   // frame.setResizable(false);
	  }
	 
	}