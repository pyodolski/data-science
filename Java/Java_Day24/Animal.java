package Java_Day24;

public interface Animal {
    void cry();
}
interface Pet{
    void play();
}
class Tail {
    public void move() {
        System.out.println("살랑살랑~");
    }
}
class Cat extends Tail implements Animal, Pet{
    @Override
    public void move() {
        super.move();
    }

    @Override
    public void play() {

    }

    @Override
    public void cry() {

    }
}

class Main_{
    public static void main(String[] args) {
        Tail tail = new Cat();
        Animal animal = new Cat();
        Pet pet = new Cat();
        var main = new Main_();
        main.runCry(new Cat());
        main.runPlay(new Cat());

    }


    public void runCry(Animal animal) {
        animal.cry();
    }
    public void runPlay(Pet pet)
    {
        pet.play();
    }
}
