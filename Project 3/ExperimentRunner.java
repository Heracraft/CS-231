public class ExperimentRunner {
    public static int runExptHeadless(int N) {
        Landscape landscape = new Landscape(500, 500);

        for (int i = 0; i < N; i++) {
            double x = Math.random() * 500;
            double y = Math.random() * 500;
            SocialAgent agent = new SocialAgent(x, y, 25);
            landscape.addAgent(agent);
        }

        int agentsMoved = 1;
        int iterations = 0;

        while (agentsMoved > 0 && iterations < 5000) {
            agentsMoved = landscape.updateAgents();
            iterations++;
        }

        return iterations;
    }

    public static void main(String[] args) {
        int[] ns = {50, 100, 150, 200, 250};
        System.out.println("N,Iterations");
        for (int n : ns) {
            System.out.println(n + "," + runExptHeadless(n));
        }

        System.out.println("=== Element 2: Different Radii with N=150 ===");
        int[] radii = {10, 25, 40, 55, 70};
        System.out.println("Radius,Iterations");
        for (int r : radii) {
            System.out.println(r + "," + runExptHeadlessRadius(150, r));
        }
    }

    public static int runExptHeadlessRadius(int N, int r) {
        Landscape landscape = new Landscape(500, 500);

        for (int i = 0; i < N; i++) {
            double x = Math.random() * 500;
            double y = Math.random() * 500;
            SocialAgent agent = new SocialAgent(x, y, r);
            landscape.addAgent(agent);
        }

        int agentsMoved = 1;
        int iterations = 0;

        while (agentsMoved > 0 && iterations < 5000) {
            agentsMoved = landscape.updateAgents();
            iterations++;
        }

        return iterations;
    }
}
