package Strategy;

public class DayDate implements DateStrategy{
    @Override
    public void deadline(double time){
        System.out.println("Deadline due to" + time + "pm");
    }
}
