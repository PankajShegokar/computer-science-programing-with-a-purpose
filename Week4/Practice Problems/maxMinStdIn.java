public class maxMinStdIn {
    public static void main(String[] args) {
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            if (value < 0) {
                StdOut.println("Please enter only Positive Numbers");
                continue;
            } else {
                if (value > max)
                    max = value;
                if (value < min)
                    min = value;

            }

        }
        StdOut.println("Maximum value entered is " + max);
        StdOut.println("Minimum value entered is " + min);
    }

}