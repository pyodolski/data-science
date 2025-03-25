package My_project.ThreadTest;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread task1 = new Thread(new MyRunnable(), "Task 1" );
        Thread task2 = new Thread(new MyRunnable(), "Task 2" );
        Thread task3 = new Thread(new MyRunnable(), "Task 3" );

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        System.out.println("Task 1 finished!");

        task2.join();
        System.out.println("Task 2 finished!");

        task3.join();
        System.out.println("Task 3 finished!");

    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    try {
        Thread.sleep(2000);

    }catch (Exception e){
        e.printStackTrace();
    }
        System.out.println("finished: " + Thread.currentThread().getName());

    }
}