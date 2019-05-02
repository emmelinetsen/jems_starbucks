

package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen
{

   /** public MyCards()
    {
    }**/

    public MyCards(AppController c)
    {
        super(c);
    }

    /**
     * Get Display Contents
     * @return Display Contents
     */
    public String display() {
        String value = "$";
       // value += String.format("%.2f", cardValue);
        value += String.format("%.2f", this.appController.cardAmount());
        return value;
    }

    /**
     * Send Touch Events to AppController instance
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
//        System.err.println("KeyPad MyCards Touched at (" + x + ", " + y + ")");

        // touch(3,3) from MyCards screen switches to the MyCardsPay screen
        if (x == 3 && y == 3) {
          //  AppController.getInstance().setCurrentScreen(new MyCardsPay());
            appController.changeScreen("MyCardsPay");
        }

        // touch(3,3) from MyCards screen switches to the MyCardsPay screen
        if (x == 2 && y == 4) {
            appController.changeScreen("MyCardsOptions");
           // AppController.getInstance().setCurrentScreen(new MyCardsOptions());
        }
    }


}
