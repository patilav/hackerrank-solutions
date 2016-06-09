import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int result = factorial(number);
        System.out.println(result);
    }
    /*
        function name : factorial
        Input parameters: 
            int number = number for which you want to find the factorial
        returns int factorial of number 
        Base case : number = 1
    */
    
    public static int factorial(int number)  { 
       if (number <= 1)
           return 1;
        else
           return (number * factorial(number-1));
    }
}
