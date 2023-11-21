package Factory;

import Strategy.Priority;

public class HardTask implements Task{
    @Override
    public void id() {
        System.out.println("This is task ID");
    }

    @Override
    public String getTaskName() {
        return "This is task NAME";
    }
    @Override
    public String getDescription() {
        return "This is task DESCRIPTION";
    }

    @Override
    public double dueDate() {
        return 2023;
    }

    @Override
    public Priority getPriority() {
        return Priority.LOW;
    }
}
