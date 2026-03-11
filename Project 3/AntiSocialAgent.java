import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class AntiSocialAgent extends Agent {

    public AntiSocialAgent(double x0, double y0, int radius) {
        super(x0, y0, radius);
        // remainder of constructor code
    }

    /**
     * draws a red circle of radius 5 at the Agent's location.
     */
    public void draw(Graphics g, int scale) {
        if (!this.moved)
            g.setColor(new Color(255, 0, 0));
        else
            g.setColor(new Color(255, 125, 125));

        g.fillOval((int) this.getX() * scale, (int) this.getY() * scale, 5 * scale, 5 * scale);

    }

    public void updateState(Landscape scape) {
        Random randomGenerator = new Random();
        if (scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() > 1) {
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