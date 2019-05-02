/**
 * Name: Emmeline Tsen
 * ID: 007825649
 */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class NewTests {

    IApp app ;

    public NewTests()
    {
    }

    @Before
    public void setUp()
    {
        app = new AppAuthProxy() ;
    }

    /**
     * Verify application is not authenticated when invalid pin is entered
     */
    @Test
    public void InvalidPasscodeTest1()
    {
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(1,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("PinScreen", app.screen());
    }

    /**
     * Verify "Invalid Pin" text and reset of pin boxes when invalid pin is entered
     */
    @Test
    public void InvalidPasscodeTest2()
    {
        String[] lines;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(1,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("PinScreen", app.screen());
        lines = app.screenContents().split("\n");

        // verify 'Invalid Pin' text when entered invalid passcode
        assertEquals("Invalid Pin", lines[3].trim());
        assertEquals("[_][_][_][_]", lines[5].trim());

    }

    /**
     * Verify backspace on AddCard. Verify only 9 numbers can be entered for card number
     */
    @Test
    public void AddCardBackspaceTest1(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(3,8); // backspace
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,7); // 9
        app.touch(3,6); // 6
        lines = app.screenContents().split("\n");
        assertEquals("[123457896]", lines[4].trim());

    }

    /**
     * Verify backspace on AddCard.
     * Verify only 9 numbers can be entered for card number
     * Verify only 3 digits can be entered for card pin
     * Verify correct value is added onto card.
     */
    @Test
    public void AddCardBackspaceTest2(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(3,8); // backspace
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,7); // 9
        app.touch(3,6); // 6
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        app.touch(3,8); // backspace
        app.touch(1,7); // 7
        app.touch(3,7); // 9
        lines = app.screenContents().split("\n");
        assertEquals("[123457896]", lines[4].trim());
        assertEquals("[979]", lines[5].trim());

        // add card - see balance
        app.next() ;
        app.display() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$20.00", lines[7]);
    }

    /**
     * Add multiple cards.
     * Verify additional money after adding second card
     */
    @Test
    public void AddMultipleCardsTest(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;

        // add first card
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,7); // 9
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        // check digit entry
        app.display() ;
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
        // add card - see balance
        app.next() ;
        app.display() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$20.00", lines[7]);

        // add second card
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,6); // 6
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7); // 9
        app.touch(2,5); // 2
        app.touch(3,7); // 9
        // check digit entry
        app.display() ;
        lines = app.screenContents().split("\n");
        assertEquals("[123456786]", lines[4].trim());
        assertEquals("[929]", lines[5].trim());
        // add card - see balance
        app.next() ;
        app.display() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$40.00", lines[7]);

    }

    /**
     * Verify focus is switched correctly.
     */
    @Test
    public void AddCardSwitchCurrentFocusTest(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card ID Digits
        app.touch(3,2); // focus on card id
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(2,3); // focus on card code
        // Card Code Digits
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        lines = app.screenContents().split("\n");
        assertEquals("[12]", lines[4].trim());
        assertEquals("[99]", lines[5].trim());
        app.touch(3,2); // focus on card id
        // Card ID Digits
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,6); // 6
        app.touch(2,3); // focus on card code
        // Card Code Digits
        app.touch(3,7); // 9
        lines = app.screenContents().split("\n");
        assertEquals("[123456786]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
    }

    /**
     * Verify only first 9 digits of card number entered is valid.
     * Verify only first 3 digits of card code entered is valid.
     */
    @Test
    public void AddCardValidCardTest(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card ID Digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,7); // 9
        app.touch(2,6); // 5
        app.touch(2,3); // focus on card code
        // Card Code Digits
        app.touch(3,7); // 9
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[967]", lines[5].trim());
    }

    /**
     * Add card with less than 9 digits.
     * Verify 'next' will clear out Card Number Entry Box and Code Entry Box.
     * Verify card is not added.
     */
    @Test
    public void AddCardInvalidCardTest(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;

        // add first card
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        app.touch(3,7); // 9

        // attempt to add card
        app.next() ;
        lines = app.screenContents().split("\n");
        System.err.println(Arrays.toString(lines));
        assertEquals("[]", lines[4].trim());
        assertEquals("[]", lines[5].trim());

        app.execute("A") ; // MyCards Page
        lines = app.screenContents().split("\n");
        assertEquals("$0.00", lines[7].trim());
    }

    /**
     * Add card with valid card number and pin. Click Previous.
     * Verify 'prev' will not add card even with valid card information.
     */
    @Test
    public void AddCardGoBackTest(){
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;

        // add first card
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        app.touch(3,6); // 6
        app.touch(1,7); // 7
        app.touch(2,7); // 8
        app.touch(3,7); // 9
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7); // 9
        app.touch(3,7); // 9
        app.touch(3,7); // 9

        // attempt to add card
        app.prev();
        app.execute("A") ; // MyCards Page
        lines = app.screenContents().split("\n");
        assertEquals("$0.00", lines[7].trim());
    }

    /**
     * Verify correct value for multiple payments on card.
     */
    @Test
    public void MultiplePaymentsTest1()
    {
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5);
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        app.touch(3,7);
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7);
        app.touch(3,7);
        app.touch(3,7);
        // check digit entry
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
        // add card - see balance
        app.next() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$20.00", lines[7].trim());
        // switch to payment
        app.touch(3,3);
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[6].trim());
        assertEquals("Scan Now", lines[9].trim());
        // Make Payments
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(3,3); // switch to balance
        lines = app.screenContents().split("\n");
        assertEquals("$15.50", lines[7].trim());
    }

    /**
     * Verify card does not go negative when insufficient funds for payment.
     */
    @Test
    public void MultiplePaymentsTest2()
    {
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5);
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        app.touch(3,7);
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7);
        app.touch(3,7);
        app.touch(3,7);
        // check digit entry
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
        // add card - see balance
        app.next() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$20.00", lines[7].trim());
        // switch to payment
        app.touch(3,3);
        lines = app.screenContents().split("\n");
        assertEquals("[123456789]", lines[6].trim());
        assertEquals("Scan Now", lines[9].trim());
        // Make Payments -- $21.00 total
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(2,2);  // Pay $1.50
        app.touch(3,3); // switch to balance
        lines = app.screenContents().split("\n");
        assertEquals("$0.50", lines[7].trim());
    }

    @After
    public void tearDown()
    {
    }
}

