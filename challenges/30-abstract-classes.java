import java.util.*;
abstract class Book
{
    String title;
    String author;
    Book(String t,String a){
        title=t;
        author=a;
    }
    abstract void display();
}
//Write MyBook Class
class MyBook extends Book {
    int price;
    /*
     parameterized constructor
     @param title - string representing tile of my book
     @param author - string representing author of my book 
     @param price - int representing price of my book 
    */
    MyBook(String title,String author,int price) { 
        super(title,author);
        this.price=price;
    }
    public void display() {
        System.out.println("Title: " +this.title+"\nAuthor: "+this.author+"\nPrice: "+this.price);
    }   
}
public class Solution
{
   public static void main(String []args)
   {
      Scanner sc=new Scanner(System.in);
      String title=sc.nextLine();
      String author=sc.nextLine();
      int price=sc.nextInt();
      Book new_novel=new MyBook(title,author,price);
      new_novel.display();
   }
}
