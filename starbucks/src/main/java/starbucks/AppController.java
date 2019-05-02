package starbucks ;

//import com.sun.source.tree.IfTree;

/**
 * Main App Controller Class
 */
public class AppController implements IApp {

    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IScreen settings ;
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doStore ;
    private IMenuCommand displaySettings ;
    private IFrame frame ;

    private double value;
    private boolean isNext = false;
    private String card = "000000000";

    public AppController() {
        mycards = new MyCards(this ) ;
        store = new Store( this ) ;
        rewards = new Rewards( this ) ;
        payments = new Payments( this ) ;
        settings = new Settings( this );
        frame = new Frame( mycards ) ;

        // setup command pattern
        displayMyCards  = new MenuCommand() ;
        displayPayments = new MenuCommand() ;
        displayRewards  = new MenuCommand() ;
        doStore         = new MenuCommand() ;
        displaySettings = new MenuCommand() ;
        displayMyCards.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( mycards ) ;
                    }
                }
        ) ;
        displayPayments.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( payments ) ;
                    }
                }
        ) ;
        displayRewards.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( rewards ) ;
                    }
                }
        ) ;
        doStore.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( store ) ;
                    }
                }
        ) ;
        displaySettings.setReceiver(
                new IMenuReceiver() {
                    /** Command Action */
                    public void doAction() {
                        frame.setCurrentScreen( settings ) ;
                    }
                }
        ) ;
        frame.setMenuItem ( "A", displayMyCards ) ;
        frame.setMenuItem ( "B", displayPayments ) ;
        frame.setMenuItem ( "C", displayRewards ) ;
        frame.setMenuItem ( "D", doStore ) ;
        frame.setMenuItem ( "E", displaySettings ) ;

   }


    /**
     * Sets the current screen to the passed in screen name
     * @param screen Screen name to change to
     */
    public void changeScreen(String screen){
        switch (screen){
            case "MyCards":
                frame.setCurrentScreen(mycards);
                break;
            case "MyCardsPay":
                frame.setCurrentScreen(new MyCardsPay(this));
                break;
            case "MyCardsOptions":
                frame.setCurrentScreen(new MyCardsOptions(this));
                break;
            case "MyCardsMoreOptions":
                frame.setCurrentScreen(new MyCardsMoreOptions(this));
                break;
            case "AddCard":
                frame.setCurrentScreen(new AddCard(this));
                break;
            default:
                System.out.println("");
        }
    }


    /**
     * Sets the previous screen to the passed in screen name
     */
    public void setPreviousScreen(){
        frame.setPreviousScreen();
    }


    /**
     * Sets the next screen to the passed in screen name
     * @param screen Next screen name
     * @param card Card Number
     */
    public void setNextScreen(String screen, String card){
        System.err.println("this.value: " + this.value);
        switch (screen){
            case "MyCards":
                if (card.equals("pay")){ // setting next screen from card pay
                    if (this.value >= 1.50)
                        this.value -= 1.50;
                }
                else{ // setting card number and amount if adding card
                    this.card = card;
                    isNext = true; // card value will only be set when isNext is true
                }
                frame.setNextScreen(new MyCards( this ));
                break;

            case "AddCard":
                frame.setNextScreen(new AddCard( this)) ;
                break;

            default:
                System.out.println("");
        }
    }

    public String cardNumber(){
        return card ;
    }

    public double cardAmount(){
        return value ;
    }


    /**
      * Switch to Landscape Mode
      */
    public void landscape() {
        frame.landscape() ;
    }

    /**
     * Switch to Portait Mode
     */
    public void portrait() {
        frame.portrait() ;
    }

    /**
     * Send In Touch Events
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        frame.touch(x, y) ;
    }

    /**
     * Display Current Screen
     */
    public void display() {
        frame.display() ;
    }

    /**
     * Execute Menu Bar Command
     * @param c Menu Bar Option (A, B, C, D or E)
     */
    public void execute( String c ) {
        frame.cmd( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        frame.previousScreen() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        if (isNext){
            this.value += 20.00;
            isNext = false;
        }

        frame.nextScreen() ;
    }

    /**
     * Get Current Screen Name
     * @return Screen Name
     */
    public String screen() {
        return frame.screen() ;
    }

    /**
     * Get Current Screen Contents
     * @return Current Screen Contents
     */
    public String screenContents() {
        return frame.contents() ;
    }




}
