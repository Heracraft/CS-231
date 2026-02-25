/*
file name:      CardTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea CardTests
*/


public class CardTests {

    public static double cardTests() {

        double score = 0.5;

        // case 1: testing Card(i)
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            if ( c1 != null && c2 != null ) {
                score += 0.5 ;
            }

        }

        // case 2: testing getValue()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.getValue() + " == 5");
            System.out.println(c2.getValue() + " == 10");

            // verify
            if ( ( c1.getValue() == 5 ) && ( c2.getValue() == 10 ) ) {
                score += 0.5 ;
            }

        }

        // case 3: testing toString()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            if ( ( c1.toString().equals("5") ) && ( c2.toString().equals("10") ) ) {
                score += 0.5 ;
            }

        }

        return score;
    }


    public static void main(String[] args) {

        cardTests();
    }
}