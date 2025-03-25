package Java_Day23;

// abstract 키워드 사용
public abstract class Pet {

    // 적어도 한개 이상의 추상 클래스를 가져야 하고. new Pet()은 불가능.
    // 자식 클래스는 추상 메소드를 전부 구현해줘야 함.
    abstract public void walk(); // 추상 메소드 구현체가 없어도 컴파일 오류가 뜨지 않는다.
    abstract public void eat();
    protected int health; // 추상화 변수는 없지만 결국 부모 클래스이기 때문에 그냥 이렇게 가눙
    protected Pet(){
        health=90;
    }
    public int getHealth(){
        return health;
    }

    public void run(){
        System.out.println("run...");
    }

    // Override 금지를 위해 final
    // Template Method
    public final void go(){ // final 붙인 이유:
        walk();
        eat();
        run();
    }
}

class Cat extends Pet{

    // 구현체
    @Override
    public void walk() {
        System.out.println("Cat walk()");
    }

    @Override
    public void eat() {
        System.out.println("Cat eat()");
    }
}

abstract class Dog extends Pet{ // eat 구현하기 싫으면 얘도 추상클래스로 바꿔주면 됨
    @Override
    public void walk() {
        System.out.println("Dog walk()");
    }
}

class BullDog extends Dog{
    @Override
    public void eat() { // 이것만 구현해줘도 됨
        System.out.println("BullDog eat()");
    }
}

class UI{
    public static void main(String[] args) {
        // new Pet() 불가능
        Pet bullDog=new BullDog();
        var cat= new Cat();

        // 당연히 부모의 메소드 다 호출 가능
        bullDog.walk();
        bullDog.eat();
        bullDog.run();
        System.out.println(bullDog.health);

        cat.walk();
        cat.eat();
    }
}