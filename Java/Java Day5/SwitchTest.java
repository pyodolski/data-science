package ch05;

import java.util.Arrays;

// 열거형 클래스
// 상수 클래스
enum DATE { // 대문자를 사용하는 것이 관례!
    MON, TUE, WED, TUR, FRI, SAT, SUN, // 마지막에 , 를 찍어주는 것이 좋음 (오류 안남)
}
/*
// (MON 구현) 복잡하기 때문에 enum class 사용
class CDATE {
    private static final CDATE C_DATE = new CDATE("MON");
    private String date;
    private CDATE(String date) {
        this.date = date;
        // 나중에 수업할 예정임 참고용
    }
}
*/
public class SwitchTest {
    public static void main(String[] args) {
 /*
        // 문자인 경우
        String today = "MON";

        switch (today) {
            case "MON":
                // break문이 없으면 break가 있을 때까지 case 구문이 실행된다.
                // System.out.println("월요일 입니다.");
                // break;
            case "TUE":
                System.out.println("병원에 가야합니다.");
                break;
            case "WED":
                System.out.println("학교에 가야합니다.");
                break;
            default:
                System.out.println("일정이 없습니다.");
          }
*/
        /*
        // 숫자인 경우
        final int MONDAY = 1;
        final int WEEKEND = 2;

        int choice = 2;
        switch (choice) {
            case MONDAY:
                System.out.println("주말입니다.");
                break;
            case WEEKEND: // break문이 없으면 break가 있을 때까지 case 구문이 실행된다.
            default:
                System.out.println("일정이 없습니다.");
        }
        */
//        DATE myDate = DATE.FRI;
//      CDATE myCDATE = CDATE.MON; -> 단독으로 선언할 때 사용 enum class X
        // . 을 사용해서 선언한 타입들을 선택할 수 있음 return type은 생성한 enum class
        // enum은 new 키워드를 사용할 수 없다.
/*
        switch (myDate) {
            case FRI: // DATE. 을 생략할 수 있다.
                System.out.println("금요일 입니다.");
                break;
            case MON:
                break;

        }
    }

 */ findDay(DATE.MON);
    } // static main func end..

    public static void findDay(DATE date) {
        System.out.println(date.name());
    //    Arrays.stream(DATE.values()).forEach(e-> System.out.println(e)); -> 추후 수업 예정
    /*    switch (date) {
            case FRI: // DATE. 을 생략할 수 있다.
                System.out.println("금요일 입니다.");
                break;
            case MON:
                break;

    */
        }
    }


