import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        // for number = 0 return 0 -- save time
        if (number == 0) {
            System.out.println(number);
        } else {
            // for number >= 1
            //Convert number to binary string
            String binaryString = convertToBinaryString(number);
            //Count and print the consecutive 1's
            System.out.println(getConsecutiveCount(binaryString));
        }
    }
    /*
    function name: convertToBinaryString
        converts an integer with base 10 to a binary representative string
    Input parameters: int n - number to convert to binary 
    Returns: String conversion of the binary number
    */
    
    public static String convertToBinaryString(int n) { 
        StringBuffer result = new StringBuffer(); 
        while(n > 0) { 
            int binaryRep = n%2;
            result.append(binaryRep);
            n = n/2;
        }
        return result.toString();
    }
    /*
    function name: getConsecutiveCount
        counts the consecutive 1's in the string
    Input parameters: String binaryString - input string representation of binary number
    Returns: int total number of 1's in the string
    */
    public static int getConsecutiveCount(String binaryString) { 
        int latestCount = 1;
        int previousCount = 0;
        int stringLength = binaryString.length();
        char[] binaryStringArray = binaryString.toCharArray();
        for (int i=0 ; i<stringLength-1 ; i++) {
            if (binaryStringArray[i] == binaryStringArray[i+1] && binaryStringArray[i]=='1') { 
                latestCount++;
            } else { 
                previousCount = Math.max(previousCount,latestCount);
                latestCount = 1;
            }
        }
        return Math.max(latestCount,previousCount);
    }
    
}
