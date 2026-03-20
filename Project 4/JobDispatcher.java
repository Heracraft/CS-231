/**
 * JobDispatcher.java
 * Nehemia Kaaya
 * CS231 Project 4
 * 
 * An abstract JobDispatcher class that manages a collection of Servers 
 * and defines the framework for allocating incoming jobs.
 */

import java.awt.Graphics;
import java.awt.Color;
// import java.awt.Toolkit;
// import java.awt.Font;

import java.util.ArrayList;

/**
 * An abstract framework for a JobDispatcher that handles servers and job assignments.
 */
public abstract class JobDispatcher {
    private ArrayList<Server> servers;
    private double systemTime;
    private ServerFarmViz visualization;
    private LinkedList<Job> jobsHandled;


    /**
     * Fills/Adds k servers into the server list
     * @param k
     */
    private void fillServers(int k) {
        this.servers = new ArrayList<Server>(k);

        for (int i = 0; i < k; i++) {
            this.servers.add(new Server());
        }
    }

    /**
     * Constructs a JobDispatcher with k total Servers.
     * 
     * @param k       the number of servers
     * @param showViz whether to show visualization
     */
    public JobDispatcher(int k, boolean showViz) {
        fillServers(k);

        this.systemTime = 0;
        this.jobsHandled = new LinkedList<Job>();
        this.visualization = new ServerFarmViz(this, showViz);
    }

    /**
     * Returns the current system time.
     * 
     * @return the system time
     */
    public double getTime() {
        return this.systemTime;
    }

    /**
     * Returns the list of servers.
     * 
     * @return ArrayList of servers
     */
    public ArrayList<Server> getServerList() {
        return this.servers;
    }

    /**
     * Advances system time to the specified time and processes all servers.
     * 
     * @param time the time to advance to
     */
    public void advanceTimeTo(double time) {
        this.systemTime = time;
        for (Server server : this.servers) {
            server.processTo(time);
        }
    }

    /**
     * Handles a job by advancing time, selecting a server, and adding the job.
     * 
     * @param job the job to handle
     */
    public void handleJob(Job job) {
        this.jobsHandled.add(job);

        double arrivalTime = job.getArrivalTime();

        advanceTimeTo(arrivalTime); // TODO: this or just update the time, no processing

        this.visualization.repaint();

        this.pickServer(job).addJob(job);

        this.visualization.repaint();

    }

    /**
     * Advances time until all jobs are completed.
     */
    public void finishUp() {
        double maxTime = systemTime;
        for (Server server : servers) {
            maxTime = Math.max(maxTime, systemTime + server.remainingWorkInQueue());
        }
        advanceTimeTo(maxTime);
    }

    /**
     * Returns the number of jobs handled.
     * 
     * @return number of jobs handled
     */
    public int getNumJobsHandled() {
        return this.jobsHandled.size();
    }

    /**
     * Calculates the average waiting time of all handled jobs.
     * 
     * @return average waiting time
     */
    public double getAverageWaitingTime() {
        double totalWaitTime = 0;
        for (Job job : jobsHandled) {
            totalWaitTime += job.timeInQueue();
        }
        return totalWaitTime / this.jobsHandled.size();
    }

    /**
     * Selects the appropriate server for a job.
     * 
     * @param j the job to assign
     * @return the selected server
     */
    public abstract Server pickServer(Job j);

    /**
     * Draws the visualization.
     * 
     * @param g the graphics object
     */
    public void draw(Graphics g) {
        double sep = (ServerFarmViz.HEIGHT - (20 * ServerFarmViz.SCALE)) / (getServerList().size() + 2.0);
        g.drawString("Time: " + getTime(), (int) sep, (int) (ServerFarmViz.HEIGHT - (20 * ServerFarmViz.SCALE)));
        g.drawString("Jobs handled: " + getNumJobsHandled(), (int) sep, (int) (ServerFarmViz.HEIGHT - (10 * ServerFarmViz.SCALE)));
        for (int i = 0; i < getServerList().size(); i++) {
            getServerList().get(i).draw(g, (i % 2 == 0) ? Color.GRAY : Color.DARK_GRAY, (i + 1) * sep,
                    getServerList().size());
        }
    }

}
