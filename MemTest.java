package ch02;

public class MemTest {
    static int s = 10;
    public static void main(String[] args){
        int a = 5;
        int b = 10;

        Counter counter = new Counter();

    }
    public static void twice(){

    }
}

class Counter{ // 자바 파일 안에 클래스가 많을 수 있지만 퍼블릭은 딱 하나만 있어야 함!!
    int state = 50;
    int count = 20;

    public int get(){
        return state+count;
    }
}