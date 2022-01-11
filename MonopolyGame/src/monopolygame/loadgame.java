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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    //JTextField t1;
    JComboBox cb;
    
    public loadgame()
    {
        JPanel p1=new JPanel();
        setSize(550,850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,10, 30));
        JLabel label=new JLabel("                                           Load existing Game                                                             ");
        JLabel L1=new JLabel("choose game name: ");
        //t1=new JTextField(10);
        p1.add(label);
        p1.add(L1);
        //p1.add(t1);
        add(p1,BorderLayout.CENTER);
        JPanel p2=new JPanel();
        save=new JButton("save");
        back=new JButton("back");
        p2.add(save,BorderLayout.WEST);
        p2.add(back,BorderLayout.EAST);
        add(p2,BorderLayout.SOUTH);
        back.addActionListener(this);
        save.addActionListener(this);
        
        File file=new File("files");
        File[] f=file.listFiles();
        String[] s=new String[f.length];
//        for(int i=0;i<f.length;i++)
//        {
//            s[i]=f[i].toString();
//        }
        //System.out.println(s[1].sbstring(49, s[1].indexOf("players")));
        //System.out.println(s[2].sbstring(49, s[2].indexOf("players")));
        for(int i=0;i<f.length;i=i+2)
        {
            s[i]=f[i].toString();
            s[i]=s[i].substring(6, s[i].indexOf("players"));
        }
        cb=new JComboBox(s);
        p1.add(cb);
        
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
            Game game=null;
            try {
                game = new Game();
            } catch (IOException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String name=cb.getSelectedItem().toString();
                game.loadgame(name);
                //System.out.println("game name:"+t1.getText());
            } catch (IOException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loadgame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}