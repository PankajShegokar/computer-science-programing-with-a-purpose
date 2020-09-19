/******************************************************************************
 * Compilation: javac Huntingtons.java 
 * Execution: java Huntingtons filename
 * files:
 * https://coursera.cs.princeton.edu/introcs/assignments/oop1/files/repeats4.txt
 * https://coursera.cs.princeton.edu/introcs/assignments/oop1/files/chromosome4-hd.txt
 *
 * Analyze a DNA string for Huntington’s disease and produce a diagnosis based
 * on count of the maximum number of repeats of CAG
 *  0–9 not human
 *  10–35 normal
 * 36–39 high risk
 *  40–180 Huntington’s
 *  181– not human
 *
 * % java Huntingtons chromosome4-hd.txt 
 * max repeats = 79 
 * Huntington's
 *
 * 
 * % java Huntingtons repeats4.txt
 * max repeats = 4 
 * not human
 ******************************************************************************/

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int max = 0;
        int count = 0;
        int i = 0;
        while (i <= dna.length() - 3) {
            if (dna.charAt(i) == 'C') {
                if (dna.substring(i, i + 3).equals("CAG")) {
                    count++;
                    max = Math.max(count, max);
                    i += 3;
                    continue;
                }
            }
            count = 0;
            i++;
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
    // removed.
    public static String removeWhitespace(String s) {
        // String output = "";
        // // char[] input = s.toCharArray();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) != ' ' && s.charAt(i) != '\t' && s.charAt(i) != '\n')
        //         output = output + s.charAt(i);
        // }
        // return output;
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of
    // repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181)
            return "not human\n";
        if (maxRepeats <= 35)
            return "normal\n";
        if (maxRepeats <= 39)
            return "high risk\n";
        return "Huntington's\n";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String data = in.readAll();
        String dna = removeWhitespace(data);
        int maxRepeats = maxRepeats(dna);

        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));

    }

}