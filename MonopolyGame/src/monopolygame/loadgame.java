/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class loadgame extends JFrame implements ActionListener{
    JButton back,save;
    JTextField t1;
    
    public loadgame()
    {
        JPanel p1=new JPanel();
        setSize(350,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,10, 30));
        JLabel label=new JLabel("                     Load existing Game                ");
        JLabel L1=new JLabel("enter game name: ");
        t1=new JTextField(10);
        p1.add(label);
        p1.add(L1);
        p1.add(t1);
        add(p1,BorderLayout.CENTER);
        JPanel p2=new JPanel();
        save=new JButton("save");
        back=new JButton("back");
        p2.add(save,BorderLayout.WEST);
        p2.add(back,BorderLayout.EAST);
        add(p2,BorderLayout.SOUTH);
         back.addActionListener(this);
        save.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object pressed=ae.getSource();
        if(pressed.equals(back))
        {
            new graphics();
            setVisible(false);
            
        }
        if(pressed.equals(save))
        {
            Game game=new Game();
            try {
                game.loadgame(t1.getText());
                //System.out.println("game name:"+t1.getText());
            } catch (IOException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
