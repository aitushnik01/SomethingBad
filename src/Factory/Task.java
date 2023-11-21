package Factory;

import Strategy.Priority;

public interface Task {
    public void id();
    public String getTaskName();
    public String getDescription();
    public double dueDate();
    public Priority getPriority();
}
