import java.util.Arrays;
import java.util.HashMap;

/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Lab 1: Java Foundations
 *
 * IMPORTANT:
 * - This file is tested using a SEPARATE test harness.
 * - Do NOT print inside these methods.
 * - Do NOT read input.
 * - Do NOT change method names or signatures.
 *
 * Each method should be implemented exactly as specified.
 *
 * ============================================================
 */

public class Lab1A {

    /*
     * ========================================================
     * Task 1: Even or Odd
     * ========================================================
     */

    public static boolean isEven(int value) {

        // TODO: Return true if value is even, false otherwise
        // I want to print out "n is even" or otherwise
        // this requires checking the return value then doing concatenation and all
        // I'll hoist that logic up here so we only run a clean isEven method
        // that'll require changing this method's definition

        // return "%s is %s".formatted(value, (value % 2 == 0) ? "even" : "odd");

        // My bad didn't realize there was a whole testing suite.
        // I'll stop making it pretty

        return value % 2 == 0;
    }

    /*
     * ========================================================
     * Task 2: Positive, Negative, or Zero
     * ========================================================
     */

    public static int signOfNumber(int value) {

        /*
         * Return:
         * 1 if value is positive
         * 0 if value is zero
         * -1 if value is negative
         */

        if (value == 0) {
            return 0;
        } else if (value > 0) {
            return 1;
        } else {
            return -1; // placeholder
        }

    }

    /*
     * ========================================================
     * Task 3: Find Largest Element in an Array
     * ========================================================
     *
     * Assume:
     * values.length >= 1
     */

    public static int maxElement(int[] values) {

        // TODO: Track and return the largest value in the array
        int largestValue = values[0];

        for (int index = 0; index <= values.length - 1; index++) {
            if (values[index] > largestValue) {
                largestValue = values[index];
            }
        }

        return largestValue;
    }

    /*
     * ========================================================
     * Task 4: Array Average
     * ========================================================
     *
     * THINK:
     * What happens if you divide integers?
     */

    public static double arrayAverage(int[] values) {

        // TODO: Compute and return t`he average
        int sum = 0;

        for (int item : values) {
            sum = sum + item;
        }

        return sum / values.length; // placeholder
    }

    /*
     * ========================================================
     * Task 5: Swap Two Values (Returning the Result)
     * ========================================================
     *
     * Java does not support returning multiple values directly.
     *
     * HINT:
     * As you may have discovered, Java does not support
     * a tuple type. How can you return two values using
     * a type you already know?
     *
     * EXAMPLE:
     * swap(3, 7) → {7, 3}
     */

    public static int[] swap(int a, int b) {

        // TODO: Return the values in swapped order

        return new int[] { b, a }; // placeholder
    }

    /*
     * ========================================================
     * Task 6: Merge Two Arrays
     * ========================================================
     *
     * DIRECTIONS:
     * - Given two integer arrays a and b,
     * - Return a NEW array containing all elements of a
     * followed by all elements of b.
     *
     * ASSUME:
     * - a and b are not null
     *
     * EXAMPLE:
     * a = {1, 2, 3}
     * b = {4, 5}
     * mergeArrays(a, b) → {1, 2, 3, 4, 5}
     *
     * RULES:
     * - Do NOT modify the original arrays
     */

    public static int[] mergeArrays(int[] a, int[] b) {

        // TODO: Create a new array of length a.length + b.length
        int[] newArray = new int[a.length + b.length];

        // TODO: Copy elements of a into the new array
        System.arraycopy(a, 0, newArray, 0, a.length);

        // TODO: Copy elements of b into the new array
        System.arraycopy(b, 0, newArray, a.length, b.length);

        return newArray;
    }

    /*
     * ========================================================
     * Task 7: Check Character Case
     * ========================================================
     *
     * Determine whether a single character is uppercase
     * or lowercase using ASCII character values.
     *
     * HINT:
     * Uppercase letters range from 'A' to 'Z'
     * Lowercase letters range from 'a' to 'z'
     *
     * You may compare characters directly:
     * if (ch >= 'a' && ch <= 'z') {
     * // lowercase
     * }
     *
     * if (ch >= 'A' && ch <= 'Z') {
     * // uppercase
     * }
     *
     * @param ch the character to classify
     * 
     * @return 1 if uppercase
     * 0 if lowercase
     * -1 otherwise (not a letter)
     */

