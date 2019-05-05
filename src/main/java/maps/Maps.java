package maps;

public class Maps {

    private final String uid;
    private double lat = 20.4;
    private double lon = 1.23;


    public Maps(String uid) {
        // this.id = id;
        this.uid = uid;
    }


    public String getUid(){
        return uid;
    }

    public double getLat(){
        return lat;
    }
    public double getLon(){
        return lon;
    }
}
