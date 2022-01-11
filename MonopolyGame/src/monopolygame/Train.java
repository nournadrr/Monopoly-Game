package monopolygame;
public class Train extends Property{


    public Train(int ID, String name,String colour, int price, int rent) {
        super(ID, name, colour, price, rent);

    }


    public Train(int ID, String name,String colour, int price, int rent,boolean ismortaged,boolean isbought,int ownerid) {
        super(ID, name, colour, price, rent,ismortaged,isbought,ownerid);

    }
    
   
    
    public int getRent(Object[] pr,int ownerID) {
        int traincount=0;
        for(int i=22;i<=25;i++)
        {
            if(ownerID==((Property)pr[i]).getOwnerid())
                traincount++;
        }
        
    switch(traincount){
        case 1:return 25;
        case 2:return 50;
        case 3:return 100;
        case 4:return 200;
           };
           return 0;
    
    
        
    }
   
    
    
}
