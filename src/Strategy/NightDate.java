package Strategy;

public class NightDate implements DateStrategy{
    @Override
    public void deadline(double time){
        System.out.println("Deadline due to" + time + "am");
    }
}
