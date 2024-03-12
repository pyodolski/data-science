package ch05;

import java.util.Scanner;

public class DoWhileTest {
    public static void main(String[] args) {
        //do while
        Scanner sc = new Scanner(System.in);
        boolean bFlag= false;
        do{
            var input=sc.nextInt();
            if(input%10==input/10) bFlag=true;
            else System.out.println("다른 숫자 입니다.");
        }while(!bFlag);

        if(bFlag) System.out.println("같은 숫자 입니다.");
    }
}