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
public abstract class Property {
private int ID;
 private String name;
 private int price;
 private boolean ismortaged;
 private boolean isbought;
 private int ownerid;
 private int rent;
 private String colour;
 
 //super(ID, name,colour, price, rent);
    public Property(int ID, String name, String colour, int price,int rent) {
        this.ID = ID;
        this.name = name;
        this.colour=colour;
        this.price = price;
        this.ismortaged = false;
        this.isbought = false;
        this.rent = rent;
    }
 
 
 
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isIsmortaged() {
        return ismortaged;
    }

    public void setIsmortaged(boolean ismortaged) {
        this.ismortaged = ismortaged;
    }

    public boolean Isbought() {
        return isbought;
    }

    public void setIsbought(boolean isbought) {
        this.isbought = isbought;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
 
 
 
}

