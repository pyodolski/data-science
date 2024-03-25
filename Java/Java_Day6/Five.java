package ch06;

import java.util.Scanner;

// 사용자로부터 숫자를 입력받고 입력받은 숫자까지의 5의배수의 개수와 함을 구해보자.
public class Five {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("숫자를 입력하세요:");
        var num = scanner1.nextInt();
        var sum = 0;
        int five = num / 5; // 11 -> 2 1 + 5
        for (int i=1; i<=five; i++){
            sum += 5*i;
            i++;
        }
        System.out.println(five);
        System.out.println(sum);
    }
}
