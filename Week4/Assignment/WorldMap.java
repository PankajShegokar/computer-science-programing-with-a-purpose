/******************************************************************************
 * Compilation: javac WorldMap.java 
 * Execution: java WorldMap n
 *
 * reads boundary information of a country (or other geographic entity) from standard input and plots the results to standard drawing.
 * A country consists of a set of regions (e.g., states, provinces, or other administrative divisions), 
 * each of which is described by a polygon.
 * 
 * % java WorldMap < india.txt
 * 
 * 
 ******************************************************************************/
package Week4.Assignment;

public class WorldMap {
    public static void main(String[] args) {

        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String state = StdIn.readString();
            int vertices = StdIn.readInt();
            double[] x = new double[vertices];
            double[] y = new double[vertices];
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 0)
                        x[i] = StdIn.readDouble();
                    if (j == 1)
                        y[i] = StdIn.readDouble();
                }
            }
            StdDraw.polygon(x, y);
        }
    }
}