package src;
public class Main {
    
    
    /**
     * This method method loops through cleaning, sorting, and making a palindrome of a user input String 
     * and prints the final string to the console output.
     */
    public static void main(String args[]) {
        StringReader reader = new StringReader();
        String str = reader.read();

        Processor processor = new Processor();
        processor.process(str);
    }
}
