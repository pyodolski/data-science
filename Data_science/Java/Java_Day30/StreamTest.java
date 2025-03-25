package Java_Day30;

import Java_Day29.FileTest;

import java.io.*;

public class StreamTest {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("b.txt"); // 기반
        InputStreamReader isr = new InputStreamReader(fis);// 보조
        // Byte 기반 스트림에서 문자를 입력할 수 있는 스트림으로 변경
        BufferedReader br = new BufferedReader(isr); // 보조
        // 버퍼기반 스트림으로 변경.
        // 기반 + 보조 + 보조
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("b.txt")));
        // 합성과 동일한 기능을 가짐.


    }
}
