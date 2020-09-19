public class WordCount {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
        }
        StdOut.println("The Word Count is " + count);

        System.exit(0);
    }

}