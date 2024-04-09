package Java_Day32;

public class ThreadJinExam {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        thread1.start();
        thread2.start();

        thread1.join(); // 특정 쓰레드가 끝날 때까지 not Runnable로 만들 수 있는 메서드
        System.out.println("Thread 1 finished!");

        thread2.join();
        System.out.println("Thread 2 finished!");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finished: "+Thread.currentThread().getName());
    }
}