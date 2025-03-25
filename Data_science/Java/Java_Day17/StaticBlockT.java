package ch19.Static;

public class StaticBlockT {

    private static int max;
    private static int[] numbers;

    static {
        // 아마존의 웹서비스 서버를 통해 추첨된 5개의 번호입니다.
        // 웹을 커넥션하고
        // 인증하고
        // 토큰생성하여 얻어진 자료
        numbers = new int[] {10, 20, 8, 19, 55}; // new int[5];

        max = numbers[0];

        for (int i =1 ; i<numbers.length;i++){
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
    }

    public static void main(String[] args) {
        int maxValue = StaticBlockT.max;
        System.out.println(maxValue);
    }
}
