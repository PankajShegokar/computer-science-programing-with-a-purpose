/******************************************************************************
 * Compilation: javac RecursiveSquares.java 
 * Execution: java RecursiveSquares n 
 * takes an integer command-line argument n and plots a recursive square pattern of order n.    
 * 
 * %  java RecursiveSquares 2
 * 1
 ******************************************************************************/
public class RecursiveSquares {

    // plot a square, centered on (x, y) of the given side length
    // with a light gray background and black border
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);

    }

    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double length) {
        if (n == 0)
            return;

        // recursively draw 4 smaller trees of order n-1

        draw(n - 1, x - length / 2, y + length / 2, length / 2.0); // upper left
        draw(n - 1, x + length / 2, y + length / 2, length / 2.0); // upper right
        drawSquare(x, y, length);
        draw(n - 1, x - length / 2, y - length / 2, length / 2.0); // lower left
        draw(n - 1, x + length / 2, y - length / 2, length / 2.0); // lower right

    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5; // center of square
        double length = 0.5; // side length of square
        draw(n, x, y, length);
    }

}