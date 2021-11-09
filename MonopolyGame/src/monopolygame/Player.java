/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;

/**
 *
 * @author Dell
 */
public class Player {
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
    
    public Player()
    {
        currentLocation=0;
        properties=new Property[20];
        noOfPlayers++;
        isPlaying=true;
        balance=1500;
        numOfProperties=0;
        jailCard=false;
        isJail=false;
    }
    public void setCurrentLocation(int currentLocation)
    {
        this.currentLocation=currentLocation;
    }
    public void incrementCurrentLocation(int dice)
    {
        currentLocation+=dice;
    }
    public void decrementCurrentLocation()
    {
        currentLocation--;
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
        properties[numOfProperties]=new Property();
        properties[numOfProperties]=p;
        numOfProperties++;
    }
    public void deleteProperty(Property p)
    {
        for(int i=0;i<numOfProperties;i++)
        {
            if(properties[i].getId()==p.getId())
            {
                for(int j=i;j<numOfProperties;j++)
                {
                    properties[j]=properties[j+1];
                }
                numOfProperties--;
                break;
            }
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
    public int getNoOfPlayers()
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
    public Property[] getProperties(Property p)
    {
        return properties;
    }
    public boolean findProperty(Property p)
    {
        for(int i=0;i<numOfProperties;i++)
        {
            if(properties[i].getId()==p.getId())
            {
                return true;
            }
        }
        return false;
    }
    public boolean getJailCard()
    {
        return jailCard;
    }
}
