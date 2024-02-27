package ch03;

public class ConstantTest {
    public static void main(String[] args) {
        final int STUDENT_NUM = 10; // 따로 초기화도 가능하지만 선언과 동시에 초기화하는 걸 추천
        // 한번 초기화 한 상태에서 재할당이 불가능
        // STUDENT_NUM = 20; (X)

        int cost = 100; // 가독성이 좋게 ! 이게 곧 실력이 됨
        int totalCost = STUDENT_NUM * cost;
    }
}