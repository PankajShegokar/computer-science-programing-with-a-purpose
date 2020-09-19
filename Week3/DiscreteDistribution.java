/******************************************************************************
 * Compilation: javac DiscreteDistribution.java 
 * Execution: java BandMatrix m, a1,a2,…,an
 *
 * takes an integer command-line argument m, followed by a sequence of positive integer command-line arguments a1,a2,…,an, 
 * and prints m random indices (separated by whitespace), 
 * choosing each index i with probability proportional to ai
 * 
 * %java DiscreteDistribution 25 1 1 1 1 1 1
 * 5 2 4 4 5 5 4 3 4 3 1 5 2 4 2 6 1 3 6 2 3 2 4 1 4
 * 
 * %java DiscreteDistribution 25 10 10 10 10 10 50
 * 3 6 6 1 6 6 2 4 6 6 3 6 6 6 6 4 5 6 2 2 6 6 2 6 2
 *
 ******************************************************************************/
package Week3;
public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        // System.out.println(m);
        // System.out.println(n);

        // Cumulative Sums
        int[] S = new int[n];
        for(int i = 0; i < n-1; i++){
            S[i+1] = S[i] + Integer.parseInt(args[i+1]);
        }
        // System.out.println(S[S.length-1]);
        int[] result = new int[m];
        for(int j = 0; j < m; j++){
            //Pick a random integer uniformliy distributed [0,Sn-1]
            int r  = (int)(Math.random() * S[S.length-1]);
            // System.out.println(r);
            int index = 0;
            for(int i = 1; i < S.length; i++){
                if(r >= S[i-1] && r < S[i])
                    index = i;
                else 
                    continue;
            }
            result[j] = index;
        }
        // Printing the result array as per the format
        for(int i=0; i < result.length; i++){
            if(i>0 && i%25==0){
                System.out.println("");
            }
            System.out.print(result[i]+ "  ");
        }
        
    }
}