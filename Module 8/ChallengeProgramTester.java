
/**
 * Purpose: This program takes the class challengeProgram.java and with the help of an array and methods 
 * creates a detailed contact table and manipulates the data. The program searches through the data looking for names,
 * relations, birthday months, phone numbers, and email addreseses using sequential searaches, binary searches, sorting methods,
 * and more. 
 *
 * @author Blake Fowler
 * @version 2/28/2024
 *
 */



public class ChallengeProgramTester {
    public static void main(String[] args)
    {
        //Our song array and all our songs
        challengeProgram[] challengeProgram = new challengeProgram[11];

       //Some of my favorite people on this small, damp, bluish-green rock :) 
        
       challengeProgram[0] = new challengeProgram("Nick", "friend", "Dec. 1", "666-666-6666", "belgianfishing@floridakeys.com");
       challengeProgram[1] = new challengeProgram("Aiden", "friend", "March 1", "777-777-7777", "kerbalspaceprogram@asteroidmining.com");
       challengeProgram[2] = new challengeProgram("Miles", "friend", "April 1", "888-888-8888", "chesshcheater@stockfish.com");
       challengeProgram[3] = new challengeProgram("Riley", "brother", "Sept. 1", "999-999-9999", "derangedcinephile@gator.com");
       challengeProgram[4] = new challengeProgram("Anna", "sister", "April 1", "333-333-3333", "littlesister@equestrian.com");
       challengeProgram[5] = new challengeProgram("Lucca", "friend", "Feb. 1", "444-444-4444", "wetnapkinsonface@horsegirl.com");
       challengeProgram[6] = new challengeProgram("Jed", "uncle", "June 1", "555-555-5555", "razorbackcreek@frosthaven.com");
       challengeProgram[7] = new challengeProgram("Seth", "uncle", "Jan. 1", "222-222-2222", "emudruid@marscolonizer.com");
       challengeProgram[8] = new challengeProgram("Shane", "father", "Jan. 2", "111-111-1111", "frusteratedengineer@dadjokes.com");
       challengeProgram[9] = new challengeProgram("Wendy", "mother", "Jan. 3", "123-123-1234", "detailedplanner@brilliantteacher.com");
       challengeProgram[10] = new challengeProgram("Persephone", "pet", "June 20", "444-444-4444", "adorablekitten@hadeskingdom.com");
       
       System.out.println("<<<<<<<<<<<<<<<Original Table>>>>>>>>>>>>>>>>>>>");
       System.out.println("");
       printContacts(challengeProgram);
       System.out.println("");
       
       
       System.out.println("<<<<<<<<<<<<<<<Sorting Names Alphabetically>>>>>>>>>>>>>>");
       System.out.println("");
       insertionName(challengeProgram);
       printContacts(challengeProgram);
       System.out.println("");
       
       
       System.out.println("<<<<<<<<<<<<<<<Sorting Relationship>>>>>>>>>>>>>>>>>>>>>>");
       System.out.println("");
       insertionRelation(challengeProgram);
       printContacts(challengeProgram);
       System.out.println("");
       
       //Binary search for a name
        System.out.println("\n\nSearching Wendy: "); 
        insertionName(challengeProgram); //Our sort enables us to do a binary search
        int foundIndex = binarySearchName(challengeProgram, "Wendy"); //Initialize index to find location with specifications
        if (foundIndex != -1) {  //If it is to be found, or not -1, we print it out at using the index we found it at
        System.out.println(challengeProgram[foundIndex]);
        } else {
         System.out.println("No such person.");
        }
        
        
        System.out.println("\n\nSearching Elon: "); 
        insertionName(challengeProgram); //Our sort enables us to do a binary search
        foundIndex = binarySearchName(challengeProgram, "Elon"); //Initialize index to find location with specifications
        if (foundIndex != -1) {  //If it is to be found, or not -1, we print it out at using the index we found it at
        System.out.println(challengeProgram[foundIndex]);
        } else {
         System.out.println("No such person.");
        }
        
        
        // Binary search for friends
        System.out.println("\n\nSearching friend: ");
        insertionRelation(challengeProgram);
        BinarySearchRelation(challengeProgram, "friend");
        
        //Binary search that has no results
        System.out.println("\n\nSearching girlfriend: ");
        insertionRelation(challengeProgram);
        BinarySearchRelation(challengeProgram, "girlfriend");
        
        
        //Our lovely sequential searches
        
        
        sequentialSearchBirthMonth(challengeProgram, "April");
        
        sequentialSearchBirthMonth(challengeProgram, "August");
        
        sequentialSearchPhoneNumber(challengeProgram, "444-444-4444");
        
        sequentialSearchPhoneNumber(challengeProgram, "180-180-9999");
        
        sequentialSearchEmailAddress(challengeProgram, "frusteratedengineer@dadjokes.com");
        
        sequentialSearchEmailAddress(challengeProgram, "emusk@spacex.com");
        
        System.out.println("\n\nThis is the end of the contact list. Have a good day.");
        
        }
        
        
 
