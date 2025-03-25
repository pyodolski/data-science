package My_project.Concert;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class Concert implements Runnable{
    private  int ticket= 10;

    @Override
    public void run() {

        for(int i = 1; i <= 10; i++ ){
            try{
                Thread.sleep(1000);
                getTicket();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    public synchronized void getTicket() throws InterruptedException {
        ticket--;
        if (ticket <= 0) {
            System.out.println("[" + Thread.currentThread().getName()+"]");
            System.out.println("sold out!");
            throw new InterruptedException("sold out ticket!");
        }
        System.out.println("[" + Thread.currentThread().getName()+"]");
        System.out.println("ticket = [" + ticket+ "]");
    }
}
class AppUI {
    public static void main(String[] args) {
        Concert concert = new Concert();
        new Thread(concert, "C1").start();
        new Thread(concert, "C2").start();
        new Thread(concert, "C3").start();
        new Thread(concert, "C4").start();
        new Thread(concert, "C5").start();
        new Thread(concert, "C6").start();


    }

}

