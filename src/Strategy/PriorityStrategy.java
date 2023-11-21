package Strategy;

public interface PriorityStrategy {
    void addTask(String description, Priority priority);
    String getNextTask();
    boolean hasPendingTasks();
}
