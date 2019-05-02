package starbucks;

/** Landscape Strategy */
public class LandscapeStrategy implements IOrientationStrategy {

    private IMenuInvoker menuA ;
    private IMenuInvoker menuB ;
    private IMenuInvoker menuC ;
    private IMenuInvoker menuD ;
    private IMenuInvoker menuE ;

    /**
     * Helper Debug Dump to STDERR
     * @param str Lines to print
     */
    private void dumpLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        for ( int i = 0; i<lines.length; i++ ) {
            System.err.println( i + ": " + lines[i] ) ;
        }
    }

    public LandscapeStrategy(IMenuInvoker menuA, IMenuInvoker menuB, IMenuInvoker menuC,
                            IMenuInvoker menuD, IMenuInvoker menuE){
        this.menuA = menuA;
        this.menuB = menuB;
        this.menuC = menuC;
        this.menuD = menuD;
        this.menuE = menuE;
    }
    /**
     * Display Screen Contents
     * @param s Reference to Screen
     */
    public void display(IScreen s)
    {
        System.out.println( contents(s) ) ;
    }

    /**
     * Display Contents of Frame + Screen
     * @param  s Screen to Display
     * @return   Contents for Screen
     */
    public String contents(IScreen s)
    {
        System.err.println("landscapeStrategy");
        String out = "" ;
        out += "================================\n" ;
        out += "  " + s.name() + "  \n" ;
        out += "================================\n" ;
        out += s.display() + "\n"  ;
        out += "================================\n" ;
        dumpLines( out ) ;
        return out ;
    }

    /** Don't Respond in Landscaope Mode */
    public void selectA() {  }

    /** Don't Respond in Landscaope Mode */
    public void selectB() {  }

    /** Don't Respond in Landscaope Mode */
    public void selectC() {  }

    /** Don't Respond in Landscaope Mode */
    public void selectD() {  }

    /** Don't Respond in Landscaope Mode */
    public void selectE() {  }
}
