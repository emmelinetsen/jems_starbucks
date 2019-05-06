package me.jems;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    private final String uid;
    private String card;
    private double amt;


    public Cards(){}

/*    public Cards(String uid) {
       // this.id = id;
        this.uid = uid;
        this.amt -= 2.50;
    }*/

    public Cards(String card, double amt){
//        this.card = card;
//        this.amt = amt;
        this.setCard(card);
        this.setAmt(amt);
    }

    public Cards(int id, String card, double amt ){
//        this.id = id;
//        this.card = card;
//        this.amt = amt;
        this.setId(id);
        this.setCard(card);
        this.setAmt(amt);
    }


//    public String getUid(){
//        return uid;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getAmt(){
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", card:'" + card + '\'' +
                ", amt:'" + amt + '\'' +
                '}';
    }
}
