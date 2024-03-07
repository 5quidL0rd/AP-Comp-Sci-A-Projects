
/**
 * Annual Weather object class
 * 
 * @author Blake Fowler
 * @version 1/11/2024
 *
 * This program takes the methods and variables from studentQuiz and uses it to create several students
 * and scores and outputs a neatly organized table at the end. 
 */
 
 
public class studentQuizTester {

    public static void main(String[] args) {


//All of our students with names and scores listed below 
        String name1 = "Blake";
        double score1 = 100;
        double secondScore1 = 100;

        String name2 = "Nick";
        double score2 = 99;
        double secondScore2 = 90;

        String name3 = "Aiden";
        double score3 = 98;
        double secondScore3 = 70;

        String name4 = "Ben";
        double score4 = 97;
        double secondScore4 = 84;

        String name5 = "Om";
        double score5 = 96;
        double secondScore5 = 99;

        double difference = 0.0;

//All of our students neatly formatted in an array (broken up for legibility) 
        studentQuiz[] students = {
                new studentQuiz(name1, score1, secondScore1),
                new studentQuiz(name2, score2, secondScore2),
                new studentQuiz(name3, score3, secondScore3),
                new studentQuiz(name4, score4, secondScore4),
                new studentQuiz(name5, score5, secondScore5)
        };
        
        //Below everything is formatted with printf for a readable final product

        System.out.printf("%-15s %15s %15s %15s %15s%n", "Student Name", "Quiz1 Grade", "Quiz2 Grade", "Difference", "Average");
        System.out.println("=========================================================================================");

        // Prints the studentQuiz array of objects using the toString() method
        for (studentQuiz student : students) {
            difference = student.calcDifference();
             System.out.printf("%-15s%15.1f%15.1f%15.1f%15.1f%n",
                    student.getName(), student.getScore(), student.getSecondScore(), difference, student.calcAverage());
        }
    }
}


