/**
 * TuringMachine object class.
 */
public class TuringMachine extends Machine{
    private State currentState;
    private int currentPosition;
    private Row currentRow;
    private int[] cells;

    /**
     * Constructor
     * read entry StateTable
     */

    public TuringMachine(int[] cells, int startPosition, State entryState) {
        this.cells = cells;
        currentPosition = startPosition;
        currentState = entryState;
    }

    /**
     * Read the symbol on the square
     */
    public void read() {
        int currentCell = (int) cells[currentPosition];
        currentRow = currentState.getRow(currentCell);
    }
    /**
     * Write the symbol on the cell
     */
    public void write() {
        cells[currentPosition] = currentRow.getWriteInst();
    }

    /**
     * Move the tape(cells)
     */
    public void move() {
        int nextInst = currentRow.getNextInst();
        currentPosition += nextInst;
        currentState = currentRow.getNextState();
    }
    /**
     * Start TuringMachine
     */
    public void execute() {
        while (currentState.getStateNo() != -1) {
            read();
            write();
            move();
            notifyObserver();
        }
    }
    public int getPosition() {
        return currentPosition;
    }
    public int[] getCells() {
        return cells;
    }
}
