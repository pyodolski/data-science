package ch05;

public class WhileTest {
    public static void main(String[] args) {
        /*int i =1 ;
        while (i<=10){
            System.out.println(i+"people");
            i++;
        }*/

        // Q1. 1부터 10까지 총 합을 출력하는 while문 작성하기
        int i = 1;
        int sum = 0;
        while (i<=10){
            sum += i;
            System.out.println("i : "+ i+", sum : "+sum);
            i++;
        }

        // Q2. 1~10까지의 4의 배수의 합을 출력
/*        int i = 1;
        int sum = 0;
        while (i<=10){
            if (i%4==0) sum += i;
            System.out.println("i : "+ i+", sum : "+sum);
            i++;
        }
*/
        // Q.3 이전 두개의 숫자를 더해 다음 숫자를 만들어가는 프로그램을 작성
        // ex) 0, 1, 1, 2, 3, 5, 8, 13, 21, ..
        // 총 길이를 10개로 하고 만들어보자.
        int n = 10;
        int first = 0;
        int second = 1;

        int count = 0;

        while (n > count){
            System.out.println(first+"");
            var next = first+second;
            first=second;
            second=next;
            count ++;
        }

    }
}