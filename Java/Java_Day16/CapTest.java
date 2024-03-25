package ch18;

import ch15.Car;

public class CapTest {
    private String myHobby;
    // 메소드 은닉
    private void init() {
        System.out.println("int");
    }
    private void process() {
        System.out.println("process");
    }
    private void release() {
        System.out.println("release");
    }
    public void work() {
        init();
        process();
        release();
    }
}
class Main_ {
    public static void main(String[] args) {
        new CapTest().work();
    }
}
