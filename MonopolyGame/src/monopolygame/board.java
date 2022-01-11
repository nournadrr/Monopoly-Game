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
import static java.lang.Thread.sleep;
import java.util.Iterator;
import java.util.logging.*;

public class board extends JFrame implements KeyListener, MouseListener, ActionListener {
    private JMenu menu1,menu2,menu3;
    JMenuItem item1,item2,item3;
    JMenuBar mb;
    
    JPanel left, down, board, up, right;
    ImageIcon imageicon[], dice1imageicon, dice2imageicon; //board images
    JLabel label[], dice1label, dice2label;//board &dice
    JLabel leftcolour, buyingprice, rent[], houseprice; //leftdata
    Image image, newimg;
    JButton Build, Sell, Morgage, Redeem, rolldice, endturn;//downdata
    Player[] players;
    Object[] property;
    JLabel[] name;//up_data
    JLabel[] balance;//up_data

    JLabel movingplayers[];

    int counterfordice = 0;// for multiple rolling dice
    int currentplayer = 0;
    int currentdice;//used to getrent of waterandelectric
    
    String filename;

    public board(Player[] p, Object[] property,String filename) throws IOException {
        this.filename=filename;
        menubar();
        Build = new JButton("Build");
        Sell = new JButton("Sell");
        Morgage = new JButton("Morgage");
        Redeem = new JButton("Redeem");
        
        down = new JPanel(new GridLayout(1, 4, 20, 5));//up,left,down,right
        down.setBorder(BorderFactory.createEmptyBorder(20, 49, 20, 20));
        up = new JPanel(new GridLayout(2, 4, 0, 0));
        right = new JPanel();

        players = p;
        this.property = property;
        addKeyListener(this);
        setLayout(new BorderLayout());
        setSize(1530, 1010);
        setResizable(false);
//        setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centredata(); // adding centre board
        add(board, BorderLayout.CENTER);
        downdata(); //adding down data
        Build.setEnabled(false);
        Sell.setEnabled(false);
        Morgage.setEnabled(false);
        Redeem.setEnabled(false);
//        endturn.setEnabled(false);
        
        add(down, BorderLayout.SOUTH);
        up_data();//adding updata
        add(up, BorderLayout.NORTH);
        left = new JPanel(new GridLayout(10, 1, 0, 0));//up,left,down,right        
        leftdata(0);// adding leftdata
        add(left, BorderLayout.WEST);
        rightdata(0);//adding properties of players
        add(right, BorderLayout.EAST);
        setplayersonboard();
        setVisible(true);
    }
    
    public void menubar() {
         mb=new JMenuBar();
        menu1=new JMenu("options");
        JMenuItem item1=new JMenuItem(new MyAction());
        JMenuItem item2=new JMenuItem(new MyAction2());
        JMenuItem item3=new JMenuItem(new MyAction3());
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        mb.add(menu1);
        setJMenuBar(mb);
    }

    public void setplayersonboard() {
        movingplayers = new JLabel[4];
        movingplayers[0] = new JLabel();
        movingplayers[0].setBackground(new Color(255, 204, 203));
        movingplayers[0].setOpaque(true);
        movingplayers[0].setBounds(10, 10, 60, 80);
        label[0].add(movingplayers[0]);
        movingplayers[1] = new JLabel();
        movingplayers[1].setBackground(Color.CYAN);
        movingplayers[1].setOpaque(true);
        movingplayers[1].setBounds(10, 10, 60, 80);
        label[0].add(movingplayers[1]);
        movingplayers[2] = new JLabel();
        movingplayers[2].setBackground(new Color(255, 255, 153));
        movingplayers[2].setOpaque(true);
        movingplayers[2].setBounds(10, 10, 60, 80);
        label[0].add(movingplayers[2]);
        movingplayers[3] = new JLabel();
        movingplayers[3].setBackground(new Color(144, 238, 144));
        movingplayers[3].setOpaque(true);
        movingplayers[3].setBounds(10, 10, 60, 80);
        label[0].add(movingplayers[3]);
    }

