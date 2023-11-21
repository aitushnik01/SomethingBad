package Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskUpdates implements SubjectTask {
    private final List<ObserverTask> observers;

    public TaskUpdates() {
        observers = new ArrayList<>();
    }

    public void updateTasks(String taskDetails) {
        notifyObservers(taskDetails);
    }

    @Override
    public void registerObserver(ObserverTask observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverTask observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String taskDetails) {
        for (ObserverTask observer : observers) {
            observer.update(taskDetails);
        }
    }
}
