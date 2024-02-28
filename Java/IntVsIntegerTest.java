package ch01;

public class IntVsIntegerTest {
    public static void main(String[] args){
        int i = 10;
        //타입과 변수를 아직 안배웠지만~~

        Integer wi= new Integer(20); // Integer 클래스에 값 할당을 위해 new 를 사용해서 객체 생성 (동적할당) : 메모리에 올라감
        // int를 wrapping한 클래스
        System.out.println(i);
        System.out.println(wi); //객체를 넣었는데 20을 찍어주네~? 자동으로 박스 안에 있는 값을 끄집어내나 보다~

        Integer autoBoxed = i;
        int unBoxed = wi;

        int sum = autoBoxed+unBoxed;

        System.out.println(sum); // int Integer int 관련된 클래스, Integer 클래스에 값을 넣든 int 에 값을 넣든 똑같이 호환이 되는 내장함수 자동으로 박싱과 언박싱이 이루어진다.

        long l = 9;
        Long lw = new Long(9); // 똑같이 박싱과 언박싱이 자동으로 이루어짐
        // 클래스로 제공되는 이유 자바의 자료구조를 사용하려면 기본적으로 객체여야 사용할 수 있음
        // ex arraylist 에 기본형 타입이 들어갈 수 없고, 클래스만 들어갈 수 있음 이렇게 기본형타입을 다 클래스로 만들어 놓음
        // 자바의 모든 자료구조들은 모두 다 클래스로 동작하기 때문에 !!!!
        // 박싱과 언박싱 : int <-> Integer 이런식으로 자동으로 됨 => Integer 을 사용해서 연산이 가능해진다.

        IntVsIntegerTest.typeChecker(i);

        }

    public static void typeChecker(Object o){
        System.out.println("type checker : " +o.getClass().getName()); // 자바에서 타입 체크하는 법
    }
}
