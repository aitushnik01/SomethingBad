package Observer;

public class UserTask implements ObserverTask{
    private String name;

    public UserTask(String name){
        this.name = name;
    }
    @Override
    public void update(String taskDetails){
        System.out.println(name + "notified about changes");
    }
}
