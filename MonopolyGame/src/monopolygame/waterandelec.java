package monopolygame;
public class waterandelec extends Property {
    private int rent;

    public waterandelec(int ID, String name, int price) {
        super(ID, name,"", price,0);
    }

    public  int getRent(int dice,Property[] c) {
        
        if(c[26].getOwnerid()==c[27].getOwnerid())
            return 10*dice;
        else
            return 4*dice;
    }

//    public void setRent(int dice) {
//        this.rent = dice*4;
//    }
    
   
    
    
    
    
    }
    
   
  

