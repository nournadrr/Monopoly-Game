package monopolygame;
public class Chances {
    private int id;
    private static String []message;
    

    public Chances(int id) {
        this.id = id;
        message=new String[3];
        message[0]=new String("go to jail");
        message[1]=new String("take 100$");
        message[2]=new String("pay 150$");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String[] getMessage() {
        return message;
    }

    public static void setMessage(String[] message) {
        Chances.message = message;
    }
    public static void todo(int i,Player p)
    {
        if(i==0)
        {
            System.out.println("go to jail");
            p.setCurrentLocation(30);
        }
        else if(i==1)
        {
            System.out.println("take 100$");
            p.incrementBalance(100);
        }
        else if(i==2)
        {
            System.out.println("pay 150$");
            p.decrementBalance(150);

        }
    }
    
}
