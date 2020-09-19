public class Charge {
    private final double rx, ry;
    private final double q;

    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e9;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);

    }

    public String toString() {
        return q + " Coulombs at (" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge charge_1 = new Charge(0.51, 0.63, 21.3);
        Charge charge_2 = new Charge(0.13, 0.94, 81.9);
        StdOut.println(charge_1);
        StdOut.println(charge_2);
        StdOut.printf("Net Potential at (" + x + ", " + y + ") is %.2e Volts",
                (charge_1.potentialAt(x, y) + charge_2.potentialAt(x, y)));
    }

}