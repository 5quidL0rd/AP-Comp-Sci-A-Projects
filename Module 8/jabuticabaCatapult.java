
 /**
 * The jabuticabaCatapult calculates the distance a jabuticaba fruit
 * can be thrown at, converting from MPH to meters per second. Then,
 * the jabuticabaCatapultTester prints out the value in a 2-D array.
 *
 * @author Blake Fowler
 * @version 2/22/2024
 */




import java.util.Arrays;

// Jabuticaba is a rare fruit found in Brazil. 

class jabuticabaCatapult {
  //initializing our 2-D array where everyone can access it
   double[][] distances;

    public jabuticabaCatapult(int[] speeds, int[] angles) {
         distances = new double[speeds.length][angles.length]; //Creating our 2-D array with rows and columns according to speeds and angles
        
        //Rows and columns printed out similarily to Test2D.java
        for (int i = 0; i < speeds.length; i++) {
            for (int j = 0; j < angles.length; j++) {
                distances[i][j] = calcDistance(speeds[i], angles[j]); //calcDistance used to fill it up with data
            }
        }
    }

    //Calculating distance we can chuck a jabuticaba fruit according to speed and angle
    private double calcDistance(int speed, int angle) {
    double radians = Math.toRadians(angle); //Converting to radians as according to Java API 
    double speedMetersPerSecond = ((speed * 1609) / 3600.0); //Converting mile to meters and hour to seconds
    //I elected to use meters per second which use the necessary conversions below
    double constantGRAVITY = 9.81; // m/s^2

    return (speedMetersPerSecond * speedMetersPerSecond) * Math.sin(2 * radians) / constantGRAVITY;  //Returning the distance as according to the formula and math class
}
    //For our tester class
    public double[][] getDistances() {
        return distances;
    }
}

