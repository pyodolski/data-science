package Java_Day24;

import java.sql.Array;
import java.util.*;

interface Changeable {
    void change();
}

interface Powerable {
    void power(boolean on);

}
interface Controlable extends Changeable, Powerable { // interface 키워드에 한해서만 extends 다중으로 가능

}
public class MyObj implements Controlable{
    @Override
    public void change() {

    }

    @Override
    public void power(boolean on) {

    }
}
class Main {
    public static void main(String[] args) {
        var objs = new ArrayList<MyObj>();
        objs.add(new MyObj());
        objs.add(new MyObj());

        Controlable controlable = objs.get(0);
        Powerable powerable = objs.get(1);
    }
}
