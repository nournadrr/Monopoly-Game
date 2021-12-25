/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class board extends JFrame {
    ImageIcon  imageicon[];
    JLabel label[];
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
        




        JPanel south=new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.LEFT));
        south.setBounds(30, 30, 340, 340);
        south.setBackground(Color.black);
        //ImageIcon i=new ImageIcon(getClass().getResource(new File("‪C:/Users//ab_ay/OneDrive/Desktop/sources/0.PNG")));
        imageicon=new ImageIcon[11];
        for(int i=0;i<imageicon.length;i++)
        {
            String s="src//images//"+i+".PNG";
            imageicon[i]=new ImageIcon(s);
            Image image=imageicon[i].getImage();
            Image newimg=image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
            imageicon[i]=new ImageIcon(newimg);
        }
        label=new JLabel[11];
        for(int j=imageicon.length-1;j>=0;j--) {
            label[j]=new JLabel();
            //i[j].s
            label[j].setIcon(imageicon[j]);
            south.add(label[j]);
        }
        add(south,BorderLayout.SOUTH);
//        south.setVisible(true);
        setVisible(true);
        
        
        
    }
    
}
