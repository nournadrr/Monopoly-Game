package monopolygame;
import java.io.FileNotFoundException;
import java.util.*;
public class MonopolyGame {
    public static void main(String[] args) throws FileNotFoundException {
        
        Chances []chance=new Chances[6];
        chance[0]=new Chances(2);
        chance[1]=new Chances(7);
        chance[2]=new Chances(17);
        chance[3]=new Chances(22);
        chance[4]=new Chances(33);
        chance[5]=new Chances(36);
        
        
        Taxes[] ta=new Taxes[2];
        ta[0]=new Taxes(4,"INCOME TAX",200);
        ta[1]=new Taxes(38,"LUXURY TAX",150);

        
        
        Property[] c=new Property[28];
        Property.readFromfile(c);
        
        System.out.println(c[16].getName());
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        Game game=new Game();

        Player[] p=new Player[3];
        p[0]=new Player();
        p[1]=new Player();
        p[2]=new Player();
        int dice;
        int z=1;
        while(/*Player.getNoOfPlayers()>1*/ z<15)
        {
            for(int i=0;i<Player.getNoOfPlayers();i++)
            {
                //if you want to buy a mortaged property
                //game.buyMortage(p[i]);
                
                boolean isit=false;
                int counter=0;
                do{             
                     counter++;
                    dice =(int)(Math.random()*11+2);
                    if(p[i].getIsJail())
                    {
                        p[i].incrementjailtime();
                        continue;
                    }
                    p[i].setCurrentLocation(dice);
                    for(int j=0;j<c.length;j++)  //Properties
                    {
                        if(p[i].getCurrentLocation()==c[j].getID())
                        {
                            isit=true;
                            if(c[j].Isbought())
                            {
                                int rentprice;
                                if(c[j].getID()==26||c[j].getID()==27) 
                                {
                                    p[i].decrementBalance(((waterandelec)c[j]).getRent(dice,c));
                                    rentprice=((waterandelec)c[j]).getRent(dice,c);
                                }
                                else if(c[j].getID()==22||c[j].getID()==23||c[j].getID()==24
                                        ||c[j].getID()==25)
                                {
                                    p[i].decrementBalance(((Train)c[j]).getRent(c,c[j].getOwnerid()));
                                    rentprice=((Train)c[j]).getRent(c,c[j].getOwnerid());
                                }
                                
                                else 
                                {
                                    p[i].decrementBalance(c[j].getRent());
                                    rentprice=c[j].getRent();
                                }
                                if(!c[j].isIsmortaged())
                                {
                                    p[c[j].getOwnerid()].incrementBalance(rentprice);
                                }

                            }
                            else
                            {
                                System.out.println("do u wanna buy");
                                if(p[i].getBalance()>c[j].getPrice())
                                {
                                    p[i].decrementBalance(c[j].getPrice());
                                    c[j].setOwnerid(i);
                                    p[i].setProperties(c[j]);
                                }
                            }
                        }
                    }
                    
                    
                    if(isit!=true) //Chances
                    {
                        if(p[i].getCurrentLocation()==2||p[i].getCurrentLocation()==7
                                ||p[i].getCurrentLocation()==17||p[i].getCurrentLocation()==22||
                                p[i].getCurrentLocation()==33||p[i].getCurrentLocation()==36)
                        {
                            int choice=(int)(Math.random()*3+1);
                            Chances.todo(choice, p[i]);
                        }



                        if(p[i].getCurrentLocation()==ta[0].getId()) //taxes

                        {
                            p[i].decrementBalance(ta[0].getPayment());
                        }
                        else if(p[i].getCurrentLocation()==ta[1].getPayment())
                        {
                            p[i].decrementBalance(ta[1].getPayment());
                        }
                        
                                            
                        
                    }
                }while(dice==12&&counter<=3);
            }
            z++;
        }
        
        
        
        
        
        
    }    
}
