/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.*;

public class board extends JFrame implements KeyListener, MouseListener {
    ImageIcon imageicon[], dice1imageicon, dice2imageicon;
    JLabel label[], dice1label, dice2label;
    JLabel leftcolour,buyingprice,rent[],houseprice;
    Image image;
    Image newimg;
    JButton Build, Sell, Morgage, Redeem;
    Player[] players;
    Object[] property;

    public board(Player[] p,Object[] property) throws IOException {
        players=p;
        this.property=property;
        addKeyListener(this);
        setLayout(new BorderLayout());
        setSize(1100, 1000);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel south = new JPanel();
        JPanel west = new JPanel();
        JPanel north = new JPanel();
        JPanel east = new JPanel();
        JPanel centre = new JPanel();
        JPanel board = new JPanel(new BorderLayout());
        centre.setBackground(Color.BLACK);
        south.setLayout(new GridLayout(1, 9, 4, 4));
        south.setBackground(Color.black);
        west.setLayout(new GridLayout(9, 1, 4, 4));
        west.setBackground(Color.black);
        north.setLayout(new GridLayout(1, 9, 4, 4));
        north.setBackground(Color.black);
        east.setLayout((new GridLayout(9, 1, 4, 4)));
        east.setBackground(Color.black);
        imageicon = new ImageIcon[41];
        label = new JLabel[41];

        //Adding to centre
        
        imageicon[40] = new ImageIcon("src//images//centre.PNG");
        image = imageicon[40].getImage();
        newimg = image.getScaledInstance(870, 735, java.awt.Image.SCALE_SMOOTH);
        imageicon[40] = new ImageIcon(newimg);
        label[40] = new JLabel();
        label[40].setIcon(imageicon[40]);
        centre.add(label[40]);

        for (int i = 0; i < imageicon.length; i++) {
            String s = "src//images//" + i + ".PNG";
            imageicon[i] = new ImageIcon(s);
            image = imageicon[i].getImage();
            newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            imageicon[i] = new ImageIcon(newimg);
        }
        for (int j = 11 - 1; j >= 0; j--) {
            label[j] = new JLabel();
            label[j].setIcon(imageicon[j]);
            south.add(label[j]);
            label[j].addMouseListener(this);
        }
        for (int j = 19; j >= 11; j--) {
            label[j] = new JLabel();
            label[j].setIcon(imageicon[j]);
            west.add(label[j]);
            label[j].addMouseListener(this);
        }
        for (int j = 20; j <= 30; j++) {
            label[j] = new JLabel();
            label[j].setIcon(imageicon[j]);
            north.add(label[j]);
            label[j].addMouseListener(this);
        }
        for (int j = 31; j <= 39; j++) {
            label[j] = new JLabel();
            label[j].setIcon(imageicon[j]);
            east.add(label[j]);
            label[j].addMouseListener(this);
        }

        board.add(south, BorderLayout.SOUTH);
        board.add(west, BorderLayout.WEST);
        board.add(north, BorderLayout.NORTH);
        board.add(east, BorderLayout.EAST);
        board.add(centre, BorderLayout.CENTER);
        add(board, BorderLayout.CENTER);  

        // end el centre

        // start ta7t
        JPanel down = new JPanel(new GridLayout(1, 4, 20, 5));//up,left,down,right
        down.setBorder(BorderFactory.createEmptyBorder(20, 49, 20, 220));
        Build = new JButton("Build");
        Sell = new JButton("Sell");
        Morgage = new JButton("Morgage");
        Redeem = new JButton("Redeem");
        Build.setPreferredSize(new Dimension(0, 70));
        down.add(Build); // add action listner in buttons
        down.add(Sell);
        down.add(Morgage);
        down.add(Redeem);

        dice1imageicon = new ImageIcon("src\\images\\dice6.PNG");
        image = dice1imageicon.getImage();
        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        dice1imageicon = new ImageIcon(newimg);
        dice1label = new JLabel();
        dice1label.setIcon(dice1imageicon);
        down.add(dice1label);
        dice2label = new JLabel();
        dice2label.setIcon(dice1imageicon);
        down.add(dice2label);

        dice2label.addMouseListener(this);
        dice1label.addMouseListener(this);

        add(down, BorderLayout.SOUTH);
        
        // end el down
        
        
        // start ely foo2
        JPanel right=new JPanel(new GridLayout(4,1,10,10));
        add(new rightpanel(p),BorderLayout.NORTH);
        
        //end ely foo2
       
       
        ////////////////////////////////////////////////////////////////////////////////////////
//        JPanel left=new JPanel(new GridLayout(7,1,0,0));
//        Cities c=(Cities)property[0];
//        leftcolour=new JLabel(c.getName(),SwingConstants.CENTER);
//        leftcolour.setFont(new Font("Serif", Font.BOLD, 14));
//        leftcolour.setOpaque(true);
//        Color loon=new Color(181,101,29);
//        leftcolour.setBackground(loon);
////        leftcolour.setMinimumSize(new Dimension(30, 20));
//        leftcolour.setPreferredSize(new Dimension(200, 20));
////        leftcolour.setMaximumSize(new Dimension(30, 20));
//        
//        buyingprice=new JLabel(Integer.toString(c.getPrice()));
//        rent=new JLabel[5];
//        rent[0]=new JLabel(Integer.toString(c.getRenthouse()));
//        rent[1]=new JLabel(Integer.toString(c.getRent2()));
//        rent[2]=new JLabel(Integer.toString(c.getRent3()));
//        rent[3]=new JLabel(Integer.toString(c.getRent4()));
//        rent[4]=new JLabel(Integer.toString(c.getRentofhotel()));
//        houseprice=new JLabel(Integer.toString(c.getHousesprice()));
//        
//        
//        left.add(leftcolour);
//        for(int i=0;i<rent.length;i++)
//            left.add(rent[i]);
//        left.add(houseprice);
//        add(left,BorderLayout.WEST);
        leftdata(0);
       ////////////////////////////////////////////////////////////////////////////////////////
        
        setVisible(true);
    }
    
