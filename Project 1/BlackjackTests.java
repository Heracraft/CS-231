/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea BlackjackTests
*/

//Draw percent: 8 +/- 1
//Dealer percent: 49 +/- 1
//Player percent: 41 +/1 1

public class BlackjackTests {

    public static double blackjackTests() {

        double score = 0;

        Blackjack blackjackGame = new Blackjack() ;
        float dealerWins = 0;
        float playerWins = 0;
        float draws = 0;

        int nSims = 10000;
        for ( int i = 0 ; i < nSims ; i++ ) {
            int result = blackjackGame.game( false );   
            if ( result == 0 ) {
                draws ++ ;
            } else if ( result == -1 ) {
                dealerWins ++ ;
            } else {
                playerWins ++ ;
            }
        }

        int fracDraws = (int)( ( draws / nSims ) * 100 ) ;
        int fracDealer = (int)( ( dealerWins / nSims ) * 100 ) ;
        int fracPlayer = (int)( ( playerWins / nSims ) * 100 ) ;

        System.out.println( fracDraws );
        System.out.println( fracDealer );
        System.out.println( fracPlayer );

        if ( ( 6 <= fracDraws ) && ( fracDraws <= 10 ) && 
            ( 47 <= fracDealer ) && ( fracDealer <= 51 ) && 
            ( 39 <= fracPlayer ) && ( fracPlayer <= 43 ) ) {
            score += 4 ;

        } else {
            System.out.println("Blackjack simulation test failed");
        }
        return score ;
    }

    public static void main(String[] args) {

        blackjackTests();
    }
}