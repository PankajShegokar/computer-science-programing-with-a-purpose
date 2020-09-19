/******************************************************************************
 * Compilation: javac Checkerboard.java Execution: java Checkerboard n
 *
 * takes a command-line integer n and plots an n-by-n checkerboard pattern to
 * standard drawing. Color the squares blue and light gray, with the bottom-left
 * square blue.
 * 
 * % java Checkerboard 4
 * 
 * 
 ******************************************************************************/
package Week4.Assignment;

public class Checkerboard {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 != 0)
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else
                    StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }

}