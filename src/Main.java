import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // HACK: Read files or make GUI
        // Create StateTable
        State stopState = new State(-1);
        State state0 = new State(0);
        State state1 = new State(1);

        // Add rows to State
        state0.addRow(Row.BLANK, Row.createRow(Row.BLANK, Row.LEFT, state1));
        state0.addRow(Row.ZERO, Row.createRow(Row.ONE, Row.RIGHT, state1));
        state0.addRow(Row.ONE, Row.createRow(Row.ZERO, Row.RIGHT, state0));
        state1.addRow(Row.BLANK, Row.createRow(Row.BLANK, Row.RIGHT, stopState ));
        state1.addRow(Row.ZERO, Row.createRow(Row.ONE, Row.LEFT, state1));
        state1.addRow(Row.ONE, Row.createRow(Row.ZERO, Row.LEFT, state1));

        System.out.println(state0.toString());
        System.out.println(state1.toString());

        // Create a tape(cells): 110
        int[] cells = new int[50];
        Arrays.fill(cells, -1);

        // Set initial position
        int startPosition = cells.length / 2;

        cells[startPosition - 2] = 1;
        cells[startPosition - 1] = 1;
        cells[startPosition] = 0;

        // Print initial stare of the tape
        System.out.println("start position: " + startPosition);
        System.out.println("initial state:");
        for (int cell: cells) {
            if (cell == -1) {
                // if blank, print a space
                System.out.print(" ");
            } else {
                System.out.print(cell);
            }
            System.out.print("|");
        }
        System.out.println("\n");

        // Generate a instance of TuringMachine
        Machine machine = new TuringMachine(cells, startPosition, state0);

        // Generate a instance of PrintObserver
        Observer observer = new PrintObserver();

        // Add observer
        machine.addObserver(observer);

        System.out.println("======start======");

        // Start TuringMachine
        machine.execute();

        System.out.println("======end======");

    }
}
