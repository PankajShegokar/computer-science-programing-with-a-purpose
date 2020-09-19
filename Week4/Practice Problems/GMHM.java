public class GMHM {
    public static void main(String[] args) {
        int count = 0;
        double harmonicSum = 0.0;
        double gmLogSum = 0.0;
        while(!StdIn.isEmpty()){
            double value = StdIn.readDouble();
            harmonicSum+= (1/value);
            gmLogSum += Math.log(value);
            count++;
        }
        StdOut.println(" The Geometric Mean is "+Math.exp(gmLogSum/count));
        StdOut.println(" The Harmonic Mean is "+count/harmonicSum);
    }
}