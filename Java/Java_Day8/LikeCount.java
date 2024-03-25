package ch08;

// 좋아요를 선택 시 LikeCount객체가 생성된다고 가정
public class LikeCount {
    static int count = 0; // 공유번수로서 활용이 가능
    int myCount;


    public LikeCount() // 생성자 함수 -> 리턴타입이 없음
    {
        LikeCount.count++;
        myCount = LikeCount.count;
//        System.out.println("like count number :" + LikeCount.count);
    }

//    public static int getCount() // static에서는 static만 바로 참조 가능
//    {
//        LikeCount lc = new LikeCount();
//        return lc.count; // 객체를 생성해서 사용
//    //    return count; -> 불가능 인스턴스 변수이기 떄문에 참조 불가
//    }
}

    class AppUI { // main 함수에 pulic를 안해도 사용가능하지만 해당 패키지 내에서만 사용가능
    public static void main(String[] args) {
        // 2사람이 좋아요를 선택해서 로직대로 LikeCount 객체를 생생했다.
        var likeCnt1 = new LikeCount();
        //       System.out.println("1번 사람 : " + LikeCount.count);
        // 이런식으로 하는 것은 의미없음
        var likeCnt2 = new LikeCount();
        //       System.out.println("2번 사람 : " + LikeCount.count);
        var likeCnt3 = new LikeCount();
        //       System.out.println("3번 사람 : " + LikeCount.count);
        // 특정 시점의 count 추출
        // 객체 개념 사용
        // 인스턴스 변수를 생성해서 고유한 메모리에 저장
        System.out.println("1번 사람 : " + likeCnt1.myCount);
        System.out.println("2번 사람 : " + likeCnt2.myCount);
        System.out.println("3번 사람 : " + likeCnt3.myCount);

    }
}

