package Java_Day23;
public class Animal {
    protected void move(){
        System.out.println("Animal Move()");
    }
}

class Human extends Animal{ // 합성은 그냥 기능. 원래의 기능에서 추가하고 끝. // 하지만 상속은 본인만의 메소드를 가질 수 있고 부모의 메소드를 오버라이드도 할 수 있고 장점이 많음

    public int age; // age가 어디에서 안되고 되는지 확인해보면 좋을 듯 AppUI의 move()에서는 안됨. Animal을 받으니까
    @Override
    public void move() { // 다른 클래스에서도 사용 가능하게 public 으로!
        System.out.println("Human Move()");
    }
}

class AppUI{
    public static void main(String[] args) {
        Human human = new Human();
        Animal lion = new Lion();
        // upcasting : Animal 먼저 메모리에 올라가고 그 다음에 Human이 올라감 (Human은 Animal의 메모리도 알고 있음 부모라서!)-> 묵시적 형변환
        new AppUI().move(human); // main은 static 이기 때문에 AppUI랑은 아무런 관계가 없음 그러니까 이 클래스 안의 메소드를 사용하려면 new AppUI() 로 객체를 생성해서 메소드에 접근해야 한다.
        // 개발적으로 말해보자면 -> 인스턴스 기준의 메소드가 실행된다.

        Lion liion = (Lion)(new Animal()); // new animal에는 lion의 메모리가 없어서 캐스팅이 안된다.
        System.out.println("================");
        var ui = new AppUI();
        ui.move(human);
        ui.move(liion);

    }
    // 다형성
    public void move(Animal animal){

        animal.move();
        // ((Lion)animal).hunting(); -> 강제적 형변환 안됨
        // 변경
        if(animal instanceof Lion){
            ((Lion)animal).hunting();
        }
    }
}

class Lion extends Animal{
    @Override
    protected void move() {
        System.out.println("Lion Move()");
    }

    public void hunting(){
        System.out.println("Lion hunting()");
    }
}