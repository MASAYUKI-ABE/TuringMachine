import java.util.ArrayList;
import java.util.Arrays;

public class TuringMachine extends Machine{
    private State currentState;
    private int currentPosition;
    private Row currentRow;
    private int[] cells;

    /**
     * コンストラクタ
     * StateTableを読み込む
     * テープは50マスと想定
     */

    public TuringMachine(int[] cells, int startPosition, State entryState) {
        this.cells = cells;
        currentPosition = startPosition;
        currentState = entryState;
    }

    /**
     * テープの読み込み処理
     */
    public void read() {
        int currentCell = (int) cells[currentPosition];
        currentRow = currentState.getRow(currentCell);
    }
    /**
     * テープの書き込み処理
     */
    public void write() {
        cells[currentPosition] = currentRow.getWriteInst();
    }

    /**
     * テープの移動処理
     */
    public void move() {
        int nextInst = currentRow.getNextInst();
        currentPosition += nextInst;
        currentState = currentRow.getNextState();
    }
    /**
     * チューリングマシンの施行実行
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