       //THIS IS THE END OF THE LAND OF MAIN. TREAD WITH CAUTION
       

       
       
       
       
       
       
       
       //Prints out a nice little table for us using a for statement. 
       public static void printContacts(challengeProgram[] c)
    {
        System.out.println("Name           Relation        Birthday     Phone Number     Email Address");
        System.out.println("---------------------------------------------------------------------------");
        for(int i = 0; i < c.length; i++)
            System.out.println(c[i]);
    }
       
        
        
   public static void insertionName(challengeProgram[] source) {
    for (int i = 1; i < source.length; i++) {
        challengeProgram key = source[i];
        int j = i - 1;
        while (j >= 0 && source[j].getName().compareTo(key.getName()) > 0) {
            source[j + 1] = source[j];
            j = j - 1;
        }
        source[j + 1] = key;
        //Included but commented out as instructed
      /*  System.out.println("\nPass # " + i);
            for(challengeProgram a : source)  
                if( a != null) System.out.printf("%-20s \n", a.getName() ); */
    }
    }
    
    public static void insertionRelation(challengeProgram[] source) {
    for (int i = 1; i < source.length; i++) {
        challengeProgram key = source[i];
        int j = i - 1;
        while (j >= 0 && source[j].getRelation().compareTo(key.getRelation()) > 0) {
            source[j + 1] = source[j];
            j = j - 1;
        }
        source[j + 1] = key;
        //Included but commented out as instructed
      /*  System.out.println("\nPass # " + i);
            for(challengeProgram a : source)  
                if( a != null) System.out.printf("%-20s \n", a.getRelation() ); */
    }
    }



    public static int binarySearchName(challengeProgram[] c, String toFind) {
    int high = c.length - 1;
    int low = 0;
    int probe;

    while (low <= high) {
        probe = (high + low) / 2;
        int comparisonResult = c[probe].getName().compareTo(toFind);
        if (comparisonResult == 0)
            return probe; // we found the name at the index probe
        else if (comparisonResult < 0)
            low = probe + 1; // name is in the upper half
        else
            high = probe - 1; // name is in the lower half
    }
    
    return -1; //No such person 
}        
        
  
     
     //Binary search for artist     
   public static void BinarySearchRelation(challengeProgram[] c, String toFind) {
    int high = c.length;
    int low = -1;
    int probe;

    //Comments above still apply 
    while (high - low > 1) {
        probe = (high + low) / 2;

        if (c[probe].getRelation().compareTo(toFind) > 0)
            high = probe;
        else {
            low = probe;
            if (c[probe].getRelation().compareTo(toFind) == 0) {
                break;
            }
        }
    }

     //Linear method based off TestAssignment2 employed to find all instances of artist names
    if ((low >= 0) && (c[low].getRelation().compareTo(toFind) == 0)) {
        linearPrintRelation(c, low, toFind);
    } else
        System.out.println("We could not find  " + toFind + " in your contact list.");
}

//Our SUPER handy linear search. 
public static void linearPrintRelation(challengeProgram[] c, int low, String toFind) {
    int i;
    int start = low;
    int end = low;

    // find starting point of matches
    i = low - 1;
    while ((i >= 0) && (c[i].getRelation().compareTo(toFind) == 0)) {
        start = i;
        i--;
    }
    // find ending point of matches
    i = low + 1;
    while ((i < c.length) && (c[i].getRelation().compareTo(toFind) == 0)) {
        end = i;
        i++;
    }
    // now print out the matches
    for (i = start; i <= end; i++)
        System.out.println(c[i]);
}        
        
//Let the Sequential searches begin 
     public static void sequentialSearchBirthMonth(challengeProgram[] c, String month) {
    boolean found = false;
    System.out.println("\n\nSearching for birth month: " + month);
    for (challengeProgram contact : c) {
        String birthday = contact.getBirthday().trim(); // Trim any leading or trailing whitespaces
        int spaceIndex = birthday.indexOf(' ');
        if (spaceIndex != -1) {
            String contactMonth = birthday.substring(0, spaceIndex);
            if (contactMonth.equalsIgnoreCase(month)) {
                found = true;
                System.out.println(contact);
            }
        }
    }
    if (!found) {
        System.out.println("No people found with birth month: " + month);
    }
}     



   public static void sequentialSearchPhoneNumber(challengeProgram[] c, String phoneNumber) {
    boolean found = false;
    System.out.println("\n\nSearching for phone number: " + phoneNumber);
    for (challengeProgram contact : c) {
        if (contact.getPhoneNumber().equals(phoneNumber)) {
            found = true;
            System.out.println(contact);
        }
    }
    if (!found) {
        System.out.println("No people found with phone number: " + phoneNumber);
    }
}   

     
    public static void sequentialSearchEmailAddress(challengeProgram[] c, String emailAddress) {
    boolean found = false;
    System.out.println("\n\nSearching for email address: " + emailAddress);
    for (challengeProgram contact : c) {
        if (contact.getEmailAddress().equals(emailAddress)) {
            found = true;
            System.out.println(contact);
        }
    }
    if (!found) {
        System.out.println("No people found with birth month: " + emailAddress);
    }
}   

     
        
        
}
