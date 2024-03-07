/**
 * Purpose: This main class works together with Music.java to print out a table of songs
 * that includes the song title, year it was released, and the artist that made it. This tester class
 * creates these songs by use of an array, and uses methods to perform binary searches. 
 *
 * @author Blake Fowler
 * @version 2/19/2024
 *
 */




public class MusicTesterV3 {
    public static void main(String[] args)
    {
        //Our song array and all our songs
        Music[] songs = new Music[10];

       //Same songs as in 8.01
        songs[0] = new Music("No Hands", 2010,   "Waka Flocka Flame");
        songs[1] = new Music("Shut Up and Dance", 2014,   "Walk the Moon");
        songs[2] = new Music("I Wanna Be Yours",  2013, "Arctic Monkeys");
        songs[3] = new Music("Do I Wanna Know?", 2013, "Arctic Monkeys");
        songs[4] = new Music("My Ordinary Life", 2017, "The Living Tombstone");
        songs[5] = new Music("Bang!", 2021,    "AJR");
        songs[6] = new Music("Starboy", 2016,    "The Weeknd");
        songs[7] = new Music("The Box",  2019, "Roddy Ricch");
        songs[8] = new Music("Ashes", 2020, "Stellar");
        songs[9] = new Music("Bank Account",  2017, "21 Savage");
        
        
        //Data printed out before we go and change everything
        System.out.println("<<<<<<<<<< Original Table >>>>>>>>>>>>>");
        printSongs(songs); 
        
        //Sorting songs by title with an insertion sort
        System.out.println("");
        System.out.println("<<<<<<<<<<<Sorting songs by Title>>>>>>>>>>>");
        insertionTitle(songs);
        printSongs(songs);

 
       //Sorting songs by artist with an insertion sort
        System.out.println("");
        System.out.println("<<<<<<<<<<<Sorting songs by Artist>>>>>>>>>>");
        insertionArtist(songs);
        printSongs(songs);
        
        //Sorting years with a selection sort (To change things up a bit)
        System.out.println("");
        System.out.println("<<<<<<<<<<<Sorting songs by Year>>>>>>>>>>>>");
        selectionYear(songs);
        printSongs(songs); 
        
        System.out.println("\n\nSearching by Title");
        System.out.println("----------------------");
        
        //Binary search for a song title (In this case Bang! by AJR)
        System.out.println("\n\nSearching Bang!: "); 
        insertionTitle(songs); //Our sort enables us to do a binary search
        int foundIndex = binarySearchTitle(songs, "Bang!"); //Initialize index to find location with specifications
        if (foundIndex != -1) {  //If it is to be found, or not -1, we print it out at using the index we found it at
        System.out.println(songs[foundIndex]);
        } else {
         System.out.println("I'm sorry, but that is not in the data set.");
}

        System.out.println("\n\nSearching Loafers : "); //Song by BoyWithUke (it's good)
        insertionTitle(songs);
        foundIndex = binarySearchTitle(songs, "Loafers");
        if (foundIndex != -1) {
        System.out.println(songs[foundIndex]);
        }
        else {
        System.out.println("I'm sorry, but that is not in the data set.");
        System.out.println("Maybe discover a new song?"); //Just a friendly suggestion
        }

       //Searching by artist
       System.out.println("\n\nSearching by Artist");
       System.out.println("-----------------------");
        
        System.out.println("\n\nSearching Arctic Monkeys: ");
        insertionArtist(songs);
        binarySearchArtist(songs, "Arctic Monkeys");
        
        System.out.println("\n\nSearching BoyWithUke: ");
        insertionArtist(songs);
        binarySearchArtist(songs, "BoyWithUke: "); //I was going to include him so I'll stick him here
        
         
         
       //Searching by date
        System.out.println("\n\nSearching by Date");
        System.out.println("--------------------");

          
        
        
        System.out.println("\n\nSearching 2017: ");
        selectionYear(songs);
        binarySearchYear(songs, 2017);

   
        System.out.println("\n\nSearching 1991 2077: ");
        selectionYear(songs);
        binarySearchYear(songs, 1991); //I hope you don't love the year 1991 I randomly picked it in truth
        


}
      //Prints out a nice little table for us using a for statement. 
       public static void printSongs(Music[] s)
    {
        System.out.println("Title                      Year        Artist");
        System.out.println("-------------------------------------------------------");
        for(int i = 0; i < s.length; i++)
            System.out.println(s[i]);
    }
    
    
    //Uses a binary search to find titles 

