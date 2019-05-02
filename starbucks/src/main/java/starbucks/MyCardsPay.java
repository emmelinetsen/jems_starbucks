

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen
{


    public MyCardsPay(AppController c)
    {
        super(c);
    }

    /**
     * Get Display Contents
     * @return MyCardsPay Display Contents
     */
    public String display() {
        String value = "[";
        value += this.appController.cardNumber();
        value += "]";
        value += "\n\n\nScan Now";

        return value;
    }

    /**
     * Touch Events. Direct to the correct screens
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
//        System.err.println( "KeyPad MyCardsPay Touched at (" + x + ", " + y + ")" ) ;

        // touch(3,3) from MyCardsPay screen switches to the MyCards screen
        if (x==3 && y==3){
            appController.changeScreen("MyCards");
        }

        // making payments
        if (y == 2){
            if(x==2 || x==3){
                appController.setNextScreen("MyCards", "pay");
            }
        }



    }
}

