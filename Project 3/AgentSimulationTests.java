/*
file name:      AgentSimulationTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentSimulationTests
*/

import java.util.Random;

public class AgentSimulationTests {

    public static int runExpt(int N) {
        Landscape landscape = new Landscape(500, 500);
        Random rand = new Random();
        
        for (int i = 0; i < N; i++) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            SocialAgent agent = new SocialAgent(x, y, 25);
            landscape.addAgent(agent);
        }
        
        int agentsMoved = 1;
        int iterations = 0;
        
        while (agentsMoved > 0 && iterations < 5000) {
            agentsMoved = landscape.updateAgents();
            iterations++;
        }
        
        return iterations;
    }


    public static double agentSimulationTests() {

        //Note, you must implement runExpt in AgentSimulation for this code to work!
        

        double score = 0.;

        {
            int[] nums = { 50 , 100 };
            int[] correctAnswers = { 234 , 541 };
            for ( int i = 0 ; i < nums.length ; i++ ) {
                int output = 0 ;
                for ( int j = 0 ; j < 20 ; j++ ) {
                    output += runExpt( nums[ i ] ) ;
                }
                output /= 20;
                System.out.println( output );
                if ( ( output < correctAnswers[ i ] + 100 ) && ( ( output > correctAnswers[ i ] - 100 ) ) ) {
                    score += 1.;
                }
            }
        }

        {
            int output = runExpt( 250 ) ;
            if ( output == 5000 ) {
                score += 1.;
            }

        }
        return score ;
    }

    public static void main(String[] args) {

        System.out.println( agentSimulationTests() );
    }
}
