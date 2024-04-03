package Java_Day28;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppUI {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aaa", "bbb", "ccc");
//        Collections.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        });
        Collections.sort(words,
                ((s1, s2) ->Integer.compare(s1.length(), s2.length()) ));

        for(var s : words) System.out.println(s);

        Comparator<String> func = (s1, s2) ->Integer.compare(s1.length(), s2.length());

    }
    public static int resultMethod(Comparator<String> comparator) {
        return 1;
    }
}
