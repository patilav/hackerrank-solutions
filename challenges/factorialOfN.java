import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class factorialOfN {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int fact = sn.nextInt();
        
        BigInteger product = BigInteger.valueOf(fact);
        for (int i = (fact - 1); i > 0; i--) {
            product = product.multiply((BigInteger.valueOf(i)));
        }
        if(fact == 0){
            System.out.println("1");
        } else {
            System.out.println(product);
        }
    }
}
