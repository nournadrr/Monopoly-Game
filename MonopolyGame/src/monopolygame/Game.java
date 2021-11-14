package monopolygame;
import java.util.*;
public class Game {
    Scanner in=new Scanner(System.in);
    
    
    public void buyMortage(Player p)
    {
        System.out.println("do you want to buy a mortaged property?");
        String choice=in.next();
        if(choice.equals("yes"))
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
        }
        
        else
            System.out.println("u can only build in a city");
    }
    
    public void dice(Player p) {
        //(int)(Math.random()*12+1)
        for(int i=0;i<3;i++)
        {
            int dice=(int)(Math.random()*12+1);
            
            if(dice!=12)
                break;
        }
    }
    

}
