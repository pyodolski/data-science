package Java_Day25.game;
import  java.util.*;
interface WeatherUpdate{
    void update();
}
public class Orc implements WeatherUpdate{
    @Override
    public void update() {
    }
}
class Hobit implements WeatherUpdate {
    @Override
    public void update() {
        System.out.println("Orc");
    }
}
enum WeatherType {
    SUNNY, // public static final
    RAINY,
    WINDY,
    COLD,
}

class Center {
    private Set<WeatherUpdate> observers;
    private WeatherType weatherType;
    public Center() {
        observers = new HashSet<>();
        weatherType = WeatherType.SUNNY;
    }
    public void addObserver(WeatherUpdate weatherUpdate) {
        observers.add(weatherUpdate);
    }

    public void weatherUpdate() {
        var types = WeatherType.values();
        int index = weatherType.ordinal() + 1;

        weatherType = types[index];
    }
}

class Main {
    public static void main(String[] args) {
        var center = new Center();

        // Orc orc = new Orc();
        WeatherUpdate observer = new Orc();

        observer = new Hobit();
        center.addObserver(observer);
        List<Orc> lists = new ArrayList<>();
        lists = new LinkedList<>();
    }
}