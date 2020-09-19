/******************************************************************************
 *  Compilation:  javac Scale.java
 *  Execution:    java Scale n
 *  Dependencies: StdAudio.java
 *
 *  Plays an A major scale
 *
 ******************************************************************************/

public class Scale {

    // create a pure tone of the given frequency for the given duration
    public static double[] tone(double hz, double duration) { 
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a; 
    } 


    // test client - A major scale
    public static void main(String[] args) {

        // scale increments
        int[] steps = { 0, 2, 4, 5, 7, 9, 11, 12 };
        for (int i = 0; i < steps.length; i++) {
            double hz = 440.0 * Math.pow(2, steps[i] / 12.0);
            StdAudio.play(tone(hz, 1.0));
        }
    }
}
