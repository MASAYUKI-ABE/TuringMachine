import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Stateを作成
        State stopState = new State(-1);
        State state0 = new State(0);
        State state1 = new State(1);

        // Stateにrowを追加
        state0.addRow(Row.BLANK, Row.createRow(Row.BLANK, Row.LEFT, state1));
        state0.addRow(Row.ZERO, Row.createRow(Row.ONE, Row.RIGHT, state1));
        state0.addRow(Row.ONE, Row.createRow(Row.ZERO, Row.RIGHT, state0));
        state1.addRow(Row.BLANK, Row.createRow(Row.BLANK, Row.RIGHT, stopState ));
        state1.addRow(Row.ZERO, Row.createRow(Row.ONE, Row.LEFT, state1));
        state1.addRow(Row.ONE, Row.createRow(Row.ZERO, Row.LEFT, state1));

        System.out.println(state0.toString());
        System.out.println(state1.toString());

        // テープ(cells)を用意
        // 110
        int[] cells = new int[50];
        Arrays.fill(cells, -1);

        // テープのスタート位置を指定
        int startPosition = cells.length / 2;

        cells[startPosition] = 1;
        cells[startPosition + 1] = 1;
        cells[startPosition + 2] = 0;

        // 初期状態を表示
        System.out.println("start position: " + startPosition);
        System.out.println("initial state:");
        for (int cell: cells) {
            if (cell == -1) {
                // blankの場合はスペース
                System.out.print(" ");
            } else {
                System.out.print(cell);
            }
            System.out.print("|");
        }
        System.out.println("\n");

        // TuringMachineをインスタンス化
        Machine machine = new TuringMachine(cells, startPosition, state0);

        // Observerをインスタンス化
        Observer observer = new PrintObserver();

        // TuringMachineにObserverを登録
        machine.addObserver(observer);

        System.out.println("======start======");

        // TuringMachineを動かす
        machine.execute();

        System.out.println("======end======");

    }
}
