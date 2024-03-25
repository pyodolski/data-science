package ch15;

public class Car {
    String modelName;
    String color;
    int maxSpeed;

    public Car() {
        System.out.println("Car() call!");
        modelName = "KIA";
        color = "Bule";
    }

    public Car(String modelName, String color) {
        this.modelName = modelName;
        this.color = color;
        maxSpeed = 90;
    } // 생성자 오버로딩 -> SET 함수 한번에 하는 것도 동일
}


class Main2 {
    public static void main(String[] args) {

        // 기본형 생성자 호출
        var car = new Car();
        System.out.println("main");

        // 기본 생성자는 더이상 컴파일러가 제공하지 않는다.
        var supercar = new Car("AUDI", "RED");


    }
}
