public class UniqueRun {
    public static void main(String[] args) {
        int prev = StdIn.readInt();
        StdOut.print(prev+"  ");
        while (!StdIn.isEmpty()) {
            int current = StdIn.readInt();
            if (current != prev) {
                prev = current;
                StdOut.print(current+"  ");
            } else
                continue;
        }
    }

}