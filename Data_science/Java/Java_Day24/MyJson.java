package Java_Day24;

public interface MyJson {
    int age = 9;
    String printJson();

    default void upperString() {
        String text = printJson().toUpperCase();
        System.out.println(text);
    }
    default void jump() {
        go();
        System.out.println("jump....");
    }
    static void myInter(){
        go1(); // static이 붙었기 때문에 사용가능
        System.out.println(age + "my ...");
    }
    private void go() {
        System.out.println("go");
    }
    private static void go1() {
        System.out.println("gogo");
}

class Impl implements MyJson {
    @Override
    public String printJson() {
        return "kim";
    }

    @Override
    public void upperString() {
        // MyJson.super.upperString();
    }
}

    class Impl1 implements MyJson {
        @Override
        public String printJson() {
            return "park";
        }
}

class Ma {
    public static void main(String[] args) {
        Impl impl = new Impl();
        new Impl1().upperString();
        impl.upperString();
        impl.jump();
        MyJson.myInter();
        }

    }
}