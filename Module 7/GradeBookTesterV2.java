/**
 * Purpose:  This class utilizes the class GradeBook.java to print out a data table
 * with information regarding various students. It replaces, adds, and mutates the original 
 * data of a group of five initial students. 
 *
 * @author <Blake Fowler>
 * @version < 2/13/2024 >
 */






import java.util.ArrayList;

public class GradeBookTesterV2 {
    public static void main(String[] args) {
        ArrayList<GradeBookV2> students = new ArrayList<>(); //Creation of our arraylist
        //The fist batch of 5 students with quiz grades as instructed in 3. a. 
        students.add(new GradeBookV2("Blake", 100, 100, 100, 100, 100));
        students.add(new GradeBookV2("Riley", 70, 65, 80, 75, 85));
        students.add(new GradeBookV2("Luke", 90, 85, 95, 80, 75));
        students.add(new GradeBookV2("Taylor", 80, 75, 85, 90, 95));
        students.add(new GradeBookV2("Anna", 95, 90, 85, 80, 75));
        
        /*As instructed in 4. of the assignment, each method is tested below at least once to demonstrate my algorithms.
        every change is explained above the new data table so it should be straightforward to follow*/
        
        //First data table printed out by means of traversing through the data (As instructed in 3. b. i.)
        System.out.println("Original Data:");
        gradeBook(students); 
        System.out.println();
        
        
        //Second data table where a student's name is replaced (As instructed 3. b. ii.)
        System.out.println("Replacing a student's name (Taylor with Ben):");
        replaceStudentName(students, "Taylor", "Ben");
        gradeBook(students);

        //Third data table with a student's quiz grade replaced with a new one (As instructed in 3. b. iii.)
        System.out.println("Replacing Riley's Quiz 1 grade from 70 to 100:");
        changeQuizGrade(students, "Riley", 100);
        gradeBook(students);

        //Fourth data table with a student replaced by another student (As instructed in 3. b. iv.)
        System.out.println("Completely replacing a student (Ben with Nick):");
        completelyReplacingStudent(students, "Ben", "Nick", 1, 1, 1, 1, 1);
        gradeBook(students);

        //A student inserted before another (As instructed in 3. b. v.)
        System.out.println("Inserting a new student: (Lucca before Nick)");
        insertStudent(students, 3, "Lucca", 99, 99, 99, 99, 99);
        gradeBook(students);
 
        //A student is deleted by name (As instructed in 3. b. vi.)
        System.out.println("Deleting a student: (Blake)");
        deleteStudent(students, "Blake");
        gradeBook(students);
    }
    
    
    //Prints out the data in a tidy, neat table (Been looking forward to using this format)
    public static void gradeBook(ArrayList<GradeBookV2> students) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                          "Student", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
        System.out.println("-------------------------------------------------------------------------------");

        for (GradeBookV2 student : students) {
            int[] scores = student.getScores();
            System.out.printf("| %-10s | %-10d | %-10d | %-10d | %-10d | %-10d |%n",
                              student.getName(), scores[0], scores[1], scores[2], scores[3], scores[4]);
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

    //Method for replacing a student
    public static void replaceStudentName(ArrayList<GradeBookV2> students, String oldName, String newName) {
        for (GradeBookV2 student : students) {
            if (student.getName().equals(oldName)) {
                student.setName(newName);
                return;
            }
        }
        System.out.println("Student not found.");
    }

   //Method for changing a single quiz grade
    public static void changeQuizGrade(ArrayList<GradeBookV2> students, String studentName, int newQuizGrade) {
        for (GradeBookV2 student : students) {
            if (student.getName().equals(studentName)) {
                student.setScores(1, newQuizGrade);
                return;
            }
        }
        System.out.println("Student not found.");
    }


     //Method for replacing a student
    public static void completelyReplacingStudent(ArrayList<GradeBookV2> students, String oldName, String newName, int quizGrade1, int quizGrade2, int quizGrade3, int quizGrade4, int quizGrade5) {
    for (GradeBookV2 student : students) {
        if (student.getName().equals(oldName)) {
            student.setName(newName);
            student.setScores(1, quizGrade1);
            student.setScores(2, quizGrade2);
            student.setScores(3, quizGrade3);
            student.setScores(4, quizGrade4);
            student.setScores(5, quizGrade5);
            return;
        }
    }
    System.out.println("Student not found.");
}

//Method for inserting a new student
    public static void insertStudent(ArrayList<GradeBookV2> students, int location, String addName, int quizGrade1, int quizGrade2, int quizGrade3, int quizGrade4, int quizGrade5) {
        if (location >= 0 && location <= students.size()) {
            students.add(location, new GradeBookV2(addName, quizGrade1, quizGrade2, quizGrade3, quizGrade4, quizGrade5));
}    
}
//Method for deleting a student
    public static void deleteStudent(ArrayList<GradeBookV2> students, String find)
    {
        int location = 0;
        int index;

        // find location of item you want to delete
        for(index = 0; index < students.size(); index++)
        {
            if(students.get(index).getName().equals(find))
            {
                location = index;
                break;
            }
        }
        
        // delete item from ArrayList
        if (index != students.size())
            students.remove(location);
    }
}
//End of code

    
    
    
    
