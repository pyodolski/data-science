package Java_Day32;

public class Worker implements Runnable {

    private String name;
    private Thread jointhread;

    public Worker(String name, Thread jointhread) {
        this.name = name;
        this.jointhread = jointhread;
    }

    public void run() {
        if (jointhread != null) {
            try {
                jointhread.join();
                System.out.println(name + "wait for " + jointhread.getName() + "to complete");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name + "start running.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + "finished...");
    }
}

class MyThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker("Task 1",null));
        Thread t2 = new Thread(new Worker("Task 2", t1));
        Thread t3 = new Thread(new Worker("Task 3", t2));
        t1.start(); // t1이 끝나고 t2가 실행되야 함
        t2.start();
        t3.start();
    }
}
