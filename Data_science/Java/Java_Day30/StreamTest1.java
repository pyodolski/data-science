package Java_Day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamTest1 {
    public static void main(String[] args) throws IOException {
//        // case1 : 표준 입력 스트림
//        var inputStream = System.in; // 바이트 기반 스트림
//        int i;
//
//
//        while ((i =inputStream.read())!= '\n') {
//            System.out.print((char)i);
//            // 바이트 기반이기 때문에 한글을 읽어올 수 없음 한글(2 ~ 4 byte 이기 때문)
//        }
//        inputStream.close();
        // [ 2. 한글 출력 ]
//        var isr = new InputStreamReader(System.in); // 보조 스트림이기 때문에 기반 스트림을 넣어줘야함
//        // 이제 한글을 읽어올 수는 있지만 한개 씩밖에 못읽어옴
//        int i;
//        while ((i = isr.read()) != '\n'){
//            System.out.print((char)i);
//        }
//        // 문자기반 스트림으로 변경
//        isr.close();
//        /* read()를 사용하면 하나만 읽음 (바이트 기반) */
        int i;
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine()); // 버퍼에 담았기 때문에 반복문을 사용할 필요가 없음
        // 별도의 버퍼 공간에 있기 때문에 for while문을 사용할 필요가 없음
        // close를 상속받고 있기 때문에 main문을 빠져나가면 자동적으로 close 호출이 되기 때문에 따로 호출 할 필요가없음
        // 순서에 맞게 넣어야함 기반이 있어야 보조를 사용 가능
    }
}

