/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementarz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Tomek
 */
public class Elementarz {
    
    JButton  wyczysc, niebieski, zolty, rozowy, pomaranczowy, czerwony, zielony, czarny, szary, cyjan;
    Rysowanie rysowanie;
    ActionListener actionlistener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == wyczysc){
            rysowanie.clear();
            } else if (e.getSource() == niebieski){
            rysowanie.blue();
            } else if (e.getSource() == zolty){
            rysowanie.yellow();
            } else if (e.getSource() == rozowy){
            rysowanie.pink();
            } else if (e.getSource() == pomaranczowy){
            rysowanie.orange();
            } else if (e.getSource() == czerwony){
            rysowanie.red();
            } else if (e.getSource() == zielony){
            rysowanie.green();
            } else if (e.getSource() == czarny){
            rysowanie.black();
            } else if(e.getSource() == szary){
            rysowanie.gray();
            } else if (e.getSource() == cyjan){
            rysowanie.cyan();
            }
        }
    };
    public void interfejs(){
        JFrame okno = new JFrame("Elementarz");
        Container menu = okno.getContentPane();
        menu.setLayout(new BorderLayout());
        final Rysowanie canvas = new Rysowanie();
        menu.add(canvas, BorderLayout.CENTER);
        JPanel przyciski = new JPanel();
        wyczysc = new JButton("Wyczyść");
        wyczysc.addActionListener(actionlistener);
        niebieski = new JButton("Niebieski");
        niebieski.addActionListener(actionlistener);
        zolty = new JButton("Żółty");
        zolty.addActionListener(actionlistener);
        rozowy = new JButton("Różowy");
        rozowy.addActionListener(actionlistener);
        pomaranczowy = new JButton("Pomarańczowy");
        pomaranczowy.addActionListener(actionlistener);
        czerwony = new JButton("Czerwony");
        czerwony.addActionListener(actionlistener);
        zielony = new JButton("Zielony");
        zielony.addActionListener(actionlistener);
        czarny = new JButton("Czarny");
        czarny.addActionListener(actionlistener);
        szary = new JButton("Szary");
        szary.addActionListener(actionlistener);
        cyjan = new JButton("Cyjan");
        cyjan.addActionListener(actionlistener);
        
        przyciski.add(wyczysc);
        przyciski.add(niebieski);
        przyciski.add(zolty);
        przyciski.add(rozowy);
        przyciski.add(pomaranczowy);
        przyciski.add(czerwony);
        przyciski.add(zielony);
        przyciski.add(czarny);
        przyciski.add(szary);
        przyciski.add(cyjan);
        
        
        menu.add(przyciski, BorderLayout.NORTH);
        okno.setSize(800,800);
        okno.setVisible(true);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Elementarz().interfejs();
        
    }
    
    
}
