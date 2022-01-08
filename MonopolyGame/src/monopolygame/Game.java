package monopolygame;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Game implements Serializable{
//    Scanner in=new Scanner(System.in);
    private static Player[] p=new Player[4];
    private static String[] filenames=new String[5];
    
//    public void buyMortage(Player p)
//    {
//        System.out.println("do you want to buy a mortaged property?");
//        String choice=in.next();
//        if(choice.equalsIgnoreCase("yes"))
//        {
//            for(int i=0;i<p.getNumOfProperties();i++)
//            {
//                if(p.getProperties(i).isIsmortaged())
//                    System.out.println(p.getProperties(i).getName()+"  ID:"+p.getProperties(i).getID());
//            }
//            System.out.println("enter id of property to buy");
//            int id=in.nextInt();
//            for(int i=0;i<p.getNumOfProperties();i++)
//            {
//                if(p.getProperties(i).getID()==id)
//                {
//                    p.getProperties(i).setIsmortaged(false);
//                    p.decrementBalance(p.getProperties(i).getPrice());
//                }
//            }
//        }
//    }
    
    
    public void canbuild(Player pl,Object[] pr) {
        Scanner in=new Scanner(System.in);
        System.out.println("Choose the property u want to build in");
        int choice=in.nextInt();
        boolean canBuild=true;
        if(choice<=21&&choice>=0)
        {
            for(int i=0;i<22;i++)
            {
                if(((Property)pr[choice]).getColor().equalsIgnoreCase(((Property)pr[i]).getColor()))
                {
                    if(((Property)pr[i]).getOwnerid()!=pl.getId())
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
    
//<<<<<<< board
    public static void rolling()
    {
        
    }
    
    public static  void roll_Dice(Player [] p,Object [] c,int dice,int counter, int i){
//=======
  //  public static  void roll_Dice(Object [] c,int dice,int counter, int i){
//>>>>>>> master
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
               if(p[i].getCurrentLocation()==((Property)c[j]).getID())
               {
                   System.out.println("you are now standing on : "+((Property)c[j]).getName());
                   isit=true;
                   if(((Property)c[j]).Isbought())
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
                           rentprice=((Train)c[j]).getRent(c,((Property)c[j]).getOwnerid());
                           System.out.println("Please pay : "+rentprice);
                           p[i].decrementBalance(rentprice);
                       }

                       else 
                       {
                           rentprice=((Property)c[j]).getRent();
                           System.out.println("Please pay : "+rentprice);
                           p[i].decrementBalance(rentprice);

                       }
                       if(!((Property)c[j]).isIsmortaged())
                       {
                           p[((Property)c[j]).getOwnerid()].incrementBalance(rentprice);
                       }

                   }
                   else
                   {
                       System.out.println("do u wanna buy enter yes for yes and no for no\n");
                       String buuuyy=sc.next();
                       if(p[i].getBalance()>((Property)c[j]).getPrice()&&buuuyy.equalsIgnoreCase("yes"))
                       {
                           p[i].decrementBalance(((Property)c[j]).getPrice());
                           ((Property)c[j]).setOwnerid(i);
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
    
    
    public static void savePlayer(Player[] p) throws FileNotFoundException, IOException
    {        
        String name="SavePlayers.bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(p);
        out.close();
    }
    public static Object[] loadProperty(Object[] c) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String name="SaveProperty.bin";
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
         c=(Object[])in.readObject();
         in.close();
         return c;
    }
    
    public static Player[] loadPlayer(Player[] p) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String name="SavePlayers.bin";
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
        p=(Player[])in.readObject();
        in.close();
        return p;
    }
    
    public static void saveProperty(Object[] c) throws FileNotFoundException, IOException
    {
        String name="SaveProperty.bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(c);
        out.close();
    }
    public void saveNewGame(String name) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        name=name+".bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
        out.writeObject(p);
        out.close();
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
        Player[] player1=new Player[4];
        player1=(Player[])in.readObject();
        filenames[0]=name;
        System.out.println("file name: "+name);
        for(int i=0;i<player1.length;i++)
        {
            System.out.println("Player: "+player1[i].getName());
        }
        
    }
    public void loadgame(String name) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        for(int i=0;i<filenames.length;i++)
        {
            //System.out.println("nour");
            if(name.equals(filenames[i]))
            {
                //System.out.println("nour");
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
                Player[] player2=new Player[4];
                player2=(Player[])in.readObject();
                System.out.println("file name: "+name);
                for(int j=0;j<player2.length;j++)
                {
                    System.out.println("Player: "+player2[j].getName());
                }
            }
        }
    }
    public void newgame(Player[] p,String name) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        this.p=p;
        saveNewGame(name);
    }
    
    public void returnPlayers()
    {
        for(int i=0;i<p.length;i++)
        {
            System.out.println("Player: "+p[i].getName());
        }
    }
}