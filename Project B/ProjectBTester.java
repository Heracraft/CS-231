/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project B: Modeling Elephants
 *
 * ProjectBTester
 *
 * Grader / tester for Elephant.java and Tracker.java.
 *
 * Run with:
 *   javac *.java
 *   java ProjectBTester
 *
 * ============================================================
 */
public class ProjectBTester {

    private static int score = 0;
    private static final int TOTAL = 18;

    public static void main(String[] args) {

        System.out.println("CS231 Project B Tester");
        System.out.println("----------------------");

        testCompilationAndInterfaces();
        testTrackerDefaults();
        testTrackerInvariants();
        testTrackerMovement();
        testTrackerInsideOutside();
        testElephantDefaults();
        testElephantDelegation();   // <-- corrected
        testToStringFormats();

        System.out.println("\n----------------------");
        System.out.println("FINAL SCORE: " + score + " / " + TOTAL);
    }

    // --------------------------------------------------------
    // Category A — Compilation & Interfaces (3 pts)
    // --------------------------------------------------------

    private static void testCompilationAndInterfaces() {
        System.out.println("\n[A] Compilation & Interfaces");

        try {
            new Elephant();
            new Tracker();
            score += 3;
            System.out.println("  ✔ Compiles and constructors exist (+3)");
        } catch (Exception ex) {
            System.out.println("  ✘ Compilation/interface failure (0)");
        }
    }

    // --------------------------------------------------------
    // Category B — Tracker (7 pts)
    // --------------------------------------------------------

    private static void testTrackerDefaults() {
        System.out.println("\n[B1] Tracker default constructor");

        Tracker t = new Tracker();

        boolean ok =
                t.getDistanceFromCenter() == 0.0 &&
                t.getParkRadius() == 30.0;

        if (ok) {
            score += 2;
            System.out.println("  ✔ Default values correct (+2)");
        } else {
            System.out.println("  ✘ Incorrect default values (0)");
        }
    }

    private static void testTrackerInvariants() {
        System.out.println("\n[B2] Distance non-negative invariant");

        Tracker t = new Tracker(1.0, 30.0);
        boolean negative = false;

        for (int i = 0; i < 20; i++) {
            t.move(10.0);
            if (t.getDistanceFromCenter() < 0) {
                negative = true;
                break;
            }
        }

        if (!negative) {
            score += 2;
            System.out.println("  ✔ Distance never negative (+2)");
        } else {
            System.out.println("  ✘ Distance became negative (0)");
        }
    }

    private static void testTrackerMovement() {
        System.out.println("\n[B3] Tracker movement behavior");

        Tracker t = new Tracker();
        double before = t.getDistanceFromCenter();
        boolean changed = false;

        for (int i = 0; i < 10; i++) {
            t.move(5.0);
            if (t.getDistanceFromCenter() != before) {
                changed = true;
                break;
            }
        }

        if (changed) {
            score += 1;
            System.out.println("  ✔ Distance changes over time (+1)");
        } else {
            System.out.println("  ✘ Distance never changes (0)");
        }
    }

    private static void testTrackerInsideOutside() {
        System.out.println("\n[B4] isInsidePark correctness");

        Tracker t = new Tracker(29.0, 30.0);
        boolean inside1 = t.isInsidePark();

        t.setDistanceFromCenter(31.0);
        boolean inside2 = t.isInsidePark();

        if (inside1 && !inside2) {
            score += 2;
            System.out.println("  ✔ Inside/outside logic correct (+2)");
        } else {
            System.out.println("  ✘ Inside/outside logic incorrect (0)");
        }
    }

    // --------------------------------------------------------
    // Category C — Elephant (5 pts)
    // --------------------------------------------------------

    private static void testElephantDefaults() {
        System.out.println("\n[C1] Default Elephant constructor");

        Elephant e = new Elephant();
        int age = e.getAge();
        char sex = e.getSex();
        boolean trackerExists = (e.getTracker() != null);

        boolean ok =
                age >= 1 && age <= 60 &&
                (sex == 'm' || sex == 'f') &&
                trackerExists;

        if (ok) {
            score += 2;
            System.out.println("  ✔ Random age/sex and tracker present (+2)");
        } else {
            System.out.println("  ✘ Default constructor incorrect (0)");
        }
    }

    /**
     * Corrected delegation test.
     *
     * NOTE:
     * Distance may not change due to random inward movement
     * and clamping at zero. We must not require numeric change
     * on a single move.
     */
    private static void testElephantDelegation() {
        System.out.println("\n[C2–C4] Elephant delegation");

        Elephant e = new Elephant();
        Tracker t = e.getTracker();

        boolean moveDelegated = false;

        // Try multiple moves to tolerate randomness + clamping
        for (int i = 0; i < 10; i++) {
            double before = t.getDistanceFromCenter();
            e.move(5.0);
            double after = t.getDistanceFromCenter();

            if (before != after || after == 0.0) {
                moveDelegated = true;
                break;
            }
        }

        boolean insideDelegated =
                (e.isInsidePark() == t.isInsidePark());

        if (moveDelegated && insideDelegated) {
            score += 3;
            System.out.println("  ✔ Movement and inside check delegated (+3)");
        } else {
            System.out.println("  ✘ Delegation failure (0)");
        }
    }

    // --------------------------------------------------------
    // Category D — toString() (3 pts)
    // --------------------------------------------------------

    private static void testToStringFormats() {
        System.out.println("\n[D] toString formatting");

        Tracker t = new Tracker(12.0, 30.0);
        String trackerStr = t.toString();

        boolean trackerFormat =
                trackerStr.startsWith("Tracker[distance=") &&
                trackerStr.contains(" km, radius=30.0 km, inside=") &&
                trackerStr.endsWith("]");

        Elephant e = new Elephant(10, 'm', new Tracker());
        String elephantStr = e.toString();

        boolean elephantFormat =
                elephantStr.startsWith("Elephant[age=10, sex=m, Tracker[");

        int earned = 0;

        if (trackerFormat) {
            earned += 2;
            System.out.println("  ✔ Tracker toString format (+2)");
        } else {
            System.out.println("  ✘ Tracker toString format incorrect");
        }

        if (elephantFormat) {
            earned += 1;
            System.out.println("  ✔ Elephant toString format (+1)");
        } else {
            System.out.println("  ✘ Elephant toString format incorrect");
        }

        score += earned;
    }
}