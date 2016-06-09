import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}
class Student extends Person{
	private int[] testScores;
   /* Constructor for Student
   
      Input parameters: String firstName - first name of the student
      			String lastName - last name of the student
      			int id - student id number 
      			int[] scores - array of student scores
   
   */
    public Student(String firstName, String lastName, int id, int[] scores) { 
        super(firstName,lastName,id);
        this.testScores=scores.clone();
    }
    /*
    function name : calculate
    calculates the avegrage score of student and returns grade of student from given set of scores
    Input parameters: None
    Returns: char grade based on the student's average score
    */
    public char calculate() {
        int total = 0;
        int arrayLength = this.testScores.length;
        for(int i=0;i<arrayLength;i++) {
            total+=this.testScores[i];
        }
        float average = total/arrayLength;
        return getGrade(average);
    }
    /*
    function name : getGrade
    calculates the avegrage score of student and returns grade of student from given set of scores
    Input parameters: None
    Returns: char grade based on the student's average score
    */
    public char getGrade(float average)  {
        char grade='T';
        if (average>=90 && average<=100){ 
            grade='O';
        } else if (average>=80 && average<=90){ 
            grade='E';
        } else if (average>=70 && average<=80){ 
            grade='A';
        } else if (average>=55 && average<=70){ 
            grade='P';
        } else if (average>=40 && average<=55){ 
            grade='D';
        } else if (average<=40){ 
            grade='T';
        }
        return grade;
    }
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
