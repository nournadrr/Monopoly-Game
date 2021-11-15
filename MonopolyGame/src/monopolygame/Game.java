package monopolygame;
import java.util.*;
public class Game {
    Scanner in=new Scanner(System.in);
    
    
    public void buyMortage(Player p)
    {
        System.out.println("do you want to buy a mortaged property?");
        String choice=in.next();
        if(choice.equalsIgnoreCase("yes"))
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
    
    
    public void canbuild(Player pl,Property[] pr) {
        System.out.println("Choose the property u want to build in");
        int choice=in.nextInt();
        boolean canBuild=true;
        if(choice<=21&&choice>=0)
        {
            for(int i=0;i<22;i++)
            {
                if(pr[choice].getColor().equalsIgnoreCase(pr[i].getColor()))
                {
                    if(pr[i].getOwnerid()!=pl.getId())
                        canBuild=false;
                }                        
            }

            if(canBuild&&(pl.getBalance()>((Cities)pr[choice]).getHousesprice()))
            {
                System.out.println("u builded a new house");
                ((Cities)pr[choice]).setHousecounter();
                pl.decrementBalance(((Cities)pr[choice]).getHousesprice());
            }
            else
                System.out.println("u can't build");
        }
        
        else
            System.out.println("u can only build in a city");
    }
    
    public static  void roll_Dice(Player [] p,Property [] c,int dice,int counter, int i){
        Scanner sc=new Scanner(System.in);

        Taxes[] ta=new Taxes[2];
        ta[0]=new Taxes(4,"INCOME TAX",200);
        ta[1]=new Taxes(38,"LUXURY TAX",150);
                        
        if(p[i].getIsPlaying()==false)
        {
            return;
        }
        boolean isit=false;
        //int counter=0;
        do{             
            counter++;
           dice =(int)(Math.random()*11+2);
           if(p[i].getIsJail())
           {
               p[i].incrementjailtime();
               continue;
           }
            System.out.println("your dice is: "+dice);
           p[i].incrementCurrentLocation(dice);
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
       }while((dice==12&&counter<=3));
        
    }
    

}
