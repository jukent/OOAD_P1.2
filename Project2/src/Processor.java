package src;

/**
 * Reader
 * 
 * Methods:
 * clean()
 * sort()
 * make_palindrome()
 * process()
 */

import java.util.Arrays;


class Processor {


    /**
     * @param str: String
     * @return str_cleaned: String
     * 
     * This method cleans a string by 
     * - converting all letters to upper case
     * - discarding white space
     * 
     * Example:
     * clean('Hello world!') -> 'HELLOWORLD!'
     * 
     * Learned about the string method `charAt(i)` from Techie Delight
     * https://www.techiedelight.com/iterate-over-characters-string-java/
     * 
     * Learned about Character `toUpperCase()` method from Stack Overflow
     * https://stackoverflow.com/questions/3696441/converting-a-char-to-uppercase
     * 
     * `str_cleaned.replaceAll(" ", "")` Doesn't seem to work for me so I'm going to use an if test.
     */
    private String clean(String str) {   
        String str_cleaned = new String();
        for (int i =0; i< str.length(); i++) {
            char char_upper = Character.toUpperCase(str.charAt(i));
            if (char_upper != ' ') {
                str_cleaned += char_upper;
            }
        }
        return str_cleaned;
    }


    /**
     * @param str: String
     * @return str_sorted: String
     * 
     * This method sorts the characters of a string into alphabetical order.
     * 
     * Example:
     * sort('juke6049') -> '0469ejku'
     * 
     * Learned that this was as simple as calling `Arrays.sort()` from TutorialsPoint
     * https://www.tutorialspoint.com/how-to-sort-a-string-in-java-alphabetically-in-java
     */
    private String sort(String str) {   
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray); 
        String str_sorted = new String(charArray);
        return str_sorted;
    }


    /**
     * @param str: String
     * @return str: String
     * 
     * This method creates a palindrome of a string 
     * by duplicating characters from the 0th to the -2nd index in reverse order.
     * 
     * This method does not check if the string is already a Paindrome, or if it can be made into a Palindrome
     * with fewer additions.
     * 
     * The desired palindrome direction was unclear to me, but based on comments on Piazza we want
     * make_palindrome('Tivoli') -> 'iloveiTivoli'
     * not:: make_palindrome('Tivoli') -> 'TivoliloveiT'
     * 
     * Example:
     * make_palindrome('Tivoli') -> 'iloveiTivoli'
     * 
     * Changed method name from `palindrome()` to make it a verb
     * 
     */
    private String make_palindrome(String str) {   
        int length = str.length();

        // Since adding characters to beginning of string, need to make separate String objects 
        // so that `str.charAt(i)` doesn't end up in a loop pointing to the same character.
        // i.e. BCERU -> CCCCBCERU
        String str_palindromed = new String();

        for (int i = 1; i <= length-1; i++) {
            str_palindromed = str.charAt(i) + str_palindromed; // instead of += because want to add character to beginning
        }
        str_palindromed += str; //Add original characters
        return str_palindromed;
    }


    /**
     * @param str: String
     * @return str: String
     * 
     * This method loops through cleaning, sorting, and making a palindrome of a string.
     */
    public void process(String str) {
        System.out.println("Cleaning, Sorting, and Making a Palindrome . . .");

        String str_cleaned = clean(str);
        String str_sorted = sort(str_cleaned);
        String str_palindromed = make_palindrome(str_sorted);

        System.out.println(str_palindromed);
    }
}
