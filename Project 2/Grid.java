import java.util.Random;

public class Grid {
    private static String arraysToString(int[] arr) {
        String output = "[";
        for (int i = 0; i < arr.length; i++) {
            output += String.format("%2s", arr[i]);
            if (i < (arr.length - 1)) {
                output += ", ";
            }
        }
        output += "]";
        return output;
    }

    private static String arraysToString(int[][] arr) {
        String output = "[";
        for (int i = 0; i < arr.length; i++) {
            int[] item = arr[i];

            output += "\n%s".formatted(arraysToString(item));

            if (i < (arr.length - 1)) {
                output += ", ";
            }

        }
        output += "\n]";
        return output;
    }

    private static void assignRandomInts(int[][] grid) {
        Random randomGenerator = new Random();

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                grid[rowIndex][colIndex] = randomGenerator.nextInt(0, 100);
            }
        }
    }

        // --------------------------------------------------------
    // Return true if two 2D arrays contain identical values.
    // --------------------------------------------------------
    public static boolean gridEquals(int[][] arr1, int[][] arr2) {
        int rowSize1 = arr1.length;
        int rowSize2 = arr2.length;

        if (rowSize1 != rowSize2) {
            // basic check, rows are diff.
            return false;
        }

        // row sizes are equal, so we can just use rowSize1
        for (int rowIndex = 0; rowIndex < rowSize1; rowIndex++) {
            int colSize1 = arr1[rowIndex].length;
            int colSize2 = arr2[rowIndex].length;

            if (colSize1 != colSize2){
                // col size diff, wrong
                return false;
            }

            // col size is equal, so we can just use colSize1
            for (int colIndex = 0; colIndex < colSize2; colIndex++) {
                if(arr1[rowIndex][colIndex] != arr2[rowIndex][colIndex]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // ----------------------------------------------------
        // TODO: Check for at least two command line arguments.
        // If not provided, print a usage statement and return.
        // ----------------------------------------------------

        if (args.length<2){
            System.err.println("row-size and col-size not specified");
            System.err.println("To run this program:\n java Grid.java row-size col-size");
            return;
        }

        int rowSize=Integer.valueOf(args[0]);
        int colSize=Integer.valueOf(args[1]);

        // ----------------------------------------------------
        // TODO: Parse command line arguments into two integers.
        // These will represent rows and columns.
        // ----------------------------------------------------

        // ----------------------------------------------------
        // Declare and create a rectangular 2D int array.
        // ----------------------------------------------------
        int[][] grid = new int[rowSize][colSize];

        // ----------------------------------------------------
        // Fill the rectangular grid with random integers.
        // ----------------------------------------------------

        assignRandomInts(grid);

        // ----------------------------------------------------
        // Create a non-rectangular (jagged) 2D array.
        // Each row should have a different length.
        // ----------------------------------------------------
        int[][] grid2 = new int[5][];

        for (int i = 0; i < grid2.length; i++) {
            grid2[i] = new int[i + 1];
        }

        // ----------------------------------------------------
        // Fill the non-rectangular grid with random ints.
        // ----------------------------------------------------
        assignRandomInts(grid2);

        // ----------------------------------------------------
        // Print both grids using a helper method.
        // ----------------------------------------------------
        System.out.println(arraysToString(grid) + "\n");
        System.out.println(arraysToString(grid2));

        // ----------------------------------------------------
        // Provided equality demo setup (DO NOT MODIFY)
        // ----------------------------------------------------
        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] arr3;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = i + j;
                arr2[i][j] = i + j;
            }
        }
        arr3 = arr1;

        // ----------------------------------------------------
        // TODO: Print results of == comparisons.
        // ----------------------------------------------------

        System.out.println(arr1==arr2);

        // ----------------------------------------------------
        // TODO: Test your gridEquals method.
        // ----------------------------------------------------

        System.out.println("Grid equals result: %s".formatted(gridEquals(arr1, arr2)));

        // ----------------------------------------------------
        // TODO (Optional): Transpose the rectangular grid and
        // print the result.
        // ----------------------------------------------------
    }
    // --------------------------------------------------------
    // TODO (Optional):
    // Return the transpose of a rectangular grid.
    // --------------------------------------------------------
    public static int[][] transpose(int[][] arr) {

        return null;
    }
}