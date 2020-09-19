/******************************************************************************
 * Compilation: javac ColorHSB.java 
 * Execution: java ColorHSB
 *
 * A data type ColorHSB.java that represents a color in
 * hue–saturation–brightness (HSB) format, along with a sample client.
 *
 * %java ColorHSB 25 84 97 < web.txt
Red (0, 100, 100)

 * 
 ******************************************************************************/

public class ColorHSB {
    private final int hue, saturation, brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
            throw new IllegalArgumentException("Illegal Argument range");

        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (this.saturation == 0 || this.brightness == 0)
            return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (Double.isNaN(that.hue) || Double.isNaN(that.saturation) || Double.isNaN(that.brightness))
            throw new IllegalArgumentException(" Values should be non NaN ");
        return Math.min((this.hue - that.hue) * (this.hue - that.hue),
                (360 - Math.abs(this.hue - that.hue)) * (360 - Math.abs(this.hue - that.hue)))
                + (this.saturation - that.saturation)*(this.saturation - that.saturation)
                + (this.brightness - that.brightness)*(this.brightness - that.brightness);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB chsb = new ColorHSB(h, s, b);
        double distance = Double.POSITIVE_INFINITY;
        String closestColo = "";
        String minHue = "";
        String minSat = "";
        String minBright = "";
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] lineArray = line.trim().split("\\s+");
            ColorHSB targetHsb = new ColorHSB(Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]),
                    Integer.parseInt(lineArray[3]));
            if (chsb.distanceSquaredTo(targetHsb) < distance) {
                distance = chsb.distanceSquaredTo(targetHsb);
                closestColo = lineArray[0];
                minHue = lineArray[1];
                minSat = lineArray[2];
                minBright = lineArray[3];
            }
        }
        StdOut.println(closestColo + " (" + minHue + ", " + minSat + ", " + minBright + ")");
    }

}