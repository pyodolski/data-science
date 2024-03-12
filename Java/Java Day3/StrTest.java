package ch03;

import java.awt.*;

public class StrTest {
    public static void main(String[] args) {

        // 리터럴을 활용
        String a = "hello";
        System.out.println(a); //hello
        System.out.println(a.hashCode());

        a = a+"world";
        System.out.println(a); //hello world
        System.out.println(a.hashCode());
        a="hello";
        String b="hello";

        // 실제 저장된 메모리의 주소
        System.out.println("System.identityHashCode(a): "+System.identityHashCode(a)); // hashcode 와 다름. 조금 더 정확한 주소
        System.out.println("System.identityHashCode(b): "+System.identityHashCode(b));

        //객체 내부 상태에 기반해서 생성된 주소
        System.out.println("a.hashcode() : "+a.hashCode());
        System.out.println("b.hashcode() : "+b.hashCode());

        // new() 사용 -> heap memory 에 저장
        //런타임 시에 메모리를 동적으로 올림.(동적 메모리)
        // str 은 stack 에 (블록이 닫히면 사라짐) , new String("hello")는 가비지 컬렉터에 의해 사라짐
        String str = new String("hello"); // new 를 사용하는 이유: 자바에서 객체를 메모리에 올리기 위해
        String str2 = new String("hello");

        // 똑같은 hello 인데 주소를 다르게 가짐. => 리터럴을 활용해 선언하는게 더 메모리에 효율적이다!
        System.out.println("System.identityHashCode(str): "+System.identityHashCode(str));
        System.out.println("System.identityHashCode(str2): "+System.identityHashCode(str2));
        System.out.println("str.hashcode() : "+str.hashCode());
        System.out.println("str2.hashcode() : "+str2.hashCode()); // 실제 메모리와 해시코드의 주소가 다르다?!

        // ==연산 : 가리키는 주소로 연산을 진행하기 때문에 not equal이 나옴
        if (str == str2){
            System.out.println("str, str2 : equal");
        }else{System.out.println("str, str2 : not equal");}
        //equals 연산: value로 연산을 진행하기 때문에 equal이 나옴 -> 해시코드
        if (str.equals(str2)){
            System.out.println("str, str2 : equal");
        }else{System.out.println("str, str2 : not equal");}
    }
}
