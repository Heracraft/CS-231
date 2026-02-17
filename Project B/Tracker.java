import java.util.Random;

/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project B: Modeling Elephants
 *
 * Class: Tracker
 *
 * A Tracker models an elephant’s distance from the center
 * of a park using a simplified one-dimensional (1D) model.
 *
 * All distances are measured in kilometers.
 *
 * Note:
 * - Distance from the park center must never be negative.
 * - Inside/outside status is computed, not stored.
 *
 * Specification:
 * - Stores the distance from the park center.
 * - Stores the park radius (default: 30 km).
 * ============================================================
 */
public class Tracker {

    // --------------------------------------------------------
    // Instance Variables
    // --------------------------------------------------------

    // TODO:
    // Declare two private instance variables:
    // - one to store the distance from the park center
    // - one to store the park radius
    //
    // Choose types that are consistent with the specification.

    private double distance = 0;
    private double radius = 0;

    private double validateDistance(double distanceFromCenter) {
        if (distanceFromCenter < 0) {
            distanceFromCenter = 0;
        }

        return distanceFromCenter;
    }

    // --------------------------------------------------------
    // Constructors
    // --------------------------------------------------------

    /**
     * Default constructor.
     *
     * Note:
     * - This constructor establishes the baseline model.
     *
     * It should:
     * - Place the elephant at the center of the park
     * - Use a park radius of 30 km
     */
    public Tracker() {
        // TODO:
        // Initialize the instance variables using default values.
        this(0.0, 30.0);
    }

    /**
     * Full constructor.
     *
     * Note:
     * - This constructor allows explicit control over the model.
     *
     * @param distanceFromCenter initial distance from center (km)
     * @param parkRadius         park radius (km)
     */
    public Tracker(double distanceFromCenter, double parkRadius) {
        // TODO:
        // Initialize the instance variables using the provided values.
        this.distance = validateDistance(distanceFromCenter);
        this.radius = parkRadius;
    }

    // --------------------------------------------------------
    // Accessor and Mutator Methods
    // --------------------------------------------------------

    // TODO:
    // Write accessor and mutator methods for each instance variable.
    //
    // Note:
    // - Any method that modifies distance must ensure it
    // never becomes negative.

    public void setDistanceFromCenter(double distanceFromCenter) {
        this.distance = validateDistance(distanceFromCenter);
    }

    public double getDistanceFromCenter() {
        return this.distance;
    }

    public void setParkRadius(double parkRadius) {
        this.radius = parkRadius;
    }

    public double getParkRadius() {
        return this.radius;
    }

    // --------------------------------------------------------
    // Behavior Methods
    // --------------------------------------------------------

    /**
     * Randomly moves the elephant either toward or away from
     * the park center by x kilometers.
     *
     * Note:
     * - If movement would result in a negative distance,
     * the distance should be set to 0.
     *
     * @param x movement distance (km)
     */
    public void move(double x) {
        // TODO:
        // Randomly choose whether to move toward or away from the center.
        Random randomGenerator = new Random();

        boolean moveForward = randomGenerator.nextBoolean();

        double newDistance = (moveForward) ? distance + x : distance - x; // if add if true, subtract otherwise

        setDistanceFromCenter(newDistance);

        // Update the distance accordingly.
        // Enforce the non-negative distance invariant.
    }

    /**
     * Determines whether the elephant is inside the park.
     *
     * Note:
     * - This value must be computed, not stored.
     *
     * @return true if distance from center is less than or
     *         equal to the park radius
     */
    public boolean isInsidePark() {
        // TODO:
        // Compute and return whether the elephant is inside the park.

        if (distance <= radius) {
            return true;
        }

        return false;
    }

    // --------------------------------------------------------
    // Object Methods
    // --------------------------------------------------------

    /**
     * Returns a string representation of this Tracker.
     *
     * Note:
     * - The format is strict and must match exactly.
     *
     * FORMAT:
     * Tracker[distance=DIST km, radius=30.0 km, inside=BOOLEAN]
     */
    @Override
    public String toString() {
        // TODO:
        // Return a string that follows the required format exactly.
        return "Tracker[distance=%s km, radius=%s km, inside=%s]".formatted(distance, radius, isInsidePark());
    }
}