package Observer;

public interface SubjectTask {
    void registerObserver(ObserverTask observer);
    void removeObserver(ObserverTask observer);
    void notifyObservers(String flightDetails);
}
