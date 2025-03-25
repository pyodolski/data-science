package Java_Day26;

public class Animal {
    public void move() {
        System.out.println("move on");
    }
}

//class Dog extends Animal{
//    @Override
//    public void move() {
//        super.move();
//    }
//}
// 단발성으로 사용해야함
class Creatrue {
    public void mothod(Animal dog) {
        dog.move();
    }
}
class Main___{
    public static void main(String[] args) {
        // 지역 변수로 선언하여 사용
        var creature = new Creatrue();
        creature.mothod(new Animal() {
            @Override
            public void move() {
                System.out.println("gog move");
            }
        }
        );
    }
}
