public class Interval {
    private final double left, right;

    public Interval(double min, double max ){
        if (Double.isNaN(min) || Double.isNaN(max))
            throw new IllegalArgumentException("Interval cannot be NaN");
        if(max < min)
            throw new IllegalArgumentException("left argument should be less than right argument");
        this.left= min;
        this.right=max;
    }

    public boolean contains(double x) {
        return this.left <= x && x <= this.right;
    }

    public boolean intersects(Interval b) {
        if (this.right < b.left) return false;
        if (this.left>b.right) return false;
        return true;
    }

    public String toString() {
        return "[" + this.left + ", " + this.right + "]";

    }

    public static void main(String[] args){
        Interval i1 = new Interval(5, 30);
        StdOut.println(i1);
        StdOut.println(i1.contains(10));
        StdOut.println(i1.intersects(new Interval(20, 25)));

    }
}