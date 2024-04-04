package Java_Day29;

public class InvalidOperateException extends Exception{ // 사용자 예외 생성 예제
    private int name;
    // 자신만의 logic은 들어갈 수 있음.
    private  int code;
    public InvalidOperateException(String msg, int code) {
        super(msg);
        this.code = code;
    }
    public void processCode() {
        System.out.println(code);
    }
}
class OrderProc {
    public void precessOrder(int num) throws InvalidOperateException {
        if (num <= 0) {
            var ex = new InvalidOperateException("0보다 같거나 작은 주문 접수,문제발생", 99);
            ex.processCode();
            throw new InvalidOperateException("0이거나 작은 주문 접수. 문제 발생", 99);

        }
    }
}

class Main__ {
    public static void main(String[] args) {
        var orderProc = new OrderProc();
        try {
            orderProc.precessOrder(-1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}