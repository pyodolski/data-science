package Java_Day3;

public class Typetest {
    public static void main(String[] args) {
        int intVal = 10;
        double doubleVal = intVal; // 묵시적 형변환
        System.out.println(doubleVal);

        double doubleVal2 = 10.99;
        int intVal2 = (int)doubleVal2; // 명시적 형변환
        System.out.println(intVal2);

        int bigNum = 1000000;
        byte smallNum = (byte)bigNum; // 오버플로우 발생
        System.out.println(smallNum);

        double dNum = 1.2;
        float fNum = 0.9F;

        // 큰타입과 작은타입의 연산시 큰타입으로 흡수
        float fSum = (float)(dNum + fNum);
    }
}
