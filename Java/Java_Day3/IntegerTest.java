package ch03;

public class IntegerTest {
    public static void main(String[] args) {
        byte by = 127; // -126 ~ 127 이기 때문에 출력 가능하다.
        System.out.println(by);

        int iby = by; // small -> big size 묵시적 형변환이 이루어진다.
        System.out.println(iby);

        // by = iby; big -> small size ( X ) -> 명시적인 형변환을 해주어야 한다.
        by = (byte)iby;
        System.out.println(by);

        int i2 = 66666;
        by = (byte)i2;
        System.out.println(by);

        short sby = 89;
        i2 = sby;
        // sby = i2; -> 불가능
        sby = (short)i2;
        System.out.println(i2);

        long lby = 8888888888L;
        // long의 상수 값을 넣을 때는 L,l을 뒤에 명기해야 한다.
        lby = 45000;
    }
}
