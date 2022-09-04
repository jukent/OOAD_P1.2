# 5448OOAD_P1.2
Project 1.2 Homework for 5448:OOAD :: 1) Numerical Entry and Statistical Analysis and 2) String Manipulation

## Project 1: Numerical Entry and Statistical Analysis

src/
    Reader.java
        getuserdata()
    Analyzer.java
        calc_median()
        get_median()
        calc_mean()
        get_mean()
        calc_mode()
        get_mode()
        calc_variance()
        get_variance()
        calc_sdev()
        get_sdev()
        calc_min()
        get_min()
        calc_max()
        get_max()
        calc_occurances()
        calc_max_occurances()
        get_max_occurances()
        analyze()
    Main.java
        main()

NOTES::
My first main challenge was the `while` loop in the `Reader` Class. I tried many different combinations of conditions before I got the code to exit when a blank line is entered. After that, it wasn't too hard to make the code more robust by adding exception handling for the user entering values other than floats or never having entered any values at all.

My next challenge was figuring out the structure of the entire project, instead of just one method, and making sure I understood how information was passed btween Classes. This was my first Java project, so this behavior and explicit typing was my biggest challenge. Luckily the extensions on Visual Studio Code were very helpful! I still don't have a complete grasp of when methods should be static, or if I should have leveraged making them private in this workflow.

The next challenge was the `Analyzer` Class. This file is rather long, and I considered pulling out the functions related to each operation into their own class, but then the naming scheme got a little convoluted and seemed unintuitive to a potential user. I did, however, separate the calculation and printing methods for each operation. This is what I've learned to be best "Clean Coding" practices, and also made it so that the `calc_variance()` method could calculate the mean without printing the mean to the console repeatedly (this was happening for other operations as well). I decided to calculate the mean again within the `calc_variance()` method instead of passing in the mean as an input argument (even though that could save on potential computing time) because I thought that introduced the possibility of a mean that didn't match the passed in array being used for calculation and it seemed clunky to pass in arguments that were derived from each other.

I computed all of the operations on the `ArrayList` type rather than converting to an `Array`. In some of my searching online, I saw a lot of suggestions to convert to an Array before doing math operators. From what I could gather this is because the mutable nature of an `ArrayList` makes it great for appending user data, but a little slower when performing operations that do not require it to still be mutable. However, I couldn't get those methods to work for me and since this was my first Java code I thought I could stick with the types that I did have a good grasp on. Similarly, I didn't do a recursive sum method because I did not fully understand it.

The trickiest operator to execute was the `calc_max_occurances()` and related methods. I ended up splitting this into parts. First was calculating the occurances of the set of all user-input numbers in a `HashMap` (`calc_occurances()`) because I needed to return pairs of values (value and count) and this did the trick (even if the **key** wa(s my `value` and my **value** was count which is potentially confusing). Then I created a new `HashMap` only with the numbers that have the maximum count (could be as many maximum occurances as appear in the data) (`calc_max_occurances()`). And finally printed the `HashMap` with each maximum occurance having a new line of output (`get_max_occurances()`) . The mode (`calc_mode()`) then grabbed the values from this `HashMap`.

Code citation and resources used or adapted are listed in the docstring before each relevant method.


-----------------------------

## Project 2: String Manipulation
