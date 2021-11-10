package monopolygame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author youssef m pc
 */
public class Train extends Property{
    private int traincount;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;

    public Train(int ID, String name,String colour, int price, int rent) {
        super(ID, name, colour, price, rent);
        this.traincount = traincount;
        this.rent1 = rent1;
//        this.rent2 = rent2;
//        this.rent3 = rent3;
//        this.rent4 = rent4;
    }

    public int getTraincount() {
        return traincount;
    }

    public void setTraincount() {
        this.traincount++;
    }

    public int getRent1() {
        return rent1;
    }

    public void setRent1(int rent1) {
        this.rent1 = rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public void setRent2(int rent2) {
        this.rent2 = rent2;
    }

    public int getRent3() {
        return rent3;
    }

    public void setRent3(int rent3) {
        this.rent3 = rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public void setRent4(int rent4) {
        this.rent4 = rent4;
    }
    
   
    
    public void setrentoftrian(int rent0, int rent1 ,int rent2, int rent3) {
    switch(traincount){
        case 0:getRent1() ; break;
        case 1:getRent2();break;
        case 2:getRent3();break;
        case 3:getRent4();break;
           }
    
        
    }
   
    
    
}
