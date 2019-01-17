/**
 * Stateの1行を表すクラス
 */


public class Row {
    // Symbol
    static final int BLANK = -1;
    static final int ZERO = 0;
    static final int ONE = 1;

    // next instuction
    static final int LEFT = -1;
    static final int RIGHT = 1;

    private int writeInst;
    private int nextInst;
    private State nextState;

    private Row(int writeInst, int nextInst, State nextState) {
        this.writeInst = writeInst;
        this.nextInst = nextInst;
        this.nextState = nextState;
    }

    public static Row createRow(int writeInst, int nextInst, State nextState) {
        return new Row(writeInst, nextInst, nextState);
    }

    public int getWriteInst() {
        return writeInst;
    }

    public int getNextInst() {
        return nextInst;
    }

    public State getNextState() {
        return nextState;
    }
}
