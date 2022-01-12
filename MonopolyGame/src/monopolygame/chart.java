/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolygame;

import java.awt.*;
import static java.awt.Color.*;
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.Spring.height;

/**
 *
 * @author youss
 */
public class chart extends JFrame {

   
    public int dicenum[];
    public String names[]={"one","two","three","four","five","six"};
    //JFrame frame = new JFrame("stat");
    // setSize(400,400);
    //frame.setLocationRelativeTo(null);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);

    public chart( int dicenum[]) {
        super("Statistics");
        //JPanel p = new JPanel();

        /* Set the background of the JPanel to the specified Color. */
//        setBackground(new Color(186, 140, 99));
        
        //add(p);
        setSize(500, 500);
       
        this.dicenum = dicenum;
//        setOpaque(false);
//        setBorder(BorderFactory.createEmptyBorder());
//        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        setResizable(true);
//        setBackground(black);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.black);
        g.drawLine(30, 0, 30, 480);//line el 3lshemal
        g.drawLine(30, 480, 480, 480);//line el t7t
        g.drawString("10-", 15, 470);
        int x = 50;
        //int size = 3;

//        g.drawRect(50,350,20,50);
       
        int xleft = 15;
        int yleft = 480;
        int numleft = 0;
        
        g.drawString("10-", 15, 470);
        g.drawString("20-", 15, 460);
        g.drawString("30-", 15, 450);
        g.drawString("40-", 15, 440);
        g.drawString("50-", 15, 430);
        g.drawString("60-", 15, 420);
        g.drawString("70-", 15, 410);
        g.drawString("80-", 15, 400);
        g.drawString("90-", 15, 390);
        g.drawString("100-", 10, 380);
        g.drawString("110-", 10, 370);
        g.drawString("120-", 10, 360);
//        for(int j=0;j<15;j++)
//        {
//          
//             g.drawString(String.valueOf(numleft+10), 15,yleft-10 );
//             System.out.println("1");
//         
//        }
        Color rainbow[]=new Color[]{blue,yellow,red,cyan,green,magenta};
        for (int i = 0; i < 6; i++) {

            int h = this.dicenum[i];
//            g.setColor(rainbow[i]);
            g.setColor(rainbow[i]);
            g.fillRect(x, 480, 20, -h);
            g.drawString(names[i], x - 5, h - h * 3 + 470);

            x += 50;
           
            
            try {
              sleep(400);
                
//            long now=System.currentTimeMillis();
//            while(now<80000)
//            {
//                now=System.currentTimeMillis();
//            }
            
//            try {
//                Thread.sleep(100);
////            try {
////                sleep(300);
////
////            } catch (InterruptedException ex) {
////                Logger.getLogger(barchart.class.getName()).log(Level.SEVERE, null, ex);
////            }
//            } catch (InterruptedException ex) {
//                Logger.getLogger(barchart.class.getName()).log(Level.SEVERE, null, ex);
//            }
            } catch (InterruptedException ex) {
                Logger.getLogger(chart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        repaint();
    }

}

/*public static void main(){
    
}*/