package src;

/**
 * Reader
 * 
 * Methods:
 * get_userdata()
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Reader {
  
  /**
   * @param 
   * @return userdata
   * 
   * This function repeatedly queries the user to input any real number and appends 
   * that number to an Array List.
   * Querying ends when the user enters a blank line or any value that cannot be 
   * converted to a float. The program exits if the user generated ArrayList has no
   * entries.
   *
   * Code on how to use Scanner to get user input adapted from BeginnersBook 
   * "Java Program to get input from user":
   * https://beginnersbook.com/2014/07/java-program-to-get-input-from-user/
   * 
   * Code on how to use while loop with Scanner adapted from this Stack Overflow quesions:
   * https://stackoverflow.com/a/32415571 and https://stackoverflow.com/a/26779647
   * 
   * Code on how to initiate an Array List from W3 Schools "Java ArrayList":
   * https://www.w3schools.com/java/java_arraylist.asp
   * 
   * Code on how to handle exceptions from W3 Schools "Java Exceptions - Try...Catch"
   * https://www.w3schools.com/java/java_try_catch.asp
   */
  public static ArrayList<Float> get_userdata() {
    System.out.println("This program generates a list of user input numbers. Numbers are added one at a time. To end the list enter a blank line.");

    // Initiate empty ArrayList
    ArrayList<Float> userdata = new ArrayList<Float>();

    // Initial ask for numerical input from user
    System.out.println("Enter a real number: ");

    Scanner scanner = new Scanner(System.in); 

    // Loop until the user input is null
    while(scanner!=null){
      // Reading the user input as a string to avoid calling multiple variations `scanner.next . . .` in the same iteration,
      // As apposed to calling scanner.nextFloat(), because I need to check if empty (which I can't call on a float)
      String line_str = scanner.nextLine();

      // Check if line is empty
      if (line_str.isEmpty()) {
        System.out.println("User exited list generation with: "+ userdata);
        break;
      } else {
        
        // Using exception handling so that incorrect input is another way to exit list generation.
        // As opposed to ending the whole workflow with an error.
        try {
          // Try to convert to a float
          Float fnum = Float.parseFloat(line_str);

          // Append ArrayList with user input
          userdata.add(fnum);

          // Print current list
          System.out.println("Current list: " + userdata);

          // After processing user input, ask again
          System.out.println("Enter a real number: ");
            
        } catch (Exception e) {
          System.out.println("User input must be a number. Exiting list generation with: "+ userdata);
          break;
        }
      }
    }
    scanner.close();

    // Make sure the array is not empty
    if (userdata.size() == 0) {
      System.out.println("The list cannot be empty. Please try again.");
      System.exit(0);
      // I get an error if I don't return this value even though we're exiting
      return userdata;
    } else {
      return userdata;
    }
  }
}
