/******************************************************************************
 * Compilation: javac AudioCollage.java Execution: java AudioCollage
 *
 * A library to manipulate digital audio and use that library to create an audio
 * collage
 * 
 * % java AudioCollage
 ******************************************************************************/
package Week5.Assignment;
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = alpha * a[i];
        }
        return c;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[a.length - 1 - i];
        }
        return c;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i <= a.length - 1)
                c[i] = a[i];
            else
                c[i] = b[i - a.length];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        if (a.length >= b.length) {
            double[] mixArray = new double[a.length];
            double[] c = new double[a.length - b.length];
            c = merge(b, c);
            for (int i = 0; i < a.length; i++) {
                mixArray[i] = a[i] + c[i];
            }
            return mixArray;
        } else {
            double[] mixArray = new double[b.length];
            double[] c = new double[b.length - a.length];
            c = merge(a, c);
            for (int i = 0; i < b.length; i++) {
                mixArray[i] = b[i] + c[i];
            }
            return mixArray;
        }

    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int rate = (int) Math.floor(a.length / alpha);
        double[] c = new double[rate];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[(int) Math.floor(i * alpha)];
        }
        return c;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {

        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] beatboxCollage = changeSpeed(
                mix(merge(beatbox, reverse(beatbox)), mix(amplify(beatbox, 2), reverse(beatbox))), 2);

        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] buzzerCollage = changeSpeed(
                mix(merge(buzzer, reverse(buzzer)), mix(amplify(buzzer, 2), reverse(buzzer))), 2);

        double[] chimes = StdAudio.read("chimes.wav");
        double[] chimesCollage = changeSpeed(
                mix(merge(chimes, reverse(chimes)), mix(amplify(chimes, 2), reverse(chimes))), 2);

        double[] cow = StdAudio.read("cow.wav");
        double[] cowCollage = changeSpeed(mix(merge(cow, reverse(cow)), mix(amplify(cow, 2), reverse(cow))), 2);

        double[] dialup = StdAudio.read("dialup.wav");
        double[] dialupCollage = changeSpeed(
                mix(merge(dialup, reverse(dialup)), mix(amplify(dialup, 2), reverse(dialup))), 2);

        double[] piano = StdAudio.read("piano.wav");
        double[] pianoCollage = changeSpeed(mix(merge(piano, reverse(piano)), mix(amplify(piano, 2), reverse(piano))),
                2);

        double[] audioCollage = merge(beatboxCollage,
                merge(buzzerCollage, merge(chimesCollage, merge(cowCollage, merge(dialupCollage, pianoCollage)))));
        // double[] cowAmplified = amplify(cow, 2);
        // double[] cowReverse = reverse(cow);
        // double[] cowMerge = merge(cow, cowReverse);
        // double[] cowMix = mix(merge(cow, cowReverse), mix(amplify(cow,
        // 2),reverse(cow)));
        // StdAudio.play(cow);
        // StdAudio.play(cowAmplified);
        // StdAudio.play(cowReverse);
        // StdAudio.play(cowMerge);
        // StdAudio.play(cowMix);
        for (int i = 0; i < audioCollage.length; i++) {
            if (audioCollage[i] > 1)
                audioCollage[i] = 1;
            else if (audioCollage[i] < -1)
                audioCollage[i] = -1;
            else
                continue;
        }
        StdAudio.play(audioCollage);
    }
}