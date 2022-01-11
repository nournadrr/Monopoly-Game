/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolygame;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.Serializable;


/**
 *
 * @author Dell
 */
public abstract class Property implements Serializable {
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
        ownerid=-1;
    }

    public Property(int ID, String name, String colour, int price,int rent,boolean ismortaged,boolean isbought,int ownerid)
    {
        this.ID = ID;
        this.name = name;
        this.colour=colour;
        this.price = price;
        this.ismortaged = ismortaged;
        this.isbought = isbought;
        this.rent = rent;
        this.ownerid=ownerid;
    }
    
    {
        
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

    public String getColor()
    {
        return colour;
    }
    
    public void setRent(int rent) {
        this.rent = rent;
    }
    
    public static Property[] readFromfile(Property[] s) throws FileNotFoundException {
        String name="Properties.txt";
        File file=new File(name);
        Scanner input=new Scanner(file);
        for(int i=0;i<22;i++)
        {
            s[i]=new Cities(input.nextInt(),input.nextInt(),input.nextInt(),
            input.nextInt(),input.nextInt(),input.nextInt(),
            input.nextInt(),input.next(),input.next(),input.nextInt(),input.nextInt());
        }

        for(int i=22;i<26;i++)
        {
            s[i]=new Train(input.nextInt(),input.next(),input.next(),input.nextInt(),input.nextInt());
        }
        
        
        for(int i=26;i<28;i++)
            s[i]=new waterandelec(input.nextInt(),input.next(),input.nextInt());
        
        input.close();
        return s;
    }
          public static void writetofile(Property[] s) throws FileNotFoundException 
          {
              String name="Properties.txt";
              File file=new File(name);
              PrintWriter out=new PrintWriter(file);

              for(int i=0;i<22;i++)
              {
                  
                  out.print(((Cities)s[i]).getHousesprice()+" ");
                  out.print(((Cities)s[i]).getRenthouse()+" ");
                  out.print(((Cities)s[i]).getRent2()+" ");
                  out.print(((Cities)s[i]).getRent3()+" ");
                  out.print(((Cities)s[i]).getRent4()+" ");
                  out.print(((Cities)s[i]).getRentofhotel()+" ");
                  out.print(((Cities)s[i]).getID()+" ");
                  out.print(((Cities)s[i]).getName()+" ");
                  out.print(((Cities)s[i]).getColor()+" ");
                  out.print(((Cities)s[i]).getPrice()+" ");
                  out.println(((Cities)s[i]).getRent()+" ");
              }
              for(int i=22;i<26;i++)
              {
                  out.println(((Train)s[i]).getID()+" "+((Train)s[i]).getName()+" "+
                          ((Train)s[i]).getColor()+" "+((Train)s[i]).getPrice()+" "+((Train)s[i]).getRent());
              }
              for(int i=26;i<28;i++)
              {
                  out.println(((waterandelec)s[i]).getID()+" "+((waterandelec)s[i]).getName()+" "+((waterandelec)s[i]).getPrice());
              }
              out.close();
          }

    @Override
    public String toString() {
        return getName();
    }
          


 
}

