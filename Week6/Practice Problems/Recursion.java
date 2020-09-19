public class Recursion {

    public static double harmonic(int n) {
        if (n == 1)
            return 1;
        return harmonic(n - 1) + 1.0 / n;
    }

    public static void main(String[] args) {
        System.out.println(harmonic(5));
    }
}