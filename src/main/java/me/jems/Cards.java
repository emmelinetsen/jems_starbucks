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
    private String card;

    private String username;
    private double amt;


    public Cards(){
        card = "";
        username = "";
        amt = 0;
    }



    public Cards(String card, String username, double amt){
        this.setCard(card);
        this.setAmt(amt);
        this.setUsername(username);
    }


//    public String getUid(){
//        return uid;
//    }


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "{" +
                "user:" + username +
                ", card:'" + card + '\'' +
                ", amt:'" + amt + '\'' +
                '}';
    }
}
