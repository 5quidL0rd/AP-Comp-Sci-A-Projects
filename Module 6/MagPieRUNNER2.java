
/**
 * A simple class to run the Magpie class.

 * Code adapted from work by Laurie White for the College Board.
 *
 * @author Blake Fowler
 * @version 1/16/2024
 */

import java.util.Scanner;

public class MagPieRUNNER2
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        MagPIE2 maggie = new MagPIE2();

        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

         //I left all of the code unchanged but did include another way to end the conversation for fun
         while (!(statement.equalsIgnoreCase("Bye") || statement.equalsIgnoreCase("Cya")))        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }

}
