package Decorator;

import Factory.Task;
import Strategy.Priority;

public class OnlineTask implements TaskDecorator{
    protected Task decoratedTask;
    public OnlineTask(Task decoratedTask) {
        this.decoratedTask = decoratedTask;
    }
    @Override
    public void id() {
        decoratedTask.id();
    }

    @Override
    public String getTaskName() {
        String baseName = decoratedTask.getTaskName();
        decoratedTask.getTaskName();
        return baseName + "Offline";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double dueDate() {
        double baseDueDate = decoratedTask.dueDate();
        decoratedTask.dueDate();
        return baseDueDate;
    }

    @Override
    public Priority getPriority() {
        return decoratedTask.getPriority();
    }
}
