package ch04;

import java.util.Scanner;

public class LogicalOperatorTest {
    public static void main(String[] args) {

        // 입력장치 : 값들을 가져오기 위한 유틸 클래스
        Scanner scanner = new Scanner(System.in);
        // System.out.println("정수 하나를 입력하세요");

        // int num = scanner.nextInt(); // 입력받은 정수를 저장
        // 논리 연산자
        // && : 양쪽의 항이 True일때만 Ture가 된다.

        // boolean checkFlag = !(num >= 1 && num <= 100);
        // 대문자인지 확인하는 로직
        System.out.println("문자열을 입력하세요");
        String str = scanner.next();
        char c = str.charAt(0);
        boolean checkFlag =  (c >= 'A' && c <= 'Z');
        System.out.println(checkFlag);

        // 내가 입력한 문자가 알파벳인지 체크하는 로직
        System.out.println("문자열을 입력하세요");
        String str1 = scanner.next();
        char c1 = str.charAt(0);
        boolean checkFlag1 =  ((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z') );
        System.out.println(checkFlag);
    }
}
