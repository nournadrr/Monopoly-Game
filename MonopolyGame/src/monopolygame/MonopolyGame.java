package monopolygame;
import java.util.*;
public class MonopolyGame {
    public static void main(String[] args) {
        
        
        
        
        
        
        Property[] c=new Property[28];
        
        
        /* int Cost_Of_House, int rent_with_1_house, int rent_with_2_house, 
            int rent_with_3_house, int rent_with_4_house, int rent_with_Hotel,
            int id, String name, String colour, int price, int rent */
         c[0]=new Cities(50,10,30,90,160,250,1,"PROFILE","purple",60,2);
         c[1]=new Cities(50,20,60,180,320,450,3,"RANK","purple",60,4);
        
         c[2]=new Cities(50,30,90,270,400,550,6,"SCORE BOARD","blue",100,6);
         c[3]=new Cities(50,30,90,270,400,550,8,"SCORE","blue",100,6);
         c[4]=new Cities(50,40,100,300,450,600,9,"FEEDBACK","blue",120,8);
        
         c[5]=new Cities(100,50,150,450,625,750,11,"TERMINATOR","orange",140,10);
         c[6]=new Cities(100,50,150,450,625,750,13,"ASSASSIN","orange",140,10);
         c[7]=new Cities(100,60,180,500,700,900,14,"FOG OF WAR","orange",160,12);
       
         c[8]=new Cities(100,70,200,550,700,900,16,"PRIVATE MESSAGING","green",180,14);
         c[9]=new Cities(100,70,200,550,700,950,18,"IGNORE LIST","green",180,14);
         c[10]=new Cities(100,80,220,600,800,1000,19,"ACCOUNT NAME","green",200,16);
        
         c[11]=new Cities(150,90,250,700,875,1050,21,"CARTOS","red",220,18);
         c[12]=new Cities(150,90,250,700,875,1050,23,"TOURNEY DIRECTORS","red",220,18);
         c[13]=new Cities(150,100,300,750,925,1100,24,"HUNTERS","red",240,20);
        
         c[14]=new Cities(150,110,330,800,975,1150,26,"HELP","yellow",260,22);
         c[15]=new Cities(150,110,330,800,975,1150,27,"RULES","yellow",260,22);
         c[16]=new Cities(150,120,360,850,1025,1200,29,"FAQ","yellow",280,24);
        
         c[17]=new Cities(200,130,390,900,1100,1275,31,"MAP FOUNDRY","pink",300,26);
         c[18]=new Cities(200,130,390,900,1100,1275,32,"FLAME WARS","pink",300,26);
         c[19]=new Cities(200,150,450,1000,1200,1400,34,"GENERAL DISCUSSION","pink",320,28);
        
         c[20]=new Cities(200,175,500,1100,1300,1500,37,"MODS","darkblue",350,35);
         c[21]=new Cities(200,200,600,1400,1700,2000,39,"ADMINS","darkblue",400,50);




        /*
        public Trains(int id, String name, String colour, int price, int rent) {
        super(id, name, colour, price, rent);
    }
*/
        //Property[] tr=new Property[4];
        c[22]=new Train(5,"READING RAILROAD","",200,25);
        c[23]=new Train(15,"PENNSYLVANIA RAILROAD","",200,25);
        c[24]=new Train(25,"B. & O.","",200,25);
        c[25]=new Train(35,"SHORT LINE","",200,25);

        
        //Property[] we=new Property[2];
        c[26]=new waterandelec(12,"ELECTRIC COMPANY",150);
        c[27]=new waterandelec(28,"WATER WORKS",150);
        
        Taxes[] ta=new Taxes[2];
        ta[0]=new Taxes(4,"INCOME TAX",200);
        ta[1]=new Taxes(38,"LUXURY TAX",150);

        
        
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        Player[] p=new Player[3];
        p[0]=new Player();
        p[1]=new Player();
        p[2]=new Player();
        int dice;
        
        while(Player.getNoOfPlayers()>1) //Active players
        {
            for(int i=0;i<Player.getNoOfPlayers();i++) // each players turn
            {
                boolean isit=false;
                dice =(int)(Math.random()*12);
                if(p[i].getIsJail())   // check if player is jailed
                {
                    p[i].incrementjailtime();
                    continue;
                }
                p[i].setCurrentLocation(dice);
                for(int j=1;j<c.length;j++)  //Properties
                {
                    if(p[i].getCurrentLocation()==c[j].getID())// loop for properties
                    {
                        isit=true;
                        if(c[j].Isbought())  //check if property is owned by other players
                        {
                            p[i].decrementBalance(c[j].getRent());
                            int ownerid=c[j].getOwnerid();
                            p[ownerid].incrementBalance(c[j].getRent());
                        }
                        else
                        {
                            System.out.println("do u wanna buy");
                            if(p[i].getBalance()>c[j].getPrice())
                            {
                                p[i].decrementBalance(c[j].getPrice());
                                c[j].setOwnerid(i);
                                p[i].setProperties(j);
                            }
                        }
                    }
                }
                if(isit!=true) //Chances
                {
                    if(p[i].getCurrentLocation()==2||p[i].getCurrentLocation()==7||p[i].getCurrentLocation()==17||p[i].getCurrentLocation()==22||
                            p[i].getCurrentLocation()==33||p[i].getCurrentLocation()==36)
                        
                }
                if(isit!=true) //Pay taxes
                {
                    if(p[i].getCurrentLocation()==ta[0].getId())
                    {
                        p[i].decrementBalance(ta[0].getPayment());
                    }
                    else if(p[i].getCurrentLocation()==ta[1].getPayment())
                    {
                        p[i].decrementBalance(ta[1].getPayment());
                    }
                }
            }
        }
        
        
        
        
        
        
    }    
}
