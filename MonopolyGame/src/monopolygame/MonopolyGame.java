package monopolygame;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.*;
public class MonopolyGame {    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
//        ArrayList<Object> a=new ArrayList<>();
//                Property[] s=new Property[28];
//         
//         /* int Cost_Of_House, int rent_with_1_house, int rent_with_2_house, 
//            int rent_with_3_house, int rent_with_4_house, int rent_with_Hotel,
//            int id, String name, String colour, int price, int rent */
//         s[0]=new Cities(50,10,30,90,160,250,1,"MEDITERRANEAN_AVENUE","BROWN",60,2);
//         s[1]=new Cities(50,20,60,180,320,450,3,"BALTIC_AVENUE","BROWN",60,4);
//
//         s[2]=new Cities(50,30,90,270,400,550,6,"ORIENTAL_AVENUE","blue",100,6);
//         s[3]=new Cities(50,30,90,270,400,550,8,"VERMONT_AVENUE","blue",100,6);
//         s[4]=new Cities(50,40,100,300,450,600,9,"CONNECTICUT_AVENUE","blue",120,8);
//
//         s[5]=new Cities(100,50,150,450,625,750,11,"ST.CHARLES_PLACE","pink",140,10);
//         s[6]=new Cities(100,50,150,450,625,750,13,"STATES_AVENUE","pink",140,10);
//         s[7]=new Cities(100,60,180,500,700,900,14,"VIRGINIA_AVENUE","pink",160,12);
//
//         s[8]=new Cities(100,70,200,550,700,900,16,"ST.JAMES","orange",180,14);
//         s[9]=new Cities(100,70,200,550,700,950,18,"TENNESSEE_AVENUE","orange",180,14);
//         s[10]=new Cities(100,80,220,600,800,1000,19,"NEWYORK_AVENUE","orange",200,16);
//
//         s[11]=new Cities(150,90,250,700,875,1050,21,"KENTUCKY_AVENUE","red",220,18);
//         s[12]=new Cities(150,90,250,700,875,1050,23,"INDIANA_AVENUE","red",220,18);
//         s[13]=new Cities(150,100,300,750,925,1100,24,"ILLINOS_AVENUE","red",240,20);
//
//         s[14]=new Cities(150,110,330,800,975,1150,26,"ATLANTIC_AVENUE","yellow",260,22);
//         s[15]=new Cities(150,110,330,800,975,1150,27,"VENTHOR_AVENUE","yellow",260,22);
//         s[16]=new Cities(150,120,360,850,1025,1200,29,"MARVIN_GARDENS","yellow",280,24);
//
//         s[17]=new Cities(200,130,390,900,1100,1275,31,"PACIFIC_AVENUE","green",300,26);
//         s[18]=new Cities(200,130,390,900,1100,1275,32,"NORTHCAROLINA_AVENUE","green",300,26);
//         s[19]=new Cities(200,150,450,1000,1200,1400,34,"PENNSYLVANIA_AVENUE","green",320,28);
//
//         s[20]=new Cities(200,175,500,1100,1300,1500,37,"PARK_PLACE","darkblue",350,35);
//         s[21]=new Cities(200,200,600,1400,1700,2000,39,"BOARDWALK","darkblue",400,50);
//
//
//
//
//        /*
//        public Trains(int id, String name, String colour, int price, int rent) {
//        super(id, name, colour, price, rent);
//    }
//*/
//        //Property[] tr=new Property[4];
//        s[22]=new Train(5,"READING_RAILROAD","",200,25);
//        s[23]=new Train(15,"PENNSYLVANIA RAILROAD","",200,25);
//        s[24]=new Train(25,"B._&_O.","",200,25);
//        s[25]=new Train(35,"SHORT_LINE","",200,25);
//
//
//        //Property[] we=new Property[2];
//        s[26]=new waterandelec(12,"ELECTRIC COMPANY",150);
//        s[27]=new waterandelec(28,"WATER WORKS",150);
        
        
//        
//        Game.saveProperty(s);
       
        
        
        //ArrayList<Object> arraylist=new ArrayList<>();
//                Scanner sc=new Scanner(System.in);
//                Game game=new Game();
                Player[] p=null;
//                Object[] c=null;//=new Property[28];
//
//              System.out.println("enter 1 for new game or 2 to load a game");
//                int choose =sc.nextInt();
//               if(choose==2)
//               {
//                    Game.loadProperty(c);
//                    p=Game.loadPlayer(p);
//                    System.out.println(p[1].getName()+" "+p[0].getName());
//                }
//                else
//                {
//                    //Property.readFromfile(arraylist);
//                    c=Game.loadProperty(c);
//                    System.out.println(((Property)c[18]).getName());
//                    p=new Player[3];
//                    p[0]=new Player();
//                    p[0].setName("abdo");
//                    p[0].setId(1);
//                    p[1]=new Player();
//                    p[1].setName("nour");
//                    p[1].setId(2);
//                    p[2]=new Player();
//                    p[2].setName("youssef");
//                    p[2].setId(3);
//                }
//        Chances []chance=new Chances[6];
//        chance[0]=new Chances(2);
//        chance[1]=new Chances(7);
//        chance[2]=new Chances(17);
//        chance[3]=new Chances(22);
//        chance[4]=new Chances(33);
//        chance[5]=new Chances(36);
//        
//
//       System.out.println(p[1].getName());
//  
//        
//        
//
//        
//        
//        int dice=0,turnchoice, counter=0;
//        
//        while(true)//Player.getNoOfPlayers()>1)
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
//                        //case 1:game.buyMortage(p[i]); break;
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

                  new graphics();
                  //Game game=new Game();
//                  newgame n=new newgame();
                  //p=newgame.addPlayers();
//                  game.returnPlayers();
                   //p=newgame.addPlayers();
    }    
}
