package Factory;

public class HardTaskFactory implements TaskFactory {
    @Override
    public Task createTask() {
        return new HardTask();
    }
}