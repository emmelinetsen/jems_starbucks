
package starbucks;

//import javax.smartcardio.Card;

// import java.security.Key;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen
{
    private KeyPad kp;
    private PinScreen ps ;
    private Spacer sp ;
    private CardNumber cn ;
    private CardPin cp;

    boolean pin = false; // boolean to focus on pin


    public AddCard(AppController c)
    {
        super(c);

        kp = new KeyPad() ;
        cn = new CardNumber();
        cp = new CardPin();
        sp = new Spacer() ;
        ps = new PinScreen(new AppController()) ;

        // setup the composite pattern
        ps.addSubComponent( cn ) ;
        ps.addSubComponent( cp ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;


        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( cn ) ;



    }

    /**
     * Get Display Contents
     * @return Display Contents
     */
    public String display() {
        return ps.display();
    }

    /**
     * Determine what the focus of the card should be
     * Sets pin = true if the focus on AddCard should be on the card pin
     * @param x Touch X Coordinate
     * @param y Touch Y Coordinate
     */
    private void checkFocus(int x, int y){
        // Changing focus to card pin
        if (x==2 && y==3){
            pin = true;
            // removing card number as observer
            ((IKeyPadSubject)kp).removeObserver( cn );

            // adding card pin as observer
            ((IKeyPadSubject)kp).attach( cp ) ;
        }

    }

    /**
     * Send Touch Events to appController
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {

        checkFocus(x, y);

        if (!pin || y==2){
            // Default will focus on card ID entry
            ps.touch(x,y);
        }
        // Focus on pin
        if (pin){
            cp.touch(x,y);
            if (y==2){ // switching focus to card ID
                pin = false;

                // removing card pin as observer
                ((IKeyPadSubject)kp).removeObserver( cp );

                // adding card number as observer
                ((IKeyPadSubject)kp).attach( cn ) ;

            }

        }


        if (cp.validCard()){
            appController.setNextScreen("MyCards",cn.cardNum);
        }
        else
            appController.setNextScreen("AddCard", "");
    }

}
