package ch15;

public class Good {
    int sum;
    static int index;
    String str;

    //instance 블럭
    { // ..........................................................{ 3 }
        index = 1;
        for (int i = 0; i < 50; i++) {
            sum += 1;
        }
        System.out.println("instance block");
    } // 함수 필드가 아닌 것에 코드 블럭 처럼 사용하는 것

    public Good() { // 생성자 함수
        str = "HEllO";
        System.out.println("default constructor block"); //......... { 4 }
    }

    //static block
    static { // ....................................................{ 2 }
        String data = loadConfigData();
        index = 9;
        System.out.println("static block");
    }

    private static String loadConfigData() { // .................... { 1 }
        System.out.println("load data.....");
        return "load data.....";
    }
}

class Main3 {
    public static void main(String[] args) {
        var good = new Good();
  //    System.out.println("constructor block");
        System.out.println(good.sum); // .............................{ 5 }
        var good1 = new Good(); // 두번 째부터는 static 은 호출 되지 않음

    }
}
