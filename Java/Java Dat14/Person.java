package ch15;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // if (this.name.equals(((Person)obj).name)
        return  Objects.equals(this.name,((Person)obj).name); // 이렇게 바꿀 수 있음!
    }

    @Override
    public String toString() { // println은 toString을 부모객체로 가짐. !
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name); // kavin 이라는 똑같은 상수이름, 상수풀. : 똑같은 해시코드를 가짐
    }
}
class Main{
    public static void main(String[] args) {
        // 이름이 같으면 같은 객체라고 가정
        var p1 = new Person();
        p1.setName("kavin");
        var p2 = new Person();
        p2.setName("kavin");

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2)); // true를 반환하지만 아직 해시코드는 다름, JVM은 다른 객체로 인식하고 있음

        // Set : 객체만 저장가능한 자바의 자료구조
        // 중복된 객체를 저장할 수 없다. 즉, key가 동일하면 저장이 안됨.
        Set<Person> personSet = new HashSet<>(); // Set에 들어갈 객체 타입 : Person, HashSet<>(); : Person 생략 가능! 앞에 Set<Person>에 명기했기 때문에 컴파일러가 알아서 추가해줌
        // hashset 객체 추가. : add
        personSet.add(p1);
        personSet.add(p2);

        for(var p : personSet){
            System.out.println(p);
        }
        // 결과값: personSet에 kavin이 두개 다 들어갔다. : 두 개를 다른 객체로 인식했다는 소리. -> 해시코드르 오버라이딩 하면 됨

    }
}
