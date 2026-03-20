/**
 * CS231 Project 4
 * RoundRobinDispatcher.java
 * Pick the Server in a round-robin process.
 */

import java.util.Random;
import java.util.ArrayList;

/**
 * A JobDispatcher that selects servers in a round-robin fashion.
 */
public class RoundRobinDispatcher extends JobDispatcher{

    private int currentIndex=0;

    /**
     * Constructs a RoundRobinDispatcher with k servers.
     * @param k the number of servers
     * @param showViz whether to show the visualization
     */
    public RoundRobinDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Picks a server in a round-robin process.
     * The first time it's called, it returns the first server, then the next, and so on.
     * @param job the job to handle
     * @return the chosen server
     */
    @Override
    public Server pickServer(Job job){
        ArrayList<Server> serverList = this.getServerList();

        if(currentIndex>=serverList.size()){
            currentIndex=0;
        }

        Server choosenServer=serverList.get(currentIndex);

        currentIndex++;

        return choosenServer;
    }
    
}
