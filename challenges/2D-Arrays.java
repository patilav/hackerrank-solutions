import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int length = 6;
    public static int maxHourGlassSum = 9*7;
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[length][length];
        for(int i=0; i < length; i++){
            for(int j=0; j < length; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int currentSum = 0;
        int previousSum = 0;
        /*  Find the sum of each Hour glass 
            for which there are 16 starting points for (i,j) from i,j = {0,length/2}
        */
        for(int i=0; i<=length/2; i++) { 
            for(int j=0; j<=length/2; j++) {
                //find the sum of each hour glass
                currentSum = getSumOfHourglass(i,j,arr);
                if (i==0 && j==0) { 
                    previousSum = currentSum;
                }
                //take maximum of currrent and previous sum and store it in previousSum
                previousSum = (previousSum>=currentSum)?previousSum:currentSum;
                // break if you have found the maximum sum in any of the iterations and skip others
                if (previousSum == maxHourGlassSum){
                    System.out.println(maxHourGlassSum);
                    return;
                }
            }
        }
        System.out.println((previousSum>=currentSum)?previousSum:currentSum);
        return;
    }
    /*
        function name:getSumOfHourglass
        Input parameters:
            int x = position of beginning of the row
            int y = position of beginning of the column
            int [][] arr = array for which sum needs to be calculated
        Output parameters: returns Sum of the Hourglass with given x,y
    */
    public static int getSumOfHourglass(int x,int y, int [][]arr) {
        int sum = arr[x+1][y+1];
        for(int i=0; i<(length/2); i=i+2) { 
            for(int j=(length/2)-1; j>=0; j--) { 
                sum+=arr[i+x][j+y];
            }
        }
        return sum;
    }
}
