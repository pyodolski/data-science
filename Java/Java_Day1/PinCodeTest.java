package ch01;

public class PinCodeTest {
    public static void main(String[] args)
    {
        int flagRead = 0b0001;
        int flagWrite = 0b0010;

        // | : or bit 연산
        // 둘 중에 하나라도 1이면 1이다.

        int permission = flagRead | flagWrite; // 0011
        System.out.println(permission);
        System.out.println((Integer.toBinaryString(permission)));

        int pin1 = 0b0001;
        int pin2 = 0b0010;

        int powerOn = 0b0100;
        int triggerOn = 0b1000;

        // 특정 핀 상태가 2개를 받아서 or 연산 하고
        // 파워 상태를 and 연산을 통해 체크하자.

        int gpioState = pin1 | pin2;
        System.out.println("GPIO STATE =" + gpioState);
        // &비트 and 연산 (둘다 1일때만 1이된다.)
        boolean isPowerOn = (gpioState & powerOn) != 0;
    }
}