/*
file name:      UpdateStateTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea UpdateStateTests
*/

public class UpdateStateTests {

    public static double updateStateTests() {

        double score = 0.;

        // case 1: testing updateState() doesn't move the agent for a social agent when it has many neighbors
        {
            // set up
            Landscape landscape = new Landscape(100, 100);
            SocialAgent a1 = new SocialAgent(10, 10, 5);
            landscape.addAgent(a1);
            
            for (int i = 0; i < 4; i++) {
                SocialAgent neighbor = new SocialAgent(10 + (i % 2) * 3, 10 + (i / 2) * 3, 5);
                landscape.addAgent(neighbor);
            }
            
            // verify
            a1.updateState(landscape);

            // test
            if ( ( a1.getX() == 10 ) && ( a1.getY() == 10 ) && ( a1.getMoved() == false ) ){
                System.out.println("1");
                score += 0.75 ;
            } else {
                System.out.println("FAILED: Test 1");
            }
        }

        // case 2: testing updateState() moves the agent for an antisocial agent when it has many neighbors
        {
            // set up
            Landscape landscape = new Landscape(100, 100);
            AntiSocialAgent a1 = new AntiSocialAgent(10, 10, 5);
            landscape.addAgent(a1);
            
            for (int i = 0; i < 4; i++) {
                SocialAgent neighbor = new SocialAgent(10 + (i % 2) * 3, 10 + (i / 2) * 3, 5);
                landscape.addAgent(neighbor);
            }
            
            // verify
            a1.updateState(landscape);

            // test
            if ( ( a1.getX() != 10 ) && ( a1.getY() != 10 ) && ( a1.getY() != a1.getX() ) && ( a1.getMoved() == true ) ){
                System.out.println("2");
                score += 0.75 ;
            } else {
                System.out.println("FAILED: Test 2");
            }
        }

        // case 3: testing updateState() moves the agent for a social agent when it has few neighbors
        {
            // set up
            Landscape landscape = new Landscape(100, 100);
            SocialAgent a1 = new SocialAgent(10, 10, 5);
            landscape.addAgent(a1);

            // verify
            a1.updateState(landscape);

            // test
            if ( ( a1.getX() != 10 ) && ( a1.getY() != 10 ) && ( a1.getY() != a1.getX() ) && ( a1.getMoved() == true ) ){
                System.out.println("3");
                score += 0.75 ;
            } else {
                System.out.println("FAILED: Test 3");
            }
        }

        // case 4: testing updateState() doesn't move the agent for an antisocial agent when it has few neighbors
        {
            // set up
            Landscape landscape = new Landscape(100, 100);
            AntiSocialAgent a1 = new AntiSocialAgent(10, 10, 5);
            landscape.addAgent(a1);

            // verify
            a1.updateState(landscape);

            // test
            if ( ( a1.getX() == 10 ) && ( a1.getY() == 10 ) && ( a1.getMoved() == false ) ){
                System.out.println("4");
                score += 0.75 ;
            } else {
                System.out.println("FAILED: Test 4");
            }
        }

        return score ;

    }

    public static void main(String[] args) {

        System.out.println( updateStateTests() );
    }
}
