package Factory;

public class SimpleTaskFactory implements TaskFactory {
    @Override
    public Task createTask() {
        return new SimpleTask();
    }
}

