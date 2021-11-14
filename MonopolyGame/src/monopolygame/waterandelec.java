/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolygame;

/**
 *
 * @author youssef m pc
 */
public class waterandelec extends Property {
    private int rent;

    public waterandelec(int ID, String name, int price) {
        super(ID, name,"", price,0);
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int dice) {
        this.rent = dice*4;
    }
    
   
    
    
    
    
    }
    
   
  

