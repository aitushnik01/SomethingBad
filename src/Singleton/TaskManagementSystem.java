package Singleton;


import Observer.TaskUpdates;
import SQL.TaskCRUD;

public class TaskManagementSystem {
    private static volatile TaskManagementSystem instance;

    private TaskManagementSystem() {
    }

    public static TaskManagementSystem getInstance() {
        if (instance == null) {
            synchronized (TaskManagementSystem.class) {
                if (instance == null) {
                    instance = new TaskManagementSystem();
                }
            }
        }
        return instance;
    }

    public void createTask(String description, int priority, String dueDate) {
        // Create the task in the database using CRUD class
        TaskCRUD.createTask(description, priority , dueDate);

        // Notify observers about the new task created
        TaskUpdates taskUpdates = new TaskUpdates();
        taskUpdates.updateTasks("New task: " + description + ", Due Date: " + dueDate + ", Priority: " + priority);
    }
}
