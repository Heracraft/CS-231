class Simulation {
    public static void main(String[] args) {
        int[] iterations = { 100, 1000, 10000, 100000, 1000000 };
        Results[] results = new Results[5];

        Blackjack blackjack = new Blackjack();

        for (int i = 0; i < iterations.length; i++) {
            int iterationCount = iterations[i];

            int playerWinCount = 0;
            int dealerWinCount = 0;
            int pushCount = 0;

            for (int iteration = 0; iteration <= iterationCount; iteration++) {
                int winner = blackjack.game(false);
                if (winner == -1) {
                    dealerWinCount++;
                } else if (winner == 1) {
                    playerWinCount++;
                } else if (winner == 0) {
                    pushCount++;
                } else {
                    throw new Error("Wrong winner code returned. Must return 1,0, or -1");
                }
            }

            double playerWinRate = ((double) playerWinCount / iterationCount) * 100;
            double dealerWinRate = ((double) dealerWinCount / iterationCount) * 100;
            double pushRate = (pushCount / iterationCount) * 100;

            // return {playerWinCount, dealerWinRate, push};
            results[i] = new Results(iterationCount, playerWinRate, dealerWinRate, pushRate);
        }

        for (Results result : results) {
            System.out.println(result.toString());
        }
    }
}

class Results { // I know, I know. Extra but why not.
    public double playerWinRate;
    public double dealerWinRate;
    public double pushRate;

    public int iterationCount;

    public Results(int iterationCount, double playerWinRate, double dealerWinRate, double pushRate) {
        this.iterationCount = iterationCount;

        this.playerWinRate = playerWinRate;
        this.dealerWinRate = dealerWinRate;
        this.pushRate = pushRate;
    }

    public String toString() {
        return "%s\tPlayer win rate: %s\tDealer win rate: %s\tPush rate:%s"
            .formatted(
                iterationCount,
                String.format("%.2f", playerWinRate),
                String.format("%.2f", dealerWinRate), 
                pushRate
            );
    }

}