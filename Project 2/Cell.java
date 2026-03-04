import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        this.alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        int noOfLiveNeighbours = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.getAlive()) {
                noOfLiveNeighbours++;
            }
        }

        if (this.alive) {
            // cel is allive

            if (noOfLiveNeighbours < 2) {
                // dies by underpopulation
                this.setAlive(false);
            }

            if (noOfLiveNeighbours > 3) {
                // dies by overpopulation
                this.setAlive(false);
            }

            // continues to live
        } else {
            // cell is dead

            if (noOfLiveNeighbours == 3) {
                // alive by reproduction
                this.setAlive(true);
            }

        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (this.alive){
            return "1";
        }
        else{
            return "0";
        }
    }
}