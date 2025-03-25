package Java_Day31;

public class MyThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "start");
        for (int i = 1; i < 10; i++) System.out.print(i + " ");
        System.out.println();
    }
}

class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");

        var myThread = new MyThread1();
        Thread thread = new Thread(myThread); // Runable의 객체를 Thread 내에 넣어줘야 함
        thread.start(); // Runable 상태로 진입
        var myThread2 = new MyThread1();
        Thread thread2 = new Thread(myThread2); // Runable의 객체를 Thread 내에 넣어줘야 함
        thread2.start(); // Runable 상태로 진입

        System.out.println(Thread.currentThread() + " end");
        // CPU 점유를 할당받는 것은 main이 설정할 수 없기 때문에 실행마다 결과 값이 달라진다.
    }
}