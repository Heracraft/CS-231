/**
 * LeastWorkDispatcher.java
 * Nehemia Kaaya
 * CS231 Project 4
 * 
 * Picks the Server with the least remaining processing time in its queue, with ties handled arbitrarily.
 */

import java.util.ArrayList;

/**
 * A JobDispatcher that selects the server with the minimum remaining processing
 * time.
 */
public class LeastWorkDispatcher extends JobDispatcher {

    /**
     * Constructs a LeastWorkDispatcher with k servers.
     * 
     * @param k       the number of servers
     * @param showViz whether to show the visualization
     */
    public LeastWorkDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Picks the Server with the least remaining processing time in its queue.
     * Ties are handled arbitrarily.
     * 
     * @param j the job to handle
     * @return the server with the least remaining work
     */
    @Override
    public Server pickServer(Job j) {
        ArrayList<Server> serverList = this.getServerList();

        Server choosenServer = serverList.getFirst();
        double leastProcessingTime = choosenServer.remainingWorkInQueue();

        for(Server server: serverList){
            if(server.remainingWorkInQueue()<leastProcessingTime){
                leastProcessingTime=server.remainingWorkInQueue();

                choosenServer=server;
            }
        }

        return choosenServer;
    }

}