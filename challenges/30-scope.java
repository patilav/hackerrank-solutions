import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
  	/* parameterized constructor
       @param elements - array of integers representing the elements
    */
    public Difference(int[] elements) {
        this.elements=elements.clone();
    }
    /*
        function name: computeDifference
        computes the maximum absolute diffrence between the elements
    */
    public void computeDifference() { 
        int difference;
        int currentDifference;
        int elementLength=this.elements.length;
        for(int i=0;i<elementLength;i++) { 
            for(int j=i+1;j<elementLength;j++) {
                currentDifference=getElementDifference(elements[i],elements[j]);
                if (maximumDifference<=currentDifference) {
                    this.maximumDifference=currentDifference; 
                }
            }
        }
    }
    /*
        function name: getElementDifference
        computes the absolute diffrence between the two elements
    */
    public int getElementDifference(int number1,int number2){
        return Math.abs(number1-number2);
    }
  } // End of Difference class

public class Solution {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] a = new int[N];
                for (int i = 0; i < N; i++) {
                    a[i] = sc.nextInt();
                }

                Difference D = new Difference(a);

                D.computeDifference();

              	System.out.print(D.maximumDifference);
            }
        }
