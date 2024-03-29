package Java_Day24;


interface planet {
    int age = 20;
}
interface Flower {
    int age = 10;

}
class Tulip implements planet, Flower {
    int age = 30;
}
public class UI {
    public static void main(String[] args) {
        Tulip tulip = new Tulip();
        System.out.println(tulip.age);

        Flower flower = new Tulip();
        System.out.println(flower.age); // 좋지않은 방법
        System.out.println(Flower.age); // 정상 방법
    }
}
