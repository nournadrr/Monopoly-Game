package monopolygame;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.*;
public class MonopolyGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        
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
        
        //System.out.println(c[16].getName());
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        Game game=new Game();

        Player[] p=new Player[3];
        p[0]=new Player();
        p[0].setName("abdo");
        p[0].setId(1);
        p[1]=new Player();
        p[1].setName("nour");
        p[1].setId(2);
        p[2]=new Player();
        p[2].setName("youssef");
        p[2].setId(3);
        int dice=0,turnchoice, counter=0;
        while(Player.getNoOfPlayers()>1)
        {
            for(int i=0;i<p.length;i++)
            {
                do {
                    System.out.println(p[i].getName()+" turn with balance "+p[i].getBalance()+
                            "your current location is "+p[i].getCurrentLocation());
                    System.out.println("Choose\n 1:Buy mortgaged property\n 2:build a house"
                            + "\n 3:roll dice \n 4:end turn \n 5:forfeit \n 6:save and exit");
                     turnchoice=sc.nextInt();


                    switch(turnchoice) {
                        case 1:game.buyMortage(p[i]); break;
                        case 2:game.canbuild(p[i], c); break;
                        case 3: break;
                        case 4:continue;                            
                        case 5:
                            p[i].setIsPlaying(false);
                            Player.decrementPlayers();
                            break;
                        case 6:
                            
                            exit(0);

                    }
                    if(turnchoice==3)
                    {
                        
                        if(p[i].getIsPlaying()==false)
                        {
                            continue;
                        }

                        boolean isit=false;
                        //int counter=0;
                        //do{             
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
                                   System.out.println("you are now standing on : "+c[j].getName());
                                   isit=true;
                                   if(c[j].Isbought())
                                   {
                                       int rentprice;
                                       if(j==26||j==27) 
                                       {
                                           rentprice=((waterandelec)c[j]).getRent(dice,c);
                                           System.out.println("Please pay : "+rentprice);
                                           p[i].decrementBalance(rentprice);

                                       }
                                       else if(j==22||j==23||j==24||j==25)
                                       {
                                           rentprice=((Train)c[j]).getRent(c,c[j].getOwnerid());
                                           System.out.println("Please pay : "+rentprice);
                                           p[i].decrementBalance(rentprice);
                                       }

                                       else 
                                       {
                                           rentprice=c[j].getRent();
                                           System.out.println("Please pay : "+rentprice);
                                           p[i].decrementBalance(rentprice);

                                       }
                                       if(!c[j].isIsmortaged())
                                       {
                                           p[c[j].getOwnerid()].incrementBalance(rentprice);
                                       }

                                   }
                                   else
                                   {
                                       System.out.println("do u wanna buy enter yes for yes and no for no\n");
                                       String buuuyy=sc.next();
                                       if(p[i].getBalance()>c[j].getPrice()&&buuuyy.equalsIgnoreCase("yes"))
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
                                   System.out.print("u are in a chance field : ");
                                   int choice=(int)(Math.random()*3+1);
                                   Chances.todo(choice, p[i]);
                               }


                               if(p[i].getCurrentLocation()==ta[0].getId()) //taxes

                               {
                                   System.out.println("you are now standing on : "+ta[0].getName());
                                   System.out.println("Pay : "+ta[0].getPayment());
                                   p[i].decrementBalance(ta[0].getPayment());
                               }
                               else if(p[i].getCurrentLocation()==ta[1].getPayment())
                               {
                                   System.out.println("you are now standing on : "+ta[1].getName());
                                   System.out.println("Pay : "+ta[1].getPayment());
                                   p[i].decrementBalance(ta[1].getPayment());
                               }
                           }
                            System.out.println(" \n current balance is "+p[i].getBalance());
                       //}while(turnchoice!=5||turnchoice!=4||(dice==12&&counter<=3));
                    }
                
                }while(turnchoice!=5||turnchoice!=4||(dice==12&&counter<=3));
            }
        }        
    }    
}
