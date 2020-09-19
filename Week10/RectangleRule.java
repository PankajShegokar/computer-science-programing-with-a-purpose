/******************************************************************************
 *  Compilation:  javac RectangleRule.java
 *  Execution:    java RectangleRule a b
 *  
 *  Numerically integrate the function f in the interval (a, b) using
 *  the rectangle rule.
 *
 *  % java RectangleRule -3 3
 *  0.997300243823125     // true answer = 0.9973002040...
 *
 *  Observation: this says that 99.7% of time a standard normal random
 *  variable is within 3 standard deviation of its mean.
 *
 *  Caveat: this is not the best way to integrate the normal density
 *  function. See what happens if you make b very big.
 *
 *  %  java RectangleRuleRule 0 100000
 *  0.0                   // true answer = 1/2
 *
 *
 ******************************************************************************/

public class RectangleRule {


   /**********************************************************************
    * Integrate f from a to b using the rectangled rule.
    * Increase n for more precision.
    **********************************************************************/
    public static double integrate(Function f, double a, double b, int n) {
        double delta = (b - a) / n;           // step size
        double sum = 0.0;                     // area
        for (int i = 0; i < n; i++) {
            sum += delta * f.evaluate(a + delta*(i + 0.5));
        }
        return sum;
    }



    // sample client program
    public static void main(String[] args) { 
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        Function f = new GaussianPDF();
        StdOut.println(integrate(f, a, b, n));
    }

}
