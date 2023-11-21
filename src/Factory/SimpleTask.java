package Factory;

import Strategy.Priority;

public class SimpleTask implements Task {

    @Override
    public void id() {
        System.out.println("This is simple Task");
    }

    @Override
    public String getTaskName() {
        return "Task name";
    }

    @Override
    public String getDescription() {
        return "This is simple task desc";
    }

    @Override
    public double dueDate() {
        return 2025;
    }

    @Override
    public Priority getPriority() {
        return Priority.LOW;
    }
}

