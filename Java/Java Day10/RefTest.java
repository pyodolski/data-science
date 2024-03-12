package ch10;

public class RefTest {
    public static void main(String[] args) {
        var refTest = new RefTest();
        int val = 1; // local variable
        int[] refArr = {1,3,6}; // instance variable

        refTest.addValue((val));
        System.out.println(val);

        refTest.addRef(refArr);
        System.out.println(refArr[0]);
    }

    public void addValue(int val){
        val = 100;

    }

    public void addRef(int[] refArr){
            refArr[0] = 10000;
    }
}
