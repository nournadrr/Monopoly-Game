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
public class Cities extends Property {

    private int housesprice;
    private int housecounter;
    private int renthouse;
    private int rent2;
    private int rent3;
    private int rent4;
    private int rentofhotel;

    public Cities(int housesprice, int renthouse, int rent2,
            int rent3, int rent4, int rentofhotel,
            int ID, String name, String colour, int price, int rent) {
        super(ID, name, colour, price, rent);
        this.housesprice = housesprice;
        this.housecounter = 0;
        this.renthouse = renthouse;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rentofhotel = rentofhotel;
    }

    public Cities(int housesprice, int renthouse, int rent2,
            int rent3, int rent4, int rentofhotel,
            int ID, String name, String colour, int price, int rent, boolean ismortaged, boolean isbought, int ownerid, int housecounter) {
        super(ID, name, colour, price, rent, ismortaged, isbought, ownerid);
        this.housesprice = housesprice;
        this.housecounter = housecounter;
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

    public void incrementHousecounter() {
        this.housecounter++;
    }
    
    public void decrementHousecounter() {
        this.housecounter--;
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

    public int rent() {

//        System.out.println(housecounter);
        switch (housecounter) {
            case 0:
                System.out.println("0");
                return super.getRent();
            case 1:
                System.out.println("1");
                return getRenthouse();
            case 2:
                return getRent2();
            case 3:
                return getRent3();
            case 4:
                return getRent4();
            case 5:
                return getRentofhotel();
        }
        return -1;

    }
    
    public boolean canbuild(int currentplayer,Cities c,Object[] properties)
    {
        boolean build=true;
        
        if(getHousecounter()>=5)
            build=false;
        else
        {
            for(int i=0;i<properties.length;i++)
            {
                if(properties[i].getClass().getName().equalsIgnoreCase("monopolygame.Cities"))
                {
                    if(c.getColor().equals(((Cities)properties[i]).getColor()))
                    {
                        if(currentplayer!=((Cities)properties[i]).getOwnerid())
                            build=false;
                    }
                }
            }
        }
        
        
        return build;
//        Scanner in=new Scanner(System.in);
//        System.out.println("Choose the property u want to build in");
//        int choice=in.nextInt();
//        boolean canBuild=true;
//        if(choice<=21&&choice>=0)
//        {
//            for(int i=0;i<22;i++)
//            {
//                if(((Property)pr[choice]).getColor().equalsIgnoreCase(((Property)pr[i]).getColor()))
//                {
//                    if(((Property)pr[i]).getOwnerid()!=pl.getId())
//                        canBuild=false;
//                }                        
//            }
//
//            if(canBuild&&(pl.getBalance()>((Cities)pr[choice]).getHousesprice()))
//            {
//                System.out.println("u builded a new house");
//                ((Cities)pr[choice]).setHousecounter();
//                pl.decrementBalance(((Cities)pr[choice]).getHousesprice());
//            }
//            else
//                System.out.println("u can't build");
//        }
//        
//        else
//            System.out.println("u can only build in a city");
//    }
    }

}
