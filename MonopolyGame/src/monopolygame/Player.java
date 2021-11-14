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
public class Player {
    Game g;
    Scanner in=new Scanner(System.in);
    private int currentLocation;
    private String name;
    private int id;
    private Property[] properties;

    private int numOfProperties;
    private static int noOfPlayers=0;
    private boolean isPlaying;
    private boolean isJail;
    private int balance;
    private boolean jailCard;
    private int jailtime;
    
    public Player()
    {
        currentLocation=0;
        properties=new Property[28];

        noOfPlayers++;
        isPlaying=true;
        balance=1500;
        numOfProperties=0;
        jailCard=false;
        isJail=false;
        jailtime=0;
    }
    public void setCurrentLocation(int currentLocation)
    {
        this.currentLocation=currentLocation;
        if(currentLocation==30)
            isJail=true;
    }
    public void incrementCurrentLocation(int dice)
    {
        for(int i=0;i<dice;i++)
        {
            currentLocation=(currentLocation+1)%39;
            if(currentLocation==0)
                incrementBalance(250);
        }
        if(currentLocation==30)
            isJail=true;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setProperties(Property p)
    {
        properties[numOfProperties++]=p;

    }
    public void incrementjailtime()
    {
        jailtime++;
        if(jailtime==2)
        {
            jailtime=0;
            isJail=false;
        }
        
    }

    public void decrementPlayers()
    {
        noOfPlayers--;
    }
    public void setIsPlaying(boolean playing)
    {
        isPlaying=playing;
    }
    public void setIsJail(boolean jail)
    {
        isJail=jail;
    }
    public void incrementBalance(int amount)
    {
        balance+=amount;
    }
    public void decrementBalance(int amount)
    {
        
        balance-=amount;
        if(balance<0)
        {
            while(balance<0)
            {
                boolean choice=false;
                for(int i=0;i<numOfProperties;i++)
                {
                    if(properties[i].isIsmortaged()==false)
                    {
                        choice=true;
                        break;
                    }
                }
                if(choice)
                {
                    mortage();
                }
                else
                {
                    isPlaying=false;
                    noOfPlayers--;
                    break;
                }
            }
        }
        
    }
    public void mortage()
    {
        int numberOfProperty=in.nextInt();
        if(properties[numberOfProperty].getOwnerid()==this.id)
        {
            if(properties[numberOfProperty].isIsmortaged()==false)
            {
                properties[numberOfProperty].setIsmortaged(true);
                incrementBalance(properties[numberOfProperty].getPrice()); 
            }
        }
    }
    public void setJailCard(boolean card)
    {
        jailCard=card;
    }
    public int getCurrentLocation()
    {
        return currentLocation;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public int getNumOfProperties()
    {
        return numOfProperties;
    }
    public static int getNoOfPlayers()
    {
        return noOfPlayers;
    }
    public boolean getIsPlaying()
    {
        return isPlaying;
    }
    public boolean getIsJail()
    {
        return isJail;
    }
    public int getBalance()
    {
        return balance;
    }
    public Property getProperties(int i)
    {
        return properties[i];
    }
  
    /*
    public boolean findProperty(int id)
    {
        for(int i=0;i<numOfProperties;i++)
        {
            if(properties[i].getID()==id)

            {
                return true;
            }
        }
        return false;
    }
*/

    public boolean getJailCard()
    {
        return jailCard;
    }
}
