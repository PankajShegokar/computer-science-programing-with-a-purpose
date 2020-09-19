public class TopDownFibonacci {
    private static long[] f = new long[92];

    public static long fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // return cached value (if previously computed)
        if (f[n] > 0)
            return f[n];

        // compute and cache value
        f[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return f[n];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            StdOut.println(i + ": " + fibonacci(i));
    }

}