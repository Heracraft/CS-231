import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.Random;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    private int cols;
    private int rows;
    // no need, the nested array is rectangular. we can just look at the first row
    // and the first col
    // actually we do need it, keeps the code cleaner especially inside getNeighbors

    /**
     * An overloaded method that takes in an array/2D array and prints it out
     * in matrix format.
     * 
     * The first method takes in unidimensional array and returns a matrix row
     * The seocond method takes in a 2D array and yields to the first for each row
     * and combines the outputs into one string matrix.
     * 
     * @param <T> A generic type for the array's core elements. For this case it'd
     *            always be an int
     * @param arr
     * @return a matrix string.
     */

    private <T> String arrayToString(T[] arr) {
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            output += String.format("%2s", arr[i]);
        }
        output += "\n";
        return output;
    }

    private <T> String arrayToString(T[][] arr) {
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            T[] item = arr[i];
            output += arrayToString(item);

        }
        return output;
    }

    /**
     * A generic method that allocates a generic value to each cell in the grid
     * given a call back
     * 
     * @param grid         the landscape to allocate cells/values to
     * @param cellSupplier An interface that returns a cell given 0 arguments.
     *                     Its my attempt at a higher order function in java.
     */

    private void allocateValues(Cell[][] grid, Supplier<Cell> cellSupplier) {
        // fancy supplier logic but why not.
        // I hail from typescript land and there we have higher order functions.
        // Couldn't resist.

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                grid[rowIndex][colIndex] = cellSupplier.get();
            }
        }
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        this.cols = columns;
        this.rows = rows;

        this.landscape = new Cell[rows][columns];
        this.initialChance = -1;
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        this.cols = columns;
        this.rows = rows;

        landscape = new Cell[rows][columns];

        this.initialChance = chance;

        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        Random randomGenerator = new Random();

        allocateValues(this.landscape, () -> {
            boolean isAlive = randomGenerator.nextDouble(0, 1) < this.initialChance;
            return new Cell(isAlive);
        });
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return this.landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        return arrayToString(this.landscape);
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        for (int rowIndex = Math.max(row - 1, 0); rowIndex <= Math.min(row + 1, this.rows - 1); rowIndex++) {
            for (int colIndex = Math.max(col - 1, 0); colIndex <= Math.min(col + 1, this.cols - 1); colIndex++) {
                if (rowIndex == row && colIndex == col)
                    continue; // don't count itself
                neighbors.add(this.landscape[rowIndex][colIndex]);
            }
        }

        return neighbors;
    }

    /**
     * Advances the current Landscape by one step.
     */
    public void advance() {
        Cell[][] tempLandscape = new Cell[rows][cols];

        for (int rowIndex = 0; rowIndex < this.landscape.length; rowIndex++) {
            for (int colIndex = 0; colIndex < this.landscape[rowIndex].length; colIndex++) {
                Cell oldCell = this.landscape[rowIndex][colIndex];

                Cell newCell = new Cell(oldCell.getAlive());

                newCell.updateState(getNeighbors(rowIndex, colIndex));

                tempLandscape[rowIndex][colIndex] = newCell;
                ;
            }
        }

        this.landscape = tempLandscape;
        tempLandscape = null;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
    }
}
