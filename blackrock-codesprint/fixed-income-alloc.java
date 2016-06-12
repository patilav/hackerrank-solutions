import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Portfolio { 
    private String portfolioName;
    private int orderQantity;
    
    public Portfolio(String name,int qty) {
        this.portfolioName=name;
        this.orderQantity=qty;
    }
    public int compare(Portfolio p1,Portfolio p2){
        return p1.orderQantity-p2.orderQantity;
    }
    public int compareTo(Portfolio p1){
        return (this.portfolioName).compareTo(p1.portfolioName);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        int totatPortfolios=Integer.parseInt(sn.nextLine());
        int minimumTradeSize=sn.nextInt();
        int increament=sn.nextInt();
        int availableUnits=sn.nextInt();
        List<Portfolio> portfolios=new ArrayList<Portfolio>;
        int totalOrderQuantity;
        for(int i=0;i<totatPortfolios;i++) { 
            String portfolioLine=sn.nextLine();
            String[] portfolioDetails = str.split(" ");
            String portfolioName=portfolioDetails[0];
            int orderQuantity=Integer.parseInt(portfolioDetails[1]);
            totalOrderQuantity+=orderQuantity;
            Portfolio p=new Portfolio(portfolioName,orderQuantity);
            portfolios.add(Portfolio);
        }
        fulfillPortfolioOrders(portfolios,
                               totatPortfolios,
                               minimumTradeSize,
                               increament,
                               availableUnits,
                               totalOrderQuantity);
    }
    public static void fulfillPortfolioOrders(List<Portfolio> portfolios,
                                              int totatPortfolios,
                                              int minimumTradeSize,
                                              int increament,
                                              int availableUnits,
                                              int totalOrderQuantity) { 
        Collections.sort(portfolios,new Portfolio());
        
        for(Portfolio p:portfolios){ 
            double portfolioAllocation=(p.orderQantity/totalOrderQuantity)*availableUnits;
            if(portfolioAllocation<minimumTradeSize) {
               if (portfolioAllocation>minimumTradeSize/2) 
               {
                   
               } else {
                   //not able to allocate make portfolio name - 0
               }
                
            } else { // portfolioAllocation>=minimumTradeSize
                if (portfolioAllocation>p.orderQantity) {
                    double amountTobeTraded=(portfolioAllocation-minimumTradesize)/increamemnt;
                    boolean isAllocationTradable=(amountTobeTraded.intValue()==amountTobeTraded)?true:false;
                    if (isAllocationTradable) { 
                        // allocate the p.orderQantity to the portfolio name and 
                        // recaluate the availableUnits and portfolioAllocation and totalOrderQuantity
                    }
                    if(portfolioAllocation)
                    
                }
                
            } 
        }
    }
}
