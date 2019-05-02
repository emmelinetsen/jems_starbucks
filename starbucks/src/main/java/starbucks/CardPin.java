package starbucks;

/*** Card Pin for Add Card */
public class CardPin implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 0 ;
    private int displayCount = 0 ;
    private  int cardIdCount ;
    protected String cardPin = "" ;

    /**
     * Touch Event
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y)
    {
        if ( count > 4)
        {
//            System.err.println( "Card Pin Touched at (" + x + ", " + y + ")" ) ;
        }
        else
        {

            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
    }

    /**
     * Set Next Touch Handler
     * @param next Touch Event Handler
     */
    public void setNext( ITouchEventHandler next)
    {
        nextHandler = next ;
    }


    /**
     * Display "Echo Feedback" on Card Number entered so far
     * @return Passcode String for Display
     */
    public String display()
    {
//        System.err.println( "displayCount: " + displayCount + "cardPin at display " + cardPin) ;
        return "[" + cardPin + "]";

    }

    /**
     * Add Sub Component (Not used)
     * @param c Sub Component to Add
     */
    public void addSubComponent( IDisplayComponent c )
    {

    }

    /**
     * Key Event Update
     * @param c   Count of Keys So Far
     * @param key Last key Pressed
     */
    public void keyEventUpdate( int c, String key )
    {
//        System.err.println( "Card Number Pin: " + cardPin + " key " + key + " count: "+ count + " " + c) ;

        cardIdCount = c ;

        // setting count for the display() method switch statement
        if (count <= 2) {
            if (key.equals("X")){ // if backspace
                cardPin = cardPin.substring(0,cardPin.length()-1);
                count--;
            }
            else {
                cardPin = cardPin.concat(key);
                count ++;
            }

        }


    }

    /**
     * Returns whether card is valid
     * Card if valid when there are 11 digits in card ID and 3 digits in card pin
     * @return True if valid card
     */
    public boolean validCard (){

        return (cardIdCount >= 12 && count >= 2);
    }
}


