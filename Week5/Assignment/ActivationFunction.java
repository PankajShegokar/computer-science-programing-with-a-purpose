/******************************************************************************
 * Compilation: javac ActivationFunction.java 
 * Execution: java ActivationFunction m
 *
 * takes a command-line real number m; and computes various real valued functions
 * 
 * %  java ActivationFunction 1.0
heaviside(1.0) = 1.0
  sigmoid(1.0) = 0.7310585786300049
     tanh(1.0) = 0.7615941559557649
 softsign(1.0) = 0.5
     sqnl(1.0) = 0.75
 ******************************************************************************/
package Week5.Assignment;
public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x < 0)
            return 0.0;
        else if (x == 0)
            return 0.5;
        else
            return 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if(x >= 20){
            return 1.0;
        }
        else if(x <= -20){
            return -1.0;
        }
        else
            return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x == Double.POSITIVE_INFINITY)
            return 1;
        else if (x == Double.NEGATIVE_INFINITY)
            return -1;
        else
            return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x <= -2)
            return -1;
        else if (x < 0)
            return x + (x * x / 4);
        else if (x < 2)
            return x - (x * x / 4);
        else
            return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("     tanh(" + x + ") = " + tanh(x));
        StdOut.println(" softsign(" + x + ") = " + softsign(x));
        StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}