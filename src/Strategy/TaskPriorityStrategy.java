package Strategy;

import Factory.Task;
import java.util.Comparator;
import java.util.PriorityQueue;

// Priority-based strategy for Task management
public class TaskPriorityStrategy implements PriorityStrategy {
    private final PriorityQueue<Task> taskQueue;

    public TaskPriorityStrategy() {
        // Initialize priority queue to store tasks
        taskQueue = new PriorityQueue<>(Comparator.comparing(Task::getPriority));
    }
    @Override
    public void addTask(String description, Priority priority) {

    }

    @Override
    public String getNextTask() {
        if (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll();
            return "Next Task: " + nextTask.getTaskName() + " (Priority: " + nextTask.getPriority() + ")";
        } else {
            return "No pending tasks.";
        }
    }

    @Override
    public boolean hasPendingTasks() {
        return !taskQueue.isEmpty();
    }
}