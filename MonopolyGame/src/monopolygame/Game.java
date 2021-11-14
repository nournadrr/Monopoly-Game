/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.util.*;
/**
 *
 * @author Dell
 */
public class Game {
    Scanner in=new Scanner(System.in);
    
    
    public void buyMortage(Player p)
    {
        System.out.println("do you want to buy a mortaged property?");
        String choice=in.next();
        if(choice=="yes")
        {
            for(int i=0;i<p.getNumOfProperties();i++)
            {
                if(p.getProperties(i).isIsmortaged())
                    System.out.println(p.getProperties(i).getName()+"  ID:"+p.getProperties(i).getID());
            }
            System.out.println("enter id of property to buy");
            int id=in.nextInt();
            for(int i=0;i<p.getNumOfProperties();i++)
            {
                if(p.getProperties(i).getID()==id)
                {
                    p.getProperties(i).setIsmortaged(false);
                    p.decrementBalance(p.getProperties(i).getPrice());
                }
            }
        }
    }
    
}
