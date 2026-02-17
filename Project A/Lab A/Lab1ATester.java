/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Lab 1-A Test Harness
 *
 * This file tests Lab1A.java.
 *
 * HOW TO USE:
 *   1. Place this file in the same directory as Lab1A.java
 *   2. Compile both files
 *   3. Run this file
 *
 * IMPORTANT:
 *   - Do NOT modify this file
 *   - This file prints results for verification
 *
 * ============================================================
 */

import java.util.Arrays;

public class Lab1ATester {

    /* ========================================================
     * Utility Methods
     * ======================================================== */

    private static void printResult(String testName, boolean passed) {
        if (passed) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName);
        }
    }

    private static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    /* ========================================================
     * Task 1: Even or Odd
     * ======================================================== */

    private static void testIsEven() {
        printResult("isEven(4)", Lab1A.isEven(4) == true);
        printResult("isEven(7)", Lab1A.isEven(7) == false);
    }

    /* ========================================================
     * Task 2: Positive, Negative, or Zero
     * ======================================================== */

    private static void testSignOfNumber() {
        printResult("signOfNumber(10)", Lab1A.signOfNumber(10) == 1);
        printResult("signOfNumber(0)",  Lab1A.signOfNumber(0)  == 0);
        printResult("signOfNumber(-3)", Lab1A.signOfNumber(-3) == -1);
    }

    /* ========================================================
     * Task 3: Find Largest Element
     * ======================================================== */

    private static void testMaxElement() {
        int[] values = {3, 7, 2, 9, 5};
        printResult("maxElement", Lab1A.maxElement(values) == 9);
    }

    /* ========================================================
     * Task 4: Array Average
     * ======================================================== */

    private static void testArrayAverage() {
        int[] values = {2, 4, 6, 8};
        printResult("arrayAverage", Lab1A.arrayAverage(values) == 5.0);
    }

    /* ========================================================
     * Task 5: Swap Two Values
     * ======================================================== */

    private static void testSwap() {
        int[] expected = {7, 3};
        int[] actual   = Lab1A.swap(3, 7);

        printResult("swap(3,7)", arraysEqual(actual, expected));
    }

    /* ========================================================
     * Task 6: Merge Two Arrays
     * ======================================================== */

    private static void testMergeArrays() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};

        int[] expected = {1, 2, 3, 4, 5};
        int[] actual   = Lab1A.mergeArrays(a, b);

        printResult("mergeArrays", arraysEqual(actual, expected));
    }

    /* ========================================================
     * Task 7: Check Character Case
     * ======================================================== */

    private static void testCheckCharCase() {
        printResult("checkCharCase('A')", Lab1A.checkCharCase('A') == 1);
        printResult("checkCharCase('z')", Lab1A.checkCharCase('z') == 0);
        printResult("checkCharCase('7')", Lab1A.checkCharCase('7') == -1);
    }

    /* ========================================================
     * Task 8: Adjacent Twos
     * ======================================================== */

    private static void testHas22() {
        printResult("has22({1,2,2})",
                Lab1A.has22(new int[]{1, 2, 2}) == true);

        printResult("has22({1,2,1,2})",
                Lab1A.has22(new int[]{1, 2, 1, 2}) == false);
    }

    /* ========================================================
     * Task 9: Count Occurrences
     * ======================================================== */

    private static void testCountOccurrences() {
        int[] values = {1, 2, 2, 3};

        printResult("countOccurrences(...,2)",
                Lab1A.countOccurrences(values, 2) == 2);

        printResult("countOccurrences(...,4)",
                Lab1A.countOccurrences(values, 4) == 0);
    }

    /* ========================================================
     * Task 10: Is Array Non-Decreasing
     * ======================================================== */

    private static void testIsNonDecreasing() {
        printResult("isNonDecreasing({1,2,2,3})",
                Lab1A.isNonDecreasing(new int[]{1, 2, 2, 3}) == true);

        printResult("isNonDecreasing({1,3,2})",
                Lab1A.isNonDecreasing(new int[]{1, 3, 2}) == false);
    }

    /* ========================================================
     * Main
     * ======================================================== */

    public static void main(String[] args) {

        System.out.println("=== CS231 Lab 1-A Test Harness ===");

        testIsEven();
        testSignOfNumber();
        testMaxElement();
        testArrayAverage();
        testSwap();
        testMergeArrays();
        testCheckCharCase();
        testHas22();
        testCountOccurrences();
        testIsNonDecreasing();

        System.out.println("=== End of Tests ===");
    }
}