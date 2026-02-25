/*
file name:      ArrayListTests.java
Authors:        Ike Lage
last modified:  02/18/25
*/


public class ArrayListTests {

    public static double arrayListTests() {

        double score = 0;

        // case 1: testing ArrayList()
        {
            // setup
            ArrayList<Integer> al = new ArrayList<Integer>();

            // test
            if ( al != null ) {
                score += 0.5 ;
            }
        }

        // case 2: testing add(T item)
        {
            // setup
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                al.add(i);
            }

            // test
            if ( al.size() == 5 ) {
                score += 0.5 ;
            }
        }

        // case 3: testing get()
        {
            // setup
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                al.add(i);
            }

            // test
            if ( ( al.get(0) == 0 ) && ( al.get(3) == 3 ) && ( al.get(4) == 4 ) ) {
                score += 0.5 ;
            }
        }

        // case 4: testing set(int index, T item)
        {
            // setup
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                al.add(i);
            }

            // test
            al.set(0, 9);
            al.set(3, 8);
            al.set(4, 7);

            if ( ( al.get(0) == 9 ) && ( al.get(1) == 1 ) && ( al.get(3) == 8 ) ) {
                score += 0.5 ;
            }
        }

        return score ;
    }


    public static void main(String[] args) {

        System.out.println("%s / 2.0".formatted(arrayListTests()));;
    }
}