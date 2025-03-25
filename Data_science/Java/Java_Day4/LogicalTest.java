package ch04;

public class LogicalTest {
    public static void main(String[] args) {

        int num1 = -0;
        int i = 0;

        // 둘 다 True 일 때만 True가 된다.
        boolean value = ((num1 += 10) < 10) && ((i += 2) < 10); //&& 논리연산사를 사용할 때 주의: 앞에가 False이면 뒤에 연산은 하지 않고 그냥 넘어가버린다.
        System.out.println(value+":"+num1+":"+i);
        //null, i의 값은 얼마인가?
        // num1 = 10, i = 0, value = False

        boolean value1 = ((num1 += 10) < 10) || ((i += 2) < 10);
        //null, i의 값은 얼마인가?
        // num1 = 10, i = 2, value = True;
    }
}