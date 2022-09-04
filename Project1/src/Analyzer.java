package src;
/**
 * Analyzer
 * 
 * Methods:
 * calc_median()
 * calc_mean()
 * calc_mode()
 * print_mode()
 * calc_variance()]
 * calc_sdev()
 * calc_min()
 * calc_max()
 * calc_occurances()
 * calc_max_occurances()
 * print_max_occurances()
 * analyze()
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Analyzer {
 

    /**
     * @param userdata: ArrayList<Float>
     * @return median: Float
     *
     * This method calculates the median of an ArrayList of Floats as a Float.
     *
     * Even Array Length Example: 
     *   userdata = [1, 2, 3, 4, 5, 6] // target median is 3.5
     *   length = 6
     *   middle_index = 3
     *   (userdata.get(middle_index) + userdata.get(middle_index-1))/2 = 3.5
     *
     * Odd Array Length Example: 
     *   userdata = [1, 2, 3, 4, 5] // target median is 3
     *   length = 5
     *   middle_index = 2
     *   userdata.get(middle_index) = 3
     */
    private static float calc_median(ArrayList<Float> userdata) {
        // Defining float variable `median` so it is accessible outside of the if/else scope.
        float median;

        Collections.sort(userdata);
        int length = userdata.size();

        // Get half of the length, and downcast to an integer 
        // Drops fractional values (i.e. float 3.5 -> int 3)
        // This is desirable because Java is 0-indexed
        int middle_index = length / 2;

        // If an even number of elements, the median is the average of the 2 middle values
        if (length %2 == 0) {
            median = (userdata.get(middle_index) + userdata.get(middle_index-1))/2;
        } else {
            // If an odd number of elements, the median is the middle value
            median = userdata.get(middle_index);
        }
        return median;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return mean: Float
     *     
     * This method calculates the mean of an ArrayList of Floats as a Float.
     * 
     * Example: 
     *   userdata = [1, 2, 3, 4, 5] // target mean is 3
     *   length = 5
     *   sum = 15
     *   sum / length = 3
     * 
     */
    private static float calc_mean(ArrayList<Float> userdata) {
        int length = userdata.size();

        float mean = 0;
        for (int i = 0; i < length; i++) {
            mean += userdata.get(i);
        }
            
        mean /= length;
        return mean;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return mode_list: ArrayList<Float>
     * 
     * This method calculates a List of modes (Floats) of an ArrayList of Floats by calling up the 
     * 'calc_max_occurances()' method which returns a HashMap of key value pairs
     * for entries that most frequently occur (Floats) mapped to their occurances (Integers), 
     * and then extracts the Float entries into a list.
     * 
     * If no entries are repeated, then there is no mode.
     */
    private static ArrayList<Float> calc_mode(ArrayList<Float> userdata) {
        Hashtable<Float, Integer> max_occurances = calc_max_occurances(userdata);

        Enumeration<Float> keys = max_occurances.keys();
        ArrayList<Float> mode_list = new ArrayList<Float>();
        while(keys.hasMoreElements()){
            Float key = keys.nextElement();
            mode_list.add(key);
        }

        // If all values are equally occuring, then there is no mode.
        int num_length = userdata.size();
        int mode_list_length = mode_list.size();
        if (mode_list_length == num_length) {
            mode_list.clear();
        }
        
        return mode_list;
    }


    /**
     * @param mode_list: ArrayList<Float>
     *
     * This method takes an ArrayList of modes (Floats)
     * and prints the values to the console as a list if the ArrayList has multiple nodes,
     * and as a singe value if there is only one mode. 
     * 
     * If there are no modes, this is printed.
     */
    private static void print_mode(ArrayList<Float> mode_list) {
        int length = mode_list.size();
        if (length ==0) {
            System.out.println("Mode: There is no mode.");
        } else if (length == 1){
            System.out.println("Mode: " + mode_list.get(0));
        } else {
            System.out.println("Modes: " + mode_list);
        }
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return variance: Float
     * 
     * This method calculates the variance of an ArrayList of Floats as a Float.
     */
    private static float calc_variance(ArrayList<Float> userdata) {
        int length = userdata.size();
        float mean = calc_mean(userdata);

        float variance = 0;
        for (int i = 0; i < length; i++) {
            float term = (userdata.get(i) - mean);
            variance += term * term;
        }
        variance /= length;
        return variance;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return sdev: Double
     * 
     * This method calculates the standard deviation of an ArrayList of Floats as a Float.
     */
    private static double calc_sdev(ArrayList<Float> userdata) {
        float variance = calc_variance(userdata);

        // Using Math for square root calculation
        // Seems to require it be a double even though this precision hasn't been propogated through the code.
        double sdev = Math.sqrt(variance);
        return sdev;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return min: Float
     * 
     * This method runs through elements in an ArrayLis of FLoats.
     * If each element is smaller than current minimum, it is set as the new minimum.
     */
    private static float calc_min(ArrayList<Float> userdata) {
        int length = userdata.size();

        float min = userdata.get(0);
        for (int i = 0; i < length; i++) {
                if (userdata.get(i)< min) {
                    min = userdata.get(i);
                };
            }
        return min;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return max: Float
     * 
     * This method runs through elements in ArrayList of Floats.
     * If each element is larger than current maximum, it is set as the new maximum.
     */
    private static float calc_max(ArrayList<Float> userdata) {
        int length = userdata.size();

        float max = userdata.get(0);
        for (int i = 0; i < length; i++) {
                if (userdata.get(i) > max) {
                    max = userdata.get(i);
                };
            }
        return max;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return occurances: Hashtable<Float, Integer>
     * 
     * This method runs through an ArrayList of Floats and generates a Hashatble mapping
     * the set of unique Float values to their occurances (Integers).
     * 
     * Code from TutorialsPoint "Java program to calculate mode in Java"
     * https://www.tutorialspoint.com/Java-program-to-calculate-mode-in-Java
     * 
     * Code on using Hashtables to return multiple values from the Java documentation
     * https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html
     * 
     * Assuming that if multiple values equally and maximally occuring, 
     * the desired behavior is to print all these value-count pairs.
     */
    private static Hashtable<Float, Integer> calc_occurances(ArrayList<Float> userdata) {
        int length = userdata.size();
        Collections.sort(userdata);
        Hashtable<Float, Integer> occurances = new Hashtable<Float, Integer>();

        Float current = null;
        Integer count = 0;
        double threshhold = 0.001;

        for (var i = 0; i < length; i++) {
            // Adding a null check to make `diff` comparison possible (has to be type Float for both values)
            if (current != null) {
                double diff = userdata.get(i) - current;
                if (diff>(-1 * threshhold) && diff<threshhold) {
                    // A number we've encountered before
                    count +=1;
                    occurances.replace(userdata.get(i), count);
                } else {
                // First time encountering this number
                count = 1;
                current = userdata.get(i);
                occurances.put(current, count);
                }
            } else {
                // If `current` is null (i.e. only for the first number)
                count =1;
                current = userdata.get(i);
                occurances.put(current, count);
            }
        }
        return occurances;
    }


    /**
     * @param userdata: ArrayList<Float>
     * @return max_occurances: Hashtable<Float, Integer>
     * 
     * This method calculates the value and count of an ArrayList's maximum occurances
     * by calling up the 'calc_occurances()' method which returns a HashMap of key value pairs
     * for the unique set of Floats and their occurances (Integers), 
     * and then creating a new HashMap with only the key value pairs 
     * that are most occuring.
     * 
     * Example:
     * If the Float entry 2.0 was in the list 3 times (and other numbers were not duplicated more than 3 times) 
     * the answer is value 2.0, count 3.
     * 
     * Code adapted from Stack Overflow
     * https://stackoverflow.com/a/10005160
     */
    private static Hashtable<Float, Integer> calc_max_occurances(ArrayList<Float> userdata) {
        Hashtable<Float, Integer> occurances = calc_occurances(userdata);

        Hashtable<Float, Integer> max_occurances = new Hashtable<Float, Integer>();

        Integer maxCount = 0;
        Iterator<Entry<Float, Integer>> itr = occurances.entrySet().iterator();
        Map.Entry<Float, Integer> entry = null;
        while(itr.hasNext()){
            entry = itr.next();
            if(entry.getValue() > maxCount) {
                max_occurances.clear(); /* New max remove all current max occurances */
                maxCount = entry.getValue();
                max_occurances.put(entry.getKey(), entry.getValue());
            } else if(entry.getValue() == maxCount) {
                max_occurances.put(entry.getKey(), entry.getValue());
            }
        }
        return max_occurances;
    }


    /**
     * @param max_occurances: Hashtable<Float, Integer>
     * 
     * This method takes a Hashtable of the most occuring elements (Floats )of an ArrayList of Floats
     * and how often they occur (Integers), and print the values to the console.
     * 
     * Code on printing a Hashtable from JavaCodeExamples "Print Hashtable in Java Example"
     * https://www.javacodeexamples.com/print-hashtable-in-java-example/3154
     */
    private static void print_max_occurances(Hashtable<Float, Integer> max_occurances) {
        Iterator<Entry<Float, Integer>> itr = max_occurances.entrySet().iterator();
        Map.Entry<Float, Integer> entry = null;
        while(itr.hasNext()){
            entry = itr.next();
            System.out.println("Maximum Occurances: Value " + entry.getKey() + ", Count " + entry.getValue() );
        }
    }


    /**
     * @param userdata: ArrayList<Float>
     * 
     * This method calls up the calculation methods for 8 statistical operations:
     * - median
     * - mean
     * - mode
     * - variance
     * - standard deviation
     * - minimum
     * - maximum
     * - maximum occurances
     * 
     * This method prints the result of the desired operations in turn either in one line
     * for or by calling up a print method (done for mode and maximum occurances).
     */
    public static void analyze(ArrayList<Float> userdata) {
        System.out.println("Beginning statistical analysis of list . . .");

        float median = calc_median(userdata);
        System.out.println("Median: " + median);

        float mean = calc_mean(userdata);
        System.out.println("Mean: " + mean);

        ArrayList<Float> mode = calc_mode(userdata);
        print_mode(mode);

        float variance = calc_variance(userdata);
        System.out.println("Variance: " + variance);

        double sdev = calc_sdev(userdata);
        System.out.println("Standard Deviation: " + sdev);

        float min = calc_min(userdata);
        System.out.println("Minimum: " + min);

        float max = calc_max(userdata);
        System.out.println("Maximum: " + max);

        Hashtable<Float, Integer> max_occurances = calc_max_occurances(userdata);
        print_max_occurances(max_occurances);
    }
}
