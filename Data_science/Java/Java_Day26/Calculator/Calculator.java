package Java_Day26.Calculator;

interface Operate {
    int operate(int a, int b);
}

public class Calculator {
    private final int a;
    private final int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculate(Operate operate) {
        return operate.operate(a, b);
    }
}


class AppUI {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        Calculator calculator = new Calculator(num1, num2);
        int result = calculator.calculate(new Operate() {
            @Override
            public int operate(int a, int b) {
                return a + b;
                // 인터페이스를 사용해서 operate 기능을 main에서 바꿀 수 있음.
                // 런타임 때 생성을 하기 때문에 메모리적으로 이득을 볼 수 있음.
            }
        });
        System.out.println(result);
    }
}
