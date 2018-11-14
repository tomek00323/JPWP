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

/**
 *
 * @author Tomek
 */
public class Rysowanie extends JPanel {
    private Graphics2D g2;
    private Image image;
    private int x,y,old_x,old_y;
    
    
    
    
    public Rysowanie(){
        //setDoubleBuffered(false);
        addMouseListener(new MouseAdapter(){
        
            public void mousePressed(MouseEvent e){
                old_x = e.getX();
                old_y = e.getY();
            }
        
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
        
        public void mouseDragged(MouseEvent e){
            x = e.getX();
            y = e.getY();
        
        
            if (g2 != null){
                g2.drawLine(old_x, old_y, x, y);
                repaint();
                old_x = x;
                old_y = y;
            }
        
        };
        
        
        
        
    });
}
    
    protected void paintComponent(Graphics g){
        if(image == null){
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }
    
    public void clear(){
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    
    public void blue(){
        g2.setPaint(Color.blue);
    }
    
    public void yellow(){
        g2.setPaint(Color.yellow);
    }
    
    public void pink(){
        g2.setPaint(Color.pink);
    }
    
    public void orange(){
        g2.setPaint(Color.orange);
    }
    
    public void red(){
        g2.setPaint(Color.red);
    }
    
    public void green(){
        g2.setPaint(Color.green);
    }
    
    public void black(){
        g2.setPaint(Color.black);
    }
    
    public void gray(){
        g2.setPaint(Color.gray);
    }
    
    public void cyan(){
        g2.setPaint(Color.cyan);
    }
    
    
}