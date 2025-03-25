package My_project.Pet;

public abstract class Pet {
    protected int age;
    protected Pet(int age) {
        this.age = age;
    }
    abstract protected void walk(); // 상속 받는 자식에서 구현
    protected void eat(){
        System.out.println("pet eat...");
    }
    protected void jump(){
        System.out.println("pet jump...");
    }
    protected final void wakeUp() { // 상속 x
        walk();
        eat();
        jump();
    }
}
class Dog extends Pet {
    private String nickName;
    private Fly fly;
    public Dog(int age, Fly fly) {
        super(age);
        this.fly = fly;
    }
    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public Fly getFly() {
        return fly;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    protected void walk() { // 추상메소드 받아와야함 여기서 구현 해야함
        System.out.println("왈왈");
    }
}
class Cat extends  Pet {

    private String nickName;
    public Cat(int age) {
        super(age);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    protected void walk() {
        System.out.println("야옹");
    }
}
class Snake extends FlyA {
    public Snake(int age) {
        super(age);
    }

    @Override
    protected void walk() {
        System.out.println("기어갑니다...");
    }
}
class Fly {
    private Cat cat;

    public Fly() {

    }
    public Fly(Cat cat) {
        this.cat = cat;
    }

    public void fly() {
        System.out.println("날아갑니다");
    }
}
abstract class FlyA extends Pet {
    public FlyA(int age) {
        super(age);
    }
    protected void fly() {
        System.out.println("날아갑니당");
    }
}

class main {
    public static void main(String[] args) {
        var dog = new Dog(2, new Fly());
        var cat = new Fly(new Cat(2));
        cat.fly();
        dog.getFly().fly();
        var snake = new Snake(2);
        snake.fly(); // 원래의 부모를 상속받는 어댑터를 만들어서 자식이 그것을 상속받도록하는것이 가장 깔꼼
    }
}