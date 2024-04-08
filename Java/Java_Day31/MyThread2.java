package Java_Day31;

public class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "start");
        for (int i = 1; i < 10; i++) System.out.print(i + " ");
        System.out.println();
    }
}

class ThreadTest2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");

        new Thread(()->{
            System.out.println(Thread.currentThread() + "start");
            for (int i = 1; i < 10; i++) System.out.print(i + " ");
            System.out.println();
        }).start();

        System.out.println(Thread.currentThread() + " end");
        // CPU 점유를 할당받는 것은 main이 설정할 수 없기 때문에 실행마다 결과 값이 달라진다.
    }
}