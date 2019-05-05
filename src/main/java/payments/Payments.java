package payments;

public class Payments {


    private final String uid;
    private double balance = 20.0;


    public Payments(String uid) {
       // this.id = id;
        this.uid = uid;
        this.balance -= 2.50;
    }


    public String getUid(){
        return uid;
    }

    public double getBalance(){
        return balance;
    }
}
