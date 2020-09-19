/******************************************************************************
 *  Compilation:  javac RightTriangle.java
 *  Execution:    java RightTriangle a, b, c
 *
 *  Takes three int command-line arguments and determines whether they constitute the side lengths of some right triangle
 * 
 *  %java RightTriangle 3 4 5
 *  true
 *
 ******************************************************************************/
package Week1;
public class RightTriangle {
    public static void main(String[] args) {
        boolean result = false;
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean all_positive = (a>0) && (b>0) && (c>0);
        boolean triplet_result1 = (Math.pow(a, 2) == (Math.pow(b, 2)  + Math.pow(c, 2) ));
        boolean triplet_result2 = (Math.pow(b, 2) == (Math.pow(c, 2)  + Math.pow(a, 2) ));
        boolean triplet_result3 = (Math.pow(c, 2) == (Math.pow(a, 2)  + Math.pow(b, 2) ));
        result = all_positive && (triplet_result1 || triplet_result2 || triplet_result3 );
        System.out.println(result);
    }
    
}