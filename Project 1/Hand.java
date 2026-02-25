public class Hand {
    private ArrayList<Card> hand;
    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand(){
        // this.hand = new ArrayList<Card>(11); // largest amount of cards you can have before bursting
        this.hand = new ArrayList<Card>(); // but maybe its more efficient if we dont

    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        this.hand = new ArrayList<Card>();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        this.hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return this.hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return this.hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int value=0;
        for (int i=0;i<this.hand.size();i++){
            value+=this.hand.get(i).getValue();
        }
        return value;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        int handValue = this.getTotalValue();

        String output = "[";

        for (int i=0;i<this.hand.size();i++){
            output+=this.hand.get(i).toString();
            if (i<this.hand.size()-1){
                output+=", ";
            }
        } 

        output+="] : %s".formatted(handValue);

        return output;

    }
}
