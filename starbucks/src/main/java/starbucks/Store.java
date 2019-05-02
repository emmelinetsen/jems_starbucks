

package starbucks ;

/** Store Screen */
public class Store extends Screen
{

    public Store(AppController c)
    {
        super(c);
    }


    /**
     * Get Display Contents
     * @return Store Display Contents
     */
    public String display(){
        return  "           x\n" +
                "   x        \n" +
                "    x       \n" +
                "         x  \n" +
                "           x\n" +
                "       x    \n" +
                "x           \n";
    }

}
