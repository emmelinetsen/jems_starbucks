package me.jems;

import javax.persistence.*;

@Entity
@Table
public class Maps {

    @Id
    private String store_address;

    private String city;

    public Maps() {


    }

    public Maps(String store_address, String city) {
        this.setCity(city);
        this.setStoreLocation(store_address);
    }


    public String getCity() {
        return city;
    }

    public String getstore_address() {
        return store_address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStoreLocation(String store_address) {
        this.store_address = store_address;
    }

    @Override
    public String toString() {
        return "store_address:'" + store_address + "store_city:" + city + '}';
    }
}