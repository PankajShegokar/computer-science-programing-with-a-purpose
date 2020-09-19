public class Triangle {
    public static void main(String[] args) {
        // StdDraw.setPenRadius(0.01);
        // StdDraw.text(0.5, 0.5, "Hello, World");
        // StdDraw.square(0.5, 0.5, 0.25);
        int n = 200;
        StdDraw.setXscale(-5, n+5);
        StdDraw.setYscale(-5, n+5);
        for (int i = 0; i <= n; i++)
            StdDraw.line(0, n/2 - i, i, 0);
    }
}