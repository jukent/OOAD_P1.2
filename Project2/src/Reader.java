package src;

/**
 * Reader
 * 
 * Methods:
 * read()
 */

import java.util.Scanner;

public class Reader {
    
  
    /**
     * @return str: String
     * 
     * This method reads a string from the console input.
     */
    public static String read() {   
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter a string: ");
        
        String str = scanner.nextLine();
        scanner.close();

        return str;
    }
}
