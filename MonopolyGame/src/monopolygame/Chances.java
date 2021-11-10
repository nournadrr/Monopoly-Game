package monopolygame;
public class Chances {
    private int id;
    private static String []message;
    

    public Chances(int id ) {
        this.id = id;
        message[0]="go to jail";
        message[1]="take 100$";
        message[2]="pay 150$";
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
            p.setCurrentLocation(10);
        }
    }
    
}
