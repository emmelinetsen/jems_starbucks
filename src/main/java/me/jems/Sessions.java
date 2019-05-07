package me.jems;


import javax.persistence.*;

@Entity
@Table
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int session_id;

    private String username;


    public Sessions(){
    }

    public Sessions(String username) {
        this.username = username;
    }


    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
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
                "session_id=" + session_id +
                ", username=" + username + "}";
    }

}
