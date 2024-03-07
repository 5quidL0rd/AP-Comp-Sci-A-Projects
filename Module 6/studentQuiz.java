/**
 * 
 * 
 * @author Blake Fowler
 * @version 1/11/2024
 *
 * This main program declares and initialzes variable, creates all the necessary methods, and contains the 
 * toString method.
 */



public class studentQuiz {
   private String n;      //all of our variables declared privately 
   private double s;
   private double S; 
   // One parameter constructor, all private instance variables initialized
   public studentQuiz(String name) {
      n = name;
      s = 0.0;
      S = 0.0;
   }

   // Two parameter constructor
   public studentQuiz(String name, double score, double secondScore) {
      n = name;
      s = score;
      S = secondScore;
   }

   public String getName() {   //get method for the name
      return n;
   }

   public double getScore() {  //get the first score
      return s;
   }

   public double getSecondScore() {  //get the second score
      return S;
   }

   public void setName(String name) {  //set name 
      n = name;
   }

   public void setScore(double score) {  //set the first score
      s = score;
   }

   public void setSecondScore(double secondScore) {  //set the second score
      S = secondScore;
   }

   public double calcDifference() {  //calculate the difference 
      return s - S;
   }

   public double calcAverage() {  //calculate average
      return (s + S) / 2;
   }

   public String toString() {
      return String.format("%-10s %-12.1f %-12.1f", getName(), getScore(), getSecondScore());
   } //uses the toString method to format the name and scores 
}