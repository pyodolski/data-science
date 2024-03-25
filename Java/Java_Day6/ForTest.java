package ch06;

public class ForTest {
    public static void main(String[] args) {
    /*    var sum = 0;
        for(int i=0; i<=10;i++){
            sum += i;
        }
        System.out.println(sum);

        sum = 0;
        for(var i=0; ;i++) { // 초기화 식, 증감식, 조건식 모두 생략이 가능하다.
            sum += i;
            if (i >= 10)break;
            }
        System.out.println(sum);

        sum = 0;
        for(var i=0;;){
            sum += i;
            if (i >= 10)break;
            i++;
        }

        sum = 0;
        var i = 0;
        for(;;){
            sum += i;
            if (i >= 10)break;
            i++;
        }

        // while 문사용
        var sum = 0;
        int i = 0;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println(sum);

     */
        // do while문 사용
        var num = 0;
        var total = 0;

        do{
            total += num;
            num++;
        }while(num <= 10);

        System.out.println(total);
    }
}


