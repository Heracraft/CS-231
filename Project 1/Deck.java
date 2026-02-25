import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>(52);

    /**
     * Creates the underlying deck as an ArrayList of Card objects.
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        this.build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck.
     * Replaces any current deck stored.
     */

    private void addCards(int value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.deck.add(new Card(value));
        }
    }

    public void build() {
        // addCards(4, 0);
        this.deck = new ArrayList<Card>(52);

        byte lowerBound = 2;
        byte upperBound = 10;

        for (int i = lowerBound; i <= upperBound; i++) {
            addCards(i, 4);
        }

        addCards(10, 4); // Jack
        addCards(10, 4); // Queen
        addCards(10, 4); // King
        addCards(11, 4); // Aces

    }

    /**
     * Returns the number of cards left in the deck.
     * 
     * @return the number of cards left in the deck
     */
    public int size() {
        return this.deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * 
     * @return the first card of the deck
     */
    public Card deal() {
        return this.deck.remove(0);
    }

    /**
     * Shuffles the cards currently in the deck.
     */
    public void shuffle() {
        Random randomGenerator = new Random();


        for (int backIndex = this.deck.size()-1; backIndex > 0 ; backIndex--) {
            int randomIndex = randomGenerator.nextInt(0, backIndex+1);

            Card struckItem = this.deck.get(randomIndex);

            this.deck.set(randomIndex, this.deck.get(backIndex));
            this.deck.set(backIndex, struckItem);

        }

    }

    /**
     * Returns a string representation of the deck.
     * 
     * @return a string representation of the deck
     */
    public String toString() {
        return "%s ... %s: %s cards".formatted(this.deck.get(0), this.deck.get(this.deck.size()-1), this.deck.size());
    }
}
