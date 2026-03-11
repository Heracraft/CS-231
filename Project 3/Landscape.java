
/**
 * Nehemia Kaaya
 * Project 3: Social agents
 * March 6th 2026
 * CS231
 * 
 * Landscape class. Impements the 2D plane onto which agents interact
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.Random;

public class Landscape {
    private int w;
    private int h;

    private LinkedList<Agent> agents;

    /**
     * Constructs a Landscape with the specified width and height.
     * Initializes an empty list of agents.
     *
     * @param w the width of the landscape
     * @param h the height of the landscape
     */
    public Landscape(int w, int h) {
        this.h = h;
        this.w = w;
        this.agents = new LinkedList<Agent>();
    }

    /**
     * Returns the height of this landscape.
     *
     * @return the height value
     */
    public int getHeight() {
        return this.h;
    }

    /**
     * Returns the width of this landscape.
     *
     * @return the width value
     */
    public int getWidth() {
        return this.w;
    }

    /**
     * Calculates distance on a 2D plane
     * 
     * @param x0 intial x
     * @param y0 intial y
     * @param x1 final x
     * @param y1 final y
     * @return
     */
    private double getDistace(double x0, double y0, double x1, double y1) {
        double dx = x1 - x0;
        double dy = y1 - y0;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Adds an agent to the beginning of the agent list.
     *
     * @param a the agent to add to this landscape
     */
    public void addAgent(Agent a) {
        this.agents.add(a);
    }

    /**
     * Returns a string representation of this landscape.
     *
     * @return a string describing the number of agents on this landscape
     */
    @Override
    public String toString() {
        return "there are: %s agent(s)".formatted(this.agents.size());
    }

    /**
     * Retrieves all agents within the specified radius of the given location.
     *
     * @param x0     the x-coordinate of the center point
     * @param y0     the y-coordinate of the center point
     * @param radius the search radius
     * @return a LinkedList of agents within the specified radius of (x0, y0)
     */
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        LinkedList<Agent> neighbors = new LinkedList<Agent>();

        for (Agent agent : this.agents) {
            if (getDistace(x0, y0, agent.getX(), agent.getY()) <= radius) {
                neighbors.add(agent);
            }
        }

        return neighbors;
    }

    /**
     * Draws this landscape and all of its agents.
     *
     * @param g the Graphics object used to draw
     */
    public void draw(Graphics g, int scale) {
        for (Agent agent : agents) {
            agent.draw(g, scale);
        }
    }

    public int updateAgents() {
        Random randomGenerator = new Random();

        int randomIndex = randomGenerator.nextInt(0, this.agents.size());

        Agent randomAgent = this.agents.remove(randomIndex);

        double rX = randomAgent.getX();
        double rY = randomAgent.getY();
        int rRadius = randomAgent.getRadius();

        AntiSocialAgent newAntiSocialAgent = new AntiSocialAgent(rX, rY, rRadius);

        agents.add(newAntiSocialAgent);

        int noOfMovedAgents=0;

        for (Agent agent:this.agents){
            agent.updateState(this);
            if(agent.moved){
                noOfMovedAgents++;
            }
        }
        // TODO:

        return noOfMovedAgents;
    }

    /**
     * Main method for testing the Landscape class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Landscape scape = new Landscape(10, 01);
        System.out.println(scape.getDistace(20, 0.5, 21.4, 0.43));
    }

}
