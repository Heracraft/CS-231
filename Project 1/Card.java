public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */

    private int validateValue(int val){
        if(val <= 11 && val>=2){
            return val;
        }
        else{
            throw new Error("card value must be between 2 and 11");
        }
    }

    public Card(int val) {
        this.value = validateValue(val);
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return String.valueOf(this.value);
    }
}
