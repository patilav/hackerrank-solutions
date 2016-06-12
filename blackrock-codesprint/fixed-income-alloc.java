import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Portfolio implements Comparator<Portfolio>, Comparable<Portfolio>{ 
    public String portfolioName;
    public int orderQantity;
    public int alllocatedValue;
    public Portfolio(){
        this.portfolioName="";
        this.orderQantity=0;
        this.alllocatedValue=0;
    }
    public Portfolio(String name,int qty) {
        this.portfolioName=name;
        this.orderQantity=qty;
        this.alllocatedValue=0;
    }
    public Portfolio(String name,int qty,int allocation) {
        this.portfolioName=name;
        this.orderQantity=qty;
        this.alllocatedValue=allocation;
    }
    public int compare(Portfolio p1,Portfolio p2){
        return p1.orderQantity-p2.orderQantity;
    }
    public int compareTo(Portfolio p1){
        return (this.portfolioName).compareTo(p1.portfolioName);
    }
    public void print(){
        System.out.println("Portfolio Name = "+this.portfolioName+
                          " Order Qantity = "+this.orderQantity+
                          " Alllocated Value = "+this.alllocatedValue);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        int totatPortfolios=Integer.parseInt(sn.nextLine());
        System.out.println("totatPortfolios = "+totatPortfolios);
        int minimumTradeSize=sn.nextInt();
        int increament=sn.nextInt();
        int availableUnits=sn.nextInt();
        System.out.println("minimumTradeSize = "+minimumTradeSize+
                          "increament = "+increament+
                          "availableUnits = "+availableUnits);
        List<Portfolio> portfolios=new ArrayList<Portfolio>();
        int totalOrderQuantity=0;
        String portfolioLine=sn.nextLine();
        for(int i=0;i<totatPortfolios;i++) { 
            portfolioLine=sn.nextLine();
            System.out.println("portfolioLine = "+portfolioLine);
            String[] portfolioDetails = portfolioLine.split(" ");
            String portfolioName=portfolioDetails[0];
            int orderQuantity=Integer.parseInt(portfolioDetails[1]);
            totalOrderQuantity+=orderQuantity;
            Portfolio p=new Portfolio(portfolioName,orderQuantity);
            portfolios.add(p);
            p.print();
        }
        
        fulfillPortfolioOrders(portfolios,
                               totatPortfolios,
                               minimumTradeSize,
                               increament,
                               availableUnits,
                               totalOrderQuantity);
       Collections.sort(portfolios);
       for(Portfolio p:portfolios){
            System.out.println(p.portfolioName+" "+p.alllocatedValue);
       }
    }
    
    public static void fulfillPortfolioOrders(List<Portfolio> portfolios,
                                              int totatPortfolios,
                                              int minimumTradeSize,
                                              int increament,
                                              int availableUnits,
                                              int totalOrderQuantity) {
        Collections.sort(portfolios);
        //Collections.sort(portfolios,new Portfolio());
        int indexOfPortfolio=0;
        for(Portfolio p:portfolios){ 
            int portfolioAllocation=(int)(((double)p.orderQantity/(double)totalOrderQuantity)*(double)availableUnits);
            System.out.println(p.portfolioName+" portfolioAllocation "+portfolioAllocation);
            System.out.println(p.portfolioName+" totalOrderQuantity "+totalOrderQuantity);
            System.out.println(p.portfolioName+" availableUnits "+availableUnits);
            System.out.println(p.portfolioName+" p.orderQantity "+p.orderQantity);
            System.out.println(p.portfolioName+" minimumTradeSize "+minimumTradeSize);
            
            if(portfolioAllocation<minimumTradeSize) {
               System.out.println("inside portfolioAllocation<minimumTradeSize");
               if (portfolioAllocation>minimumTradeSize/2)
               {    System.out.println("inside portfolioAllocation>minimumTradeSize/2");
                    int newOrderQantity=p.orderQantity-(int)portfolioAllocation; 
                    Portfolio newPortfolio=new Portfolio(p.portfolioName,newOrderQantity,(int)portfolioAllocation);
                    // allocate the p.orderQantity to the portfolio name and 
                    portfolios.set(indexOfPortfolio,newPortfolio);
                    totalOrderQuantity-=portfolioAllocation;
                    availableUnits-=portfolioAllocation;
               }
            } else
            {   System.out.println("inside portfolioAllocation>=minimumTradeSize");    
                 //if (portfolioAllocation>=p.orderQantity) {
                 //   System.out.println("inside portfolioAllocation>=p.orderQantity");
                    int newPortfolioAllocation=updatePortfolioOrderDetails(portfolios,p,
                                                            minimumTradeSize,
                                                            increament,
                                                            availableUnits,
                                                            portfolioAllocation,
                                                            indexOfPortfolio);
                        // recaluate the availableUnits and totalOrderQuantity
                        totalOrderQuantity-=newPortfolioAllocation;
                        availableUnits-=newPortfolioAllocation;
                //    } else { 
                //        System.out.println("inside portfolioAllocation<p.orderQantity");
                //    }
                }
                indexOfPortfolio++;
            }
            
        }
    public static int updatePortfolioOrderDetails(List<Portfolio> portfolios,
                                                  Portfolio p,
                                                  int minimumTradeSize,
                                                  int increament,
                                                  int availableUnits,
                                                  double portfolioAllocation,
                                                  int indexOfPortfolio) {
        //int multiplier=(int)portfolioAllocation%minimumTradeSize;
        //System.out.println("multiplier"+multiplier);
        //int multiplier=(int)(portfolioAllocation/(minimumTradeSize+increament));
        int newPortfolioAllocation=0;
        //if (multiplier>0) { 
            newPortfolioAllocation=(int)portfolioAllocation;//minimumTradeSize+increament*multiplier;
            int newOrderQantity=p.orderQantity-newPortfolioAllocation;
            Portfolio newPortfolio=new Portfolio(p.portfolioName,newOrderQantity,newPortfolioAllocation);
            // allocate the p.orderQantity to the portfolio name and 
            portfolios.set(indexOfPortfolio,newPortfolio);
        //}
        return newPortfolioAllocation;
    }
}
