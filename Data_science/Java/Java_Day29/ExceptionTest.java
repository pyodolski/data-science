package Java_Day29;

public class ExceptionTest {
    public static void main(String[] args)throws Exception {
        new ExceptionTest().divide(3,0);
//        try {
//            int result = new ExceptionTest().divide(3,0);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
    }
    public int divide(int num1, int num2){
        try {
            if (num2 == 0) throw new Exception("0으로 나눌 수 없어요!");
        }catch (Exception e){
          e.printStackTrace();
//            e.fillInStackTrace(); // 해당 예외 클래스 정보 외 다른 정보들은 쌓이지 않는 것
        }

        return num1 / num2;
    }
}
