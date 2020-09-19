
public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix // of a[][]
    // containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] s = new int[n][n];
        // Copy first row and first column
        for (int i = 0; i < n; i++) {
            s[0][i] = a[0][i];
            s[i][0] = a[i][0];
        }
        // construct an auxiliary size matrix S[][] in which each entry S[i][j]
        // represents size of the square sub-matrix
        // with all 1s including a[i][j] where a[i][j] is the rightmost and bottommost
        // entry in sub-matrix.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1)
                    s[i][j] = Math.min(s[i - 1][j], Math.min(s[i][j - 1], s[i - 1][j - 1])) + 1;
            }
        }
        // Return the max value in s[][]
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] > size)
                    size = s[i][j];
            }

        }
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix // containing
    // only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();

        int[][] a = new int[n][n];

        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                    // StdOut.print(a[i][j] + " ");
                }
                // StdOut.println();
            }
        }

        StdOut.println(size(a));
    }
}