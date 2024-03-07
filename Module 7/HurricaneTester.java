/**
 * Starter code for the Hurricane Tester
 *
 *This code takes the methods from Hurricane.java
 *and data from HurricaneData.txt to print out the data
 * in a user-friendly manner.
 *
 *
 * Blake Fowler 2/1/2024
 *
 */
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;  //Included so we can use arrays 
public class HurricaneTester

{

    public static void main(String[] args) throws IOException
    {
        //read data from text file & put in an array
        File fileName = new File("hurricanedata.txt");
        Scanner inFile = new Scanner(fileName);
        int numValues = 0;
        
        //count number of lines in text file
        while (inFile.hasNextLine() )
        {
            inFile.nextLine();
            numValues++;
        }
        inFile.close();
        
        
        //initialize arrays based on lines counted in text file
        int [] years = new int[numValues];
        String [] months = new String[numValues];
        int [] pressures = new int[numValues];
        double [] windSpeeds = new double[numValues];
        String [] names = new String[numValues];
        int [] categories = new int[numValues];
        
        //read and assign data from text file to the arrays
        inFile = new Scanner(fileName);
        int index = 0;
        while(inFile.hasNext() )
        {
            years[index] = inFile.nextInt();
            months[index] = inFile.next();
            pressures[index] = inFile.nextInt();
            windSpeeds[index] = inFile.nextDouble();
            names[index] = inFile.next();
            index++;
        }
        inFile.close();
        
      // Convert the wind speed, determine categories, calculate sums
      
    
        for (int i = 0; i < numValues; i++) {
            // Convert wind speed and determine category
            double windSpeed = windSpeeds[i];
            windSpeed = windSpeed * 1.15078;   //Conversion from knots to mph as according to Google
            int category;                      //Initialization for categorization of categories 
            

           //Our if-else statements to determine categories according to wind speeds after conversion to mph
            if (windSpeed >= 74 && windSpeed <= 95) {
                category = 1;
            } else if (windSpeed >= 96 && windSpeed <= 110) {
                category = 2;
            } else if (windSpeed >= 111 && windSpeed <= 129) {     //Makes sure value is in correct range and increments where necessary
                category = 3;
            } else if (windSpeed >= 130 && windSpeed <= 156) {
                category = 4;
            } else {
                category = 5;
            }

         
            // Hurricane object updated following code
            categories[i] = category;
            
            
             
        }

        // create a Hurricane ArrayList using the data above
        ArrayList<Hurricane> hurricanes = new ArrayList<>();
        
        
       //Use a for loop to add the values to the array from the text file
        for (int i = 0; i < numValues; i++) {
           hurricanes.add(new Hurricane(years[i], names[i], months[i], categories[i], pressures[i], windSpeeds[i]));              
           }

        // User asked to specify the years of the hurricanes
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the starting year: ");
        int startYear = scanner.nextInt();
        System.out.print("Please enter ending year: ");
        int endYear = scanner.nextInt();
        
        
        //Some new variables initialized to calculate the values at the end
        int totalCategories = 0;
        double totalWindSpeed = 0.0;
        int totalPressure = 0;
        int hurricanesInRange = 0;
        
       

        
          
        
         //Initialization of our various categories
        int category1Count = 0;
        int category2Count = 0;
        int category3Count = 0;
        int category4Count = 0;
        int category5Count = 0;

         //Preparation for the max and min values using Java's constants as directed
        int maxCategory = Integer.MIN_VALUE;
        int minCategory = Integer.MAX_VALUE;
        int maxPressure = Integer.MIN_VALUE;
        int minPressure = Integer.MAX_VALUE;
        double maxWindSpeed = Double.MIN_VALUE;
        double minWindSpeed = Double.MAX_VALUE;


        // Print the data for hurricanes within the specified range
        System.out.println("                              Hurricanes " + startYear + "-" + endYear + "                  ");
        System.out.println("Year    Hurricane            Month       Category     Pressure (mb)         Wind Speed (mph)             ");
        System.out.println("=========================================================================================================");
        //enhanced for loop determines whether or not the hurricane falls into year specified by user
        for (Hurricane hurricane : hurricanes) {
            int hurricaneYear = hurricane.getYear();
            if (hurricaneYear >= startYear && hurricaneYear <= endYear) {
                System.out.println(hurricane);
               

                //Using variables from above we add data if the hurricanes meet the criteria specified by the user
                totalCategories += hurricane.getCat();
                totalWindSpeed += hurricane.getWindspeed();
                totalPressure += hurricane.getPressure();
                hurricanesInRange++;
                
                
                // Update maximum and minimum values from user entries 
        maxCategory = Math.max(maxCategory, hurricane.getCat());
        minCategory = Math.min(minCategory, hurricane.getCat());
        maxPressure = Math.max(maxPressure, hurricane.getPressure());
        minPressure = Math.min(minPressure, hurricane.getPressure());
        maxWindSpeed = Math.max(maxWindSpeed, hurricane.getWindspeed());
        minWindSpeed = Math.min(minWindSpeed, hurricane.getWindspeed());
        
        //Time to increment hurricane category count if it meets the criteria 
        
           if (hurricane.getCat() == 1) {
            category1Count++;
        } else if (hurricane.getCat() == 2) {
            category2Count++;
        } else if (hurricane.getCat() == 3) {
            category3Count++;
        } else if (hurricane.getCat() == 4) {
            category4Count++;
        } else if (hurricane.getCat() == 5) {
            category5Count++;
        }
    }
}
        
        // Check if there are hurricanes in the specified range
        if (hurricanesInRange > 0) {
            // Calculate averages with new variables
            double averageCategory = (double) totalCategories / hurricanesInRange;
            double averageWindSpeed = (totalWindSpeed*1.15078) / hurricanesInRange;
            double averagePressure = (double) totalPressure / hurricanesInRange;

            // Print averages out
            
           System.out.println("=========================================================================================================");
           
           System.out.print("                                  Average: ");
           System.out.printf("%-12.1f %-16.1f     %8.2f%n", averageCategory, averagePressure, averageWindSpeed);

        } else {
            System.out.println("\nNo hurricanes found in the specified year range.");
        }
       
                                  
                                  
          
System.out.print("                                  Maximum: ");
System.out.printf("%-12d %-16d     %8.2f%n", maxCategory, maxPressure, maxWindSpeed * 1.15078); 


System.out.print("                                  Minimum: ");
System.out.printf("%-12d %-16d     %8.2f%n", minCategory, minPressure, minWindSpeed * 1.15078);
      

                               

        //Prints out how many hurricanes were between each category total 
        System.out.println("");
        System.out.println("Summary of our Categories:");
        System.out.println("Number of Category 1 Hurricanes: " + category1Count + " hurricanes");
        System.out.println("Number of Category 2 Hurricanes: " + category2Count + " hurricanes");
        System.out.println("Number of Category 3 Hurricanes: " + category3Count + " hurricanes");
        System.out.println("Number of Category 4 Hurricanes: " + category4Count + " hurricanes");
        System.out.println("Number of Category 5 Hurricanes: " + category5Count + " hurricanes");

        scanner.close(); //close scanner out 
    }
}
