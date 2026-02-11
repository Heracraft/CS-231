/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Lab B — Working with Classes
 *
 * Class: Circle
 *
 * A Circle is defined by a center point and a radius.
 *
 * Specification:
 *  - A Circle has a Point representing its center.
 *  - A Circle has a radius stored as a double.
 *  - The default Circle is centered at (0.0, 0.0) with radius 1.0.
 *  - The radius of a Circle must never be negative.
 * ============================================================
 */
public class Circle {

    // --------------------------------------------------------
    // Instance Variables
    // --------------------------------------------------------

    // TODO:
    // Declare two private instance variables:
    //  - One of type Point to represent the center
    //  - One of type double to represent the radius

    private Point center;
    private double radius;

    // --------------------------------------------------------
    // Constructors
    // --------------------------------------------------------

    /**
     * Constructs a default circle.
     *
     * REQUIREMENT:
     *  - This constructor MUST delegate to another
     *    Circle constructor using the this(...) operator.
     *
     * NOTE:
     *  - Delegating to another constructor avoids duplicating
     *    initialization logic and keeps construction consistent.
     *
     * After construction:
     *  - The center is at (0.0, 0.0)
     *  - The radius is 1.0
     */
    public Circle() {
        // TODO:
        // Delegate to an appropriate constructor so that
        // the circle is centered at (0.0, 0.0) with radius 1.0.
        this(new Point(), 1.0); // No need to provide arguments to point since its provided by default
    }

    /**
     * Constructs a circle with the given center and radius.
     *
     * @param center the center of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point center, double radius) {
        // TODO:
        // Initialize the center and radius using the provided arguments.
        //
        // The radius must not be negative.
        // Use the validateRadius helper method.

        this.center = center;
        this.radius = validateRadius(radius); 
    }

    /**
     * Constructs a circle with the given center coordinates and radius.
     *
     * @param x the x-coordinate of the center
     * @param y the y-coordinate of the center
     * @param radius the radius of the circle
     */
    public Circle(double x, double y, double radius) {
        // TODO:
        // Create a Point representing (x, y) and initialize the circle.
        //
        // Avoid duplicating initialization logic.
        // The radius must not be negative.

        this(new Point(x,y), radius);
    }

    // --------------------------------------------------------
    // Accessors and Mutators
    // --------------------------------------------------------

    /**
     * Returns the center of this circle.
     *
     * @return the center point
     */
    public Point getCenter() {
        // TODO:
        // Return the center of this circle.
        return this.center;
    }

    /**
     * Returns the radius of this circle.
     *
     * @return the radius
     */
    public double getRadius() {
        // TODO:
        // Return the radius of this circle.
        return this.radius;
    }

    /**
     * Sets the center of this circle.
     *
     * @param center the new center
     */
    public void setCenter(Point center) {
        // TODO:
        // Update the center of this circle.
        this.center=center;
    }

    /**
     * Sets the radius of this circle.
     *
     * @param radius the new radius
     */
    public void setRadius(double radius) {
        // TODO:
        // Update the radius of this circle.
        //
        // The radius must not be negative.
        // Use the validateRadius helper method.
        this.radius=validateRadius(radius);
    }

    // --------------------------------------------------------
    // Private Helper Methods
    // --------------------------------------------------------

    /**
     * Ensures a radius value is valid.
     *
     * @param radius the proposed radius
     * @return a non-negative radius value
     */
    private double validateRadius(double radius) {
        // TODO:
        // If radius is negative, return 0.0.
        // Otherwise, return radius.
        if (radius<0){
            return 0.0;
        }
        return radius;
    }

    // --------------------------------------------------------
    // Object Methods
    // --------------------------------------------------------

    /**
     * Returns a string representation of this circle.
     *
     * Format:
     *   Center: (x, y), Radius: r
     *
     * IMPORTANT:
     *  - The string representation of the center MUST be
     *    obtained by calling the Point object's toString()
     *    method.
     *  - Do NOT manually reconstruct the point's string.
     *
     * @return a string representing this circle
     */
    @Override
    public String toString() {
        // TODO:
        // Return a string in the exact format:
        // "Center: (x, y), Radius: r"
        //
        // You MUST call the center Point's toString() method
        // to obtain "(x, y)".
        
        return "Center: %s, Radius: %s".formatted(this.center.toString(), this.radius);
    }
}
