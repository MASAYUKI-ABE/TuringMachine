import java.util.Iterator;

public class PrintObserver implements Observer {
    @Override
    public void update(Machine machine) {
        System.out.println("executed!");
        System.out.println("head: " + machine.getPosition());
        printList(machine.getCells());
    }
    private void printList(int[] numbers) {
        System.out.print("|");
        for (int num: numbers) {
            if (num == -1) {
                // blankの場合はスペース
                System.out.print(" ");
            } else {
                System.out.print(num);
            }
            System.out.print("|");
        }
        System.out.println("");
    }
}
