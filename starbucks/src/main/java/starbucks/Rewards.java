

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen
{

    public Rewards(AppController c)
    {
        super(c);
    }


    /**
     * Get Display Contents
     * @return Rewards Display Contents
     */
    @Override
    public String display(){
        return "Make Every \nVisit Count";
    }

}
