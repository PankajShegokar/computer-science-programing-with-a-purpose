/******************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker r
 *
 *  takes an integer command-line argument r and simulates the motion of a random walk 
 * until the random walker is at Manhattan distance r from the starting point.
 * Print the coordinates at each step of the walk (including the starting and ending points), treating the starting point as (0, 0). 
 * Also, print the total number of steps taken.
 * 
 *  %java RandomWalker 5 
(0, 0)
(-1, 0)
(0, 0)
(-1, 0)
(-2, 0)
(-2, -1)
(-3, -1)
(-2, -1)
(-2, -2)
(-1, -2)
(-2, -2)
(-3, -2)
(-2, -2)
(-1, -2)
(-2, -2)
(-3, -2)
steps = 15
 *
 ******************************************************************************/
package Week2;
public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        System.out.println("("+x+", "+y+")");
        while((Math.abs(x)+Math.abs(y)) < r){    
            double random = Math.random();
            if(random < 0.25) 
                x--;
            else if(random < 0.50) 
                x++;
            else if(random < 0.75) 
                y--;
            else if(random < 1.00) 
                y++;     
            steps++;    
            System.out.println("("+x+", "+y+")");      
        }
        System.out.println("steps = "+steps);  
    }
    
}