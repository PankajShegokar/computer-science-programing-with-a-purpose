/******************************************************************************
 * Compilation: javac BandMatrix.java Execution: java BandMatrix n, width
 *
 * two integer command-line arguments n and width and prints an n-by-n pattern,
 * with a zero (0) for each element whose distance from the main diagonal is
 * strictly more than width, and an asterisk (*) for each entry that is not, and
 * two spaces between each 0 or *.
 * 
 * %java BandMatrix 8 1 * 0 0 0 0 0 0 * * 0 0 0 0 0 0 * * * 0 0 0 0 0 0 * * * 0
 * 0 0 0 0 0 * * * 0 0 0 0 0 0 * * * 0 0 0 0 0 0 * * * 0 0 0 0 0 0 * *
 *
 ******************************************************************************/
package Week2;
public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // System.out.println(j);
                if(Math.abs(j-i) <= width) System.out.print("*  ");
                else System.out.print("0  ");
            }
            System.out.println(' ');

        }
    }
    
}