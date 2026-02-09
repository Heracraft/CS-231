import java.util.Arrays;

/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project 1: Method Library
 *
 * PURPOSE:
 * Implement a small library of static methods involving
 * numbers, strings, and arrays. Each method is tested
 * independently against a course-provided test suite.
 *
 * TESTING MODEL:
 * Your code will be evaluated using a testing harness
 * provided by the course staff.
 *
 * The harness will execute each method independently and
 * provide feedback indicating which tests your code passes
 * and which tests it does not.
 *
 * RULES (READ CAREFULLY):
 *
 * 1. Do NOT change method names or signatures
 *
 * 2. Do NOT add additional methods
 *
 * 3. Do NOT print output (System.out.print / println)
 *
 * 4. Do NOT read input (Scanner, args, etc.)
 *
 * 5. Do NOT modify parameters unless explicitly allowed
 *
 * 6. All methods must be implemented iteratively (no recursion)
 *
 * 7. You may NOT import any libraries or use classes forbidden
 * in the task instructions
 *
 * 8. For all String-based tasks, the ONLY String method you may use
 * is charAt(int index). No other String methods are allowed.
 *
 * ============================================================
 */

public class Project_A {

    /**
     * Task 1: Reverse an Integer
     *
     * Reverse the digits of a non-negative integer.
     *
     * RESTRICTIONS:
     * You must perform this operation numerically using
     * the modulus (%) and division (/) operators.
     *
     * String conversions (e.g., Integer.toString, parsing,
     * or any other String-based approach) are NOT allowed.
     *
     * HINT:
     * You can decompose a number digit-by-digit using
     * the modulus (%) and division (/) operators.
     *
     * Example:
     * int digit = n % 10; // last digit
     * n = n / 10; // remove last digit
     *
     * @param n a non-negative integer whose digits will be reversed
     * @return the integer formed by reversing the digits of n
     */
    public static int reverseInt(int n) {
        // TODO

        int result = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            result = result * 10 + lastDigit;
            n = (int) n / 10;
        }
        return result;
    }

    /**
     * Task 2: Reverse a String
     *
     * Return a new string whose characters appear in reverse order.
     *
     * HINT:
     * The String class provides a charAt(int index) method to
     * access individual characters.
     *
     * Example:
     * char c = input.charAt(0);
     *
     * @param input the original string
     * @return a new string with characters in reverse order
     */
    public static String reverseString(String input) {
        // TODO
        int length = input.length();
        String result = "";

        for (int index = length - 1; index >= 0; index--) {
            result += input.charAt(index);
        }
        return result; // placeholder
    }

    /**
     * Task 3: Palindrome Check
     *
     * Determine whether a string reads the same forwards
     * and backwards.
     *
     * HINT:
     * You only need to compare characters symmetrically from the
     * start and end of the string.
     *
     * Think about how many comparisons are actually necessary.
     *
     * @param input the string to test
     * @return true if input is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        // TODO
        input = input.toLowerCase();

        int length = input.length();
        int middle = Math.floorDiv(length, 2);

        for (int pos = 0; pos < middle; pos++) {
            int oppositePos = (length - pos - 1);
            if (input.charAt(pos) != input.charAt(oppositePos)) {
                return false;
            }
        }

        return true; // placeholder
    }

    /**
     * Task 4: Count Vowels in a String
     *
     * Count the number of vowels in the input string.
     *
     * HINT:
     * Use charAt(i) to examine one character at a time.
     *
     * Example:
     * char c = input.charAt(i);
     *
     * @param input the string to examine
     * @return the number of vowels in input
     */
    public static int countVowels(String input) {
        // TODO
        int vowelCount = 0;

        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    /**
     * Task 5: Reverse an Array
     *
     * Reverse the elements of the given array IN PLACE.
     *
     * You must rearrange the elements within the original array
     * and may NOT allocate any additional arrays or use extra
     * storage beyond a small number of temporary variables.
     *
     * HINT:
     * Consider using two indices:
     * one starting at the beginning of the array,
     * one starting at the end of the array.
     *
     * Swap elements while the indices move toward each other.
     *
     * @param values the array to reverse
     * @return the same array reference after its elements
     *         have been reversed in place
     */
    public static int[] reverseArray(int[] values) {
        // TODO
        int forward = 0; // forward index
        int back = values.length - 1; // backwards index

        // while (forward<values.length && back>=0) {
        while (forward < back) {
            int firstElement = values[forward];
            int secondElement = values[back];

            values[forward] = secondElement;
            values[back] = firstElement;

            forward++;
            back--;
        }

        return values;
    }

    /**
     * Task 6: Swap Two Values
     *
     * Return a two-element array containing the values in swapped order.
     *
     * @param a the first value
     * @param b the second value
     * @return a two-element array {b, a}
     */
    public static int[] swap(int a, int b) {
        // TODO
        int[] newArray = { b, a };

        return newArray; // placeholder
    }

    /**
     * Task 7: Concatenate Two Arrays
     *
     * Return a new array containing all elements of the first array
     * followed by all elements of the second array.
     *
     * HINT:
     * Before copying elements, decide how large the resulting
     * array must be.
     *
     * Array sizes in Java cannot change after creation.
     *
     * @param a the first array
     * @param b the second array
     * @return a new array containing a followed by b
     */
    public static int[] concatenateArrays(int[] a, int[] b) {
        // TODO
        int[] newArray = new int[a.length + b.length];

        System.arraycopy(a, 0, newArray, 0, a.length);
        System.arraycopy(b, 0, newArray, a.length, b.length);
        return newArray;
    }

    /**
     * Task 8: Check String Case
     *
     * Determine whether a string is all uppercase, all lowercase,
     * or mixed case.
     *
     * HINT:
     * Using your knowledge of ASCII character values allows you
     * to determine if a character is uppercase ('A' - 'Z') or
     * lowercase ('a' - 'z').
     *
     * You may compare character values directly:
     * if (currentChar >= 'a' && currentChar <= 'z') {
     * // lowercase
     * }
     *
     * if (currentChar >= 'A' && currentChar <= 'Z') {
     * // uppercase
     * }
     *
     * You may inspect characters using charAt(i).
     *
     * @param input the string to classify
     * @return 1 if all uppercase, 0 if all lowercase, -1 if mixed
     */

    private static boolean isLowerCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    private static boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static int checkCase(String input) {
        // TODO

        if (isLowerCase(input.charAt(0))) {
            // the first charachter is lower case
            // then check if all are lowercase

            for (int index = 0; index < input.length(); index++) {
                char c = input.charAt(index);
                if (!isLowerCase(c)) {
                    return -1;
                }
            }

            return 0;
        } else {
            // the first charachter is upper case
            // then check if all are uppercase

            for (int index = 0; index < input.length(); index++) {
                char c = input.charAt(index);
                if (!isUpperCase(c)) {
                    return -1;
                }
            }
            return 1;
        }
    }

    /**
     * Task 9: Adjacent Value Check
     *
     * Determine whether an integer array contains two adjacent
     * occurrences of a target value.
     *
     * HINT:
     * If you compare nums[i] with nums[i + 1], make sure i
     * never reaches the last index of the array.
     *
     * @param nums   the array to examine
     * @param target the value to check for adjacency
     * @return true if target appears in two adjacent positions,
     *         false otherwise
     */
    public static boolean hasAdjacentValue(int[] nums, int target) {
        // TODO

        int index=0;

        for (int item:nums){
            if (index==nums.length-1){
                break;
            }

            if (item==target && item == nums[index+1]){
                return true;
            }

            index++;
        }

        return false; // placeholder
    }

    /**
     * Task 10: Duplicate Detection
     *
     * Determine whether an integer array contains any duplicate values.
     *
     * HINT:
     * When comparing elements, think about which comparisons
     * are redundant and can be skipped.
     *
     * Ask: once two positions have been compared, do you ever
     * need to compare them again?
     *
     * @param values the array to examine
     * @return true if any value appears more than once, false otherwise
     */
    public static boolean hasDuplicates(int[] values) {
        // TODO
        int middle = Math.floorDiv(values.length, 2);
        int length = values.length;

        for(int index=0;index<middle;index++){
            int backIndex=length-index-1;
            if(values[index]==values[backIndex]){
                return true;
            }
        }

        return false; // placeholder
    }
}
