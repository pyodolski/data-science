package ch06;

import java.util.Scanner;

public class TypingTest {
    public static void main(String[] args) {

        String[] sentences = new String[3]; // 배열에 문장을 저장해서 해결
        sentences[0] = "안녕하세요!";
        sentences[1] = "대구대학교 학생 입니다.";
        sentences[2] = "우리는 야학을 하고 있는 멋진 학생입니다.";
        // 배열에 각각의 방에 문장 삽입

        System.out.println("타자 게임을 시작합니다.");
        System.out.println("문장을 보고 정확하게 입력하세요.");

        System.out.println();
        System.out.println("_______________________________");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        // for문을 사용해서 코드의 길이를 축소
        // length는 배열(Array)의 크기이며,
        // length()는 사용되는 문자열의 길이를 나타내게 된다
        for (var s = 0; s < sentences.length; s++) {
            System.out.println(sentences[s]);
            System.out.print("입력하세요: "); // 개행되지 않고 바로 입력 가능
            var starttime = System.currentTimeMillis();
            var input = sc.nextLine();
            var endtime = System.currentTimeMillis();
            var difftime = (endtime - starttime) / 1000;
            System.out.println("소요시간은 " + difftime + "초");


            var accuarcy = TypingTest.calculator(sentences[s], input);
            System.out.println("정확도는" + accuarcy + "%");
            //  System.out.println(input);
            System.out.println();
        }
    }

    public static double calculator(String sentence, String word)
    { // 정확도를 계산 해주는 함수

        int correctChar = 0;
        for (int i = 0; i < Math.min(sentence.length(), word.length()); i++)
        {
            if (sentence.charAt(i) == word.charAt(i)) correctChar++; // 들여쓰기..
        }

            var rate = ((double) correctChar / sentence.length()) * 100;
            var fomatStr = String.format("%2.2f", rate);
            return Double.parseDouble(fomatStr);
    }
}


