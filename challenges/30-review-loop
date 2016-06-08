import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalStrings = Integer.parseInt(input.nextLine());
        for(int i=0;i<totalStrings;i++) {
            //fetch each string
            String testString = input.nextLine();
            //print characters at even places
            printLine(testString,true);
            System.out.print(" ");
            //print characters at even places
            printLine(testString,false);
            System.out.println();
        }
    }
    
    /*
        function name: printLine
        used to print strings with even/odd charater places 
        Input paratmeters: 
        String testString : string to be processes
        boolean add : true - for even places 
                      false - for odd places
        returns void
    */
    
    public static void printLine(String testString,boolean add) { 
        int testStringLength = testString.length();
        for(int i=0;i<testStringLength;i++) {
            int stringPosition = (i*2)+((add==true)?0:1);
            if (stringPosition<testStringLength)
                System.out.print(testString.charAt(stringPosition));
        }
    }
}
