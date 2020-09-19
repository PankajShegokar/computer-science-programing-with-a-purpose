/******************************************************************************
 * Compilation: javac RevesPuzzle.java 
 * Execution: java RevesPuzzle n 
 * 
 * takes an integer command-line argument n and prints a solution to Reve’s puzzle
 * 
 * 1. Let k denote the integer nearest to n+1− Math.sqrt(2n+1). 
 * 2. Transfer (recursively) the k smallest discs to a single pole other than the start or destination poles. 
 * 3. Transfer the remaining n−k disks to the destination pole (without using the pole that now contains the smallest k discs). 
 *    To do so, use the algorithm for the 3-pole towers of Hanoi problem.
 * 4. Transfer (recursively) the k smallest discs to the destination pole.
 * 
 * % java RevesPuzzle 3
Move disc 1 from A to B
Move disc 2 from A to C
Move disc 3 from A to D
Move disc 2 from C to D
Move disc 1 from B to D
 ******************************************************************************/

public class RevesPuzzle {
    private static void revers(int n, String from, String temp1, String temp2, String to) {
        if (n == 0)
            return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        /* transfer (recursively) the k smallest discs. */
        revers(k, from, to, temp2, temp1);

        // 3-pole of Hanoi.
        hanoi(n, k, from, temp2, to);
        revers(k, temp1, from, temp2, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k)
            return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        revers(n, "A", "B", "C", "D");
    }
}