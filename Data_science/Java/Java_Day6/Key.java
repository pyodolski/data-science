package ch06;

import java.util.Scanner;

/*
2. 자연습 앱을 만들어보자
    1. 3개의 문장을 배열에 저장하고 각 문장을 보여주면 사용자가 해당 문장을
    입력하고 각 문장별 정확도와 타자시간을 출력하자
    2. 정확도 = 맞은 글자 수 / 총 글자 수 * 100
 */

public class Key {
    public static void main(String[] args) {
        long bt1 = System.currentTimeMillis();
        String str1 = "동해물과 백두산이 마르고 닳도록 ";
        System.out.println("첫 번째 문장: " + str1);

        Scanner sc1 = new Scanner(System.in);
        System.out.println("첫 번째 문장을 입력하세요: ");
        String str11 = sc1.nextLine(); // 문자열 전체를 받아올 때
        long at1 = System.currentTimeMillis();
        long dt1 = at1 - bt1;
        long l1 = str1.length();
        double s1 = (double)l1 / (dt1 / 60000.0);
        int num1 = 0;

        int minLength1 = Math.min(str1.length(), str11.length()); // 길이 최솟값으로 두어야 원본보다 크게 해도 올바른 결과 출력
        for (int i = 0; i < minLength1; i++) {
            if (str1.charAt(i) != str11.charAt(i)) {
                num1++;
            }
        }
        double a1 = ((double) (str1.length() - num1) / str1.length()) * 100;
        System.out.println("정확도: " + a1 + "%");
        System.out.println("실행시간(s) :" + (double)dt1/1000 + "s");
        System.out.println( (int)s1 +"타");

        long bt2 = System.currentTimeMillis();
        String str2 = "하느님이 보우하사 우리나라 만세";
        System.out.println("두 번째 문장: " + str2);

        Scanner sc2 = new Scanner(System.in);
        System.out.println("두 번째 문장을 입력하세요: ");
        String str22 = sc2.nextLine(); // 문자열 전체를 받아올 때
        long at2 = System.currentTimeMillis();
        long dt2 = at2 - bt2;
        long l2 = str2.length();
        double s2 = (double)l2 / (dt2 / 60000.0);
        int num2 = 0;

        int minLength2 = Math.min(str2.length(), str22.length()); // 길이 최솟값으로 두어야 원본보다 크게 해도 올바른 결과 출력
        for (int i = 0; i < minLength2; i++) {
            if (str2.charAt(i) != str22.charAt(i)) {
                num2++;
            }
        }
        double a2 = ((double) (str2.length() - num2) / str2.length()) * 100;
        System.out.println("정확도: " + a2 + "%");
        System.out.println("실행시간(s) :" + (double)dt2/1000 + "s");
        System.out.println( (int)s2 +"타");

        long bt3 = System.currentTimeMillis();
        String str3 = "무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세";
        System.out.println("세 번째 문장: " + str3);

        Scanner sc3 = new Scanner(System.in);
        System.out.println("세 번째 문장을 입력하세요: ");
        String str33 = sc3.nextLine(); // 문자열 전체를 받아올 때
        long at3 = System.currentTimeMillis();
        long dt3 = at3 - bt3;
        long l3 = str3.length();
        double s3 = (double)l3 / (dt3 / 60000.0);
        int num3 = 0;

        int minLength3 = Math.min(str3.length(), str33.length()); // 길이 최솟값으로 두어야 원본보다 크게 해도 올바른 결과 출력
        for (int i = 0; i < minLength3; i++) {
            if (str3.charAt(i) != str33.charAt(i)) {
                num3++;
            }
        }
        double a3 = ((double) (str3.length() - num2) / str33.length()) * 100;
        System.out.println("정확도: " + a3 + "%");
        System.out.println("실행시간(s) :" + (double)dt3/1000 + "s");
        System.out.println( (int)s3 +"타");
    }
}

