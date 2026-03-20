/**
 * Server.java
 * Nehemia Kaaya
 * CS231 Project 4
 * 
 * A class representing a server.
 * The server maintains a queue of jobs and tracks system time,
 * remaining processing time, and total waiting time for accounting.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

/**
 * A class representing a server in a server farm simulation.
 * The server maintains a queue of jobs and tracks system time,
 * remaining processing time, and total waiting time for accounting.
 */
public class Server {
    private Queue<Job> jobQueue;
    private double sysTime;
    private double remainingTime;
    private double totalWaitingTime;

    private double noOfJobsProcessed;

    /**
     * Constructs a new Server with initialized fields.
     * System time, number of jobs processed, and total wait time all start at 0.
     * The job queue is initially empty.
     */
    public Server() {
        this.jobQueue = new LinkedList<Job>();
        this.sysTime = 0;
        this.remainingTime = 0;
        this.totalWaitingTime = 0;
        this.noOfJobsProcessed = 0;
    }

    /**
     * Adds the specified job to the server's queue and updates the remaining
     * processing time.
     * 
     * @param job The job to be added to the queue.
     */
    public void addJob(Job job) {
        this.jobQueue.offer(job);
        this.remainingTime += job.getProcessingTimeNeeded();
    }

    /**
     * Advances the system time of the server to the specified time and processes
     * jobs accordingly.
     * 
     * @param time The new system time to advance to.
     */
    public void processTo(double time) {
        double timeLeft = time - this.sysTime;
        while (timeLeft > 0 && this.jobQueue.size()>0) {
            Job job = this.jobQueue.peek();

            double timeSpentOnSingleJob = Math.min(job.getProcessingTimeRemaining(), timeLeft);

            job.process(timeSpentOnSingleJob, this.sysTime); // TODO: confirm processing starts at sysTime

            if (job.isFinished()) {
                this.jobQueue.poll();
                this.totalWaitingTime += job.timeInQueue();
                this.noOfJobsProcessed++;
            }

            
            remainingTime-=timeSpentOnSingleJob;
            timeLeft -= timeSpentOnSingleJob;
            this.sysTime += timeSpentOnSingleJob;
        }
        this.sysTime=time;

    }

    /**
     * Returns the total remaining processing time in this server's queue.
     * 
     * @return The remaining processing time.
     */
    public double remainingWorkInQueue() {
        return this.remainingTime;
    }

    /**
     * Returns the total waiting time for all jobs processed by the server so far.
     * 
     * @return The total waiting time.
     */
    public double getTotalWaitingTime() {
        return this.totalWaitingTime;
    }

    /**
     * Returns the number of jobs currently in the server's queue.
     * 
     * @return The size of the job queue.
     */
    public int size() {
        return this.jobQueue.size();
    }

    /**
     * Draws the server's status on the provided Graphics object.
     * 
     * @param g               The Graphics object to draw on.
     * @param c               The color to use for the server representation.
     * @param loc             The vertical location to draw the server.
     * @param numberOfServers The total number of servers being displayed.
     */
    public void draw(Graphics g, Color c, double loc, int numberOfServers) {
        double sep = (ServerFarmViz.HEIGHT - (20 * ServerFarmViz.SCALE)) / (numberOfServers + 2.0);
        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(),
                (int) (72.0 * (sep * .5) / Toolkit.getDefaultToolkit().getScreenResolution())));
        g.drawString("Work: " + (remainingWorkInQueue() < 1000 ? remainingWorkInQueue() : ">1000"), (int)(2 * ServerFarmViz.SCALE),
                (int) (loc + .2 * sep));
        g.drawString("Jobs: " + (size() < 1000 ? size() : ">1000"), (int)(5 * ServerFarmViz.SCALE), (int) (loc + .55 * sep));
        g.setColor(c);
        g.fillRect((int) (3 * sep), (int) loc, (int) (.8 * remainingWorkInQueue() * ServerFarmViz.SCALE), (int) sep);
        g.drawOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
        if (remainingWorkInQueue() == 0)
            g.setColor(Color.GREEN.darker());
        else
            g.setColor(Color.RED.darker());
        g.fillOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
    }
}