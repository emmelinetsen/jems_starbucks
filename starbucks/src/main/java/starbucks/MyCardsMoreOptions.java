

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen
{
  
    public MyCardsMoreOptions(AppController c)
    {
        super(c);
    }

    /**
     * Get Display Contents
     * @return MyCardsMoreOptions Display Contents
     */
    @Override
    public String display(){

        return  "Refresh\n"+
                "Reload\n"+
                "Auto Reload\n"+
                "Transactions";

    }

}
