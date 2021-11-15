package monopolygame;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
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
    
    
    public static void savePlayer(Player[] p) throws FileNotFoundException
    {
        String name="savePlayer.txt";
        File file=new File(name);
        PrintWriter out=new PrintWriter(file);
        //save player data
        for(int i=0;i<p.length;i++)
        {
            out.print(p[i].getId()+"  "+p[i].getName()+"  "+p[i].getBalance()+"  "+p[i].getCurrentLocation()+"  "+p[i].getIsJail()+"  "+
                    p[i].getIsPlaying()+"  "+p[i].getJailCard()+"  "+p[i].getNumOfProperties());
            for(int j=0;j<p[i].getNumOfProperties();j++)
            {
                out.print(p[i].getProperties(j).getID()+"  "+p[i].getProperties(j).getName()+"  "+p[i].getProperties(j).getColor()
                        +"  "+p[i].getProperties(j).getPrice()+"  "+p[i].getProperties(j).getOwnerid()+"  "+p[i].getProperties(j).getRent()+"  "
                +p[i].getProperties(j));
            }
            out.println();
        }
        /*
        //save properties data
        for(int i=0;i<c.length;i++)
        {
            out.print(c[i].getID()+"  "+c[i].getName()+"  "+c[i].getColor()+"  "+c[i].getOwnerid()+"  "+c[i].getPrice()+"  "+c[i].getRent());
            out.println();
        }
*/
        out.close();
    }
    //Cities(int housesprice,  int renthouse, int rent2, 
            //int rent3, int rent4, int rentofhotel, 
           // int ID, String name, String colour, int price, int rent,boolean ismortaged,boolean isbought,int ownerid,int housecounter)
    public static void loadProperty(Property c[]) throws FileNotFoundException
    {
        String name="saveProperty.txt";
        File file=new File(name);
        Scanner input=new Scanner(file);
        for(int i=0;i<22;i++)
        {
            c[i]=new Cities(input.nextInt(),input.nextInt(),input.nextInt(),
            input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt(),input.next(),
                    input.next(),input.nextInt(),input.nextInt(),input.nextBoolean(),input.nextBoolean()
                    ,input.nextInt(),input.nextInt());
        }
        //Train(int ID, String name,String colour, int price, int rent,boolean ismortaged,boolean isbought,int ownerid)
        for(int i=22;i<26;i++)
        {
            c[i]=new Train(input.nextInt(),input.next(),input.next(),input.nextInt(),input.nextInt(),input.nextBoolean()
                    ,input.nextBoolean(),input.nextInt());
        }
        //waterandelec(int ID, String name, int price,boolean ismortaged,boolean isbought,int ownerid)
        for(int i=26;i<28;i++)
            c[i]=new waterandelec(input.nextInt(),input.next(),input.nextInt(),input.nextBoolean(),input.nextBoolean(),input.nextInt());
        
        input.close();
    }
    
    public static void loadPlayer(Player[] p) throws FileNotFoundException
    {
        String name="savePlayer.txt";
        File file=new File(name);
        Scanner input=new Scanner(file);
        //public Player(int id,String name,int balance,int currentLocation,boolean isJail,boolean isPlaying,boolean jailCard,int numOfProperties)
        for(int i=0;i<p.length;i++)
        {
            p[i]=new Player(input.nextInt(),input.next(),input.nextInt(),input.nextInt(),input.nextBoolean(),input.nextBoolean(),input.nextBoolean()
            ,input.nextInt(),input.nextInt());
            //properties
            for(int j=0;j<p[i].getNumOfProperties();j++)
            {
                //(p[i].getProperties(j).getID()+"  "+p[i].getProperties(j).getName()+"  "+p[i].getProperties(j).getColor()
                        //+"  "+p[i].getProperties(j).getPrice()+"  "+p[i].getProperties(j).getOwnerid()+"  "+p[i].getProperties(j).getRent())
                
                
            }
        }
        
    }
    
    public static void saveProperty(Property c[]) throws FileNotFoundException
    {
        String name="saveProperty.txt";
        File file=new File(name);
        PrintWriter out=new PrintWriter(file);
        //Cities(int housesprice,  int renthouse, int rent2, 
            //int rent3, int rent4, int rentofhotel, 
           // int ID, String name, String colour, int price, int rent,boolean ismortaged,boolean isbought,int ownerid,int housecounter)
        for(int i=0;i<22;i++)
        {
            out.print(((Cities)c[i]).getHousesprice()+"  "+((Cities)c[i]).getRenthouse()+"  "+((Cities)c[i]).getRent2()+"  "+
                    ((Cities)c[i]).getRent3()+"  "+((Cities)c[i]).getRent4()+"  "+((Cities)c[i]).getRentofhotel()+"  "+((Cities)c[i]).getID()
            +"  "+((Cities)c[i]).getName()+"  "+((Cities)c[i]).getColor()+"  "+((Cities)c[i]).getPrice()+"  "+((Cities)c[i]).getRent()
            +"  "+((Cities)c[i]).isIsmortaged()+"  "+((Cities)c[i]).Isbought()+"  "+((Cities)c[i]).getOwnerid()+"  "+((Cities)c[i]).getHousecounter());
            
            out.println();
        }
        //Train(int ID, String name,String colour, int price, int rent,boolean ismortaged,boolean isbought,int ownerid)
        for(int i=22;i<26;i++)
        {
            out.print(((Train)c[i]).getID()+"  "+((Train)c[i]).getName()+"  "+((Train)c[i]).getColor()+"  "+((Train)c[i]).getPrice()
            +"  "+((Train)c[i]).getRent()+"  "+((Train)c[i]).isIsmortaged()+"  "+((Train)c[i]).Isbought()+"  "+((Train)c[i]).getOwnerid());
            
            out.println();
        }
        //waterandelec(int ID, String name, int price,boolean ismortaged,boolean isbought,int ownerid)
        for(int i=26;i<28;i++)
        {
            out.print(((waterandelec)c[i]).getID()+"  "+((waterandelec)c[i]).getName()+"  "+((waterandelec)c[i]).getPrice()
            +"  "+((waterandelec)c[i]).isIsmortaged()+"  "+((waterandelec)c[i]).Isbought()+"  "+((waterandelec)c[i]).getOwnerid());
            
            out.println();
        }
        
        out.close();
    }
}
