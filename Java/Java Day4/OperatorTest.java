package ch04;

public class OperatorTest {
    public static void main(String[] args) {

        // 단항 연산자
        /*
         ! : not의 의미
         */
        System.out.println(true);

        /*
        증감 연산자
         */
        int i = 0;
        int j = i++;  // 후위
        System.out.println(i);
        System.out.println(j);

        int k = 0;
        int g = ++k; // 전위
        // k = k + 1 // ++k
        System.out.println(g);
        System.out.println(k);

        /*
        증감, 감소 연산자 ex)
         */

        int num1 = 20;
        int result = num1++ * 3;
        System.out.println(num1);
        System.out.println(result);

        int num2 = 20;
        int result2 = ++num2 *3;
        System.out.println(num2);
        System.out.println(result2);

        int gameScore = 150;
        int lastScore = ++gameScore;

        lastScore = gameScore++;
        System.out.println(lastScore);
        System.out.println(gameScore);

    }
}
