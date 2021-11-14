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
        /* int Cost_Of_House, int rent_with_1_house, int rent_with_2_house, 
            int rent_with_3_house, int rent_with_4_house, int rent_with_Hotel,
            int id, String name, String colour, int price, int rent */
        for(int i=0;i<22;i++)
        {
            s[i]=new Cities(input.nextInt(),input.nextInt(),input.nextInt(),
            input.nextInt(),input.nextInt(),input.nextInt(),
            input.nextInt(),input.next(),input.next(),input.nextInt(),input.nextInt());
        }
        /*
        public Trains(int id, String name, String colour, int price, int rent) {
        super(id, name, colour, price, rent);
    }
*/
        for(int i=22;i<26;i++)
        {
            s[i]=new Train(input.nextInt(),input.next(),input.next(),input.nextInt(),input.nextInt());
        }
        
        //c[26]=new waterandelec(12,"ELECTRIC COMPANY",150);
        
        for(int i=26;i<28;i++)
            s[i]=new waterandelec(input.nextInt(),input.next(),input.nextInt());
        
        input.close();
        return s;
    }
          public static void writetofile(Property[] s) throws FileNotFoundException 
          {
              PrintWriter out=new PrintWriter("Properties.txt");
              /* int Cost_Of_House, int rent_with_1_house, int rent_with_2_house, 
            int rent_with_3_house, int rent_with_4_house, int rent_with_Hotel,
            int id, String name, String colour, int price, int rent */
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
                  out.print(((Cities)s[i]).getRent()+" ");
              }
              for(int i=22;i<26;i++)
              {
                  out.print(((Train)s[i]).getID()+" "+((Train)s[i]).getName()+" "+
                          ((Train)s[i]).getColor()+" "+((Train)s[i]).getPrice()+" "+((Train)s[i]).getRent());
              }
              for(int i=26;i<28;i++)
              {
                  out.print(((waterandelec)s[i]).getID()+" "+((waterandelec)s[i]).getName()+" "+((waterandelec)s[i]).getPrice());
              }
          }


 
}

