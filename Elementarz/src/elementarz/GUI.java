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
 * Prosta gra interaktywna trenująca umiejętność pisania recznęgo
 * @author Tomek Bojarski
 */
public class GUI {
	  /**  Przycisk X   */
	  JButton clearBtn;
	  /**  Przycisk wstecz  */
	  JButton backBtn;
	  /**  Przycisk niebieskiego koloru  */
	  JButton blueBtn;
	  /**  Przycisk zielonego koloru  */
	  JButton greenBtn;
	  /**  Przycisk czerwonego koloru  */
	  JButton redBtn;
	  /**  Przycisk magenta koloru  */
	  JButton magentaBtn;
	  /**  Przycisk dalej  */
	  JButton nextBtn;
	  /**  Przycisk wyboru poziomu  */
	  JButton mode;
	  /**  Przypisanie statyczne klasy DrawArea  */
	  DrawArea drawArea;
	  /**  Obiekt typu JTextPane zawierający informacje o stanie rozgrywki  */
	  public static final JTextPane textPane = new JTextPane();
	  /**  Obiekt typu JTextPane zawierający informacje o liczbie punktów  */
	  public static final JTextPane textPane2 = new JTextPane();
	  /**  Zmienna color typu int zawierająca informację o wybranym kolorze  */
	  public static int color =1 ;
	  /**  Zmienna level typu int zawierająca informację o wybranym poziomie gry  */
	  public static int level = 1;
	  
	  /**
	     * Metoda uruchamia grę. Następuje wywołanie metody show() która załącza interfejs graficzny.
	     */
	  public static void main(String[] args) {
		    new GUI().show();//utworzenie okna
		  }
	  
	  
	  //ActionListener do przycisków
	  ActionListener actionListener = new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == clearBtn) {
	        drawArea.clear();
	      } else if (e.getSource() == backBtn) {
	        drawArea.back();
	      } else if (e.getSource() == blueBtn) {
	        drawArea.blue();
	        color =2;
	      } else if (e.getSource() == greenBtn) {
	        drawArea.green();
	        color =3;
	      } else if (e.getSource() == redBtn) {
	        drawArea.red();
	        color =1;
	      } else if (e.getSource() == magentaBtn) {
	        drawArea.magenta();
	        color =4;
	      }else if(e.getSource()== nextBtn) {
	    	  drawArea.next();
	      }else if(e.getSource()== mode) {
	    	  if(drawArea.check == false) {
	    	  if(level == 3) {
		        	mode.setIcon(Images.letters);
		        	level =1;
		        	Images.i=0;
		        	drawArea.fontsize = 8;
		        	drawArea.clear();
		        }else if (level ==1){
		        	Images.i = 32;
		        	drawArea.clear();
		        	mode.setIcon(Images.words);
		        	drawArea.fontsize = 7;
		        	level =2;
		        }else if (level ==2) {
		        	mode.setIcon(Images.sentences);
		        	level =3;
		        	Images.i = 42;
		        	drawArea.fontsize = 6;
		        	drawArea.clear();
		        }
	      }
	      }
	    }
	  };
	  
	  /**
	     * Metoda inicjalizująca interfejs graficzny oraz wywołująca domyślny konstruktor klasy DrawArea
	     */
	  public void show() {
		Images.loadInitialImages();
	    // utworz ramke
	    JFrame frame = new JFrame("Elementarz");
	    Container content = frame.getContentPane();
	    Container content2 = frame.getContentPane();
	    // ustaw layout
	    content.setLayout(new BorderLayout());
	    content2.setLayout(new BorderLayout());
	    // utworz panel do rysowania (wywołanie domyślnego konstruktora klasy DrawArea)
	    drawArea = new DrawArea();
	    
	    // dodanie do panelu 
	    content.add(drawArea, BorderLayout.CENTER);
	    content2.add(drawArea, BorderLayout.CENTER);
	    JPanel controls = new JPanel();
	    JPanel info = new JPanel();
	    
	    //przyciski
	    clearBtn = new JButton ();
	    clearBtn.setIcon(Images.clear);
	    clearBtn.setBorderPainted(false);
	    clearBtn.setContentAreaFilled(false);
	    backBtn = new JButton();
	    backBtn.setIcon(Images.back);
	    backBtn.setBorderPainted(false);
	    backBtn.setContentAreaFilled(false);
	    blueBtn = new JButton();
	    blueBtn.setIcon(Images.blue);
	    blueBtn.setBorderPainted(false);
	    blueBtn.setContentAreaFilled(false);
	    greenBtn = new JButton();
	    greenBtn.setIcon(Images.green);
	    greenBtn.setBorderPainted(false);
	    greenBtn.setContentAreaFilled(false);
	    redBtn = new JButton();
	    redBtn.setIcon(Images.red);
	    redBtn.setBorderPainted(false);
	    redBtn.setContentAreaFilled(false);
	    magentaBtn = new JButton();
	    magentaBtn.setIcon(Images.magenta);
	    magentaBtn.setBorderPainted(false);
	    magentaBtn.setContentAreaFilled(false);
	    nextBtn = new JButton();
	    nextBtn.setIcon(Images.next);
	    nextBtn.setBorderPainted(false);
	    nextBtn.setContentAreaFilled(false);
	    mode = new JButton();
	    mode.setIcon(Images.letters);
	    mode.setBorderPainted(false);
	    mode.setContentAreaFilled(false);
	    
	    clearBtn.addActionListener(actionListener);
	    backBtn.addActionListener(actionListener);
	    blueBtn.addActionListener(actionListener);
	    greenBtn.addActionListener(actionListener);
	    redBtn.addActionListener(actionListener);
	    magentaBtn.addActionListener(actionListener);
	    nextBtn.addActionListener(actionListener);
	    mode.addActionListener(actionListener);
	    
	    // dodanie przyciskow do panelu
	    controls.add(redBtn);
	    controls.add(blueBtn);
	    controls.add(greenBtn);
	    controls.add(magentaBtn);
	    controls.add(backBtn);
	    controls.add(clearBtn);
	    controls.add(nextBtn);
	    controls.add(mode);
	    controls.setBackground(Color.LIGHT_GRAY);
	    info.setBackground(Color.LIGHT_GRAY);
	    textPane.setBackground(null);
	    textPane2.setBackground(null);
	    Font nFont = new Font("SansSerif", Font.BOLD, 20);
	    textPane.setFont(nFont);
	    textPane2.setFont(nFont);
	    textPane2.setText("Punkty : " + Integer.toString(drawArea.point));
	    info.add(textPane2);
	    info.add(textPane);
	    content.add(controls, BorderLayout.PAGE_START);
	    content.setBackground(Color.WHITE);
	    content2.add(info, BorderLayout.PAGE_END);
	    frame.setSize(1024, 768);//rozmiar okna
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykanie okna
	    //frame.setLocationRelativeTo(null);//wyśrodkowanie okna
	    frame.setVisible(true);//widoczność okna
	    frame.setResizable(false);//zablokowanie rozmiarów okna
	  }
	}