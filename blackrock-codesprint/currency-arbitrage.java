import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int transactionMoney = 100000;
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int totalTransactions = Integer.parseInt(sn.nextLine());
        for(int i=0;i<totalTransactions;i++) {
            double usdEurRate = sn.nextDouble();
            double eurGbpRate = sn.nextDouble();
            double gbpUsdRate = sn.nextDouble();
            int arbitarage = calculateArbitarage(usdEurRate,eurGbpRate,gbpUsdRate);
            System.out.println(arbitarage);
        }
    }
    public static int calculateArbitarage(double usdEurRate,double eurGbpRate,double gbpUsdRate){
        double usdEurCost = transactionMoney/usdEurRate;
        double eurGbpCost = usdEurCost/eurGbpRate;
        double gbpUsdCost = eurGbpCost/gbpUsdRate;
        int totalProfitLoss = (int)gbpUsdCost-transactionMoney;
        int arbitarage = (totalProfitLoss<=0)?0:totalProfitLoss;
        return arbitarage;
    }
}
