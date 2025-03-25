package My_project.Horse;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Horse implements Runnable{

    private String name;
    private int distance;

    public Horse(String name){
        this.name=name;
        distance =0;
    }

    @Override
    public void run() {
        /*for(int i=0; i<10; i++){
            distance +=10;
        }
        System.out.println(Thread.currentThread().getName()+" : "+ distance +"m"+" 통과! ");
        */
        while(distance!=100){
            distance+=10;
            System.out.println(Thread.currentThread().getName()+" : "+ distance +"m");
            try {
                Thread.sleep(new Random().nextInt(1000) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+" 통과! ");
    }
}

class AppUI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        ExecutorService service = Executors.newFixedThreadPool(num);

        for(int i =0; i<num; i++){
           service.execute(new Horse("[" + (i+1)+ " horse ]" ));

        }
        service.shutdown();
    }
}

