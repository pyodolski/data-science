package ch03;

public class Typetest {
    // 클래스 속성으로 사용될 수 없다.
    //var kkk = 10; 클래스에선 X , 반드시 함수 안에서만 선언해야함
    public static void main(String[] args) {
        // 지역변수(local variable) : 함수블럭에서 선언된 변수
        int i = 10;
        var age = 10;
        var dAge = 10.5;

        var s = new String ("kim"); // 이것도 가능
        // 한번 타입추론이 된 변수를 다른 타입으로 재할당 할 수 없다.
        //age = "kim";
    }
}