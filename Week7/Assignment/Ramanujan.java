
public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;

        for (int i = 0; i < Math.pow(n, 1 / 3.0); i++) {
            double b;
            b = Math.pow((n - Math.pow(i, 3)), 1 / 3.0);
            
            if (Math.abs(b - Math.round(b)) <= 0.0000001) {
                count++;
                // System.out.println("i----"+i+" b---"+Math.round(b));
            }
        }
        return (count >= 4);
    }

    //O(n^4)!!!
    // public static void listRamanujan(int n) {
    //     // for each a, b, c, d, check whether a^3 + b^3 = c^3 + d^3
    //     for (int a = 1; a <= n; a++) {
    //         int a3 = a * a * a;
    //         if (a3 > n)
    //             break;

    //         // start at a to avoid print out duplicate
    //         for (int b = a; b <= n; b++) {
    //             int b3 = b * b * b;
    //             if (a3 + b3 > n)
    //                 break;

    //             // start at a + 1 to avoid printing out duplicates
    //             for (int c = a + 1; c <= n; c++) {
    //                 int c3 = c * c * c;
    //                 if (c3 > a3 + b3)
    //                     break;

    //                 // start at c to avoid printing out duplicates
    //                 for (int d = c; d <= n; d++) {
    //                     int d3 = d * d * d;
    //                     if (c3 + d3 > a3 + b3)
    //                         break;

    //                     if (c3 + d3 == a3 + b3) {
    //                         System.out.print((a3 + b3) + " = ");
    //                         System.out.print(a + "^3 + " + b + "^3 = ");
    //                         System.out.print(c + "^3 + " + d + "^3");
    //                         System.out.println();
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }

    public static void main(String[] args) {

        // read in one command-line argument
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
