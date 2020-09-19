/******************************************************************************
 * Compilation: javac CMYKtoRGB.java Execution: java CMYKtoRGB cyan, magenta,
 * yellow, black
 *
 * Takes four double command-line arguments cyan, magenta, yellow, and black;
 * compute the corresponding RGB values, each rounded to the nearest integer;
 * and print the RGB values
 * 
 * %java CMYKtoRGB 0.0 0.14 0.70 0.15 red = 217 green = 186 blue = 65
 *
 ******************************************************************************/
package Week1;
public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        
        double white = (1 - black);
        int red = (int)Math.round(255 * white * (1 - cyan));
        int green = (int)Math.round(255 * white * (1 - magenta));
        int blue = (int)Math.round(255 * white * (1 - yellow));
        System.out.println("red   = "+red);
        System.out.println("green = "+green);
        System.out.println("blue  = "+blue);
    }
}