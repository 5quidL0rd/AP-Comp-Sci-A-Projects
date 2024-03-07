/**
 * Annual Weather object class
 * 
 * @author Blake Fowler
 * @version 1/10/2024
 *
 * This main program adds instance variables for arrays, constructors for all three, and 
 * creates getter and setter methods for all of them. Non-static methods are also included
 * for the method to calculate the average annual temperature and annual precipitation. 
 */

public class CityWeatherV3 {

    private String[] month;        //Initializes private instance variables 
    private double[] temperature;
    private double[] precipitation;

    public CityWeatherV3() {       //initializes arrays with length 12
        month = new String[12];
        temperature = new double[12];
        precipitation = new double[12];
    }


   //Setter and getter methods for all instance variables 
    public void setMonth(int index, String month) {
        this.month[index] = month;
    }

    public String getMonth(int index) {
        return month[index];
    }

    public void setTemp(int index, double temperature) {
        this.temperature[index] = temperature;
    }

    public double getTemperature(int index) {
        return temperature[index];
    }

    public void setPrecipitation(int index, double precipi) {
        this.precipitation[index] = precipi;
    }

    public double getPrecipitation(int index) {
        return precipitation[index];
    }

//Non-static method for average temperature 
    public double averageTemperature() {
        double sum = 0;
        for (int i = 0; i < temperature.length; i++) {
            sum += temperature[i];
        }
        return sum / temperature.length;
    }
//Non-static method for total precipitation 
    public double totalPrecipitation() {
        double total = 0;
        for (int i = 0; i < precipitation.length; i++) {
            total += precipitation[i];
        }
        return total;
    }

//Method for conversion of temperature to Celsius 
    public double temperatureinCelsius(int index) {
        return (getTemperature(index) - 32) * 5 / 9;
    }
//Method for converting inches to centimeters 
    public double calculaterecipitationInCentimeters(int index) {
        return getPrecipitation(index) * 2.54;
    }
}