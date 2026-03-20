/**
 * Nehemia Kaaya
 * CS231 Project 4
 * ShortestQueueDispatcher.java
 * Picks whichever Server has the smallest-sized queue .
 */

import java.util.ArrayList;

/**
 * A JobDispatcher that selects the smallest-sized server queue.
 */
public class ShortestQueueDispatcher extends JobDispatcher{

    /**
     * Constructs a ShortestQueueDispatcher with k servers.
     * @param k the number of servers
     * @param showViz whether to show the visualization
     */
    public ShortestQueueDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Returns a Server with the smallest-sized queue from the server list.
     * @param job the job to handle
     * @return the selected server
     */
    @Override
    public Server pickServer(Job job){
        ArrayList<Server> serverList = this.getServerList();

        Server choosenServer=serverList.getFirst();
        int smallestQueue=choosenServer.size();

        for (Server server: serverList){
            if (server.size()<smallestQueue){
                choosenServer=server;

                smallestQueue=server.size();
            }
        }

        return choosenServer;
    }
    
}
