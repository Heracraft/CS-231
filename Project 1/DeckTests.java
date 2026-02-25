/*
file name:      DeckTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea DeckTests
*/


public class DeckTests {

    public static double deckTests() {

        double score = 0. ;

        // case 1: testing Deck() and size()
        {
            // set up
            Deck d1 = new Deck();

            // test
            if ( ( d1 != null ) && ( d1.size() == 52 ) ) {
                score += 0.5 ;
            } else {
                System.out.println("Deck() and size() test failed");
            }
        }

        // case 2: testing deal()
        {
            // set up
            Deck d1 = new Deck();

            // test
            Card c1 = d1.deal();

            if ( ( d1 != null ) && ( c1 != null ) && ( d1.size() == 51 ) ) {
                score += 0.5 ;
            } else {
                System.out.println("deal() test failed");
            }
        }

        // case 3: testing build()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();
            d1.build();

            if ( ( d1 != null ) && ( c1 != null ) && 
                ( c2 != null ) && ( c3 != null ) && ( d1.size() == 52 ) ) {
                score += 0.5 ;
            } else {
                System.out.println("build() test failed");
            }
        }

        // case 4: testing shuffle()
        {
            // set up
            Deck d1 = new Deck();

            // verify
            

            // test
            String before = d1.toString();
            d1.shuffle();
            String after = d1.toString();

            if ( ( !before.equals(after) ) && ( d1.size() == 52 )  ) {
                score += 0.5 ;
            } else {
                System.out.println("shuffle() test failed");
            }
        }

        return score ;

    }


    public static void main(String[] args) {

        deckTests();
    }
}