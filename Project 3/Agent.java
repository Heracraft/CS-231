/**
 * Nehemia Kaaya
 * Project 3: Social agents
 * March 6th 2026
 * CS231
 * 
 * Agent parent class
 */

public class Agent {
    private double x;
    private double y;

    protected int radius;

    protected boolean moved;

    /**
     * a constructor that sets the position
     * 
     * @param x0
     * @param y0
     * @param radius
     */
    public Agent(double x0, double y0, int radius) {
        this.x = x0;
        this.y = y0;
        this.radius = radius;
    }

    /**
     * 
     * @return x position.
     */
    public double getX() {
        return this.x;
    }

    /**
     * returnsthe y position
     * @return the y position
     */
    public double getY() {
        return this.y;
    }

    /**
     * 
     * @return the radius.
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * @return the moved field.
     */
    public boolean getMoved(){
        return this.moved;
    }

    /**
     * sets the x position
     * @param newX new x position
     */
    public void setX( double newX ){
        this.x=newX;
    }

    /**
     *  sets the y position
     * @param newY new y position.
     */
    public void setY( double newY ){
        this.y=newY;
    }

    /**
     * sets the radius.
     * @param newRadius
     */
    public void setRadius( int newRadius ) {
        this.radius=newRadius;
    }

    /**
     * Returns a String containing the x and y positions with padding.
     * @return String representation in format "(x, y)"
     */
    public String toString() {
        return String.format("(%.3f, %.3f)", this.x, this.y);
    }

    /**
     * Updates the agent's state based on the landscape
     * @param scape the landscape
     */
    public void updateState(Landscape scape) {
        // Does nothing for now
    }

    /**
     * Draws the agent on the graphics context
     * @param g the graphics object
     */
    public void draw(java.awt.Graphics g, int scale) {
        // Does nothing for now. Do something witht he scale
    }

}
