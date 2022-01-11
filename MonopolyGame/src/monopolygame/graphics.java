/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
/**
 *
 * @author Dell
 */
public class graphics extends JFrame implements ActionListener {
    private JButton newgame,loadgame;
    //newgame n=new newgame();
    //loadgame load=new loadgame();
    
    public graphics()
    {
        setVisible(true);
//        //ImageIO.read(new File("I:\\oop\\img"));
        setSize(900,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        
//
//        JPanel p1=new JPanel();
//        JLabel label1=new JLabel();
//        ImageIcon image=new ImageIcon("I:\\oop\\IMG_7689.PNG");
//        Image img = image.getImage();
//        Image img2 = img.getScaledInstance(900, 900, java.awt.Image.SCALE_SMOOTH);
//        image=new ImageIcon(img2);
//        label1.setIcon(image);
//        p1.add(label1);
//        add(p1,BorderLayout.NORTH);
        


    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
//        Font myFont = new Font ("Courier New", 1, 17);
//        g.setFont (myFont);
//        g.drawString ("Hello World", 10, 10);
//        g.setColor(Color.black);
//        g.fillRect(0, 0, 700, 700);
        
        //g.drawImage(img, 0, 0, null);
        //setLayout(new BorderLayout());
        //JLabel label=new JLabel(image);
        //add(label,BorderLayout.CENTER);
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        newgame=new JButton("new game");
        p.add(newgame,BorderLayout.WEST);
        loadgame=new JButton("load game");
        p.add(loadgame,BorderLayout.EAST);
        add(p,BorderLayout.SOUTH);
        newgame.addActionListener(this);
        loadgame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        Object button=ae.getSource();
//        if(button.equals(newgame))
        if(ae.getSource()==newgame)
        {
            setVisible(false);
            MonopolyGame.n.setVisible(true);
        }
        if(ae.getSource()==loadgame)
        {
            setVisible(false);
            MonopolyGame.l.setVisible(true);
        }
    }
}