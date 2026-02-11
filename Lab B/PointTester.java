/**
 * ============================================================
 * CS 231 — Lab B
 * Tester: PointTester
 *
 * This class is used to test the Point class.
 *
 * HOW TO USE:
 *  - Start with Section 1 only.
 *  - Uncomment later sections as you implement features.
 *  - Read the console output carefully and compare it
 *    to the expected results in the comments.
 *
 * Do NOT submit this file.
 * ============================================================
 */
public class PointTester {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("PointTester — BEGIN");
        System.out.println("====================================\n");

        // ----------------------------------------------------
        // Section 1: Test Constructors
        // ----------------------------------------------------
        System.out.println("[Section 1] Constructors\n");

        Point pDefault = new Point();
        System.out.println("Default constructor:");
        System.out.println("Expected: (0.0, 0.0)");
        System.out.println("Actual:   " + pDefault + "\n");

        Point pParam = new Point(3.5, -2.0);
        System.out.println("Parameterized constructor:");
        System.out.println("Expected: (3.5, -2.0)");
        System.out.println("Actual:   " + pParam + "\n");

        // ----------------------------------------------------
        // Section 2: Test Getters
        // ----------------------------------------------------
        /*
        System.out.println("[Section 2] Getters\n");

        System.out.println("pParam.getX(): expected 3.5, actual " + pParam.getX());
        System.out.println("pParam.getY(): expected -2.0, actual " + pParam.getY());
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 3: Test Setters
        // ----------------------------------------------------
        /*
        System.out.println("[Section 3] Setters\n");

        pDefault.setX(1.0);
        pDefault.setY(1.0);

        System.out.println("After setting pDefault to (1.0, 1.0):");
        System.out.println("Expected: (1.0, 1.0)");
        System.out.println("Actual:   " + pDefault);
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 4: Re-test toString Formatting
        // ----------------------------------------------------
        /*
        System.out.println("[Section 4] toString formatting\n");

        Point p3 = new Point(0.0, 0.0);
        System.out.println("Expected exactly: (0.0, 0.0)");
        System.out.println("Actual:           " + p3);
        System.out.println();
        */

        System.out.println("====================================");
        System.out.println("PointTester — END");
        System.out.println("====================================");
    }
}
