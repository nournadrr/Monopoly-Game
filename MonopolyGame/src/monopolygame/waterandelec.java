package monopolygame;
public class waterandelec extends Property {
    private int rent;

    public waterandelec(int ID, String name, int price) {
        super(ID, name,"", price,0);
    }

    public waterandelec(int ID, String name, int price,boolean ismortaged,boolean isbought,int ownerid) {
        super(ID, name,"", price,0,ismortaged,isbought,ownerid);
    }
    
    public  int getRent(int dice,Object[] c) {
        
        if(((waterandelec)c[26]).getOwnerid()==((waterandelec)c[27]).getOwnerid())
            return 10*dice;
        else
            return 4*dice;
    }


    
   
    
    
    
    
    }
    
   
  

