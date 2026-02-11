/**
 * ============================================================
 * CS 231 — Lab B
 * Tester: CircleTester
 *
 * This class is used to test the Circle class.
 *
 * HOW TO USE:
 *  - Implement Circle features one at a time.
 *  - Uncomment each section only after completing
 *    the corresponding functionality.
 *  - Compare console output EXACTLY with expectations.
 *
 * Do NOT submit this file.
 * ============================================================
 */
public class CircleTester {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("CircleTester — BEGIN");
        System.out.println("====================================\n");

        // ----------------------------------------------------
        // Section 1: Test Default Constructor
        // ----------------------------------------------------
        System.out.println("[Section 1] Default Constructor\n");

        Circle cDefault = new Circle();
        System.out.println("Expected: Center: (0.0, 0.0), Radius: 1.0");
        System.out.println("Actual:   " + cDefault + "\n");

        // ----------------------------------------------------
        // Section 2: Test Constructor with Point
        // ----------------------------------------------------
        /*
        System.out.println("[Section 2] Constructor with Point\n");

        Point center = new Point(2.0, 3.0);
        Circle cPoint = new Circle(center, 4.5);

        System.out.println("Expected: Center: (2.0, 3.0), Radius: 4.5");
        System.out.println("Actual:   " + cPoint);
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 3: Test Constructor with Coordinates
        // ----------------------------------------------------
        /*
        System.out.println("[Section 3] Constructor with coordinates\n");

        Circle cCoords = new Circle(-1.0, -1.0, 2.0);
        System.out.println("Expected: Center: (-1.0, -1.0), Radius: 2.0");
        System.out.println("Actual:   " + cCoords);
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 4: Test Radius Validation
        // ----------------------------------------------------
        /*
        System.out.println("[Section 4] Radius validation\n");

        Circle cBadRadius = new Circle(0.0, 0.0, -5.0);
        System.out.println("Radius should be non-negative");
        System.out.println("Actual: " + cBadRadius);
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 5: Test Setters
        // ----------------------------------------------------
        /*
        System.out.println("[Section 5] Setters\n");

        cDefault.setRadius(10.0);
        cDefault.setCenter(new Point(9.0, 9.0));

        System.out.println("After updates:");
        System.out.println("Expected: Center: (9.0, 9.0), Radius: 10.0");
        System.out.println("Actual:   " + cDefault);
        System.out.println();
        */

        // ----------------------------------------------------
        // Section 6: Delegation Check (Visual)
        // ----------------------------------------------------
        /*
        System.out.println("[Section 6] Delegation check\n");

        // If Point.toString() is correct and Circle.toString()
        // calls it, this output should reflect any formatting
        // changes made in Point.
        System.out.println(cDefault);
        System.out.println();
        */

        System.out.println("====================================");
        System.out.println("CircleTester — END");
        System.out.println("====================================");
    }
}
