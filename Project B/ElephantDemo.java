/**
 * ============================================================
 * CS 231 — Data Structures & Algorithms
 * Project B: Modeling Elephants
 *
 * Class: ElephantDemo
 *
 * ElephantDemo runs a controlled experiment using a
 * population of elephants.
 *
 * Note:
 *  - This file is PROVIDED and MUST NOT be modified.
 *  - It is not a full simulation.
 *  - Your Elephant and Tracker classes must work with
 *    this file exactly as written.
 *
 * Specification:
 *  - Creates a fixed-size population of elephants.
 *  - Uses the default Elephant constructor.
 *  - Repeatedly moves each elephant.
 *  - Stops when at least 10% of the elephants are outside the park.
 * ============================================================
 */
public class ElephantDemo {

    public static void main(String[] args) {

        final int POPULATION_SIZE = 20;
        final double MOVE_DISTANCE = 2.0; // km per step
        final double OUTSIDE_THRESHOLD = 0.10;

        Elephant[] herd = new Elephant[POPULATION_SIZE];

        for (int i = 0; i < herd.length; i++) {
            herd[i] = new Elephant();
        }

        System.out.println("Initial elephant states:");
        for (Elephant e : herd) {
            System.out.println(e);
        }

        int step = 0;
        double fractionOutside = 0.0;

        while (fractionOutside < OUTSIDE_THRESHOLD) {

            step++;

            for (Elephant e : herd) {
                e.move(MOVE_DISTANCE);
            }

            int outsideCount = 0;
            for (Elephant e : herd) {
                if (!e.isInsidePark()) {
                    outsideCount++;
                }
            }

            fractionOutside = (double) outsideCount / herd.length;
        }

        System.out.println("\nExperiment complete after " + step + " steps.");
        System.out.println("Final elephant states:");

        int outsideCount = 0;
        for (Elephant e : herd) {
            System.out.println(e);
            if (!e.isInsidePark()) {
                outsideCount++;
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Elephants outside park: " + outsideCount);
        System.out.println("Total elephants: " + herd.length);
        System.out.println("Fraction outside park: "
                + ((double) outsideCount / herd.length));
    }
}