    public static int checkCharCase(char ch) {

        // TODO: Check for uppercase letters
        if (ch >= 'A' && ch <= 'Z') {
            return 1;
        }

        // TODO: Check for lowercase letters
        if (ch >= 'a' && ch <= 'z') {
            return 0;
        }

        // TODO: Return the appropriate value
        return -1;

    }

    /*
     * ========================================================
     * Task 8: Adjacent Twos
     * ========================================================
     *
     * Determine whether an array contains the value 2
     * appearing next to another 2.
     *
     * EXAMPLES:
     * has22({1, 2, 2}) → true
     * has22({1, 2, 1, 2}) → false
     * has22({2, 2, 2}) → true
     *
     * HINT:
     * Look at each element and the one immediately after it.
     *
     * ASSUME:
     * - The array has length >= 1
     */

    public static boolean has22(int[] values) {

        // TODO: Loop through the array

        // TODO: Check whether values[i] and values[i + 1] are both 2

        // TODO: Return true if such a pair is found

        byte index = 0;
        for (int item : values) {
            // int nextValue = (index != values.length - 1) ? values[index + 1] :
            // values[index];
            // no need. simply ignore the last element

            if (index == values.length - 1) {
                continue;
            }

            int nextValue = values[index + 1];

            if (item == 2 && nextValue == 2) {
                return true;
            }
            index++;
        }

        return false;
    }

    /*
     * ========================================================
     * Task 9: Count Occurrences
     * ========================================================
     *
     * Count how many times a target value appears in an array.
     *
     * EXAMPLES:
     * countOccurrences({1, 2, 2, 3}, 2) → 2
     * countOccurrences({5, 5, 5}, 5) → 3
     * countOccurrences({1, 2, 3}, 4) → 0
     *
     * ASSUME:
     * - The array has length >= 1
     *
     * @param values the array to search
     * 
     * @param target the value to count
     * 
     * @return the number of times target appears in the array
     */

    public static int countOccurrences(int[] values, int target) {

        // HashMap<Integer, Integer> occurances = new HashMap<>();

        // for (int item: values){
        //     if (item==target){
        //         if (occurances.containsKey(item)){
        //             // we have already stored an occurance
        //             int occurance = occurances.get(item);
        //             occurances.put(item, occurance++);
        //         }
        //         else{
        //             occurances.put(item, 1);
        //         }
        //     }
        // }

        // nvm I'm tripping

        int occurrences = 0;


        for (int item: values){
            if (item==target){
                occurrences++;
            }
        }

        return occurrences; // placeholder
    }

    /*
     * ========================================================
     * Task 10: Is Array Non-Decreasing
     * ========================================================
     *
     * Determine whether the values in an array are in
     * non-decreasing order.
     *
     * Non-decreasing means each value is greater than or equal
     * to the one before it.
     *
     * EXAMPLES:
     * isNonDecreasing({1, 2, 2, 3}) → true
     * isNonDecreasing({1, 3, 2}) → false
     * isNonDecreasing({5}) → true
     *
     * ASSUME:
     * - The array has length >= 1
     *
     * @param values the array to examine
     * 
     * @return true if the array is non-decreasing, false otherwise
     */

    public static boolean isNonDecreasing(int[] values) {

        byte index = 0;

        for (int item: values){
            int prevItem=values[index]; // placeholder
            
            if (index>0){
                prevItem=values[index-1];
            }

            if (item<prevItem){
                return false;
            }
        
            index++;
        }

        return true; // placeholder
    }

    public static void main() {
        // System.out.println("%s is %s".formatted(someNumber, (isEven(29)) ? "even" :
        // "odd"));
        // messy, I know. I only wanted to play with template strings and ternary
        // operators

        // System.out.println("%s is ".formatted(someNumber) + ((isEven(29)) ? "even" :
        // "odd"));
        // still messy. Maybe I should give up on template strings.
        // I'll hoist up all this mess into isEven itself

        // System.out.println(isEven(29));

        // System.out.println(signOfNumber(-30));

        // int[] someArray = { 1, 23, 4, 55 };

        // System.out.println("The largest item in %s is
        // %s".formatted(Arrays.toString(someArray), maxElement(someArray)));

        // System.out.println(arrayAverage(someArray));

        System.out.println(has22(new int[] { 1, 2, 1, 2 }));

    }
}
