package Java_Day28;

@FunctionalInterface // 함수형 인터페이스: 람다식으로 표현 가능 (추상화 메소드가 하나)
public interface MyFunction {
    void print(String str);  // 추상화 메소드
    //void abs(String str); // @FunctionalInterface 는 추상화 메소드 두개가 올 수 없다.
    public default void tt(){    }  // 추상화 메소드 X
    private void tt2(){    }  // 추상화 메소드 X
}

class Main{
    public static void main(String[] args) {
        MyFunction myFunction = (str) -> { // 구현체
            System.out.println("kkk");
        };

        MyFunction myFunction1 = System.out::println; // 구현체
        myFunction1.print("hello");
    }
}


