package src;

import java.util.ArrayList;

class Main{


    /**
     * This method queries the user to input any numbers with the `Reader.get_userdata` method
     * and then statistically analyzes this list of numbers with the `Analyzer.analyze` method
     * which performs 8 statistical operations:
     * - median
     * - mean
     * - mode
     * - variance
     * - standard deviation
     * - minimum
     * - maximum
     * - maximum occurances
     * 
     * Results are printed to the console.
     */
    public static void main(String args[]) {
            ArrayList<Float> userdata = src.Reader.get_userdata();
            src.Analyzer.analyze(userdata);
    }
}
