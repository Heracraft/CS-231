/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project A: Method Library
 *
 * STUDENT TEST HARNESS
 *
 * PURPOSE:
 *   This file allows you to run basic tests against your
 *   Project_A methods before submitting your work.
 *
 * IMPORTANT NOTES:
 *   - This harness is NOT exhaustive.
 *   - Passing these tests does NOT guarantee full credit.
 *   - The course staff will run additional hidden tests.
 *
 * HOW TO USE:
 *   1. Place this file in the same directory as Project_A.java
 *   2. Compile both files:
 *        javac Project_A.java Project_A_Tester.java
 *   3. Run the tester:
 *        java Project_A_Tester
 *
 * ============================================================
 */

public class Project_A_Tester {

    private static int testsRun = 0;
    private static int testsPassed = 0;

    public static void main(String[] args) {
        System.out.println("Running Project A tests...\n");

        testReverseInt();
        testReverseString();
        testIsPalindrome();
        testCountVowels();
        testReverseArray();
        testSwap();
        testConcatenateArrays();
        testCheckCase();
        testHasAdjacentValue();
        testHasDuplicates();

        System.out.println("\n====================================");
        System.out.println("Tests passed: " + testsPassed + "/" + testsRun);
        System.out.println("====================================");
    }

    /* ========================================================
     * Utility helpers
     * ======================================================== */

    private static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        String result = "{";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) result += ", ";
        }
        return result + "}";
    }

    private static void assertEquals(int expected, int actual, String label) {
        testsRun++;
        if (expected == actual) {
            testsPassed++;
            System.out.println("PASS: " + label + " | expected=" + expected + ", got=" + actual);
        } else {
            System.out.println("FAIL: " + label + " | expected=" + expected + ", got=" + actual);
        }
    }

    private static void assertEquals(boolean expected, boolean actual, String label) {
        testsRun++;
        if (expected == actual) {
            testsPassed++;
            System.out.println("PASS: " + label + " | expected=" + expected + ", got=" + actual);
        } else {
            System.out.println("FAIL: " + label + " | expected=" + expected + ", got=" + actual);
        }
    }

    private static void assertArrayEquals(int[] expected, int[] actual, String label) {
        testsRun++;

        if (expected == null || actual == null) {
            System.out.println("FAIL: " + label + " | expected=" + arrayToString(expected)
                               + ", got=" + arrayToString(actual));
            return;
        }

        if (expected.length != actual.length) {
            System.out.println("FAIL: " + label + " | expected=" + arrayToString(expected)
                               + ", got=" + arrayToString(actual));
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                System.out.println("FAIL: " + label + " | expected=" + arrayToString(expected)
                                   + ", got=" + arrayToString(actual));
                return;
            }
        }

        testsPassed++;
        System.out.println("PASS: " + label + " | result=" + arrayToString(actual));
    }

    /* ========================================================
     * Individual task tests
     * ======================================================== */

    private static void testReverseInt() {
        System.out.println("-- Task 1: reverseInt --");
        assertEquals(321, Project_A.reverseInt(123), "reverseInt(123)");
        assertEquals(5, Project_A.reverseInt(5), "reverseInt(5)");
        assertEquals(0, Project_A.reverseInt(0), "reverseInt(0)");
        System.out.println();
    }

    private static void testReverseString() {
        System.out.println("-- Task 2: reverseString --");
        String input = "abc";
        String result = Project_A.reverseString(input);
        testsRun++;
        if ("cba".equals(result)) {
            testsPassed++;
            System.out.println("PASS: reverseString(\"" + input + "\") | result=\"" + result + "\"");
        } else {
            System.out.println("FAIL: reverseString(\"" + input + "\") | result=\"" + result + "\"");
        }
        System.out.println();
    }

    private static void testIsPalindrome() {
        System.out.println("-- Task 3: isPalindrome --");
        String s1 = "racecar";
        String s2 = "hello";
        assertEquals(true, Project_A.isPalindrome(s1), "isPalindrome(\"" + s1 + "\")");
        assertEquals(false, Project_A.isPalindrome(s2), "isPalindrome(\"" + s2 + "\")");
        System.out.println();
    }

    private static void testCountVowels() {
        System.out.println("-- Task 4: countVowels --");
        String s1 = "hello";
        String s2 = "AEiou";
        assertEquals(2, Project_A.countVowels(s1), "countVowels(\"" + s1 + "\")");
        assertEquals(5, Project_A.countVowels(s2), "countVowels(\"" + s2 + "\")");
        System.out.println();
    }

    private static void testReverseArray() {
        System.out.println("-- Task 5: reverseArray --");
        int[] data = {1, 2, 3};
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, Project_A.reverseArray(data), "reverseArray({1, 2, 3})");
        System.out.println();
    }

    private static void testSwap() {
        System.out.println("-- Task 6: swap --");
        int a = 3;
        int b = 7;
        int[] expected = {7, 3};
        assertArrayEquals(expected, Project_A.swap(a, b), "swap(" + a + ", " + b + ")");
        System.out.println();
    }

    private static void testConcatenateArrays() {
        System.out.println("-- Task 7: concatenateArrays --");
        int[] a = {1, 2};
        int[] b = {3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, Project_A.concatenateArrays(a, b),
                          "concatenateArrays(" + arrayToString(a) + ", " + arrayToString(b) + ")");
        System.out.println();
    }

    private static void testCheckCase() {
        System.out.println("-- Task 8: checkCase --");
        assertEquals(1, Project_A.checkCase("HELLO"), "checkCase(\"HELLO\")");
        assertEquals(0, Project_A.checkCase("hello"), "checkCase(\"hello\")");
        assertEquals(-1, Project_A.checkCase("HeLLo"), "checkCase(\"HeLLo\")");
        System.out.println();
    }

    private static void testHasAdjacentValue() {
        System.out.println("-- Task 9: hasAdjacentValue --");
        int[] nums = {1, 2, 2, 3};
        assertEquals(true, Project_A.hasAdjacentValue(nums, 2),
                     "hasAdjacentValue(" + arrayToString(nums) + ", 2)");
        assertEquals(false, Project_A.hasAdjacentValue(nums, 3),
                     "hasAdjacentValue(" + arrayToString(nums) + ", 3)");
        System.out.println();
    }

    private static void testHasDuplicates() {
        System.out.println("-- Task 10: hasDuplicates --");
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 1};
        assertEquals(false, Project_A.hasDuplicates(a),
                     "hasDuplicates(" + arrayToString(a) + ")");
        assertEquals(true, Project_A.hasDuplicates(b),
                     "hasDuplicates(" + arrayToString(b) + ")");
        System.out.println();
    }
}
