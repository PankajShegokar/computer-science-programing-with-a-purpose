/******************************************************************************
 *  Compilation:  javac RandomWalkers.java
 *  Execution:    java RandomWalkers r, trials
 *
 *   takes two integer command-line arguments r and trials. In each of trials independent experiments, simulate a random walk until 
 * the random walker is at Manhattan distance r from the starting point. Print the average number of steps.
 * 
 *  %java RandomWalkers 5 1000000
 * average number of steps = 14.98188
 *
 ******************************************************************************/
package Week2;
public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        double rand;
        double steps = 0;
        for(int i = 0; i < trails; i++){            
            int x = 0;
            int y = 0;
            while((Math.abs(x)+Math.abs(y)) < r){                      
                rand = Math.random();
                if(rand < 0.25) 
                    x--;
                else if(rand < 0.50) 
                    x++;
                else if(rand < 0.75) 
                    y--;
                else if(rand < 1.00) 
                    y++;     
                steps++;                         
            }
        }
        System.out.println("average number of steps = "+ steps/trails);
    }
}