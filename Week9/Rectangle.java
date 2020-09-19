public class Rectangle {

    private final double x, y, width, height;

    // Rectangle with center coordinates, width anad height
    public Rectangle(double x0, double y0, double w, double h) {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }
    // Rectangle with bottom left and top right coordinates
    // public Rectangle(double x0, double y0, double x1, double y1){
    // x = (x1-x0)/2.0;
    // y = (y1-y0)/2.0;
    // width = x1-x0;
    // height = y1-y0;

    // }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2.0 * (height + width);
    }

    public boolean intersects(Rectangle b) {
        return (this.x + this.width / 2.0 >= b.x - b.width / 2.0 && this.y + this.height / 2.0 >= b.y - b.height / 2.0
                && this.x - this.width / 2.0 <= b.x + b.width / 2.0
                && this.y - this.height / 2.0 <= b.y + b.height / 2.0);
    }

    public boolean contains(Rectangle b) {

        // Top Left x-width/2.0, y+height/2.0 Top right x+width/2.0, y+height/2.0
        // Bottom left x-width/2.0, y-height/2.0 Bottom right x+width/2.0, y-height/2.0

        return (((this.x - this.width / 2.0) <= (b.x - b.width / 2.0))
                && ((b.x + b.width / 2) <= (this.x + this.width / 2.0))
                && ((this.y - this.height / 2.0) <= (b.y - b.height / 2.0))
                && ((b.y + b.height / 2.0) <= (this.y + this.height / 2.0)));

    }

    public void draw() {
        StdDraw.line(x - width / 2.0, y - height / 2.0, x + width / 2.0, y - height / 2.0);
        StdDraw.line(x + width / 2.0, y - height / 2.0, x + width / 2.0, y + height / 2.0);
        StdDraw.line(x + width / 2.0, y + height / 2.0, x - width / 2.0, y + height / 2.0);
        StdDraw.line(x - width / 2.0, y + height / 2.0, x - width / 2.0, y - height / 2.0);
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0.40, 0.32, 0.15, 0.2);
        Rectangle rect2 = new Rectangle(0.30, 0.20, 0.2, 0.3);
        // StdOut.println("Area "+rect1.area());
        // StdOut.println("Preimeter "+rect1.perimeter());
        StdOut.println("Is rectange 2 inside rectangle 1 " + rect1.contains(rect2));
        StdOut.println("Does rectange 2 intersect rectangle 1 " + rect1.intersects(rect2));
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        rect1.draw();
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        rect2.draw();

    }
}