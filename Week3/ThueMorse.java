/******************************************************************************
 * Compilation: javac ThueMorse.java 
 * Execution: java ThueMorse n
 *
 *  takes an integer command-line argument n and prints an n-by-n pattern like the ones below.
 *  Include two space characters between each + and - character.
 * 
 * % java ThueMorse 4
    +  -  -  +
    -  +  +  -
    -  +  +  -
    +  -  -  +
 *
 ******************************************************************************/
package Week3;
public class ThueMorse {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);

        //------------------input = 10--->n=16
        //------------------input = 16--->n=16
        int n;
        if (input % (Math.log(input) / Math.log(2)) == 0) {
            n = (int) Math.pow(2, (int) (Math.log(input) / Math.log(2)));
        }
        else {

            n = (int) Math.pow(2, (int) (Math.log(input) / Math.log(2)) + 1);
        }
        //   System.out.println("n=" + n);

        //----------------------Thue Morse Sequence-------------
        boolean[] array = new boolean[n];
        array[0] = false;

        for (int k = 0; k < Math.log(n) / Math.log(2); k++) {
            for (int i = (int) Math.pow(2, k); i < Math.pow(2, k + 1); i++) {
                System.out.println("k---"+k+"i----"+i);
                if (array[i - (int) Math.pow(2, k)]) array[i] = false;
                else array[i] = true;
                // System.out.println(array[i]);
            }
        }

        
        // System.out.println("--------print Thue Morse Sequence---------");
        // for (int i = 0; i < n; i++) {
        //     System.out.print(array[i] + " ");
        // }
        // System.out.println();
        // System.out.println("--------Thue Morse Wave---------");

        //construct Thue Morse Wave
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (array[i] == array[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }

    }
    
}