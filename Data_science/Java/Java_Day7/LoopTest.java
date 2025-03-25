package ch07;

public class LoopTest {
    public static void main(String[] args) {
        // 1에서 100까지의 정수에서 3의 배수만 출력
        /*
        for(int i =1;i<=100;i++){
            if(i%3==0) System.out.println(i);
        }
        */

        for (int i = 1; i <=100; i++){
            if(i%3!=0) continue;
            // continue 구문이 실행되면 하위 코드는 실행이 되지 않는다.
            System.out.print(i+" ");
        }
        System.out.println("\n--------------------------------------------------------");
        //1에서 100까지의 총합이 100이상이면 반복문을 빠져나오도록 코딩
        int sum = 0;
        for (int i = 1;;i++){ // 어차피 합이 100이면 빠져나올거라 조건식 생략해도 괜찮겠다~
            sum+=i;
            if(sum>=100) break;
            // if (sum>=100) return; // 반환하며 빠져나옴.(프린트 지우기). 둘 다 사용가능한데 상황에 따라 다름
        }
        System.out.println(sum);
    }
}