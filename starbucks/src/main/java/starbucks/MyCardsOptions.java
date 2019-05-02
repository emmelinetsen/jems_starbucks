

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen
{
   
    public MyCardsOptions(AppController c)
    {
        super(c);

    }


    /**
     * Touch events
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
        // touch(3,3) from MyCardsPay screen switches to the MyCards screen
        if (y==7){
            if (x <= 3 && x > 0) {
                appController.changeScreen("MyCardsMoreOptions");
            }
        }

    }

    /**
     * Get Display Contents
     * @return MyCardOptions Display Contents
     */
    @Override
    public String display(){

        return "Reload \n"+
                "Refresh \n"+
                "More Options \n"+
                "Cancel";

    }

}
