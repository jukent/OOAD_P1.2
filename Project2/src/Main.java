package src;
public class Main {
    
    
    /**
     * This method method loops through cleaning, sorting, and making a palindrome of a user input String 
     * and prints the final string to the console output.
     */
    public static void main(String args[]) {
        String str = Reader.read();

        System.out.println("Cleaning, Sorting, and Making a Palindrome . . .");
        String str_processed = Processor.process(str);

        System.out.println(str_processed);
    }
}
