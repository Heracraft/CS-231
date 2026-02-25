
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.io.FileWriter;
import java.io.BufferedWriter;

// Define a Tester class
public class Test {
	// define a static main method
	public static void main(String[] args) throws Exception {

		//Redirect their print statements so it doesn't mess up the test
        PrintStream out = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) throws IOException {
            }
        }));

		double score = 0.; //1 point for compiling
		final StringBuilder testNotes = new StringBuilder(); // Track errors

		try {
			 double arrayScore = ArrayListTests.arrayListTests();
			 score += arrayScore ;
			 if ( arrayScore < 2 ) {
			 	testNotes.append( "Your code didn't pass all of the ArrayList tests\n" );
			 }
		} catch (Exception E) {
			testNotes.append( "Your program threw one or more errors while testing ArrayList.java\n" );
		}

		try {
			double cardScore = CardTests.cardTests();
			score += cardScore ;
			 if ( cardScore < 2 ) {
			 	testNotes.append( "Your code didn't pass all of the Card tests\n" );
			 }

		} catch (Exception E) {
			testNotes.append( "Your program threw one or more errors while testing Card.java\n" );
		}

		try {
			double handScore = HandTests.handTests();
			score += handScore ;
			 if ( handScore < 2 ) {
			 	testNotes.append( "Your code didn't pass all of the Hand tests\n" );
			 }
		} catch (Exception E) {
			testNotes.append( "Your program threw one or more errors while testing Hand.java\n" );
		}

		try {
			double deckScore = DeckTests.deckTests();
			score += deckScore ;
			if ( deckScore < 2 ) {
			 	testNotes.append( "Your code didn't pass all of the Deck tests\n" );
			}
		} catch (Exception E) {
			testNotes.append( "Your program threw one or more errors while testing Deck.java\n" );
		}

		try {
			double blackjackScore = BlackjackTests.blackjackTests();
			score += blackjackScore ;
			if ( blackjackScore < 4 ) {
			 	testNotes.append( "Your code didn't pass all of the Blackjack tests\n" );
			}
		} catch (Exception E) {
			System.out.println(E);
			testNotes.append( "Your program threw one or more errors while testing Blackjack.java\n" );
		}

		//Finish up notes
		testNotes.append( "Your score is " + (int)score + "/12" );
        
        FileWriter fw = new FileWriter("sysout.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(testNotes.toString());
        bw.close();

        System.setOut(out);
        System.out.println("{ \"score\": " + score + ", \"stdout_visibility\": \"visible\"}");
	}
}
