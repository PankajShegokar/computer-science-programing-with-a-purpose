public class StringProcessing {
    public static String reverse(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
        return new String(a);
    }

    public static boolean isValidDNA(String s) {
        boolean validString = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                validString = false;
                break;
            }

        }
        return validString;
    }

    public static String kamasutraCipher(String key1, String key2, String input) {
        if (key1.length() == key2.length()) {
            char[] op = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                if (key1.indexOf(input.charAt(i)) >= 0)
                    op[i] = key2.charAt(key1.indexOf(input.charAt(i)));
                else if (key2.indexOf(input.charAt(i)) >= 0)
                    op[i] = key1.charAt(key2.indexOf(input.charAt(i)));
                else
                    op[i] = input.charAt(i);
            }
            return new String(op);
        }
        return new String("Keys are of Different Lengths!");
    }

    public static String removeConsecutiveDuplicates(String str) {
        String outString = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (i == 0) {
                outString = "" + str.charAt(i);
            } 
            else {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    outString = outString + str.charAt(i);
                }
            }
        }
        return outString;
    }
    public static String removeWhitespace(String s){
        String output = "";
        // char[] input = s.toCharArray();
        for(int i =0; i<s.length();i++){
            if(s.charAt(i)!=' ' && s.charAt(i)!='\t'&& s.charAt(i)!='\n')
                output = output + s.charAt(i);            
        }
        return output;
    }

    public static void main(String[] args) {
        // StdOut.print(reverse(args[0]));
        // System.out.println(isValidDNA(args[0]));
        // System.out.println(kamasutraCipher(args[0], args[1], args[2]));
        // System.out.println(removeConsecutiveDuplicates("ddooooonnneeeeee"));
        System.out.println(removeWhitespace("TTTTTTTTTT TTTTTTTTTT TTTTTTTTCAGCAGCA\tGCAG TTTCAGCAGT TTTTTTTTTT    TTTTTTTTTT TTTTTTTTTT TTTTTTTTT\nTTTTCAGTTTT TTTTTTTTTT T     "));

    }
}