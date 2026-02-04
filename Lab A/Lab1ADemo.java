import java.util.Scanner;

/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Week 1–2 Lecture Demo & Reference
 *
 * Demo 1: Commenting
 *   https://www.w3schools.com/java/java_comments.asp
 *
 * Demo 2: Strings and Output
 *   https://www.w3schools.com/java/java_strings.asp
 *
 * Demo 3: Primitive Data Types
 *   https://www.w3schools.com/java/java_data_types.asp
 *
 * Demo 4: Arithmetic Operators
 *   https://www.w3schools.com/java/java_operators.asp
 *
 * Demo 5: Comparison Operators
 *   https://www.w3schools.com/java/java_operators_comparison.asp
 *
 * Demo 6: Logical Operators
 *   https://www.w3schools.com/java/java_operators_logical.asp
 *
 * Demo 7: if Statements
 *   https://www.w3schools.com/java/java_conditions.asp
 *
 * Demo 8: Compound Conditions
 *   https://www.w3schools.com/java/java_conditions_logical.asp
 *
 * Demo 9: De Morgan's Laws
 *
 * Demo 10: while Loops
 *   https://www.w3schools.com/java/java_while_loop.asp
 *
 * Demo 11: for Loops
 *   https://www.w3schools.com/java/java_for_loop.asp
 *
 * Demo 12: Arrays by Initializer
 *   https://www.w3schools.com/java/java_arrays.asp
 *
 * Demo 13: Arrays by new Keyword
 *   https://www.w3schools.com/java/java_arrays.asp
 *
 * Demo 14: Enhanced for Loop (for-each)
 *   https://www.w3schools.com/java/java_foreach_loop.asp
 *
 * Demo 15–18: Methods & Overloading
 *   https://www.w3schools.com/java/java_methods.asp
 *
 * ============================================================
 */

public class Lab1ADemo {

    /* ========================================================
     * Demo 1: Commenting
     * ======================================================== */
    public static void commenting() {

        // Prints a banner so we can see where this demo starts
        System.out.println("==== Demo 1: Commenting ====");

        // This is a single-line comment explaining one line of code

        /*
         * This is a multi-line comment.
         * It is typically used to explain a block of code
         * or a longer idea.
         */


        /**
        This is a Javadoc comment.
        Javadoc comments are used to document classes
        and methods and can be turned into HTML docs.
         */
    }

    /* ========================================================
     * Demo 2: Strings and Output
     * ======================================================== */
    public static void printYourName() {

        System.out.println("\n==== Demo 2: Strings and Output ====");

        // Declare and initialize a String variable
        String firstName = "Jane";

        // Declare and initialize another String variable
        String lastName  = "Doe";

        // Concatenate the two Strings with a space in between
        String fullName = firstName + " " + lastName;

        // Print the resulting String to the console
        System.out.println("This is your full name: " + fullName);
    }

    /* ========================================================
     * Demo 3: Primitive Data Types
     * ======================================================== */
    public static void primitiveDataTypes() {

        System.out.println("\n==== Demo 3: Primitive Data Types ====");

        // Each variable demonstrates a different primitive type
        byte coursesTaken = 5;                 // small integer
        short idSuffix = 2310;                 // slightly larger integer
        int graduationYear = 2027;             // most common integer type
        long totalSteps = 12_500_000L;          // long requires L suffix

        float averageQuizScore = 87.5f;         // float requires f suffix
        double gpa = 3.74;                      // default decimal type

        char firstInitial = 'J';                // char uses single quotes
        boolean isFullTimeStudent = true;       // true or false only

        // Print a formatted summary of the values
        System.out.println("Student Profile");
        System.out.println("----------------");
        System.out.println("Initial: " + firstInitial);
        System.out.println("Graduation Year: " + graduationYear);
        System.out.println("GPA: " + gpa);
        System.out.println("Average Quiz Score: " + averageQuizScore);
        System.out.println("Full-time student: " + isFullTimeStudent);
    }

    /* ========================================================
     * Demo 4: Arithmetic Operators
     * ======================================================== */
    public static void arithmeticOperators() {

        System.out.println("\n==== Demo 4: Arithmetic Operators ====");

        // Declare two integer variables
        int a = 10;
        int b = 3;

        // Perform basic arithmetic operations
        System.out.println("a + b = " + (a + b));  // addition
        System.out.println("a - b = " + (a - b));  // subtraction
        System.out.println("a * b = " + (a * b));  // multiplication

        // Integer division truncates toward zero
        System.out.println("a / b = " + (a / b));

        // If one operand is double, result is double
        System.out.println("10.0 / 3 = " + (10.0 / 3));

        // Modulo operator gives the remainder
        System.out.println("10 % 3 = " + (10 % 3));

        // Demonstrates String concatenation vs arithmetic
        System.out.println("Result: " + 10 + 3);     // concatenation → "103"
        System.out.println("Result: " + (10 + 3));   // arithmetic first → "13"

        // Increment and decrement operators
        int counter = 5;

        counter++;   // adds 1 to counter
        counter--;   // subtracts 1 from counter
    }

    /* ========================================================
     * Demo 5: Comparison Operators
     * ======================================================== */
    public static void comparisonOperators() {

        System.out.println("\n==== Demo 5: Comparison Operators ====");

        int x = 10;
        int y = 3;

        // Each comparison produces a boolean value
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y:  " + (x > y));
        System.out.println("x < y:  " + (x < y));
        System.out.println("x >= y: " + (x >= y));
        System.out.println("x <= y: " + (x <= y));
    }

