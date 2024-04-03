package Java_Day28;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {  // ---------- ( 1 )
            @Override // @FunctionalInterface
            public void run() { // 익명클래스 사용

            }
        });
    Thread thread1 = new Thread(()->{ // ------------------------- ( 2 )
        int i = 9; // 람다식 사용
        System.out.println("eee");

    });
    thread1.start();

    }
}
