import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stateを表すクラス。複数のRowクラスをsymbol分持つ。
 */

public class State {
    private int stateNo = 0;
    HashMap<Integer, Row> rows = new HashMap();

    public State(int stateNo) {
        this.stateNo = stateNo;
    }
    public Row getRow(int symbol) {
        return (Row) rows.get(symbol);
    }
    public Row addRow(int index, Row row) {
        rows.put(index, row);
        return row;
    }
    public int getStateNo() {
        return stateNo;
    }

    @Override
    public String toString() {
        String string = "State" + stateNo + "\n";
        string += "Symbol read|Write instruction|Move instruction|Next state\n";
        string += "Blank|" + rows.get(-1).getWriteInst() + "|" + rows.get(-1).getNextInst()
                + "|" + rows.get(-1).getNextState().getStateNo() + "\n";
        string += "    0|" + rows.get(0).getWriteInst() + "|" + rows.get(0).getNextInst()
                + "|" + rows.get(0).getNextState().getStateNo() + "\n";
        string += "    1|" + rows.get(1).getWriteInst() + "|" + rows.get(1).getNextInst()
                + "|" + rows.get(1).getNextState().getStateNo() + "\n";
        return string;
    }
}
