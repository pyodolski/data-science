package Java_Day27;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T>{

    List<T> fruits = new ArrayList<>();
    public void add(T fruit) {
        fruits.add(fruit);
    }
}
class Fruit{}
class Apple extends Fruit{
    private int color = 1;
}
class Main {
    public static void main(String[] args) {
        var intBox = new FruitBox<Integer>();
        intBox.add(12);

        var appleBox = new FruitBox<Apple>();
        //List<Apple> apples = new ArrayList<>();
        var fruitBox = new FruitBox<Fruit>();
        fruitBox.add(new Apple());
    }
}