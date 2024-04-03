package Java_Day28;
@FunctionalInterface
// 인터페이스 인데 추상화 메서드가 한개있는 것을 함수형 인터페이스라고 지칭한다.
interface IAd<T> {
    T add(T x, T y);
} // 잘 사용하지는 않음.

class AppUI {
    public static void main(String[] args) {
        IAd<Integer> o = (x,y) -> x+y; // 구현체, 람다식
        System.out.println(o.add(1,1));
    }
}