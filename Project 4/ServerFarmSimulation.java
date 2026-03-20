/*
file name:      ServerFarmSimulation.java
Authors:        Ike Lage, Nehemia Kaaya
last modified:  03/19/2026
Course:         CS231
*/

public class ServerFarmSimulation {

    /**
     * Runs a simulation for a specific dispatcher type and returns the average waiting time.
     */
    private static double runExperiment(String dispatcherType, int numServers, int numJobs, int meanArrivalTime, int meanProcessingTime) {
        JobMaker jobMaker = new JobMaker(meanArrivalTime, meanProcessingTime);
        JobDispatcher dispatcher = null;

        if (dispatcherType.equals("random")) {
            dispatcher = new RandomDispatcher(numServers, false);
        } else if (dispatcherType.equals("round")) {
            dispatcher = new RoundRobinDispatcher(numServers, false);
        } else if (dispatcherType.equals("shortest")) {
            dispatcher = new ShortestQueueDispatcher(numServers, false);
        } else if (dispatcherType.equals("least")) {
            dispatcher = new LeastWorkDispatcher(numServers, false);
        }

        for (int i = 0; i < numJobs; i++) {
            dispatcher.handleJob(jobMaker.getNextJob());
        }
        dispatcher.finishUp();

        return dispatcher.getAverageWaitingTime();
    }

    /**
     * Formats a string to a specific length with padding.
     */
    private static String formatField(String val, int length) {
        if (val.length() >= length) {
            return val.substring(0, length);
        }
        StringBuilder sb = new StringBuilder(val);
        while (sb.length() < length) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int meanArrivalTime = 3;
        int meanProcessingTime = 100;
        int totalJobs = 10000000;

        System.out.println("--- Required Result 1: Dispatcher Comparison (34 Servers) ---");
        String[] dispatchers = {"random", "round", "shortest", "least"};
        System.out.println(formatField("Dispatcher", 15) + "| " + formatField("Avg. Wait Time", 20));
        System.out.println("----------------------------------------");
        
        for (String type : dispatchers) {
            double avgWait = runExperiment(type, 34, totalJobs, meanArrivalTime, meanProcessingTime);
            System.out.println(formatField(type, 15) + "| " + formatField(String.format("%.4f", avgWait), 20));
        }
        System.out.println();

        System.out.println("--- Required Result 2: ShortestQueue Scalability (30-40 Servers) ---");
        System.out.println(formatField("Servers", 10) + "| " + formatField("Avg. Wait Time", 20));
        System.out.println("----------------------------------------");
        
        for (int numServers = 30; numServers <= 40; numServers++) {
            double avgWait = runExperiment("shortest", numServers, totalJobs, meanArrivalTime, meanProcessingTime);
            System.out.println(formatField(String.valueOf(numServers), 10) + "| " + formatField(String.format("%.4f", avgWait), 20));
        }
    }
}