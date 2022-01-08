/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ab_ay
 */
public class rightpanel extends JPanel {
    JLabel[] name;
    JLabel[] balance;
    JLabel[] colour;
    public rightpanel(Player[] p) {
        create(p);
    }
    public JPanel create(Player[] p) {
        setLayout(new GridLayout(2,4,0,0));
        name=new JLabel[4];
        balance=new JLabel[4];
        colour=new JLabel[4];
        for(int i=0;i<4;i++)
        {
            name[i]=new JLabel(p[i].getName(),SwingConstants.CENTER);
            balance[i]=new JLabel(Integer.toString(p[i].getBalance()),SwingConstants.CENTER);
            name[i].setFont(new Font("Serif", Font.BOLD, 18));
            balance[i].setFont(new Font("Serif", Font.BOLD, 18));
            add(name[i]);
        }
        
        for(int i=0;i<4;i++)
            add(balance[i]);
        
        Color redColor = new Color(255,204,203);
        name[0].setBackground(redColor);
        name[0].setOpaque(true);
        balance[0].setBackground(redColor);
        balance[0].setOpaque(true);
        name[1].setBackground(Color.CYAN);
        name[1].setOpaque(true);
        balance[1].setBackground(Color.cyan);
        balance[1].setOpaque(true);
        
        Color lightyellow = new Color(255,255,153);
        name[2].setBackground(lightyellow);
        name[2].setOpaque(true);
        balance[2].setBackground(lightyellow);
        balance[2].setOpaque(true);
        
        Color lightgreen = new Color(144,238,144);
        name[3].setBackground(lightgreen);
        name[3].setOpaque(true);
        balance[3].setBackground(lightgreen);
        balance[3].setOpaque(true);
//        colour[0].setBackground(Color.yellow);
//        colour[0].setOpaque(true);
        
        //p[0].colour="red";
        
        //name
        //balance
        //colour
        
        //JLabel Name=new JLabel("Name: ");
        //JLabel getname=new JLabel("abdo");
        
        //JLabel balance=new JLabel("Balance: ");
        //JLabel getbalance=new JLabel("1500");
        
        
         //colour=new JLabel();
         
         
         //Name.setPreferredSize(new Dimension(100, 1000));
         //Name.setForeground(Color.red);
         //Name.setBackground(Color.yellow);
         //Name.setOpaque(true);
//         getname.setPreferredSize(new Dimension(100, 30));
//         balance.setPreferredSize(new Dimension(100, 30));
//         getbalance.setPreferredSize(new Dimension(100, 30));
//         colour.setPreferredSize(new Dimension(100, 30));
//         //add(Name);
//         add(getname);
//         add(balance);
//         add(getbalance);
//         add(colour);
         return this;
    }
    
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.red);
//        g.fillOval(colour[0].getX(), colour[0].getY()+80, 30, 40);
//        
//        g.setColor(Color.green);
//        g.fillOval(colour[1].getX(), colour[1].getY()+80, 30, 40);
//        
//        g.setColor(Color.blue);
//        g.fillOval(colour[2].getX(), colour[2].getY()+80, 30, 40);
//        
//        g.setColor(Color.yellow);
//        g.fillOval(colour[3].getX(), colour[3].getY()+80, 30, 40);
    }
    
}
