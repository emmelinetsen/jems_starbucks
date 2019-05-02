

package starbucks ;

/** Payments Screen */
public class Payments extends Screen
{

    public Payments(AppController c)
    {
        super(c);
    }


    /**
     * Get Display Contents
     * @return Payments Display Contents
     */
    @Override
    public String display(){
        return "Find Store \nEnable Payments";
    }

}
