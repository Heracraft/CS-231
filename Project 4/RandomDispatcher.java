/**
 * RandomDispatcher.java
 * Returns a random Server to handle the incoming job.
 */

import java.util.Random;

/**
 * A JobDispatcher that selects servers randomly.
 */
public class RandomDispatcher extends JobDispatcher{

    /**
     * Constructs a RandomDispatcher with k servers.
     * @param k the number of servers
     * @param showViz whether to show the visualization
     */
    public RandomDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Returns a random Server from the server list.
     * @param job the job to handle
     * @return a randomly chosen server
     */
    @Override
    public Server pickServer(Job job){

        final Random randomGenerator = new Random();

        int randomIdnex=randomGenerator.nextInt(0,this.getServerList().size());

        return this.getServerList().get(randomIdnex);
    }
    
}
