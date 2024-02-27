package ch02;

public class VariableTest {
    public static void main(String[] args) {

        //기본형 타입들은 그 변수들이 가리키는 곳에 값이 들어있다.
        int age;
        age = 20;

        int age2 = age;

        System.out.println(System.identityHashCode((age)));
        System.out.println(System.identityHashCode(age2));

        int b,c;
        b = 3;
        c = 1;

        int f = 10, g = 20; // 선언과 동시에 초기화 가능
        // a = 10, b = 20; -> 불가

        int y;
        // System.out.println(y); -> 값을 초기화 하지 않았는데 사용하면 사망
    }
}
