package Java_Day26;

public class StringUtil {
    public String makeString() {
        StringBuilder builder = new StringBuilder();
        builder.append("kim\n");
        builder.append("park");
        return builder.toString();
    }
    public static void main(String[] args) {
//        int i = 10;

        String str1 = "kim";
        String str2 = "park";
        System.out.println(str1.hashCode());
        // 저장되있는 저장소의 메모리
        // 값이 다르다는 것은 다른 메모리에 존재
        str1 += str2; // str1 = str1 + str2
        System.out.println(str1.hashCode());
        // 값이 다름 주소가 변경되었지만 str1이 가르키고 있는 처음 주소는 살아있다
        // 조합을 할 때마다 누적이 되는 것이지 덮어쓰거나 삭제되는 것은 아니다.
        // 문자열을 조합할 때 String 클래스를 활용해서 + 연산자로 하면
        // 메모리를 낭비가 될 수 있다. (계속 누적되고 있기 때문)
        System.out.println(str1);
        // 단일 스레드 환경에서 사용하면 좋다.
        StringBuilder stringBuilder = new StringBuilder(); // 객체 클래스
        stringBuilder.append(str1);
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append(" : ");
        stringBuilder.append(str2);
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.hashCode());

        StringUtil stringUtil = new StringUtil();
        stringUtil.makeString();
        // 조합을 하고 난 이후에도 해시코드 값이 변하지 않은 것을 알 수 있음
        // 메모리 낭비 방지
        // 멀티 스레드 환경에서 사용
        StringBuffer stringBuffer = new StringBuffer();
        // synchronized -> 속도가 느리기 때문에 단일 스레드에서는 사용할 필요가 없음
        stringBuffer.append("kim");
        stringBuffer.toString();

        // 결론 : 문자열을 조합할 떄 사용하기 유용한 클래스
        // 사용하는 스레드의 환경에 따라 적절하게 사용 (단일 Vs 멀티)
    }

}