    /* ========================================================
     * Demo 6: Logical Operators
     * ======================================================== */
    public static void logicalOperators() {

        System.out.println("\n==== Demo 6: Logical Operators ====");

        int x = 10;
        int y = -5;

        // && is logical AND
        System.out.println("x > 0 && y > 0: " + ((x > 0) && (y > 0)));

        // || is logical OR
        System.out.println("x > 0 || y > 0: " + ((x > 0) || (y > 0)));

        // ! is logical NOT
        System.out.println("!(x > 0):       " + (!(x > 0)));

        // Short-circuit example:
        // Left side is false, so right side is never evaluated
        if (x < 0 && y / x > 1) {
            System.out.println("This will never execute.");
        }

        // Left side is true, so right side is skipped
        // This prevents division by zero
        if (x > 0 || y / 0 > 1) {
            System.out.println("Short-circuit prevents division by zero.");
        }
    }

    /* ========================================================
     * Demo 7: if Statements
     * ======================================================== */
    public static void ifStatements() {

        System.out.println("\n==== Demo 7: if Statements ====");

        int score = 85;

        // The first true condition determines which block runs
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Below C");
        }
    }

    /* ========================================================
     * Demo 8: Compound Conditions
     * ======================================================== */
    public static void compoundConditions() {

        System.out.println("\n==== Demo 8: Compound Conditions ====");

        int age = 19;
        boolean hasID = true;

        // Both conditions must be true for access to be granted
        if (age >= 18 && hasID) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    /* ========================================================
     * Demo 9: De Morgan's Laws
     * ======================================================== */
    public static void deMorgansLaws() {

        System.out.println("\n==== Demo 9: De Morgan's Laws ====");

        boolean A = true;
        boolean B = false;

        // Two logically equivalent expressions
        System.out.println("!(A && B): " + !(A && B));
        System.out.println("!A || !B:  " + (!A || !B));
    }

    /* ========================================================
     * Demo 10: while Loops
     * ======================================================== */
    public static void whileLoops() {

        System.out.println("\n==== Demo 10: while Loops ====");

        int count = 1;

        // Loop continues while condition is true
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;  // ensures loop eventually terminates
        }
    }

    /* ========================================================
     * Demo 11: for Loops
     * ======================================================== */
    public static void forLoops() {

        System.out.println("\n==== Demo 11: for Loops ====");

        int sum = 0;

        // for loop handles initialization, condition, and update
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }

        System.out.println("Sum from 1 to 5 = " + sum);
    }

    /* ========================================================
     * Demo 12: Arrays by Initializer
     * ======================================================== */
    public static void arraysDemo() {

        System.out.println("\n==== Demo 12: Arrays by Initializer ====");

        // Create an array with predefined values
        int[] numbers = {10, 20, 30, 40, 50};

        // Access array elements using indices
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }

    /* ========================================================
     * Demo 13: Arrays by new Keyword
     * ======================================================== */
    public static void arraysByNew() {

        System.out.println("\n==== Demo 13: Arrays by new Keyword ====");

        // Allocate an array with default values
        int[] numbers = new int[5];

        // Populate array elements using a loop
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1) * 10;
        }

        // Print the populated array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }

    /* ========================================================
     * Demo 14: Enhanced for Loop
     * ======================================================== */
    public static void enhancedForLoop() {

        System.out.println("\n==== Demo 14: Enhanced for Loop ====");

        int[] numbers = {10, 20, 30, 40, 50};

        // for-each loop iterates directly over values
        for (int value : numbers) {
            System.out.println("Value: " + value);
        }
    }

    /* ========================================================
     * Demo 15–18: Methods & Overloading
     * ======================================================== */

    public static void printStudentName() {

        System.out.println("\n==== Demo 15: No Parameters, No Return ====");

        // Method declares and uses its own variables
        String firstName = "Jane";
        String lastName  = "Doe";

        System.out.println("Student Name: " + firstName + " " + lastName);
    }

    public static void printStudentName(String firstName, String lastName) {

        System.out.println("\n==== Demo 16: Parameters, No Return ====");

        // Parameters act like local variables
        System.out.println("Student Name: " + firstName + " " + lastName);
    }

    public static String printStudentName(String firstName,
                                          String lastName,
                                          boolean lastNameOnly) {

        System.out.println("\n==== Demo 17: Parameters and Return ====");

        // Behavior depends on the boolean parameter
        if (lastNameOnly) {
            return lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public static void printStudentName(Scanner scanner) {

        System.out.println("\n==== Demo 18: User Input with Scanner ====");

        // Read user input from the console
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Student Name: " + firstName + " " + lastName);
    }

    /* ========================================================
     * Main Method — Lecture Driver
     * ======================================================== */
    public static void main(String[] args) {

        // Demo 1
        // commenting();

        // Demo 2
        printYourName();

        // Demo 3
        // primitiveDataTypes();

        // // Demo 4
        // arithmeticOperators();

        // // Demo 5
        // comparisonOperators();

        // // Demo 6
        // logicalOperators();

        // // Demo 7
        // ifStatements();

        // // Demo 8
        // compoundConditions();

        // // Demo 9
        // deMorgansLaws();

        // // Demo 10
        // whileLoops();

        // // Demo 11
        // forLoops();

        // // Demo 12
        // arraysDemo();

        // // Demo 13
        // arraysByNew();

        // // Demo 14
        // enhancedForLoop();

        // // Demo 15
        // printStudentName();

        // // Demo 16
        // printStudentName("Alex", "Harper");

        // // Demo 17
        // String fullName = printStudentName("Taylor", "Nguyen", false);
        // System.out.println("Returned full name: " + fullName);

        // String lastNameOnly = printStudentName("Taylor", "Nguyen", true);
        // System.out.println("Returned last name only: " + lastNameOnly);

        // // Demo 18
        // Scanner scanner = new Scanner(System.in);
        // printStudentName(scanner);
    }
}