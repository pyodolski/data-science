package ch01;

public class NumberConvert {
    public static void main(String[] args){
        int i = 10;

        System.out.println(Integer.toBinaryString(i)); // System,Integer... : JDK에서 제공하는 빌트인 클래스 이런 빌트인 클래스를 잘 이용해서 원하는 시스템을 만드는게 개발자가 할 일
        System.out.println(Integer.toOctalString(i));
        System.out.println(Integer.toHexString(i));

        System.out.println("==============================");

        // 문자열들을 다시 정수로 컨벌트
        System.out.println(Integer.parseInt(Integer.toBinaryString(i),2)); // 2 진수로 인트형으로 변환: Integer.parseInt(변환하고자 하는 문자열, 원하는 진법)
        System.out.println(Integer.parseInt(Integer.toOctalString(i),8)); // 8 진수로
        System.out.println(Integer.parseInt(Integer.toOctalString(i))); // 10 진수로 명시 안해주면
        System.out.println(Integer.parseInt(Integer.toHexString(i),16)); // 16 진수로

        // 내장 클래스에 Ctrl+Click -> 함수 구경함
        // 이 클래스도 NumberConvert.main() 이런 식으로 호출되겠네~ 인스턴스, 즉 메모리에 올리지 않더라도 바로 사용할 수 있게 함
    }
}
