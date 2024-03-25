package ch18.square;
abstract class Shape {
    abstract public void draw();
    // 추상 클래스 내에는 반드시 1개 이상의 추상 메소드가 있어야한다.
    // 구현이 완전하지 않은 클래스 객체 생성을 할 수 없음 new(X)
}

public class Rectangle extends Shape { // 추상클래스 Shape 상속
    @Override // alt + insert로 생성 가능
    public void draw() {
        System.out.println("draw to rectangle");
        // Shape을 상속했기 때문에 추상클래스 내의 메소드를 구현을 해주어야함. draw
    }
}
class Triangle extends Shape{

    public void draw() {
        System.out.println("draw to triangle");
    // Override가 없어도 있는 것으로 인식은 하지만 가독성을 위해서 써주는 것이 원칙
    }
}
// upcasting의 예
class InformationUse {
    public void drawNow(Shape shape) {
        shape.draw(); // 최근에 정의 한 draw 호출 Triangle의 draw
    }
}
class Myclass {
    public void method() {

        //    var rectangle = new Rectangle();
        //    rectangle.draw();
        var triangle = new Triangle();
        var use = new InformationUse();
        use.drawNow(ShapeFactory.createShape(ShapeAngle.RECTANGLE));

    }

    public static void main(String[] args) {
        new Myclass().method();
    }
}
// factory design patten
enum ShapeAngle {
    TRIANGLE,
    RECTANGLE,
        }
class ShapeFactory {
    public static Shape createShape(ShapeAngle angle) {
        return switch(angle) {
            case TRIANGLE -> new Triangle();
            case RECTANGLE -> new Rectangle();
        };
    }
}
