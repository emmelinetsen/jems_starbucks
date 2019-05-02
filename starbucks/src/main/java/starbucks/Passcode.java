

package starbucks ;

/** Passcode Screen Component */
public class Passcode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 0;
    private boolean invalid = false;

    /**
     * Touch Event Ignored by Passcode
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y) 
    {
        if ( y==2 )
        {
//            System.err.println( "Passcode Touched at (" + x + ", " + y + ")" ) ;
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
     * Display "Echo Feedback" on Pins enterred so far
     * @return Passcode String for Display
     */
    public String display() 
    {
        String value = "";
        if ( invalid ){
            value += "  Invalid Pin";
        }

//        System.err.println("Count "+ count);
        switch ( count )
        {
            case 0: value += "\n\n [_][_][_][_]" ; break ;
            case 1: value += "\n\n [*][_][_][_]" ; break ;
            case 2: value += "\n\n [*][*][_][_]" ; break ;
            case 3: value += "\n\n [*][*][*][_]" ; break ;
            case 4: value += "\n\n [*][*][*][*]" ; break ;
            default: value += "\n\n [_][_][_][_]" ; break ;
        }
//        System.err.println("Value "+ value);

        return value  ;
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

        count = c ;
//        System.err.println( "Key: " + key ) ;

        // reset count if previous passcode was invalid
        if (invalid){
            count = 0 ;
            invalid = false ;
        }
        else if ( (count % 4 == 0) && count != 0){
            count = 0;
            invalid = true;
        }
    }
}
