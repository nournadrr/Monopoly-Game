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
public class Jail {
    Scanner in=new Scanner(System.in);
    private int id;
    private static int jailTime;
    private Player[] players;
    private int noOfPlayers;
    private int counter;
    
    public Jail()
    {
        counter=0;
        jailTime=2;
        players=new Player[10];
        noOfPlayers=0;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setPlayers(Player p)
    {
        players[noOfPlayers]=new Player();
        players[noOfPlayers]=p;
        noOfPlayers++;
    }
    public void deletePlayer(Player p)
    {
        for(int i=0;i<noOfPlayers;i++)
        {
            if(players[i].getId()==p.getId())
            {
                for(int j=i;j<noOfPlayers;j++)
                {
                    players[j]=players[j+1];
                }
                noOfPlayers--;
                break;
            }
        }
    }
    public int getId()
    {
        return id;
    }
    public int getJailTime()
    {
        return jailTime;
    }
    public Player[] getPlayers()
    {
        return players;
    }
    public int getNoOfPlayers()
    {
        return noOfPlayers;
    }
    public void goToJail(Player p)
    {
        //if player does not have a card
        if(p.getJailCard()==false)
        {
        String choice;
        System.out.println("do you want to pay 50$ to skip jail?");
        choice=in.nextLine();
        if( choice=="no")
        {
            //player is in jail
            p.setIsJail(true);
            //makes the player a non player for 2 rounds
            p.setIsPlaying(false);
        }
        //player pays
        else if(choice=="yes")
        {
            p.decrementBalance(50);
        }
        }
        //player uses jail card
        else if(p.getJailCard())
        {
            //remove jail card
            p.setJailCard(false);
        }
    }
    public void outOfjail(Player p)
    {
        p.setIsJail(false);
        p.setIsPlaying(true);
        deletePlayer(p);
    }
    
}
