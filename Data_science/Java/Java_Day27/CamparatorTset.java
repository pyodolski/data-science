package Java_Day27;

import java.util.Arrays;
import java.util.Comparator;

public class CamparatorTset {
    public static void main(String[] args) {
        String[] strArr = { "ZZa", "AAAbb", "DDuu" };
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2)*(-1); // 내림차순
            }
        });
        System.out.println(Arrays.toString(strArr));
    }
}
