package ch04;

import java.util.Scanner;

public class Qtest {
    public static void main(String[] args) {
        //다히코드
        Scanner sc = new Scanner(System.in);
        System.out.println("3자리 정수 입력: ");
        var num = sc.nextInt();
        // 936
        var num1 = num/100; //9
        var num2 = (num%100)/10; //36/10=3
        var num3 = num%10; //6
        var result = num1+num2+num3;
        System.out.println(num1+"+"+num2+"+"+num3+"+"+"="+result);

        //강사님코드
        int myNum = sc.nextInt();

        // 복합연사자를 사용해서 더 깔끔하다~?
        int h1 = myNum % 10;
        myNum /= 10;
        int h2 = myNum % 10;
        myNum /= 10;
        int h3 = myNum % 10;
        //--> 반복되고 있음을 깨닫고 반복문까지도 생각해내면 good~

        var sum = h1 + h2 + h3;
        System.out.println(sum);
    }
}