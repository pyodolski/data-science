package Java_Day29;

import java.util.Arrays;
import java.util.List;

public class ReduceT {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//      System.out.println(numbers.stream()
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        List<String> strs = Arrays.asList("안녕하세요", "Hello", "good morning");
        var maxlen = strs.stream().reduce((s1,s2)->{
            return s1.length() > s2.length() ? s1 : s2;
        });
        maxlen.ifPresent(System.out::println);
    }
}
