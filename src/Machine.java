import java.util.ArrayList;
import java.util.Iterator;

/**
 * Machine object class.
 */
public abstract class Machine {
    private ArrayList observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObserver() {
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = (Observer) it.next();
            observer.update(this);
        }
    }

    public abstract int getPosition();
    public abstract int[] getCells();
    public abstract void execute();
}
