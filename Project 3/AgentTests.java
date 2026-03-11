/*
file name:      AgentTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentTests
*/

public class AgentTests {

    public static double agentTests() {

        double score = 0.;

        // case 1: testing SocialAgent( double , double , int ) and AntiSocialAgent( double , double , int )
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);

            // verify
            System.out.println(sa + " != null");
            System.out.println(asa + " != null");

            // test
            assert sa != null : "Error in SocialAgent constructor";
            assert asa != null : "Error in AntiSocialAgent constructor";
            score += 1.0;
        }

        // case 2: testing getX() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);

            // verify
            System.out.println(sa.getX() + " == 10.5");
            System.out.println(asa.getX() + " == 15.0");

            // test
            assert sa.getX() == 10.5 : "Error in SocialAgent::getX()";
            assert asa.getX() == 15.0 : "Error in AntiSocialAgent::getX()";
            score += 1.0;
        }

        // case 3: testing getY() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);

            // verify
            System.out.println(sa.getY() + " == 20.5");
            System.out.println(asa.getY() + " == 25.0");
            
            // test
            assert sa.getY() == 20.5 : "Error in SocialAgent::getY()";
            assert asa.getY() == 25.0 : "Error in AntiSocialAgent::getY()";
            score += 1.0;
        }

        // case 4: testing getRadius() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);

            // verify
            System.out.println(sa.getRadius() + " == 5");
            System.out.println(asa.getRadius() + " == 10");

            // test
            assert sa.getRadius() == 5 : "Error in SocialAgent::getRadius()";
            assert asa.getRadius() == 10 : "Error in AntiSocialAgent::getRadius()";
            score += 1.0;
        }

        // case 5: testing setX() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);
            
            sa.setX(100.0);
            asa.setX(200.0);

            // verify
            System.out.println(sa.getX() + " == 100.0");
            System.out.println(asa.getX() + " == 200.0");

            // test
            assert sa.getX() == 100.0 : "Error in SocialAgent::setX()";
            assert asa.getX() == 200.0 : "Error in AntiSocialAgent::setX()";
            score += 1.0;
        }

        // case 6: testing setY() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);
            
            sa.setY(100.0);
            asa.setY(200.0);

            // verify
            System.out.println(sa.getY() + " == 100.0");
            System.out.println(asa.getY() + " == 200.0");

            // test
            assert sa.getY() == 100.0 : "Error in SocialAgent::setY()";
            assert asa.getY() == 200.0 : "Error in AntiSocialAgent::setY()";
            score += 1.0;
        }

        // case 7: testing setRadius() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);
            
            sa.setRadius(50);
            asa.setRadius(100);

            // verify
            System.out.println(sa.getRadius() + " == 50");
            System.out.println(asa.getRadius() + " == 100");

            // test
            assert sa.getRadius() == 50 : "Error in SocialAgent::setRadius()";
            assert asa.getRadius() == 100 : "Error in AntiSocialAgent::setRadius()";
            score += 1.0;
        }

        // case 8: testing getMoved() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent(10.5, 20.5, 5);
            AntiSocialAgent asa = new AntiSocialAgent(15.0, 25.0, 10);

            // verify
            System.out.println(sa.getMoved() + " == false");
            System.out.println(asa.getMoved() + " == false");

            // test
            assert !sa.getMoved() : "Error in SocialAgent::getMoved()";
            assert !asa.getMoved() : "Error in AntiSocialAgent::getMoved()";
            score += 1.0;
        }

        System.out.println("\n\nCongrats! You passed the Agent tests!\n");

        return score;
    }

    public static void main(String[] args) {

        System.out.println("Score: " + agentTests());
    }
}