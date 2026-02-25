/*
file name:      HandTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea HandTests
*/

public class HandTests {

    public static double handTests() {

        double score = 0.25 ;

        // case 1: testing Hand()
        {
            // set up
            Hand h1 = new Hand();

            if ( ( h1 != null ) && ( h1.size() == 0 ) ) {
                score += 0.25 ;
            }
        }

        // case 2: testing getTotalValue() and size()
        {
            // set up
            Hand h1 = new Hand();

            // test
            if ( ( h1.getTotalValue() == 0 ) && ( h1.size() == 0 ) ) {
                score += 0.25 ;
            }
        }

        // case 3: testing getTotalValue() and size()
        {
            // set up
            Hand h1 = new Hand();
            h1.add(new Card(5));

            // test
            if ( ( h1.getTotalValue() == 5 ) && ( h1.size() == 1 ) ) {
                score += 0.25 ;
            }
        }

        // case 4: testing getTotalValue(), size(), and getCard()
        {
            // set up
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));

            if ( ( h1.getTotalValue() == 10 ) && ( h1.size() == 3 ) && ( h1.getCard(0).getValue() == 5 ) 
                    && ( h1.getCard(1).getValue() == 2 ) && ( h1.getCard(2).getValue() == 3 ) ) {
                score += 0.5 ;
            } 
        }

        // case 5: testing reset()
        {
            // set up
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));
            h1.reset();

            // test
            if ( ( h1.getTotalValue() == 0 ) && ( h1.size() == 0 ) ) {
                score += 0.25 ;
            } 
        }

        // case 6: testing toString()
        {
            // set up
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));

            // test
            if ( h1.toString().equals("[5, 2, 3] : 10") ) {
                score += 0.25 ;
            } 
        }

        return score ;
    }


    public static void main(String[] args) {

        handTests();
    }
}