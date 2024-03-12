package ch03;

import java.math.BigDecimal;

public class DoubleTest {
    public static void main(String[] args) {


        double d = 10.5; // 8 byte
        System.out.println(d);
        float f = 10.5f; // 4 byte 묵시적 형변환을 해주지 않기 때문에 'f'를 명기해주어야 한다.
        System.out.println(f);

        double d_num1 = 28.45;
        double d_num2 = 27.55;

        double a = 1.0 / 3.0;
        double b = 0.1 * 3;

        double t_num = d_num1 - d_num2;
        System.out.println(t_num);

        System.out.println(a);
        System.out.println(b);

        BigDecimal bd = new BigDecimal("28.45"); // string 으로 연산 double ( X )
        BigDecimal bd1 = new BigDecimal("27.55");

        System.out.println(bd.subtract(bd1));

        int i = (int)3.14;
        System.out.println(i);

    }
}