    public static int binarySearchTitle(Music[] s, String toFind) {
    int high = s.length - 1;
    int low = 0;
    int probe;

    while (low <= high) {
        probe = (high + low) / 2;
        int comparisonResult = s[probe].getTitle().compareTo(toFind);
        if (comparisonResult == 0)
            return probe; // we found the title at the index probe
        else if (comparisonResult < 0)
            low = probe + 1; // title is in the upper half
        else
            high = probe - 1; // title is in the lower half
    }
    
    return -1; //Title does not exist (as far as our program is concerned, at least)
}        
        
        

               
   //Method for a binary search with year
   public static int binarySearchYear(Music[] s, int toFind) {  //definitely important to make toFind an integer and not string
    int high = s.length - 1;
    int low = 0;
    int probe;

    while (low <= high) {
        probe = (high + low) / 2;
        if (s[probe].getYear() == toFind) {
            // Found the year at index probe
            int firstIndex = probe;
            while (firstIndex > 0 && s[firstIndex - 1].getYear() == toFind) {
                firstIndex--;
            }
            // Print all instances of the year (like in 8.01)
            for (int i = firstIndex; i <= probe; i++) {
                System.out.println(s[i]);
            }
            return probe; // Return the index of the last occurrence
        } else if (s[probe].getYear() < toFind)
            low = probe + 1; // Year is in the upper half
        else
            high = probe - 1; // Year is in the lower half
    }

    System.out.println(toFind + " is musically unimportant in our opinion.");
    System.out.println("Find a better year!");
    return -1; // Year does not exist
}


   //Binary search for artist     
   public static void binarySearchArtist(Music[] s, String toFind) {
    int high = s.length;
    int low = -1;
    int probe;

    //Comments above still apply 
    while (high - low > 1) {
        probe = (high + low) / 2;

        if (s[probe].getArtist().compareTo(toFind) > 0)
            high = probe;
        else {
            low = probe;
            if (s[probe].getArtist().compareTo(toFind) == 0) {
                break;
            }
        }
    }

     //Linear method based off TestAssignment2 employed to find all instances of artist names
    if ((low >= 0) && (s[low].getArtist().compareTo(toFind) == 0)) {
        linearPrintArtist(s, low, toFind);
    } else
        System.out.println("We could not find  " + toFind + "in our data set. Explore new artists!");
}

//Our SUPER handy linear search. 
public static void linearPrintArtist(Music[] s, int low, String toFind) {
    int i;
    int start = low;
    int end = low;

    // find starting point of matches
    i = low - 1;
    while ((i >= 0) && (s[i].getArtist().compareTo(toFind) == 0)) {
        start = i;
        i--;
    }
    // find ending point of matches
    i = low + 1;
    while ((i < s.length) && (s[i].getArtist().compareTo(toFind) == 0)) {
        end = i;
        i++;
    }
    // now print out the matches
    for (i = start; i <= end; i++)
        System.out.println(s[i]);
}        
        
        
     //Insertion sort used for song titles 
     public static void insertionTitle(Music[] source) {
    for (int i = 1; i < source.length; i++) {
        Music key = source[i];
        int j = i - 1;
        while (j >= 0 && source[j].getTitle().compareTo(key.getTitle()) > 0) {
            source[j + 1] = source[j];
            j = j - 1;
        }
        source[j + 1] = key;
        //Included but commented out as instructed
     /*   System.out.println("\nPass # " + i);
            for(Music a : source)  
                if( a != null) System.out.printf("%-20s \n", a.getTitle() ); */
    }
    }
    
    //Insertion sort used for artist names 
    public static void insertionArtist(Music[] source) {
    for (int i = 1; i < source.length; i++) {
    Music key = source[i];
    int j = i - 1;
    while (j >= 0 && source[j].getArtist().compareTo(key.getArtist()) > 0) {
    source[j+1] = source[j];
    j = j - 1;
    }
    source[j+1] = key;
    //Included but commented out as instructed
  /*  System.out.println("\nPass # " + i);
            for(Music a : source)  
                if( a != null) System.out.printf("%-20s \n", a.getArtist() ); */
    
    
}
}

//Changing things up with selection for year
 public static void selectionYear(Music[] source)
    {
        int i;
        int k;
        int posMax;
        Music temp;

        for( i = source.length - 1 ; i >= 0 ; i-- )
        {
            // find largest element in the i elements
            posMax = 0;
            for( k = 0 ; k <= i ; k++ )
            {
                if(source[k].getYear() < source[posMax].getYear()) {
                    posMax = k;
            }
            /* swap the item with the largest cost 
             with the element in position i
             now the item is in its proper location */
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
            
            //Again, included but commented out as instructed
     /*       System.out.println("\nPass # " + i);
            for(Music a : source)  
                if( a != null) System.out.printf("%-20s \n", a.getYear() ); */
   }
   }
   
   
}
} //That's all folks



