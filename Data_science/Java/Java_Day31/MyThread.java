package Java_Day31;

// case1 : Thread 상속

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override

    public void run() {
        System.out.println(Thread.currentThread() + "start");
        for (int i = 1; i < 10; i++) System.out.print(i + " ");
        System.out.println();
    }
}

class ThreadTest1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "start");
        var myThread1 = new  MyThread("Thread1");
        myThread1.start();

        var myThread2 = new MyThread("Thread2");
        myThread2.start();
        System.out.println(Thread.currentThread() + " end");
        // CPU 점유를 할당받는 것은 main이 설정할 수 없기 때문에 실행마다 결과 값이 달라진다.
    }
}
