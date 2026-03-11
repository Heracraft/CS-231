/*
file name:      LandscapeTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea LandscapeTests
*/

public class LandscapeTests {

    public static double landscapeTests() {

        double score = 0.;

        // case 1: testing Landscape(int, int)
        {
            // setup
            Landscape l = new Landscape(500, 400);

            // verify
            System.out.println(l + " != null");

            // test
            assert l != null : "Error in Landscape::Landscape(int, int)";
            score += 1.0;
        }

        // case 2: testing getWidth()
        {
            // setup
            Landscape l = new Landscape(500, 400);

            // verify
            System.out.println(l.getWidth() + " == 500");

            // test
            assert l.getWidth() == 500 : "Error in Landscape::getWidth()";
            score += 1.0;
        }

        // case 3: testing getHeight()
        {
            // setup
            Landscape l = new Landscape(500, 400);

            // verify
            System.out.println(l.getHeight() + " == 400");
            
            // test
            assert l.getHeight() == 400 : "Error in Landscape::getHeight()";
            score += 1.0;
        }

        System.out.println("\n\nCongrats! You passed the Landscape tests!\n");

        return score;
    }

    public static void main(String[] args) {

        System.out.println("Score: " + landscapeTests());
    }
}