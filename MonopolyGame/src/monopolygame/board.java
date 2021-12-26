/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class board extends JFrame {
    ImageIcon  imageicon[];
    JLabel label[];
    Image image;
    Image newimg;
    public board() throws IOException {
        setSize(1750,1000);
        setLayout(new BorderLayout());
        //add(new JButton("east"),BorderLayout.EAST);
        //add(new JButton("north"),BorderLayout.NORTH);
        //add(new JButton("south"),BorderLayout.SOUTH);
        //add(new JButton("west"),BorderLayout.WEST);
        //add(new JButton("extra"),BorderLayout.WEST);
//        add(new JButton("centre"),BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);

//        BufferedImage i=ImageIO.read(new File(string));
        
//        p.setLayout(new FlowLayout(FlowLayout.RIGHT));
        

//        south.setBounds(30, 30, 340, 340);



        JPanel south=new JPanel();
        JPanel west=new JPanel();
        JPanel north=new JPanel();
        JPanel east=new JPanel();
        JPanel centre=new JPanel();
        centre.setBackground(Color.BLACK);
        south.setLayout(new GridLayout(1,9,3,3));
        south.setBackground(Color.black);
        west.setLayout(new GridLayout(9,1,3,3));
        west.setBackground(Color.black);
        north.setLayout(new GridLayout(1,9,3,3));
        north.setBackground(Color.black);
        east.setLayout((new GridLayout(9,1,3,3)));
        east.setBackground(Color.black);
        imageicon=new ImageIcon[41];
        label=new JLabel[41];
        
        imageicon[40]=new ImageIcon("src//images//centre.PNG");
//        image=imageicon[40].getImage();
//        newimg=image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
//        imageicon[40]=new ImageIcon(newimg);
        label[40]=new JLabel();
        label[40].setIcon(imageicon[40]);
        centre.add(label[40]);
        
        
        
        
        
        for(int i=0;i<imageicon.length;i++)
        {
            String s="src//images//"+i+".PNG";
            imageicon[i]=new ImageIcon(s);
            image=imageicon[i].getImage();
            newimg=image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            imageicon[i]=new ImageIcon(newimg);
        }
        for(int j=11-1;j>=0;j--) {
            label[j]=new JLabel();
            label[j].setIcon(imageicon[j]);
            south.add(label[j]);
        }
        for(int j=19;j>=11;j--) {
            label[j]=new JLabel();
            label[j].setIcon(imageicon[j]);
            west.add(label[j]);
        }
        for(int j=20;j<=30;j++) {
            label[j]=new JLabel();
            label[j].setIcon(imageicon[j]);
            north.add(label[j]);
        }
        for(int j=31;j<=39;j++) {
            label[j]=new JLabel();
            label[j].setIcon(imageicon[j]);
            east.add(label[j]);
        }
        add(south,BorderLayout.SOUTH);
        add(west,BorderLayout.WEST);
        add(north,BorderLayout.NORTH);
        add(east,BorderLayout.EAST);
        add(centre,BorderLayout.CENTER);
        setVisible(true);
        
        
        
    }
    
}
