/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
    private JButton newgame,loadgame,statistics;

    
    //newgame n=new newgame();
    //loadgame load=new loadgame();
    
    public graphics()
    {
        
        setSize(900,900);
        setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image image,newimg;
        ImageIcon imageicon=new ImageIcon("src\\images\\theme.jpeg");
        image=imageicon.getImage();
        newimg=image.getScaledInstance(900, 900, java.awt.Image.SCALE_SMOOTH);
        imageicon=new ImageIcon(newimg);
        JLabel label=new JLabel(imageicon);
        setContentPane(label);
        
        
        JPanel title=new JPanel(new FlowLayout());
        
        JLabel name=new JLabel("MONOPOLY");
        name.setFont(new Font("Lucida Calligraphy", Font.BOLD+Font.ITALIC, 100));
        title.add(name);
        title.setLocation(30,220);
        title.setSize(820,390);
//        title.setBackground(null):
        title.setOpaque(false);
        add(title,BorderLayout.NORTH);
        


        JPanel p=new JPanel();
        p.setLayout(new GridLayout(0,1));
        newgame=new JButton("new game");
        p.add(newgame,BorderLayout.NORTH);
        loadgame=new JButton("load game");
        p.add(loadgame,BorderLayout.CENTER);
        statistics=new JButton("statistics");
        p.add(statistics,BorderLayout.SOUTH);
        p.setSize(240, 260);
        p.setLocation(320,900/2+1);
        p.setBackground(Color.BLACK);
        p.setOpaque(true);
//        name.setLocation(p.getX()+200,p.getY()-100);
//        label.add(p);
        add(p,BorderLayout.CENTER);
        
        
        
        
        newgame.addActionListener(this);
        loadgame.addActionListener(this);
        statistics.addActionListener(this);

//        add(label);
        pack();
        setVisible(true);
    }
    
//    public void paint(Graphics g)
//    {
//        super.paint(g);
//        
//    }
    

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
        if(ae.getSource()==statistics)
        {
            setVisible(false);
            int[] dice={50,62,23,37,111,67};
            chart c=new chart(dice);
        }
    }
}