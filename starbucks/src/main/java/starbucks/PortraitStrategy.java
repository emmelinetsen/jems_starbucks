package starbucks;

/** Portrait Strategy */
public class PortraitStrategy implements IOrientationStrategy {

    private IMenuInvoker menuA ;
    private IMenuInvoker menuB ;
    private IMenuInvoker menuC ;
    private IMenuInvoker menuD ;
    private IMenuInvoker menuE ;


    public PortraitStrategy(IMenuInvoker menuA, IMenuInvoker menuB, IMenuInvoker menuC,
                            IMenuInvoker menuD, IMenuInvoker menuE){
        this.menuA = menuA;
        this.menuB = menuB;
        this.menuC = menuC;
        this.menuD = menuD;
        this.menuE = menuE;
    }
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

    /**
     * Helper:  Count lines in a String
     * @param  str Lines to Count
     * @return     Number of Lines Counted
     */
    private int countLines(String str){

        if (str == null || str.isEmpty()) {
            return 0;
        }

        int lines = 0;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }

        return lines ;
    }

    /**
     * Helper:  Pad lines for a Screen
     * @param  num Lines to Padd
     * @return     Padded Lines
     */
    private String padLines(int num) {
        StringBuffer buf = new StringBuffer();
        //  String lines = "" ;
        for ( int i = 0; i<num; i++ ) {
//            System.err.print(".") ;
            buf.append("\n");
            //  lines += "\n" ;
        }
//        System.err.println("") ;
        // return lines ;
        return buf.toString();
    }

    /**
     * Helper:  Pad Spaces for a Line
     * @param  num Num Spaces to Pad
     * @return     Padded Line
     */
    private String padSpaces(int num) {
        //String spaces = "" ;
        StringBuffer buf = new StringBuffer();

        for ( int i = 0; i<num; i++ )
            //spaces += " " ;
            buf.append(" ");
        // return spaces ;
        return buf.toString();
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
     * Return String / Lines for Frame and Screen
     * @param  s [description]
     * @return   [description]
     */
    public String contents(IScreen s)
    {
//        System.err.println("portraitStrategy");
        String out = "" ;
        out += "===============\n" ;
        int nameLen = s.name().length() ;
        if (nameLen < 14 ) {
            int pad = (14 - nameLen) / 2 ;
            out += padSpaces( pad ) ;
        }
        out += s.name() + "\n" ;
        out += "===============\n" ;
        String screen = s.display() + "\n" ;
        int cnt1 = countLines( screen ) ;
        int pad1 = (10 - cnt1) / 2;
        //System.err.println( "cnt1: " + cnt1 ) ;
        //System.err.println( "pad1: " + pad1 ) ;
        out += padLines( pad1 ) ;
        out += screen  ;
        //dumpLines( out ) ;
        int cnt2 = countLines( out ) ;
        int pad2 = 13 - cnt2 ;
        //System.err.println( "cnt2: " + cnt2 ) ;
        //System.err.println( "pad2: " + pad2 ) ;
        //dumpLines( out ) ;
        String padlines = padLines( pad2 ) ;
        out += padlines ;
        out +=  "===============\n" ;
        out +=  "[A][B][C][D][E]\n" ;
//        dumpLines( out ) ;
        return out ;
    }

    /** Select Command A */
    public void selectA() { menuA.invoke() ; }

    /** Select Command B */
    public void selectB() { menuB.invoke() ; }

    /** Select Command C */
    public void selectC() { menuC.invoke() ; }

    /** Select Command D */
    public void selectD() { menuD.invoke() ; }

    /** Select Command E */
    public void selectE() { menuE.invoke() ; }
}
