/**
 * A program to allow students to try out different
 * String methods.
 *
 * Code adapted from work by Laurie White for the College Board.
 *
 * @author Blake Fowler
 * @version 1/16/2024
 */
public class StringEXPLORER 
{

    public static void main(String[] args)
    {
        String sample = "The quick brown fox jumped over the lazy dog.";
        System.out.println("sample = " + sample);
        System.out.println();

        //  Demonstrate the indexOf method.
        int position = sample.indexOf("quick");
        System.out.println("sample.indexOf(\"quick\") = " + position);

        int notFoundPos  = sample.indexOf("slow");
        System.out.println("sample.indexOf(\"slow\") = " + notFoundPos);

        position = sample.indexOf("o");
        System.out.println("sample.indexOf(\"o\") = "+ position);
        position = sample.indexOf("o", position + 1);
        System.out.println("sample.indexOf(\"o\", position + 1) = " + position);

        System.out.println();

        // Demonstrate the toLowerCase method.
        String lowerCase = sample.toLowerCase();
        System.out.println("sample.toLowerCase() = " + lowerCase);
        System.out.println("After toLowerCase(), sample = " + sample);
        System.out.println();

        boolean isEqual = sample.equals(sample.toLowerCase());
        System.out.println("sample.equals(sample.toLowerCase() = "+ isEqual);

        // I used a phrase from a song I like to demonstrate how to use spacing. 
        String slimShady = "Guess who's back? Shady's back.";
        System.out.println("Who's back? = " + "   " + slimShady + "   ");
        System.out.println("This string demonstrates padidng the beginning and of a string literal with spaces.");
        
        //trim()
        System.out.println();
        String trimExample = " Shut up and dance with me ";  //Also from a song 
        System.out.println(trimExample);
        String trimmedtrimExample = trimExample.trim();
        System.out.println(trimmedtrimExample);
        
        //length()
        System.out.println();
        String lengthExample = "We share 98% of our DNA with chimpanzees.";  //A random fact that was floating around in my brain at the time
        int length = lengthExample.length();
        
        System.out.println("Original String: \"" + lengthExample + "\"");
        System.out.println("Length of the String: " + length);
        
        
        //indexOf 
        String indexExample = "Why you always in a mood?"; //From another song 
        
        int indexAfter4 = indexExample.indexOf('o', 4);
        
        System.out.println("Original String: \"" + indexExample + "\"");
        System.out.println("Index of 'o' after index 4: " + indexAfter4);
        
        //substring()
        System.out.println();
        String sentenceChanged = "Valor Morghulis"; //From a book series I enjoy 
        
        // Extract a substring from index 7 to 12 (exclusive)
        String substringExample = sentenceChanged.substring(6, 15);
        
        System.out.println("Original String: \"" + sentenceChanged + "\"");
        System.out.println("Substring from index 7 to 12: \"" + substringExample + "\"");
        
        
        //compareTo()
        System.out.println();
        String compareFirst = "Steve Jobs";  //Two important men in the realm of personal computing 
        String compareSecond = "Bill Gates";
        
        int result = compareFirst.compareTo(compareSecond);
        
        System.out.println("Comparison result: " + result);


       //I personally think SJ is cooler than BG so I specified the code below to give me a resposne I liked. 
        if (result < 0) {
            System.out.println(compareFirst + " is not as cool as " + compareSecond); 
        } else if (result > 0) {
            System.out.println(compareFirst + " is cooler than " + compareSecond);
        } else {
            System.out.println(compareFirst + " is equally cool as " + compareSecond);
        }
        
        
      //Another trim example
       System.out.println();
       String msg = "Please Excuse My Dear Aunt Sally";  //I discovered another way to use trim() while reviewing detailed here
       String msg7 = msg.substring(6, 14).trim();
       System.out.println(msg7);

    }

}