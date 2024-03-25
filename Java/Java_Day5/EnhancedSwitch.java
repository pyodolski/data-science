package ch05;

enum GENDER {
    MALE, FEMALE,
}
public class EnhancedSwitch {
    public static void main(String[] args) {

        GENDER gender = GENDER.MALE;

        String result = switch (gender) {
            // case절이 블록으로 묶이면 yield를 통해 값을 리턴해야 한다
            // 단문이면 별도 yield는 필요없다.
            case MALE -> {
                // int i = 9; // 블럭 내 변수 선언도 가능
                yield "남자입니다.";
            }
            case FEMALE -> "여자입니다.";
            default -> "중성입니다.";
        };
        System.out.println(result);

    }
}
