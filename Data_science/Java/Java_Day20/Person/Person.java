package Day_20.Person;

public class Person {
    public Person() {
        System.out.println("I am Person");
    }

    protected void eat() {
        System.out.println("person eat");
    }
    protected void learn() {
        System.out.println("person lean");
    }
    protected void walk() {
        System.out.println("person walk");
    }
}
// Person의 것을 쓰는 것에는 상속을 사용하는 것이 맞고,
// 각 job마다는 해당되는 행동 (기능)을 추가하는 것이기 때문에 합성을 사용하는 것이 맞음
class Programmer {
    private Person person;
    public Programmer(Person person) {
        this.person = person; // 참조변수를 생성자에 만들어야함.
        System.out.println("I am Programmer");
    }

    public Person getPerson() {
        return person;
    }

    public void coding() {
        System.out.println("programmer coding...");
    }

}

class Main_ {
    public static void main(String[] args) {
        new Programmer(new Person()).getPerson().walk();
    }
}
// 출력 순서는 안쪽뷰터
