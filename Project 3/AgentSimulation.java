/**
 * Nehemia Kaaya
 * Project 3: Social agents
 * March 6th 2026
 * CS231
 * 
 * AgentSimution class
 * Runs simulations against the Agent & landscape classes
 */

public class AgentSimulation {

    public static int runExpt(int N) {
        Landscape landscape = new Landscape(500, 500);

        for (int i = 0; i < N; i++) {
            double x = Math.random() * 500;
            double y = Math.random() * 500;
            SocialAgent agent = new SocialAgent(x, y, 25);
            landscape.addAgent(agent);
        }

        LandscapeDisplay display = new LandscapeDisplay(landscape, 1);

        int agentsMoved = 1;
        int iterations = 0;

        while (agentsMoved > 0 && iterations < 5000) {
            agentsMoved = landscape.updateAgents();
            display.repaint();

            try {
                Thread.sleep(10); // A bit faster for 5000 iterations!
            } catch (Exception e) {
                if (!(e instanceof InterruptedException)) {
                    System.err.println(e);
                }
            }

            iterations++;
        }

        return iterations;
    }

    public static void main(String[] args) {
        int N = 200; // default amount

        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        }

        System.out.println("Running experiment with N = " + N);
        int iterationsStarted = runExpt(N);
        System.out.println("Experiment finished after " + iterationsStarted + " iterations.");
        System.exit(0);
    }
}