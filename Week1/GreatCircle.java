/******************************************************************************
 * Compilation: javac GreatCircle.java Execution: java GreatCircle x1, y1, x2,
 * y2
 *
 * Takes four double command-line arguments x1, y1, x2, and y2—the latitude and
 * longitude (in degrees) of two points on the surface of the earth—and prints
 * the great-circle distance (in kilometers) between them using Haversine
 * Formula.
 * 
 * %java GreatCircle 40.35 74.65 48.87 -2.33 5902.927099258561 kilometers
 *
 ******************************************************************************/
package Week1;
public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));  
        double x2 = Math.toRadians(Double.parseDouble(args[2])); 
        double y2 = Math.toRadians(Double.parseDouble(args[3])); 
        double d = 2*6371.0*(Math.asin((Math.sqrt(Math.pow(Math.sin((x2-x1)/2.0),2) +(Math.cos(x1)*Math.cos(x2)*(Math.pow(Math.sin((y2-y1)/2.0),2)))))));
        System.out.println(d+" kilometers");
    }
}