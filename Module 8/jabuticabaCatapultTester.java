
 /**
 * The jabuticabaCatapultTester tests the jabuticabaCatapult class.
 * It pads the 2-D array with values and formats everything into a neat table. 
 *
 * @author Blake Fowler
 * @version 2/22/2024
 */


public class jabuticabaCatapultTester {
    public static void main(String[] args) {
        int[] speeds = {20, 25, 30, 35, 40}; // in miles per hour (which is why we converted above) 
        int[] angles = {30, 35, 40, 45, 50, 55}; // in degrees

         
        //Few things are more pleasing than writing "jabuticabaCatapult three times in a row
        jabuticabaCatapult jabuticabaCatapult = new jabuticabaCatapult(speeds, angles);
        double[][] distances = jabuticabaCatapult.getDistances();

        //Everything is printed out in a neat table 
        System.out.println("                 Distance Table (meters)");
        //MPH over the speed column 
        System.out.printf("%-10s", "MPH");
        for (int angle : angles) {
            System.out.printf("%-10s", angle + " deg"); //Degrees following every degree
        }
        System.out.println();
        System.out.println("=======================================================================");

        // Print the table
        for (int i = 0; i < speeds.length; i++) {
            System.out.printf("%-10s", speeds[i]);
            for (int j = 0; j < angles.length; j++) {
                System.out.printf("%-10.2f", distances[i][j]);
            }
            System.out.println();
        }
    }
}
