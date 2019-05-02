package starbucks;

/** Card Number for Add Card **/
public class CardNumber implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 1;
    protected String cardNum = "";


    /**
     * Touch Event
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y)
    {
        if ( count > 9)
        {
//            System.err.println( "Card Number Touched at (" + x + ", " + y + ")" ) ;
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
        return "[" + cardNum + "]";

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
//        System.err.println( "Card Number Key: " + cardNum + " key " + key +
//                " c " + c + " count " + count) ;


        // setting count for the display() method switch statement
        if (count <= 9){
            if(key.equals("X")){ // if backspace
                cardNum = cardNum.substring(0,cardNum.length()-1);
                count--;
            }
            else {
                cardNum = cardNum.concat(key);
                count++;
            }
        }

    }
}


