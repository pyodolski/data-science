package Java_Day28;

@FunctionalInterface
public interface IDevice {
    int device(int x, int y);
}
class AppUI_{
    public static void main(String[] args) {
        IDevice iDevice = (x,y)->(x/y);
        iDevice.device(3,5);
        System.out.println(resultMethod(iDevice));
        IDevice makf = makeFunc();
        makf.device(1,2);

    }
    public static int resultMethod(IDevice lambda) {
        return lambda.device(6,3);
    }
    public static IDevice makeFunc() {
        return (x,y)->x+y;
    }
}
