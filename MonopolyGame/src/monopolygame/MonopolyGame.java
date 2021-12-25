package monopolygame;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.*;
public class MonopolyGame {    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        new board();
//        Scanner sc=new Scanner(System.in);
//        Game game=new Game();
//        Player[] p=new Player[3];
//        Property[] c=new Property[28];
//
//        System.out.println("enter 1 for new game or 2 to load a game");
//        int choose =sc.nextInt();
//        if(choose==2)
//        {
//            Game.loadProperty(c);
//            Game.loadPlayer(p,c);
//
//        }
//        else
//        {
//            Property.readFromfile(c);
//            p[0]=new Player();
//            p[0].setName("abdo");
//            p[0].setId(1);
//            p[1]=new Player();
//            p[1].setName("nour");
//            p[1].setId(2);
//            p[2]=new Player();
//            p[2].setName("youssef");
//            p[2].setId(3);
//        }
//        Chances []chance=new Chances[6];
//        chance[0]=new Chances(2);
//        chance[1]=new Chances(7);
//        chance[2]=new Chances(17);
//        chance[3]=new Chances(22);
//        chance[4]=new Chances(33);
//        chance[5]=new Chances(36);
//        
//  
//        
//        
//
//        
//        
//        int dice=0,turnchoice, counter=0;
//        
//        while(Player.getNoOfPlayers()>1)
//        {
//            for(int i=0;i<p.length;i++)
//            {
//                boolean endGame=false;
//                boolean rolldice=false;
//                do {
//                    System.out.println(p[i].getName()+" turn with balance "+p[i].getBalance()+
//                            "your current location is "+p[i].getCurrentLocation());
//                    if(!rolldice)
//                    System.out.println("Choose\n 1:Buy mortgaged property\n 2:build a house"
//                            + "\n 3:roll dice \n 4:end turn \n 5:forfeit \n 6:save and exit");
//                    else
//                        System.out.println("Choose\n 1:Buy mortgaged property\n 2:build a house"
//                            + "\n 4:end turn \n 5:forfeit \n 6:save and exit");
//
//                     turnchoice=sc.nextInt();
//
//                     if(turnchoice==3&&rolldice)
//                     {
//                         break;
//                     }
//                    switch(turnchoice) {
//                        case 1:game.buyMortage(p[i]); break;
//                        case 2:game.canbuild(p[i], c); break;                     
//                        case 3:Game.roll_Dice(p,c,dice,counter,i);rolldice=true; break;                      
//                        case 4:endGame=true;break;                            
//                        case 5:
//                            p[i].setIsPlaying(false);
//                            Player.decrementPlayers();
//                            break;
//                        case 6:  
//                            Game.savePlayer(p);
//                            Game.saveProperty(c);
//                            exit(0);
//                    }
//                }while(!endGame && (turnchoice!=5||turnchoice!=4||(dice==12&&counter<=3)));
//            }
//        }        
    }    
}
