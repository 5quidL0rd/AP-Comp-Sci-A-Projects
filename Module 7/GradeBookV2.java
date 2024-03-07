/**
 * Purpose:  This class defines a student by their name and quiz grade scores. 
 * It provides many of the methods that will be used to calculate data and print out values
 * in GradeBookTester.java
 *
 * @author < Blake Fowler >
 * @version < 2/13/2024 >
 */





import java.util.ArrayList;

public class GradeBookV2 {
   //Instance variables for the student name and five quiz scores provided below (As instructed in 2. a.)
    private String studentName;
    private int[] quizScores;
    
    
   //Constructor for defining a student object and initializing the quiz scores (As instructed in 2. b.)
    public GradeBookV2(String studentName, int quizGrade1, int quizGrade2, int quizGrade3, int quizGrade4, int quizGrade5) {
        this.studentName = studentName;
        this.quizScores = new int[]{quizGrade1, quizGrade2, quizGrade3, quizGrade4, quizGrade5};
    }

    //Method to secure the name of a student (As instructed in 2. c. iii)
    public String getName() {
        return studentName;
    }

    //A method that takes a quiz number as input (As instructed in 2. c. i.)
   public int[] getScores() {
    return quizScores;
    
}

    //A method that sets a quiz score (As instructed in 2. c. ii.)
    public void setScores(int quizNumber, int score) {
        if (quizNumber >= 1 && quizNumber <= 5) {
            quizScores[quizNumber - 1] = score;
        } else {
            System.out.println("Invalid quiz number.");
        }
    }
 
    //Method to set the name of a student (As instructed in 2. c. iv.)
    public void setName(String name) {
        studentName = name;
    }

     //Changed to meet AP Comp Sci A requirements     
        
        public String toString() {
    String scoresString = "";
    for (int i = 0; i < quizScores.length; i++) {
        if (i != 0) {
            scoresString += ", ";
        }
        scoresString += quizScores[i];
    }
    return studentName + " quiz scores: " + scoresString;
}
        
        
    
}
//End of code