    public void lucky() {
//        int i=9;
        int i=(int) (Math.random() * 6 + 1);
        if(i==1||i==2)
        {
            String[] options = {"ok"}; 
                JOptionPane.showOptionDialog(null, "Today is your Birthday get $200", "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            players[currentplayer].incrementBalance(200);
            up_data();
        }
        else if(i==3||i==4)
        {
            String[] options = {"ok"}; 
                JOptionPane.showOptionDialog(null, "Your car broke, pay $50", "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            players[currentplayer].decrementBalance(50);
            up_data();
        }
        else if(i==5)
        {
            String[] options = {"ok"}; 
                JOptionPane.showOptionDialog(null, "You broke the law, go to jail", "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(players[currentplayer].getCurrentLocation()<30)
                    movingplayer(30-players[currentplayer].getCurrentLocation());
                else{
                    int count=0;
                    for(int j=players[currentplayer].getCurrentLocation();j!=30;j=(j+1)%40)
                        count++;
                    movingplayer(count);
                    players[currentplayer].decrementBalance(200);
                }
        }
        else//prison card
        {
            String[] options = {"ok"}; 
                JOptionPane.showOptionDialog(null, "You were loyal to your country: get free prison escape", "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                
                players[currentplayer].setJailCard(true);
        }
    }
    public void movingplayer(int dice) {
        currentdice=dice;
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i < dice; i++) {
                    try {
                        sleep(130);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    label[players[currentplayer].getCurrentLocation()].remove(movingplayers[currentplayer]);
                    label[players[currentplayer].getCurrentLocation()].repaint();
                    players[currentplayer].incrementCurrentLocation(1);
                    label[players[currentplayer].getCurrentLocation()].add(movingplayers[currentplayer]);
                    label[players[currentplayer].getCurrentLocation()].repaint();
                    if (players[currentplayer].getCurrentLocation() == 0) {
                        players[currentplayer].incrementBalance(200);
                        up_data();
                    }
                }// final currentlocation
                
                leftdata(players[currentplayer].getCurrentLocation());
                
                if(players[currentplayer].getCurrentLocation() ==4)//tax
                {
                    String[] options = {"ok"}; //// setting for buying a property
                        JOptionPane.showOptionDialog(null, "Tax area pay 200", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        players[currentplayer].decrementBalance(200);
                        up_data();
                }
                else if(players[currentplayer].getCurrentLocation() ==38)//tax
                {
                    String[] options = {"ok"}; //// setting for buying a property
                        JOptionPane.showOptionDialog(null, "Tax area pay 100", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        players[currentplayer].decrementBalance(100);
                        up_data();
                }
                else if(players[currentplayer].getCurrentLocation() ==2||players[currentplayer].getCurrentLocation() ==7
                        ||players[currentplayer].getCurrentLocation() ==17||players[currentplayer].getCurrentLocation() ==22
                        ||players[currentplayer].getCurrentLocation() ==33||players[currentplayer].getCurrentLocation() ==36)//Lucky chances
                {
                    lucky();
                }

                else if (players[currentplayer].getCurrentLocation() == 30)// jail
                {
                    players[currentplayer].setIsJail(true);
                    for (int i = 29; i >= 10; i--) {
                        try {
                            sleep(130);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        label[players[currentplayer].getCurrentLocation()].remove(movingplayers[currentplayer]);
                        label[players[currentplayer].getCurrentLocation()].repaint();
                        players[currentplayer].incrementCurrentLocation(-1);
                        label[players[currentplayer].getCurrentLocation()].add(movingplayers[currentplayer]);
                        label[players[currentplayer].getCurrentLocation()].repaint();
                    }
                    if(!players[currentplayer].getJailCard())
                    {
                    rolldice.setEnabled(false);
                    endturn.setEnabled(true);
                    }
                    else
                        players[currentplayer].setIsJail(false);
                }
                else {
                    buyingproperty();
                }
            }
        };
        t.start();
    }

    public void buyingproperty() {
        int currentlocation = players[currentplayer].getCurrentLocation();
        int propertylocation = 0;

        if (currentlocation == 0 || currentlocation == 2 || currentlocation == 4 || currentlocation == 7 || currentlocation == 10
                || currentlocation == 17 || currentlocation == 20 || currentlocation == 22 || currentlocation == 30
                || currentlocation == 33 || currentlocation == 36 || currentlocation == 38) {
            return;
        }
        for (int i = 0; i < property.length; i++) {
            if (((Property) property[i]).getID() == currentlocation) {
                propertylocation = i;
            }
        }
        if(((Property)property[propertylocation]).getOwnerid()!=currentplayer)
        {
            if (property[propertylocation].getClass().getName().equalsIgnoreCase("monopolygame.Cities")) {
                Cities c = (Cities) property[propertylocation];
                if (players[currentplayer].getBalance() > c.getPrice()) 
                {
                    if (c.getOwnerid() == -1)
                    {
                        String[] options = {"yes", "no"}; //// setting for buying a property
                        if (JOptionPane.showOptionDialog(null, "Do you want to buy this property", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {
                            players[currentplayer].decrementBalance(c.getPrice());
                            c.setOwnerid(currentplayer);
                            players[currentplayer].addProperties(c.getID());
                            leftdata(players[currentplayer].getCurrentLocation());
                            up_data();
                        }
                    } else {
                        String[] options = {"Owner: " + players[c.getOwnerid()].getName()}; //// setting for buying a property
                        JOptionPane.showOptionDialog(null, "Pay : " + c.rent(), "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        players[currentplayer].decrementBalance(c.rent());
                        players[c.getOwnerid()].incrementBalance(c.rent());
                        leftdata(players[currentplayer].getCurrentLocation());
                        up_data();
                    }
                }
            } else if (property[propertylocation].getClass().getName().equalsIgnoreCase("monopolygame.Train")) {
                Train c = (Train) property[propertylocation];
                if (players[currentplayer].getBalance() > c.getPrice()) 
                {
                    if (c.getOwnerid() == -1)
                    {
                        String[] options = {"yes", "no"}; //// setting for buying a property
                        if (JOptionPane.showOptionDialog(null, "Do you want to buy this property", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {
                            players[currentplayer].decrementBalance(c.getPrice());
                            c.setOwnerid(currentplayer);
                            players[currentplayer].addProperties(c.getID());
                            leftdata(players[currentplayer].getCurrentLocation());
                            up_data();
                        }
                    } else {
                        String[] options = {"Owner: " + players[c.getOwnerid()].getName()}; //// setting for buying a property
                        JOptionPane.showOptionDialog(null, "Pay : " + c.getRent(property,c.getOwnerid()), "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        players[currentplayer].decrementBalance(c.getRent(property,c.getOwnerid()));
                        players[c.getOwnerid()].incrementBalance(c.getRent(property,c.getOwnerid()));
                        leftdata(players[currentplayer].getCurrentLocation());
                        up_data();
                    }
                }
            } else if (property[propertylocation].getClass().getName().equalsIgnoreCase("monopolygame.waterandelec")) 
            {
                waterandelec c = (waterandelec) property[propertylocation];
                if (players[currentplayer].getBalance() > c.getPrice()) 
                {
                    if (c.getOwnerid() == -1)
                    {
                        String[] options = {"yes", "no"}; //// setting for buying a property
                        if (JOptionPane.showOptionDialog(null, "Do you want to buy this property", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {
                            players[currentplayer].decrementBalance(c.getPrice());
                            c.setOwnerid(currentplayer);
                            players[currentplayer].addProperties(c.getID());
                            leftdata(players[currentplayer].getCurrentLocation());
                            up_data();
                        }
                    } else {
                        String[] options = {"Owner: " + players[c.getOwnerid()].getName()}; //// setting for buying a property
                        JOptionPane.showOptionDialog(null, "Pay : " + c.getRent(currentdice,property), "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        players[currentplayer].decrementBalance(c.getRent(currentdice,property));
                        players[c.getOwnerid()].incrementBalance(c.getRent(currentdice,property));
                        leftdata(players[currentplayer].getCurrentLocation());
                        up_data();
                    }
                }
            }
    }

//        Property c = (Property)property[propertylocation];
//        if (players[currentplayer].getBalance() > c.getPrice()) 
//        {
//            if(((Property) property[propertylocation]).getOwnerid() == -1)
//            {
//                String[] options = {"yes", "no"}; //// setting for buying a property
//                if (JOptionPane.showOptionDialog(null, "Do you want to buy this property", "Click a button",
//                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {
//                    players[currentplayer].decrementBalance(((Property) property[propertylocation]).getPrice());
//                    c.setOwnerid(currentplayer);
//                    players[currentplayer].addProperties(c.getID());
//                    leftdata(players[currentplayer].getCurrentLocation());
//                    up_data();
//                }
//            }
//            else
//            {
//                String[] options = {"Owner: "+players[c.getOwnerid()].getName()}; //// setting for buying a property
//                JOptionPane.showOptionDialog(null,"Pay : "+c.getRent(), "Click a button",
//                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
//                players[currentplayer].decrementBalance(c.getRent());
//                players[c.getOwnerid()].incrementBalance(c.getRent());
////                c.setOwnerid(currentplayer);
//                leftdata(players[currentplayer].getCurrentLocation());
//                up_data();
//            }
//        }
        rightdata(currentplayer);
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
        for (int s = 0; s < label.length; s++) {
            if (me.getSource() == label[s]) {
                leftdata(s);
            }
        }

        for (int i = 0; i < name.length; i++) {
            if (me.getSource() == name[i] || me.getSource() == balance[i]) {
                rightdata(i);
            }
        }

        if (me.getSource() == rolldice) {
            Thread t = new Thread() {
                public void run() {
                    int ran1 = 0, ran2 = 0;
                    int i;
                    i = 0;
                    while (i < 13) {
                        try {
                            sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ran1 = (int) (Math.random() * 6 + 1);
                        dice1imageicon = new ImageIcon("src\\images\\dice" + ran1 + ".PNG");
                        image = dice1imageicon.getImage();
                        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
                        dice1imageicon = new ImageIcon(newimg);
                        dice1label.setIcon(dice1imageicon);

                        ran2 = (int) (Math.random() * 6 + 1);
                        dice2imageicon = new ImageIcon("src\\images\\dice" + ran2 + ".PNG");
                        image = dice2imageicon.getImage();
                        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
                        dice2imageicon = new ImageIcon(newimg);
                        dice2label.setIcon(dice2imageicon);
                        i++;
                    }
                    movingplayer(ran1 + ran2);
//                    movingplayer(6);
                    counterfordice++;

                    if (ran1 != ran2 || counterfordice > 2) {
                        counterfordice = 0;
                        rolldice.setEnabled(false);
                        endturn.setEnabled(true);
                    }
                }//end of run function
            };
            t.start();
        }

        if (me.getSource() == endturn) {
            Thread t = new Thread() {
                public void run() {
//                    currentplayer=0;
                    currentplayer = (currentplayer + 1) % 4;
                    leftdata(players[currentplayer].getCurrentLocation());
                    rightdata(currentplayer);
                    downdata();
                    if (players[currentplayer].getIsJail()) {
                        String[] options = {"yes", "no"}; //// setting for buying a property
                        if (JOptionPane.showOptionDialog(null, "Do you want to exit jail for $100", "Click a button",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {
                            players[currentplayer].decrementBalance(100);
                            players[currentplayer].setIsJail(false);
                            endturn.setEnabled(false);
                            rolldice.setEnabled(true);
                            up_data();
                        } else {
                            players[currentplayer].incrementjailtime();
                            endturn.setEnabled(true);
                            rolldice.setEnabled(false);
                            return;
                        }
                    } else {
                        endturn.setEnabled(false);
                        rolldice.setEnabled(true);
                        downdata();
                    }
//                    downdata();
                }
            };
            t.start();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    public void rightdata(int player) {
        right.removeAll();
        right.setPreferredSize(new Dimension(250, 20));

        JLabel p = new JLabel("Properties of: " + players[player].getName(), SwingConstants.CENTER);
        p.setFont(new Font("Serif", Font.BOLD, 14));
        p.setOpaque(true);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(200, 20));
        right.add(p);

        Iterator<Integer> it = players[player].getProperties().iterator();
        int size = players[player].getProperties().size();
        JLabel data[] = new JLabel[size];
        for (int i = 0; i < size; i++) {
            int loc = it.next();
            Object c = null;
            for (int j = 0; j < property.length; j++) {
                if (loc == ((Property) property[j]).getID()) {
                    c = (Property) property[j];
                }
            }
            data[i] = new JLabel(((Property) c).getName(), SwingUtilities.CENTER);
            data[i].setOpaque(true);
            data[i].setFont(new Font("Serif", Font.BOLD, 12));

            if (c.getClass().getName().equalsIgnoreCase("monopolygame.Cities")) {
                if (((Property) c).getColor().equalsIgnoreCase("brown")) {
                    Color loon = new Color(181, 101, 29);
                    data[i].setBackground(loon);
                } else if (((Property) c).getColor().equalsIgnoreCase("blue")) {
                    data[i].setBackground(Color.cyan);
                } else if (((Property) c).getColor().equalsIgnoreCase("pink")) {
                    data[i].setBackground(Color.pink);
                } else if (((Property) c).getColor().equalsIgnoreCase("orange")) {
                    data[i].setBackground(Color.orange);
                } else if (((Property) c).getColor().equalsIgnoreCase("red")) {
                    data[i].setBackground(Color.red);
                } else if (((Property) c).getColor().equalsIgnoreCase("yellow")) {
                    data[i].setBackground(Color.yellow);
                } else if (((Property) c).getColor().equalsIgnoreCase("green")) {
                    data[i].setBackground(Color.GREEN);
                } else if (((Property) c).getColor().equalsIgnoreCase("darkblue")) {
                    data[i].setBackground(Color.BLUE);
                } else {
                    data[i].setBackground(Color.white);
                }
            } else if (c.getClass().getName().equalsIgnoreCase("monopolygame.Train")) {
                data[i].setBackground(Color.BLACK);
                data[i].setForeground(Color.white);
            } else if (c.getClass().getName().equalsIgnoreCase("monopolygame.waterandelec")) {
                data[i].setBackground(Color.darkGray);
                data[i].setForeground(Color.white);
            }
            right.add(data[i]);
//            }
        }
        right.revalidate();
        right.repaint();
    }

    public void leftdata(int s) {
//        left=new JPanel(new GridLayout(8,1,0,0));//up,left,down,right
//        left.setBorder(BorderFactory.createEmptyBorder(20, 49, 20, 220));

        left.removeAll();
        left.setPreferredSize(new Dimension(250, 20));
        Build.setEnabled(false);
//        downdata();
        if (s == 0) {
            JLabel start = new JLabel("MONOPOLY", SwingConstants.CENTER);

            start.setFont(new Font("Serif", Font.BOLD, 14));
            start.setOpaque(true);
            start.setBackground(Color.white);
            start.setPreferredSize(new Dimension(200, 20));

            JLabel get = new JLabel("Get 200 when you pass by", SwingConstants.CENTER);
            get.setFont(new Font("Serif", Font.BOLD, 14));
            get.setOpaque(true);
            get.setBackground(Color.white);
            get.setPreferredSize(new Dimension(200, 20));

            left.add(start);
            left.add(get);
        } else if (s == 10 || s == 30)//jail
        {
            leftcolour = new JLabel("Jail Area", SwingConstants.CENTER);
            leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
            leftcolour.setOpaque(true);
            leftcolour.setBackground(Color.white);

            left.add(leftcolour);
        } else if (s == 2 || s == 7 || s == 17 || s == 22 || s == 33 || s == 36)//lucly
        {
            leftcolour = new JLabel("Wait for your lucky card", SwingConstants.CENTER);
            leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
            leftcolour.setOpaque(true);
            leftcolour.setBackground(Color.white);
            left.add(leftcolour);
        } else if (s == 20)//waiting
        {
            leftcolour = new JLabel("The Waiting Area", SwingConstants.CENTER);
            leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
            leftcolour.setOpaque(true);
            leftcolour.setBackground(Color.white);
            left.add(leftcolour);
        } else if (s == 4 || s == 38)//tax
        {
            leftcolour = new JLabel("Tax Area", SwingConstants.CENTER);
            leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
            leftcolour.setOpaque(true);
            leftcolour.setBackground(Color.white);
            JLabel x = new JLabel("You Must pay");
            x.setFont(new Font("Serif", Font.BOLD, 18));
            x.setOpaque(true);
            x.setBackground(Color.white);
            left.add(leftcolour);
            left.add(x);
        } else //properties
        {
            for (int i = 0; i < property.length; i++) {
                if (((Property) property[i]).getID() == s) {
                    if (property[i].getClass().getName().equalsIgnoreCase("monopolygame.Cities")) {
                        Cities c = (Cities) property[i];
                        leftcolour = new JLabel(c.getName(), SwingConstants.CENTER);
                        leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
                        leftcolour.setOpaque(true);
                        if (c.getColor().equalsIgnoreCase("brown")) {
                            Color loon = new Color(181, 101, 29);
                            leftcolour.setBackground(loon);
                        } else if (c.getColor().equalsIgnoreCase("blue")) {
                            leftcolour.setBackground(Color.cyan);
                        } else if (c.getColor().equalsIgnoreCase("pink")) {
                            leftcolour.setBackground(Color.pink);
                        } else if (c.getColor().equalsIgnoreCase("orange")) {
                            leftcolour.setBackground(Color.orange);
                        } else if (c.getColor().equalsIgnoreCase("red")) {
                            leftcolour.setBackground(Color.red);
                        } else if (c.getColor().equalsIgnoreCase("yellow")) {
                            leftcolour.setBackground(Color.yellow);
                        } else if (c.getColor().equalsIgnoreCase("green")) {
                            leftcolour.setBackground(Color.GREEN);
                        } else if (c.getColor().equalsIgnoreCase("darkblue")) {
                            leftcolour.setBackground(Color.BLUE);
                        } else {
                            leftcolour.setBackground(Color.white);
                        }

                        left.add(leftcolour);
                        String text = "Price: " + c.getPrice();
                        buyingprice = new JLabel(text);
                        left.add(buyingprice);

                        rent = new JLabel[6];

                        text = "Rent: " + c.getRent();
                        rent[0] = new JLabel(text);
                        text = "Rent with 1 house: " + c.getRenthouse();
                        rent[1] = new JLabel(text);
                        text = "Rent with 2 house: " + c.getRent2();
                        rent[2] = new JLabel(text);
                        text = "Rent with 3 house: " + c.getRent3();
                        rent[3] = new JLabel(text);
                        text = "Rent with 4 house: " + c.getRent4();
                        rent[4] = new JLabel(text);
                        text = "Rent with hotel: " + c.getRentofhotel();
                        rent[5] = new JLabel(text);
                        text = "Building price: " + c.getHousesprice();
                        houseprice = new JLabel(text);

                        for (int j = 0; j < rent.length; j++) {
                            left.add(rent[j]);
                        }
                        left.add(houseprice);
                        
                        if(currentplayer==c.getOwnerid()&&c.canbuild()) // for building
                        {
                            Build.setEnabled(true);
//                            downdata();
                        }
//                        else{
//                            Build.setEnabled(false);
//                            downdata();
//                        }
                        
                    } else if (property[i].getClass().getName().equalsIgnoreCase("monopolygame.Train")) {
                        Train t = (Train) property[i];
                        leftcolour = new JLabel(t.getName(), SwingConstants.CENTER);
                        leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
                        leftcolour.setOpaque(true);
                        leftcolour.setBackground(Color.BLACK);
                        leftcolour.setForeground(Color.white);

                        left.add(leftcolour);
                        String text = "Price: " + t.getPrice();
                        buyingprice = new JLabel(text);
                        left.add(buyingprice);

                        rent = new JLabel[4];
                        text = "Rent with 1 train: 25";
                        rent[0] = new JLabel(text);
                        text = "Rent with 2 trains: 50";
                        rent[1] = new JLabel(text);
                        text = "Rent with 3 trains: 100";
                        rent[2] = new JLabel(text);
                        text = "Rent with 4 trains: 200";
                        rent[3] = new JLabel(text);
                        for (int j = 0; j < rent.length; j++) {
                            left.add(rent[j]);
                        }
                    } else if (property[i].getClass().getName().equalsIgnoreCase("monopolygame.waterandelec")) {
                        waterandelec w = (waterandelec) property[i];
                        leftcolour = new JLabel(w.getName(), SwingConstants.CENTER);
                        leftcolour.setFont(new Font("Serif", Font.BOLD, 18));
                        leftcolour.setOpaque(true);
                        leftcolour.setBackground(Color.darkGray);
                        leftcolour.setForeground(Color.white);

                        left.add(leftcolour);
                        String text = "Price: " + w.getPrice();
                        buyingprice = new JLabel(text);
                        left.add(buyingprice);

                        rent = new JLabel[2];
                        text = "if 1 owned rent is 4*dice";
                        rent[0] = new JLabel(text);
                        text = "if 2 owned rent is 10*dice";
                        rent[1] = new JLabel(text);

                        for (int j = 0; j < rent.length; j++) {
                            left.add(rent[j]);
                        }
                    }
                    String own;
                    int ownerid = ((Property) property[i]).getOwnerid();
                    if (ownerid == -1) {
                        own = "No Owner";
                    } else {
                        ownerid = ((Property) property[i]).getOwnerid();
                        own = "Owner: " + players[ownerid].getName();
                    }
                    JLabel ownerlabel = new JLabel(own, SwingUtilities.CENTER);
                    ownerlabel.setFont(new Font("Serif", Font.BOLD, 22));
                    if (ownerid == 0) {
                        ownerlabel.setBackground(new Color(255, 204, 203));
                    } else if (ownerid == 1) {
                        ownerlabel.setBackground(Color.CYAN);
                    } else if (ownerid == 2) {
                        ownerlabel.setBackground(new Color(255, 255, 153));
                    } else if (ownerid == 3) {
                        ownerlabel.setBackground(new Color(144, 238, 144));
                    }
                    ownerlabel.setOpaque(true);
                    left.add(ownerlabel);
                }
            }
        }
        left.revalidate();
        left.repaint();
    }

    public void downdata() {
        down.removeAll();
        //JButton Build, Sell, Morgage, Redeem,rolldice;//downdata
//        Build = new JButton("Build");
//        Sell = new JButton("Sell");
//        Morgage = new JButton("Morgage");
//        Redeem = new JButton("Redeem");
        rolldice = new JButton("Roll Dice");
        endturn = new JButton("End Turn");
//        Build.setPreferredSize(new Dimension(220, 70));
//        Build.setBounds(10, 10, 60, 80);

        dice1imageicon = new ImageIcon("src\\images\\dice6.PNG");
        image = dice1imageicon.getImage();
        newimg = image.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        dice1imageicon = new ImageIcon(newimg);

        dice1label = new JLabel(dice1imageicon, SwingUtilities.CENTER);
        dice2label = new JLabel(dice1imageicon, SwingUtilities.CENTER);

        JLabel turn = new JLabel(players[currentplayer].getName(), SwingUtilities.CENTER);
        turn.setFont(new Font("Serif", Font.BOLD, 12));
        if (currentplayer == 0) {
            turn.setBackground(new Color(255, 204, 203));
        } else if (currentplayer == 1) {
            turn.setBackground(Color.CYAN);
        } else if (currentplayer == 2) {
            turn.setBackground(new Color(255, 255, 153));
        } else if (currentplayer == 3) {
            turn.setBackground(new Color(144, 238, 144));
        }
        turn.setOpaque(true);
        down.add(turn);

        down.add(Build); // add action listner in buttons
        down.add(Sell);
        down.add(Morgage);
        down.add(Redeem);
        down.add(rolldice);
        down.add(dice1label);
        down.add(dice2label);
        down.add(endturn);
//        dice2label.addMouseListener(this);
//        dice1label.addMouseListener(this);

//        Build.setEnabled(false);
//        Sell.setEnabled(false);
//        Morgage.setEnabled(false);
//        Redeem.setEnabled(false);
        endturn.setEnabled(false);

        rolldice.addMouseListener(this);
        endturn.addMouseListener(this);
        down.revalidate();
        down.repaint();
    }

    public void centredata() {
        JPanel south = new JPanel();
        JPanel west = new JPanel();
        JPanel north = new JPanel();
        JPanel east = new JPanel();
        JPanel centre = new JPanel();
        board = new JPanel(new BorderLayout());
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
        newimg = image.getScaledInstance(812, 602, java.awt.Image.SCALE_SMOOTH);
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
    }

    public void up_data() {
        up.removeAll();
        name = new JLabel[4];
        balance = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            name[i] = new JLabel(players[i].getName(), SwingConstants.CENTER);
            balance[i] = new JLabel(Integer.toString(players[i].getBalance()), SwingConstants.CENTER);
            name[i].setFont(new Font("Serif", Font.BOLD, 18));
            balance[i].setFont(new Font("Serif", Font.BOLD, 18));
            up.add(name[i]);
        }

        for (int i = 0; i < 4; i++) {
            up.add(balance[i]);
        }

        Color redColor = new Color(255, 204, 203);
        name[0].setBackground(redColor);
        name[0].setOpaque(true);
        balance[0].setBackground(redColor);
        balance[0].setOpaque(true);
        name[1].setBackground(Color.CYAN);
        name[1].setOpaque(true);
        balance[1].setBackground(Color.cyan);
        balance[1].setOpaque(true);

        Color lightyellow = new Color(255, 255, 153);
        name[2].setBackground(lightyellow);
        name[2].setOpaque(true);
        balance[2].setBackground(lightyellow);
        balance[2].setOpaque(true);

        Color lightgreen = new Color(144, 238, 144);
        name[3].setBackground(lightgreen);
        name[3].setOpaque(true);
        balance[3].setBackground(lightgreen);
        balance[3].setOpaque(true);

        name[0].addMouseListener(this);
        balance[0].addMouseListener(this);

        name[1].addMouseListener(this);
        balance[1].addMouseListener(this);

        name[2].addMouseListener(this);
        balance[2].addMouseListener(this);

        name[3].addMouseListener(this);
        balance[3].addMouseListener(this);

        up.revalidate();
        up.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    
    
    public class MyAction extends AbstractAction {
    public MyAction() {
        super("save and exit");
    }

    public void actionPerformed(ActionEvent e) {
        // Button pressed logic goes here
        System.out.println("save and exit pressed");
        try {
            Game.saveAndExit(filename);
            setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
     
     public class MyAction2 extends AbstractAction {
    public MyAction2() {
        super("main menu");
    }

    public void actionPerformed(ActionEvent e) {
        // Button pressed logic goes here
        System.out.println("main menu pressed");
        setVisible(false);
        new graphics();
    }
    }
     
     public class MyAction3 extends AbstractAction {
    public MyAction3() {
        super("technical");
    }

    public void actionPerformed(ActionEvent e) {
        // Button pressed logic goes here
        System.out.println("technical pressed");
        setVisible(false);
        
    }
    }
}


