/******************************************************************************
 * Compilation: javac Divisors.java 
 * Execution: java Divisors a b
 *
 * takes a command-line integer a b; and computes various integer valued functions
 * 
 * %  java Divisors 987 610
gcd(987, 610) = 1
lcm(987, 610) = 602070
areRelativelyPrime(987, 610) = true
totient(987) = 552
totient(610) = 240
 ******************************************************************************/
package Week5.Assignment;
public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else if (a == 0 && b == 0)
            return 0;
        else {
            int gcd = 0;
            while (b != 0) {
                gcd = b;
                b = a % b;
                a = gcd;
            }
            return gcd;
        }

    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        else
            return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1)
            return true;
        else
            return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (areRelativelyPrime(i, n))
                    count++;
            }
            return count;
        }

    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
        StdOut.println("lcm(" + x + ", " + y + ") = " + lcm(x, y));
        StdOut.println("areRelativelyPrime(" + x + ", " + y + ") = " + areRelativelyPrime(x, y));
        StdOut.println("totient(" + x + ") = " + totient(x));
        StdOut.println("totient(" + y + ") = " + totient(y));
    }
}