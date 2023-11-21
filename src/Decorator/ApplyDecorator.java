package Decorator;

import Factory.Task;

public class ApplyDecorator {
    public static Task applyOfflineDecorator(Task task){
        return new OfflineTask(task);
    }
    public static Task applyOnlineDecorator(Task task){
        return new OnlineTask(task);
    }
    public static String getTaskDescription(Task task) {
        return task.getDescription();
    }
}
