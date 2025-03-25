package ch05;

import java.util.Random;
import java.util.Scanner;

public class RandomNumTest {
    public static void main(String[] args) {
        // #1. 난수 발생시키기
        Random rand = new Random();
        int target = rand.nextInt(100)+1; // +1을 안하면 0~99가 되어버리기 때문에

        // #2. 입력받기
        Scanner sc = new Scanner(System.in);

        // #3. 입력받은 수와 비교
        int loopCnt = 0;
        boolean bFlag = false;
        do{
            loopCnt++;

            int myNum = sc.nextInt();
            if(myNum==target) {
                System.out.println("정답입니다. " + loopCnt + "번 만에 맞췄습니다.");
                bFlag = true;
            }
            else if (myNum>target) System.out.println("더 낮은 숫자를 입력하세요.");
            else System.out.println("더 높은 숫자를 입력하세요.");
        }while (loopCnt<10 && bFlag==false);

    }
}
