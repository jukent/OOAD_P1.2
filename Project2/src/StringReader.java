package src;

/**
 * StringReader
 * 
 * Methods:
 * read()
 */

import java.util.Scanner;

class StringReader {
    
  
    /**
     * @return str: String
     * 
     * This method reads a string from the console input.
     */
    public String read() {   
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter a string: ");
        
        String str = scanner.nextLine();
        scanner.close();

        return str;
    }
}
