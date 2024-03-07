/**
 * This class demonstrates sorting movies using the insertion sort algorithm.
 * It prints out the unsorted data in a table, before sorting by name, studio,
 * and year of release. 
 *
 * @author Blake Fowler
 * @version 2/15/2024
 */




public class MovieTesterV3 {
    public static void main(String[] args) {
        Movie[] movies = new Movie[10];  //Creation of our arrays 
        Movie[] sorted = new Movie[10];


        //All of our movies
        movies[0] = new Movie("The Social Network", 2010, "Columia Pictures");
        movies[1] = new Movie("Seven Samurai", 1954, "Toho Co. Ltd");
        movies[2] = new Movie("Suzume", 2022, "CoMix Wave Films");
        movies[3] = new Movie("Spirited Away", 2001, "Studio Ghibli");
        movies[4] = new Movie("Monty Python's Holy Grail", 1975, "Python Pictures");
        movies[5] = new Movie("Parasite", 2019, "CJ Entertainment");
        movies[6] = new Movie("Drive My Car", 2021, "Bitters End");
        movies[7] = new Movie("Snowpiercer", 2013, "Moho Film and Opus Pictures");
        movies[8] = new Movie("Dr. Strangelove", 1964, "Columbia Pictures");
        movies[9] = new Movie("Oppenheimer", 2023, "Universal Pictures");
 
  //Data table before any sorting
        System.out.println("    <<<< Before Sorting >>>> \n");
        for (int i = 0; i < movies.length; i++)
           System.out.println(movies[i]);
           
        //Sorting in both ascending and descending order by title
        selectionSortTitle(movies);
 
        System.out.println("\n   <<<< After Sorting >>>>");
        System.out.println("<<<< By title in descending order >>>>\n");
        for(int i = 0; i < movies.length; i++)
            System.out.println(movies[i] );
            
        System.out.println("\n<<<<< By title in ascending order >>>>>>\n");   
        for(int i = sorted.length - 1; i >= 0; i--)
            System.out.println(movies[i] );
        
        
        //Sorting in both ascending and descending order by studio
        selectionSortStudio(movies);
        System.out.println("\n <<<< After sorting >>>>");
        System.out.println("<<<< By Studio in descending order >>>>>\n");
        for (int i = 0; i < movies.length; i++)
        System.out.println(movies[i]);
        
         System.out.println("\n<<<<< By studio in ascending order >>>>>>\n");   
        for(int i = sorted.length - 1; i >= 0; i--)
            System.out.println(movies[i] );
        
        
        //Sorting in both ascending and descending order by year
        selectionSortYear(movies);
        System.out.println("\n <<<< By year in ascending order >>>> \n");
        for (int i = 0; i < movies.length; i++)
        System.out.println(movies[i]);
        
        System.out.println("\n <<<< By year in descending order >>>> \n");
        for (int i = sorted.length - 1; i >= 0; i--)
        System.out.println(movies[i]);
            
            
        
    }
    
    public static void selectionSortTitle(Movie[] source)
    {
        int i;
        int k;
        int posMax;
        Movie temp;

        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            // find largest element in the i elements
            posMax = 0;
            for ( k = 0 ; k <= i ; k++ )
            {
                if ( source[ k ].getTitle().compareTo(source[ posMax ].getTitle()) > 0 )
                    posMax = k;
            }
            // swap the item with the largest cost 
            // with the element in position i
            // now the item is in its proper location
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
            
     }
     }
    
    //Sorting by year
    public static void selectionSortStudio(Movie[] source) {
        int i;
        int k;
        int posMax;
        Movie temp;

    
     for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            // find largest element in the i elements
            posMax = 0;
            for ( k = 0 ; k <= i ; k++ )
            {
                if ( source[ k ].getStudio().compareTo(source[ posMax ].getStudio()) > 0 )
                    posMax = k;
            }
            // swap the item with the largest cost 
            // with the element in position i
            // now the item is in its proper location
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
}
}
     public static void selectionSortYear(Movie[] source)
    {
        int i;
        int k;
        int posMax;
        Movie temp;

        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            // find largest element in the i elements
            posMax = 0;
            for ( k = 0 ; k <= i ; k++ )
            {
                if ( source[ k ].getYear() > (source[ posMax ].getYear()))
                    posMax = k;
            }
            // swap the item with the largest cost 
            // with the element in position i
            // now the item is in its proper location
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
            
     }
     }

    
} 
