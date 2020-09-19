public class LongestPlateau {
    public static void main(String[] args) {
        int[] array_int =  new int[10];
        int start;
        int end;
        for(int i = 0; i< array_int.length-1; i++){
            if(array_int[i+1]>array_int[i])
                start = i+1;
            else
                continue;   
        }
        
    }
        
}