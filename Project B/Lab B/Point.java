/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Lab B — Working with Classes
 *
 * Class: Point
 *
 * A Point represents a location in 2D space.
 *
 * Specification:
 *  - A Point stores an x-coordinate and a y-coordinate.
 *  - Coordinates are stored as doubles.
 *  - The default Point is located at the origin (0.0, 0.0).
 * ============================================================
 */
public class Point {

    // --------------------------------------------------------
    // Instance Variables
    // --------------------------------------------------------

    // TODO:
    // Declare two private instance variables of type double
    // to store the x-coordinate and y-coordinate of the point.

    private double x;
    private double y;

    // --------------------------------------------------------
    // Constructors
    // --------------------------------------------------------

    /**
     * Constructs a point at the origin.
     *
     * REQUIREMENT:
     *  - This constructor MUST delegate to the
     *    Point(double x, double y) constructor
     *    using the this(...) operator.
     *
     * NOTE:
     *  - This avoids duplicating initialization code and ensures
     *    that all Point objects are initialized consistently.
     *
     * After construction, x == 0.0 and y == 0.0.
     */
    public Point() {
        // TODO:
        // Delegate to the two-parameter constructor
        // so that this point represents (0.0, 0.0).
        this(0.0,0.0);
    }

    /**
     * Constructs a point with the given coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x, double y) {
        // TODO:
        // Initialize the instance variables so that
        // this point represents (x, y).
        this.x=x;
        this.y=y;
    }

    // --------------------------------------------------------
    // Accessors and Mutators
    // --------------------------------------------------------

    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate
     */
    public double getX() {
        // TODO:
        // Return the x-coordinate of this point.
        return x;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate
     */
    public double getY() {
        // TODO:
        // Return the y-coordinate of this point.
        return y;
    }

    /**
     * Sets the x-coordinate of this point.
     *
     * @param x the new x-coordinate
     */
    public void setX(double x) {
        // TODO:
        // Update the x-coordinate of this point to x.
        this.x = x;
    }

    /**
     * Sets the y-coordinate of this point.
     *
     * @param y the new y-coordinate
     */
    public void setY(double y) {
        // TODO:
        // Update the y-coordinate of this point to y.
        this.y=y;
    }

    // --------------------------------------------------------
    // Object Methods
    // --------------------------------------------------------

    /**
     * Returns a string representation of this point.
     *
     * Format:
     *   (x, y)
     *
     * @return a string representing this point
     */
    @Override
    public String toString() {
        // TODO:
        // Return a string in the exact format "(x, y)".
        return "(%s, %s)".formatted(x,y);
    }
}
