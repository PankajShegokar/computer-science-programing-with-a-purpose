/******************************************************************************
 * Compilation: javac Birthday.java Execution: java Birthday n, trials
 *
 * takes two integer command-line arguments n and trials and performs the
 * following experiment, trials: times: Choose a birthday for the next person,
 * uniformly at random between 0 and n−1. Have that person enter the room. If
 * that person shares a birthday with someone else in the room, stop; otherwise
 * repeat. In each experiment, count the number of people that enter the room.
 * Print a table that summarizes the results the count i, the number of times
 * that exactly i people enter the room, and the fraction of times that i or
 * fewer people enter the room for each possible value of i from 1 until the
 * fraction reaches (or exceeds) 50%.
 * 
 * % java Birthday 31 1000000 1 0 0.0 2 32270 0.03227 3 62580 0.09485 4 87582
 * 0.182432 5 105596 0.288028 6 114427 0.402455 7 115494 0.517949
 *
 ******************************************************************************/
package Week3;
public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);     
        int[] count_array = new int[trials+n];
        //Populate the count_array with the No. of people in the room before the duplicate bithday
        for(int i =0; i<trials; i++){ 
            boolean[] has_birthday = new boolean[n];
            int count = 0;    
            while(true){
                 count++;
                //Pick a random number
                int r = (int)(Math.random()*(n));
                // System.out.println(r);
                if(has_birthday[r])
                    break;
                has_birthday[r]=true; 
            }           
            count_array[count]++;        
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.print(count_array[i] + " ");
        // }
        // Cumulative Sums
        double[] cumsum = new double[count_array.length];
        double total = 0.0;
        for(int i=0;i<count_array.length;i++){
            total+=count_array[i];
            cumsum[i] = total;
            if((total/trials)<0.5){                
                if(i!=0)
                    System.out.println(i +"     "+ count_array[i]+"     "+total/trials);
            }
            else 
                break;
        }
    }
}