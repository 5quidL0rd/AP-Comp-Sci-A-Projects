/*
*
 * Annual Weather object class
 * 
 * @author Blake Fowler
 * @version 1/10/2024
 *
 * This tester programs takes the methods and instance variables from CityWeatherV2 and fills in the necessary data
 * and asks the user to specify how they want the data to be handled. At the end of the program all of the data with the necessary
 * calculations is printed out in a user-friendly way, in part thanks to the use of printf. 
 */



import java.util.Scanner;

public class CityWeatherTesterV3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String city = "Pensacola";    //Great city   :)
        String state = "Florida";     // Great state :)
        String[] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."}; //All of our months
        double[] temperature = {52.0, 54.9, 61.0, 66.9, 74.6, 80.6, 82.6, 82.2, 78.7, 69.5, 60.7, 54.1}; //All of our F temps from 06.01
        double[] precipitation = {5.3, 4.7, 6.4, 3.9, 4.4, 6.4, 8.0, 6.9, 5.8, 4.1, 4.5, 4.0}; //All of our precipitation from 06.01
        String tempLabel = "F"; //Set to Fahrenheit unless the user specifies 
        String precipLabel = "in."; //Set to inches unless the user specifies 

       CityWeatherV2 cityWeather = new CityWeatherV2(); //New instance for class for info 

        // Using setter methods in CityWeatherV2 we set the values for all our instance variables
        for (int i = 0; i < month.length; i++) {
            cityWeather.setMonth(i, month[i]);
            cityWeather.setTemp(i, temperature[i]);
            cityWeather.setPrecipitation(i, precipitation[i]);
        }

        //User decides if they want to use Fahrenheit or Celsius 
        System.out.println("Please choose the temperature scale you wish to use: (F = Fahrenheit, C = Celsius):");
        String chooseTempScale = in.nextLine().toUpperCase(); //Conver to uppercase so both "F" and "f" work 
        while (!chooseTempScale.equals("F") && !chooseTempScale.equals("C")) {
            System.out.println("Invalid input. Please enter 'F' for Fahrenheit or 'C' for Celsius."); //Force them to put the correct answer
            chooseTempScale = in.nextLine().toUpperCase(); //Convert to uppercase so it looks professional 
        }

        if (chooseTempScale.equals("F")) {
            System.out.println("You chose Fahrenheit.");
        } else {
            System.out.println("You chose Celsius.");
            tempLabel = "C"; //Changes "F" to "C" for the final delivery 

            // Since C is specified we need to change our Fahrenheit values to Celsius, executed below 
            for (int i = 0; i < temperature.length; i++) {
                temperature[i] = cityWeather.temperatureinCelsius(i);
            }
        }
        
        //Same deal as above save for precipitation. 
        System.out.println("Now, select the precipitation scale you wish to use: (i = inches, c = centimeters):");
        String choosePrecipScale = in.nextLine().toLowerCase(); // Convert to uppercase
        while (!choosePrecipScale.equals("i") && !choosePrecipScale.equals("c")) {
            System.out.println("Invalid input. Please enter 'i' for inches or 'c' for centimeters.");
            choosePrecipScale = in.nextLine().toLowerCase(); 
        }


        //The user is nice and decides to keep with inches
        if (choosePrecipScale.equals("i")) {
            System.out.println("You chose inches.");
        } else {
            // User decides to make things difficult and chooses centimeters 
            for (int i = 0; i < precipitation.length; i++) {
                precipitation[i] = cityWeather.calculaterecipitationInCentimeters(i);
            }
            System.out.println("You chose centimeters.");
            precipLabel = "cm."; //Change hard-coded value 
        }

        // Time to calculate the average temperature after the conversions
        double averageTemperature = cityWeather.averageTemperature();

        // Same as above but for precipiation
        double totalPrecipitation = cityWeather.totalPrecipitation();

        // Time to print out the final result
        System.out.println();
        System.out.println("           Weather Data");
        System.out.println("      Location: " + city + ", " + state);
        System.out.println("Month     Temperature (" + tempLabel + ")     Precipitation (" + precipLabel + ")");
        System.out.println();
        System.out.println("***************************************************");
        for (int i = 0; i < month.length; i++) {
            // printf used below to perfect our output 
            System.out.printf("%-10s%-20.1f%-20.1f%n", month[i], temperature[i], precipitation[i]); //correct prinf now used for temp and precip
        }
        System.out.println("***************************************************");
        System.out.printf("Average: %.1f    Annual: %.1f%n", averageTemperature, totalPrecipitation);   //printf is now used correctly to print out the data
    }
}