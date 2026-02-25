/*
file name:      Blackjack.java
Authors:        Nehemia Kaaya
last modified:  8/28/2022

How to run:     echo "pray" && java Blackjack
*/

class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    public Blackjack() {
        reset();
    }

    public void reset() {
        this.playerHand = new Hand();
        this.dealerHand = new Hand();

        if (this.deck == null || this.deck.size() < 26) {
            this.deck = new Deck();
            this.deck.shuffle();
        }
    }

    // public void reset() should reset the game. Both the player Hand and dealer
    // Hand should start with no cards. If the number of cards in the deck is less
    // than 26 (the reshuffle cutoff), then the method should create a fresh
    // (complete), shuffled deck. Otherwise, it should not modify the deck, just
    // clear the player and dealer hands.

    // public void deal() should deal out two cards to both players from the Deck.
    public void deal() {
        playerHand.add(this.deck.deal());
        playerHand.add(this.deck.deal());

        dealerHand.add(this.deck.deal());
        dealerHand.add(this.deck.deal());
    }

    // public boolean playerTurn() have the player draw cards until the total value
    // of the player's hand is equal to or above 16. The method should return false
    // if the player goes over 21 (bust).

    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(this.deck.deal());
            if (playerHand.getTotalValue() > 21) {
                return false;
            }
        }
        return true;
    }

    // public boolean dealerTurn() have the dealer draw cards until the total of the
    // dealer's hand is equal to or above 17. The method should return false if the
    // dealer goes over 21.
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.add(this.deck.deal());
        
            if (dealerHand.getTotalValue() > 21) {
                // the new card would cause an overflow/loss
                return false;
            }
        }
        return true;
    }

    // public int game(boolean verbose) the game method should play a single game of
    // Blackjack following the procedure outlined above. The game method should call
    // the reset method at the start of each game. The game method should return a
    // -1 if the dealer wins, 0 in case of a push (tie), and a 1 if the player wins.
    // If the parameter verbose is true, then the game method should print out the
    // initial and final hands of the game and a statement about the result
    // (dealer/push/player).

    private void logHands(String stage) {
        // abstracted away, too much to dupe
        System.out.println(
                "%s hands\nPlayer: %s\nDealer: %s"
                        .formatted(
                                stage,
                                playerHand.toString(),
                                dealerHand.toString()));
    }

    private void interpretResults(byte winner) {
        if (winner == -1) {
            System.out.println("Dealer wins. Suprised?");
        } else if (winner == 1) {
            System.out.println("Player wins. woah!.");
        } else if (winner == 0) {
            System.out.println("its a tieeee!.");
        } else {
            throw new Error("wrong winner code provided. Must be -1,1 or 0");
        }
    }

    public int game(boolean verbose) {
        reset();
        deal();

        byte winner;

        if (verbose)
            logHands("Initial");

        boolean playerSurvived = playerTurn();
        // The player should play their entire turn before the dealer.
        // The player should calculate the value of their hand (the sum of the card
        // values) and choose whether to take a card (hit) or stop at the current value
        // (stand).
        // If the player chooses to hit, then if the new value of their hand is greater
        // than 21, the player loses (busts) and the game is over. If the value is less
        // than 21, the player repeats the process this.deck.deal()until they stand or bust.

        if (!playerSurvived) {
            // player did not survive, dealer wins

            winner = -1;
        } else {
            boolean dealerSurvived = dealerTurn();

            // System.out.println("player survived and dealer %s".formatted(dealerSurvived?"survived":"bust"));


            if (dealerSurvived) {
                // both survived
                if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {
                    // player has the biggest hand
                    winner = 1;
                } else if (playerHand.getTotalValue() == dealerHand.getTotalValue()) {
                    // tie/push
                    winner = 0;
                } else {
                    winner = -1;
                }
            } else {
                // dealer bust but player survived
                winner = 1;
            }
        }

        if (verbose) {
            logHands("Final");
            interpretResults(winner);
        }
        ;
        return winner;

        // If the player did not bust, the dealer plays.
        // The dealer will continue to take a card (hit) until the value of their hand
        // is 17 or greater.
        // If the dealer busts, then the player wins.
        // If player and dealer both avoided a bust, then the hand with the highest
        // value wins the game. If both hands are of equal value, then the hand is a tie
        // (push).

    }

    // public String toString() returns a String that has represents the state of
    // the game. It may be helpful to show the player and dealer hands as well as
    // their current total value.

    public String toString() {
        return "player's hand: %s. Total value: %s,\ndealer's hand: %s Total value: %s".formatted(
                playerHand.toString(),
                playerHand.getTotalValue(),
                dealerHand.toString(),
                dealerHand.getTotalValue());
    }

    public static void main() {
        Blackjack blackjack = new Blackjack();
        blackjack.game(true);
    }
}
