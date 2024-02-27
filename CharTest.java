package ch03;

public class CharTest {
    public static void main(String[] args) {
        char ch1 = 'A';
        System.out.println((char) (ch1 + 1));
        System.out.println((int) ch1);

        int ch2 = 68;
        System.out.println((char) ch2);

        char ch3 = '곱';
        System.out.println((int)ch3);
        System.out.println(Integer.toHexString((int)(ch3)));

        char ch4 = '\uacf1';
        System.out.println(ch4);

        String sStr = "Hello";
        // class지만 기본형처럼 사용 가능하다. ( String에 한함.)
        System.out.println(sStr);
    }
}
