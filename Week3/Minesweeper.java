/******************************************************************************
 * Compilation: javac Minesweeper.java 
 * Execution: java Minesweeper m, n, k
 *
 *  takes three integer command-line arguments m, n, and k and prints an m-by-n grid of cells with k mines,
 *  using asterisks for mines and integers for the neighboring mine counts (with two space characters between each cell)
 * 
 * % java Minesweeper 9 9 10
    0  1  *  1  0  0  0  1  *  
    1  3  2  2  0  0  0  1  1  
    *  2  *  1  0  0  1  1  1  
    1  2  2  2  1  0  1  *  1  
    0  1  2  *  1  0  1  1  1  
    1  2  *  3  3  1  1  0  0  
    1  *  3  *  2  *  1  0  0  
    1  1  2  1  2  1  1  0  0  
    0  0  0  0  0  0  0  0  0 
 *
 ******************************************************************************/
package Week3;
public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int count,row, col;
        int mine_count=0;
        String[][] mines = new String[m][n];
        String[][] result_mines = new String[m][n];
        // Generate exactly k mines of m*n cells, uniformly at random
        while(mine_count<k){
            int r = (int)(Math.random()*m*n);
            // System.out.println("r---"+r);
            row = r/n;
            col = r%n;
            if(mines[row][col]!="*"){
                mines[row][col] = "*";
                mine_count++;
            }
        }
        // //Printing the Minesweeper
        // for(int i=0; i<m; i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(mines[i][j]+"  ");
        //     }
        //     System.out.println(" ");
        // }
        //Neighbour count of mines
        if(m==1 && n==1){//for a point
            result_mines[0][0] = "0";
        }
        else if(m==1){//for row vector
            for(int j=0; j<n; j++){
                count=0;
                if(mines[0][j]!="*"){
                    if(j==0){
                        if(mines[0][j+1]=="*"){
                            count++;
                        }
                    }
                    else if(j==n-1){
                        if(mines[0][j-1]=="*"){
                            count++;
                        }
                    }
                    else{
                        if(mines[0][j+1]=="*"){
                            count++;
                        }
                        if(mines[0][j-1]=="*"){
                            count++;
                        }
                    }
                    result_mines[0][j] = Integer.toString(count);
                }
                else
                    result_mines[0][j] = mines[0][j];
            }
        }
        else if(n==1){//for column vector
            for(int i=0; i<m; i++){
                count=0;
                if(mines[i][0]!="*"){
                    if(i==0){
                        if(mines[i+1][0]=="*"){
                            count++;
                        }

                    }
                    else if(i==m-1){
                        if(mines[i-1][0]=="*"){
                            count++;
                        }
                    }
                    else {
                        if(mines[i+1][0]=="*"){
                            count++;
                        }
                        if(mines[i-1][0]=="*"){
                            count++;
                        }
                    }
                    result_mines[i][0] = Integer.toString(count);
                }
                else 
                    result_mines[i][0] = mines[i][0];
            }

        }
        else{//For Matrix            
            for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                count=0;
                if(mines[i][j]!="*"){
                    if(i==0){
                        if(j==0){
                            if(mines[i][j+1]=="*"){
                                count++;
                            }
                            if(mines[i+1][j]=="*"){
                                count++;
                            }
                            if(mines[i+1][j+1]=="*"){
                                count++;
                            }   
                        }
                        else if(j==n-1){
                            if(mines[i][j-1]=="*"){
                                count++;
                            }
                            if(mines[i+1][j]=="*"){
                                count++;
                            }
                            if(mines[i+1][j-1]=="*"){
                                count++;
                            }
                        }
                        else{
                            if(mines[i][j-1]=="*"){
                                count++;
                            }
                            if(mines[i][j+1]=="*"){
                                count++;
                            }
                            if(mines[i+1][j]=="*"){
                                count++;
                            }
                            if(mines[i+1][j+1]=="*"){
                                count++;
                            }
                            if(mines[i+1][j-1]=="*"){
                                count++;
                            }
                        }                    
                    }
                    else if(i==m-1){
                        if(j==0){
                            if(mines[i-1][j]=="*"){
                                count++;
                            }
                            if(mines[i][j+1]=="*"){
                                count++;
                            }
                            if(mines[i-1][j+1]=="*"){
                                count++;
                            }   
                        }
                        else if(j==n-1){
                            if(mines[i][j-1]=="*"){
                                count++;
                            }
                            if(mines[i-1][j]=="*"){
                                count++;
                            }
                            if(mines[i-1][j-1]=="*"){
                                count++;
                            }
                        }
                        else{
                            if(mines[i][j-1]=="*"){
                                count++;
                            }
                            if(mines[i][j+1]=="*"){
                                count++;
                            }
                            if(mines[i-1][j]=="*"){
                                count++;
                            }
                            if(mines[i-1][j+1]=="*"){
                                count++;
                            }
                            if(mines[i-1][j-1]=="*"){
                                count++;
                            }
                        }                    
                    }
                    else if(j==0){
                        if(mines[i][j+1]=="*"){
                            count++;
                        }
                        if(mines[i-1][j]=="*"){
                            count++;
                        }
                        if(mines[i+1][j]=="*"){
                            count++;
                        }
                        if(mines[i-1][j+1]=="*"){
                            count++;
                        }
                        if(mines[i+1][j+1]=="*"){
                            count++;
                        }
                    }
                    else if(j==n-1){
                        if(mines[i-1][j]=="*"){
                            count++;
                        }
                        if(mines[i+1][j]=="*"){
                            count++;
                        }
                        if(mines[i][j-1]=="*"){
                            count++;
                        }
                        if(mines[i-1][j-1]=="*"){
                            count++;
                        }
                        if(mines[i+1][j-1]=="*"){
                            count++;
                        }
                    }
                    else{
                        if(mines[i-1][j-1]=="*"){
                            count++;
                        }
                        if(mines[i-1][j]=="*"){
                            count++;
                        }
                        if(mines[i-1][j+1]=="*"){
                            count++;
                        }
                        if(mines[i][j-1]=="*"){
                            count++;
                        }
                        if(mines[i][j+1]=="*"){
                            count++;
                        }
                        if(mines[i+1][j-1]=="*"){
                            count++;
                        }
                        if(mines[i+1][j]=="*"){
                            count++;
                        }
                        if(mines[i+1][j+1]=="*"){
                            count++;
                        }
                    }
                    result_mines[i][j] = Integer.toString(count);
                }
                else
                    result_mines[i][j] = mines[i][j];
            }
        }
        }   
        //Printing the Minesweeper
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                System.out.print(result_mines[i][j]+"  ");
            }
            System.out.println(" ");
        }
    }    
}