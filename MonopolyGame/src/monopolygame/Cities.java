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
public class Cities extends Property{
    private int housesprice;
 private int housecounter;
 private int renthouse;
 private int rent2;
 private int rent3;
 private int rent4;
 private int rentofhotel;

 
/* int Cost_Of_House, int rent_with_1_house, int rent_with_2_house, 
            int rent_with_3_house, int rent_with_4_house, int rent_with_Hotel,
            int id, String name, String colour, int price, int rent */ 
 
 
    public Cities(int housesprice,  int renthouse, int rent2, 
            int rent3, int rent4, int rentofhotel, 
            int ID, String name, String colour, int price, int rent) {
        super(ID, name,colour, price, rent);
        this.housesprice = housesprice;
        this.housecounter = 0;
        this.renthouse = renthouse;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rentofhotel = rentofhotel;
    }

 

    public int getHousesprice() {
        return housesprice;
    }

    public void setHousesprice(int housesprice) {
        this.housesprice = housesprice;
    }

    public int getHousecounter() {
        return housecounter;
    }

    public void setHousecounter() {
        this.housecounter ++;
    }

    
    public int getRenthouse() {
        return renthouse;
    }

    public void setRenthouse(int renthouse) {
        this.renthouse = renthouse;
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

    public int getRentofhotel() {
        return rentofhotel;
    }

    public void setRentofhotel(int rentofhotel) {
        this.rentofhotel = rentofhotel;
    }
public void rent(){
 
    switch(housecounter)
    {
        case 0:super.getRent();break;
        case 1:getRenthouse();break;
        case 2:getRent2();break;
        case 3:getRent3();break;
        case 4:getRent4();break;
        case 5:getRentofhotel();break;
    }
   
        
    }


}

