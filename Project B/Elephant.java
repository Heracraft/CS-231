import java.util.Random;

/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project B: Modeling Elephants
 *
 * Class: Elephant
 *
 * An Elephant represents a single elephant being modeled
 * in a simplified park tracking system.
 *
 * Note:
 * - An Elephant does NOT manage spatial information directly.
 * - All movement and park-boundary logic is delegated to a Tracker.
 *
 * Specification:
 * - An Elephant stores an age and a sex.
 * - Age is an integer in the range [1, 60].
 * - Sex is represented by a character: 'm' or 'f'.
 * - An Elephant owns exactly one Tracker.
 * - All spatial state is managed by the Tracker.
 * ============================================================
 */

// enum Sex {
//     Male,
//     Female
// }

// I know, enums are overkill but I wanted to try them. I hope the tester
// doesn't mess this up.

// Yeah nvm, the tester enforces sex be a char

public class Elephant {

    // --------------------------------------------------------
    // Instance Variables
    // --------------------------------------------------------

    // TODO:
    // Declare three private instance variables:
    // - one to store the elephant's age
    // - one to store the elephant's sex
    // - one to store a reference to the associated Tracker
    //
    // Choose types that are consistent with the specification.

    private int age;
    private char sex;
    private Tracker tracker;

    // --------------------------------------------------------
    // Constructors
    // --------------------------------------------------------

    /**
     * Default constructor.
     *
     * Note:
     * - This constructor represents a new elephant entering the system.
     * - Randomness belongs here, not elsewhere in the class.
     *
     * It should:
     * - Assign a random age between 1 and 60 (inclusive)
     * - Randomly assign a sex of either 'm' or 'f'
     * - Create a default Tracker
     *
     * This constructor MUST delegate to the full constructor
     * using this(...).
     */
    public Elephant() {
        // TODO:
        // Generate appropriate random values for age and sex.

        this(
            new Random().nextInt(1, 60), 
            new Random().nextBoolean() ? 'm' : 'f', 
            new Tracker()
        );

        // Create a default Tracker.
        // Delegate to the full constructor.
    }

    /**
     * Full constructor.
     *
     * Note:
     * - All instance variables must be initialized here.
     * - Other constructors should delegate to this one.
     *
     * @param age     the elephant's age
     * @param sex     the elephant's sex
     * @param tracker the associated Tracker
     */
    public Elephant(int age, char sex, Tracker tracker) {
        // TODO:
        // Initialize all instance variables.
        this.age = age;
        this.sex = sex;
        this.tracker = tracker;
    }

    // --------------------------------------------------------
    // Accessor and Mutator Methods
    // --------------------------------------------------------

    // TODO:
    // Write accessor and mutator methods for each instance variable.
    //
    // Note:
    // - age must remain within [1, 60]
    // - sex must be either 'm' or 'f'

    public char getSex(){
        return this.sex;
    }

    public void setSex(char sex){
        this.sex=sex;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public Tracker getTracker(){
        return this.tracker;
    }

    public void setTracker(Tracker tracker){
        this.tracker=tracker;
    }

    // --------------------------------------------------------
    // Behavior Methods
    // --------------------------------------------------------

    /**
     * Simulates movement by delegating to the Tracker.
     *
     * Note:
     * - Elephant does NOT modify distance directly.
     *
     * @param delta change in distance from park center (km)
     */
    public void move(double delta) {
        // TODO:
        // Delegate movement to the associated Tracker.

        this.tracker.move(delta);
    }

    /**
     * Determines whether this elephant is inside the park.
     *
     * Note:
     * - This method should not perform any distance calculations.
     *
     * @return true if the elephant is inside the park
     */
    public boolean isInsidePark() {
        // TODO:
        // Delegate this check to the associated Tracker.
        return this.tracker.isInsidePark();
    }

    // --------------------------------------------------------
    // Object Methods
    // --------------------------------------------------------

    /**
     * Returns a string representation of this Elephant.
     *
     * Note:
     * - The format is strict and must match exactly.
     *
     * FORMAT:
     * Elephant[age=AGE, sex=SEX, TRACKER_STRING]
     *
     * where TRACKER_STRING is the result of calling
     * toString() on the associated Tracker.
     */
    @Override
    public String toString() {
        // TODO:
        // Return a string that follows the required format exactly.
        return "Elephant[age=%s, sex=%s, %s]".formatted(this.age, this.sex, this.tracker.toString());
    }
}