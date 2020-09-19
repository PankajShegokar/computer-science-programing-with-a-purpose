/******************************************************************************
 *  Compilation:  javac GaussianPDF.java
 *  Execution:    
 *
 *  A function that implements the Function interface.
 *
 ******************************************************************************/

public class GaussianPDF implements Function {
    public double evaluate(double x) {
        return Math.exp(-x*x/2) / Math.sqrt(2 * Math.PI);
    }
}
