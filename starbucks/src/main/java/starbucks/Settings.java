

package starbucks;

/** Settings Screen */
public class Settings extends Screen
{
   
    public Settings(AppController c)
    {
       super(c);
    }

    /**
     * Get display contents
     * @return Display Contents
     */
    public String display(){

        return "Add Card\nDelete Card\nBilling\nPasscode\n\nAbout|Terms\nHelp";
    }

    /**
     * Send Touch Events to AppController instance
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
        System.err.println("KeyPad MyCards Touched at (" + x + ", " + y + ")");

        if ( (y==1) && (x<4 && x>=1) ){
            //   AppController.getInstance().setCurrentScreen(new AddCard());
            appController.setPreviousScreen();
            appController.changeScreen("AddCard");
        }

    }

   
}