    public void leftdata(int s) {
        JPanel left=new JPanel(new GridLayout(8,1,0,0));//up,left,down,right
//        left.setBorder(BorderFactory.createEmptyBorder(20, 49, 20, 220));
        if(s==0)
        {
            JLabel start=new JLabel("MONOPOLY",SwingConstants.CENTER);
            start.setFont(new Font("Serif", Font.BOLD, 14));
            start.setOpaque(true);
            start.setBackground(Color.white);
            start.setPreferredSize(new Dimension(200, 20));
            
            JLabel get=new JLabel("Get 200 when you pass by",SwingConstants.CENTER);
            get.setFont(new Font("Serif", Font.BOLD, 14));
            get.setOpaque(true);
            get.setBackground(Color.white);
            get.setPreferredSize(new Dimension(200, 20));
            
            left.add(start);
            left.add(get);
            add(left,BorderLayout.WEST);
        }
        else
        {
            for(int i=0;i<property.length;i++)
            {
                if(((Property)property[i]).getID()==s)
                {
                    //leftcolour,buyingprice,rent[],houseprice;
                    if(property[i].getClass().getName().equalsIgnoreCase("monopolygame.Cities"))
                    {                      
                        System.out.println(property[i].getClass().getName());

                        Cities c=(Cities)property[i];
                        leftcolour=new JLabel(c.getName(),SwingConstants.CENTER);
                        leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
                        leftcolour.setOpaque(true);
                        if(c.getColor().equalsIgnoreCase("brown"))
                        {
                            Color loon=new Color(181,101,29);
                            leftcolour.setBackground(loon);
                        }
                        else if(c.getColor().equalsIgnoreCase("blue"))
                            leftcolour.setBackground(Color.cyan);
                        else if(c.getColor().equalsIgnoreCase("pink"))
                            leftcolour.setBackground(Color.pink);
                        else if(c.getColor().equalsIgnoreCase("orange"))
                            leftcolour.setBackground(Color.orange);
                        else if(c.getColor().equalsIgnoreCase("red"))
                            leftcolour.setBackground(Color.red);
                        else if(c.getColor().equalsIgnoreCase("yellow"))
                            leftcolour.setBackground(Color.yellow);
                        else if(c.getColor().equalsIgnoreCase("green"))
                                leftcolour.setBackground(Color.GREEN);
                        else if(c.getColor().equalsIgnoreCase("darkblue"))
                            leftcolour.setBackground(Color.BLUE);
                        else
                            leftcolour.setBackground(Color.white);
                        
                        left.add(leftcolour);
                        String text="Price: "+c.getPrice();
                        buyingprice=new JLabel(text);
                        left.add(buyingprice);
                        
                        rent=new JLabel[5];
                        text="Rent with 1 house: "+c.getRenthouse();
                        rent[0]=new JLabel(text);
                        text="Rent with 2 house: "+c.getRent2();
                        rent[1]=new JLabel(text);
                        text="Rent with 3 house: "+c.getRent3();
                        rent[2]=new JLabel(text);
                        text="Rent with 4 house: "+c.getRent4();
                        rent[3]=new JLabel(text);
                        text="Rent with hotel: "+c.getRentofhotel();
                        rent[4]=new JLabel(text);
                        text="Building price: "+c.getHousesprice();
                        houseprice=new JLabel(text);
                        
                        for(int j=0;j<rent.length;j++)
                            left.add(rent[j]);
                        left.add(houseprice);
                        add(left,BorderLayout.WEST);
                    }
                    
                    
                    
                    else if(property[i].getClass().getName().equalsIgnoreCase("Train"))
                    {
                        
                    }
                    else if(property[i].getClass().getName().equalsIgnoreCase("waterandelec"))
                    {
                        
                    }
                }
            }
        }
        ////////////////////////////////////////////////////////
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Thread w=new Thread()
        {
            public void run() 
                {
                    for(int i=0;i<label.length;i++)
                    {
                        if(me.getSource()==label[i])
                        {
                            leftdata(i);
                        }
                    }
                }
        };
        w.start();
//        if (me.getSource() == label[0]) {
//            System.out.println("works");
//        }

        
        
        
        
        
        
        if (me.getSource() == dice1label || me.getSource() == dice2label) 
        {
            Thread t = new Thread() 
            {
                public void run() 
                {
                    int i = 0;
                    while (i < 13) 
                    {
                        try {
                            sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        int ran1 = (int) (Math.random() * 5 + 2);
                        dice1imageicon = new ImageIcon("src\\images\\dice" + ran1 + ".PNG");
                        image = dice1imageicon.getImage();
                        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
                        dice1imageicon = new ImageIcon(newimg);
                        dice1label.setIcon(dice1imageicon);

                        int ran2 = (int) (Math.random() * 5 + 2);
                        dice2imageicon = new ImageIcon("src\\images\\dice" + ran2 + ".PNG");
                        image = dice2imageicon.getImage();
                        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
                        dice2imageicon = new ImageIcon(newimg);
                        dice2label.setIcon(dice2imageicon);
                        i++;
                    }
                }
            };
            t.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
}
