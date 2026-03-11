import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class SocialAgent extends Agent {
    /**
     * Constructs the social agent
     * 
     * @param x0     starting x
     * @param y0     starting y
     * @param radius radius where the agent considers others neighbours
     */

    public SocialAgent(double x0, double y0, int radius) {
        super(x0, y0, radius);
    }

    /**
     * draws a blue circle of radius 5 at the Agent's location.
     */
    public void draw(Graphics g, int scale) {
        if (!this.moved)
            g.setColor(new Color(0, 0, 255));
        else
            g.setColor(new Color(125, 125, 255));

        g.fillOval((int) this.getX() * scale, (int) this.getY() * scale, 5 * scale, 5 * scale);

    }

    /*
     * Moves the agent's x,y values by a random value between -10 and 10 if there
     * are less than 4 agents within its own radius from itself .
     */
    public void updateState(Landscape scape) {
        Random randomGenerator = new Random();
        if (scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() < 4) {
            int w = scape.getHeight();
            int h = scape.getWidth();

            double deltaX = randomGenerator.nextDouble(-10, 10);
            double deltaY = randomGenerator.nextDouble(-10, 10);

            double newX = this.getX() + deltaX;
            double newY = this.getY() + deltaY;

            if (newX < w && newY < h) {
                // Make sure that it stays within the boundary of the window!
                this.setX(newX);
                this.setY(newY);
            }

            this.moved = true;

        } else {
            this.moved = false;
        }

    }

}
