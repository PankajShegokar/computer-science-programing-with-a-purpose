public class TestRectangle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Rectangle rect1 = new Rectangle(0.40, 0.32, 0.15, 0.2);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        rect1.draw();
        Rectangle rect[] = new Rectangle[n];
        double intersect = 0.0;
        double avgPerimeter = 0;
        double avgArea = 0;
        for (int i = 0; i < n; i++) {
            double width = StdRandom.uniform(min, max);
            double height = StdRandom.uniform(min, max);
            rect[i] = new Rectangle(0.5, 0.5, width, height);
            StdDraw.setPenColor(StdDraw.GREEN);
            rect[i].draw();
            avgPerimeter += rect[i].perimeter();
            avgArea += rect[i].area();
            if(rect[i].intersects(rect1)) intersect++;
        }
        StdOut.println("Average of n Random Rectangles Perimeter is " + avgPerimeter/n);
        StdOut.println("Average of n Random Rectangles Area is " + avgArea/n);
        StdOut.println("Average of n Random Rectangles intersecting 0.40, 0.32, 0.15, 0.2 is " + intersect/n);
    }

}
