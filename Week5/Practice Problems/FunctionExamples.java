
/******************************************************************************
 *  Compilation:  javac FunctionsExamples.java
 *  Execution:    none
 *
 *  Examples of functions.
 *
 ******************************************************************************/

public class FunctionExamples {

    // absolute value of an int value
    public static int abs(int x) {
        if (x < 0) return -x;
        else       return  x;
    }

    // absolute value of a double value (overloading)
    public static double abs(double x) {
        if (x < 0) return -x;
        else       return  x;
    }

    // primality test (multiple return statements)
    public static boolean isPrime(int n) {
        if (n < 2) return false; 
        for (int i = 2; i <= n/i; i++) 
            if (n % i == 0) return false; 
        return true; 
    }

    // hypotenuse of a right triangle (multiple arguments)
    // see also Math.hypot()
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }

    // Harmonic number 
    public static double harmonic(int n) {
        double sum = 0.0; 
        for (int i = 1; i <= n; i++) 
            sum += 1.0 / i; 
        return sum; 
    } 

    // uniform random integer in [0, n) 
    public static int uniform(int n) {
        return (int) (Math.random() * n);
    } 

    // reverse an array
    public static double[] reverse(double[] a){
        double[] c = new double[a.length];
        for(int i=0; i< a.length; i++){
            c[i] = a[a.length-1 - i];
        }
        return c;
    }
    // concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b){
        double[] c = new double[a.length+b.length];
        for(int i =0; i < c.length; i++){
            if(i<=a.length-1)
                c[i] = a[i];
            else
                c[i] = b[i-a.length];
        }
        return c;
    }
    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        
        if (a.length >= b.length) {
            double[] mixArray = new double[a.length];
            double[] c = new double[a.length - b.length];
            c = merge(b, c);
            for (int i = 0; i < a.length; i++) {
                mixArray[i] = a[i] + c[i];
            }
            return mixArray;
        } else {
            double[] mixArray = new double[b.length];
            double[] c = new double[b.length - a.length];
            c = merge(a, c);
            for (int i = 0; i < b.length; i++) {
                mixArray[i] = b[i] + c[i];
            }
            return mixArray;
        }

    }

    // draw a triangle to standard draw (side effects)
    public static void drawTriangle(double x0, double y0, double x1, double y1, double x2, double y2) {   
        StdDraw.line(x0, y0, x1, y1); 
        StdDraw.line(x1, y1, x2, y2); 
        StdDraw.line(x2, y2, x0, y0); 
    } 
   
    public static String duplicate(String s) {
        String t = s + s;
        return t;
    }
    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha){
        int rate = (int)Math.floor(a.length/alpha);
        System.out.println("rate "+rate);
        double[] c = new double[rate];
        for(int i =0;i<c.length;i++){
            System.out.println("i "+i);
            c[i] = a[(int)Math.floor(i*alpha)];
        }
        return c;
    }

    public static void main(String[] args) {
        double[] a = {2.2,5.6,8.6,5.3,8.7,6.1,5.4,8.6};
        double[] b = { 6.2,4.6};
        double[] concat = changeSpeed(a,3);
        for(int i=0; i<concat.length; i++){
            StdOut.println(concat[i]);
        }
        // double[] concat = mix(a,b);
        // for(int i=0; i<concat.length; i++){
        //     StdOut.println(concat[i]);
        // }

        // double[] rev = reverse(a);
        // for(int i=0; i<rev.length; i++){
        //     StdOut.println(rev[i]);
        // }
        // String s1 = "Hi";
        // s1 = duplicate(s1);
        // String t1 = "Bye";
        // t1 = duplicate(duplicate(t1));
        // StdOut.println(s1 + t1);
    }
}