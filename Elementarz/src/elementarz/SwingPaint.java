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
	 
	  JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn, plus, minus;
	  DrawArea drawArea;
	    
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
	    		  System.out.println("STOP");
	    	  }
	      }else if(e.getSource()== minus) {
	    	 if (drawArea.fontsize>1 & drawArea.fontsize<=10) {
		    	  drawArea.fontsize--;}
	    	 else {
		    		  System.out.println("STOP");
		    	  }
	      }
	    }
	  };
	 
	  
	 
	  public void show() {
	    // utworz ramke
	    JFrame frame = new JFrame("Elementarz");
	    Container content = frame.getContentPane();
	    // ustaw layout
	    content.setLayout(new BorderLayout());
	    // utworz panel do rysowania
	    drawArea = new DrawArea();
	 
	    // dodanie do panelu 
	    content.add(drawArea, BorderLayout.CENTER);
	 
	    // przyciski
	    JPanel controls = new JPanel();
	 
	    clearBtn = new JButton("Wyczyść");
	    clearBtn.addActionListener(actionListener);
	    blackBtn = new JButton("Czarny");
	    blackBtn.addActionListener(actionListener);
	    blueBtn = new JButton("Niebieski");
	    blueBtn.addActionListener(actionListener);
	    greenBtn = new JButton("Zielony");
	    greenBtn.addActionListener(actionListener);
	    redBtn = new JButton("Czerwony");
	    redBtn.addActionListener(actionListener);
	    magentaBtn = new JButton("Magenta");
	    magentaBtn.addActionListener(actionListener);
	    plus = new JButton("plus");
	    plus.addActionListener(actionListener);
	    minus = new JButton("minus");
	    minus.addActionListener(actionListener);
	    // dodanie przyciskow do kontenera
	    controls.add(blackBtn);
	    controls.add(redBtn);
	    controls.add(blueBtn);
	    controls.add(greenBtn);
	    controls.add(magentaBtn);
	    controls.add(clearBtn);
	    controls.add(plus);
	    controls.add(minus);
	    // dodanie kontenera do panelu
	    content.add(controls, BorderLayout.PAGE_START);
	 
	    frame.setSize(1024, 768);//rozmiar okna
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykanie okna
	    frame.setVisible(true);//widocznosc okna
	  }
	 
	}
