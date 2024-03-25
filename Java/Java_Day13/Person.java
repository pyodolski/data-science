package ch13;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Objects;
public class Person {
    int age;
    String name;

    public void setAge(int age) {
        this.age = age;
    }
    public void setAge(int age, int padding) {
        if (age > 20)
            padding = 20;
        else
            padding = 10;

        age += padding;
        // Overloading example
    }
    // 자바 컴파일러에게 상위 클래스의 메소드를 오버라이딩 한다고 알려주는 일종의 메모
    @Override // 가독성을 위해서 붙여주는게 좋음
    public String toString() {
        return age + ":" + name;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            return false;
            // 이름이 같으면 같은 사람이라고 가정
        var person = (Person) obj;

        return Objects.equals(this.name,person.name);
        // 논리적으로는 서로 다른 객체 지만 if문을 사용해서 같은 것으로 판단
    }
}

class AppMain {
    public static void main(String[] args) {
//        var person = new Person();
//
//        person.age = 90;
//        person.name = "david";
//        System.out.println(person);
//        String s1 = "hello";
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
        var person = new Person();
        person.age = 90;
        person.name = "david";
        System.out.println("hashcode");
        System.out.println(person.hashCode());

        var person1 = new Person();
        person1.age = 90;
        person1.name = "david";
        System.out.println(person1.hashCode());

        System.out.println("real address");
        System.out.println(System.identityHashCode(person));
        System.out.println(System.identityHashCode(person1));

        System.out.println(person1 == person);
        System.out.println(person.equals(person1));
    }
}


