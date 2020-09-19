/******************************************************************************
 * Compilation: javac ShannonEntropy.java 
 * Execution: java ShannonEntropy m
 *
 * takes a command-line integer m; reads a sequence of integers between 1 and m
 * from standard input; and prints the Shannon entropy to standard output, with
 * 4 digits after the decimal point
 * 
 * % java ShannonEntropy 6 < 3 2 6 2 4 3 2 1 2 2 1 3 2 3 2 2 
 * 1.8750
 ******************************************************************************/
package Week4.Assignment;

 public class ShannonEntropy {

    public static void main(String[] args) {

        // sequence of n integers are between 1 and m
        int m = Integer.parseInt(args[0]);
        int n = 0;

        // compute frequencies
        // freq[i] = # times integer i appears
        int[] freq = new int[m + 1];
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            freq[value]++;
            n++;
        }

        // compute Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            double p = 1.0 * freq[i] / n;
            if (freq[i] > 0)
                entropy -= p * Math.log(p) / Math.log(2);
        }

        // print results
        StdOut.printf("%.4f", entropy);
    }
}
