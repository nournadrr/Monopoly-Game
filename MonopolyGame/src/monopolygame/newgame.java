/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author Dell
 */
public class newgame extends JFrame implements ActionListener{
     private JButton save,back;
     //graphics gr=new graphics();
     public static Player[] players=new Player[4];
     JTextField t1,t2,t3,t4,t5;
    
    public newgame()
    {
        JPanel p1=new JPanel();
        setSize(350,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,10, 30));
        JLabel L1=new JLabel("enter the game name: ");
        JLabel L2=new JLabel("enter first player name: ");
        JLabel L3=new JLabel("enter second player name: ");
        JLabel L4=new JLabel("enter third player name: ");
        JLabel L5=new JLabel("enter fourth player name: ");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t5=new JTextField(10);
        JLabel label=new JLabel("                     Create New Game                ");
        p1.add(label);
        p1.add(L1);
        p1.add(t1);
        p1.add(L2);
        p1.add(t2);
        p1.add(L3);
        p1.add(t3);
        p1.add(L4);
        p1.add(t4);
        p1.add(L5);
        p1.add(t5);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.CENTER);
        JPanel p2=new JPanel();
        save=new JButton("save");
        back=new JButton("back");
        p2.add(save,BorderLayout.WEST);
        p2.add(back,BorderLayout.EAST);
        add(p2,BorderLayout.SOUTH);
        back.addActionListener(this);
        save.addActionListener(this);
        //setVisible(true);
        
    }
    
    public static Player[] addPlayers()
    {
        return players;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object pressed=ae.getSource();
        if(pressed.equals(back))
        {
//            setVisible(false);
            //dispose();
            //gr.setVisible(true);
            new graphics();
            setVisible(false);
        }
        if(pressed.equals(save))
        {
            //System.out.println("hello");
                String gamename=t1.getText();
                players[0]=new Player();
                players[0].setName(t2.getText());
                players[0].setId(0);
                //System.out.println(t2.getText());
                
                players[1]=new Player();
                players[1].setName(t3.getText());
                players[1].setId(1);
                //System.out.println(t3.getText());
                
                players[2]=new Player();
                players[2].setName(t4.getText());
                players[2].setId(2);
                //System.out.println(t4.getText());
                
                players[3]=new Player();
                players[3].setName(t5.getText());
                players[3].setId(3);
                //System.out.println(t5.getText());
                
                //System.out.println(players[1].getName());
                Game game=null;
            try {
                game = new Game();
            } catch (IOException ex) {
                Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                game.newgame(players,gamename);
            } catch (IOException ex) {
                Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
                //game.returnPlayers();
                
            
        }
    }
}