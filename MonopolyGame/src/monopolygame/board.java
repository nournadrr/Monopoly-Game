/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class board extends JFrame implements KeyListener {
    ImageIcon  imageicon[];
    JLabel label[];
    Image image;
    Image newimg;
    JButton Build,Sell,Morgage,Redeem;
    public board() throws IOException {
        addKeyListener(this);        
        setLayout(new BorderLayout());
        setSize(1100,1000);
        
//        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel south=new JPanel();
        JPanel west=new JPanel();
        JPanel north=new JPanel();
        JPanel east=new JPanel();
        JPanel centre=new JPanel();
        JPanel board=new JPanel(new BorderLayout());
        centre.setBackground(Color.BLACK);
        south.setLayout(new GridLayout(1,9,4,4));
        south.setBackground(Color.black);
        west.setLayout(new GridLayout(9,1,4,4));
        west.setBackground(Color.black);
        north.setLayout(new GridLayout(1,9,4,4));
        north.setBackground(Color.black);
        east.setLayout((new GridLayout(9,1,4,4)));
        east.setBackground(Color.black);
        imageicon=new ImageIcon[41];
        label=new JLabel[41];
        
        imageicon[40]=new ImageIcon("src//images//centre.PNG");
        image=imageicon[40].getImage();
        newimg=image.getScaledInstance(870, 735, java.awt.Image.SCALE_SMOOTH);
        imageicon[40]=new ImageIcon(newimg);
        label[40]=new JLabel();
        label[40].setIcon(imageicon[40]);
        centre.add(label[40]);
        
        
        for(int i=0;i<imageicon.length;i++)
        {
            String s="src//images//"+i+".PNG";
            imageicon[i]=new ImageIcon(s);
            image=imageicon[i].getImage();
            newimg=image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
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
//        add(south,BorderLayout.SOUTH);
//        add(west,BorderLayout.WEST);
//        add(north,BorderLayout.NORTH);
//        add(east,BorderLayout.EAST);
//        add(centre,BorderLayout.CENTER);
        board.add(south,BorderLayout.SOUTH);
        board.add(west,BorderLayout.WEST);
        board.add(north,BorderLayout.NORTH);
        board.add(east,BorderLayout.EAST);
        board.add(centre,BorderLayout.CENTER);
        add(board,BorderLayout.CENTER);  // adding shakl el board 
        
        
        
        JPanel down=new JPanel(new GridLayout(1,4,20,5));//up,left,down,right
        down.setBorder( BorderFactory.createEmptyBorder(   20,49,20,220) );
        Build =new JButton("Build");
        Sell=new JButton("Sell");
        Morgage =new JButton("Morgage");
        Redeem=new JButton("Redeem");
        Build.setPreferredSize(new Dimension(0,70));
        down.add(Build);
        down.add(Sell);
        down.add(Morgage);
        down.add(Redeem);
        add(down,BorderLayout.SOUTH);
        
        
        
        add(new JLabel("hiiii"),BorderLayout.EAST);
        
        
        
        
        setVisible(true);
        
        
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            dispose();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
