package Java_Day27;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5}; // 메모리에 올라감
        // Stream 생성
        IntStream intStream = Arrays.stream(arr);
        System.out.println(intStream.sum());
        // System.out.println(intStream.sum());
        // 두번 째에는 메모리가 닫혀버려서 사용을 할 수가 없음
        System.out.println(Arrays.stream(arr).sum());
        // 한번 쓰고 버리는 것이기 때문에 바로 사용하는 것이 효율적.

        OptionalInt optionalint = Arrays.stream(arr).max();
        // 다시 스트림 생성
        optionalint.ifPresent((System.out::println));
        // 값이 있으면 하나씩 빼서 출력하라하는 의미.
        // optionalint.ifPresent((m-> System.out.println(m))); 과 같은 의미
        IntStream.range(0, 6).forEach(System.out::println);

        // List
        System.out.println("[List]");
        List<String> stringList = new ArrayList<String>(); // Arrays.asList("1", "2", "3", "4", "5")
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        String s = stringList.getFirst();
        int i = Integer.parseInt(s); // String -> int (= valueOf(s))
        System.out.println(stringList.stream().mapToInt(a -> Integer.parseInt(a)).sum()); // String을 저장할 수 있는 Stream을 받아옴
        System.out.println("-------------------------------------");
        System.out.println();
        List<String> animals = Arrays.asList("Animal", "Cat", "Tiger", "Superman");
        // 각 리스트의 엘리먼트를 출력해보자
        animals.forEach(System.out::println); // forEach를 바로 사용해도 된다.
        animals.stream().mapToInt(String::length).average().ifPresent(System.out::println);
        animals.stream().mapToInt(s1 -> s1.length()).average().ifPresent(System.out::println); // lambda가 무조건 들어간다,

        // man으로 끝나는 글자들의 길이를 출력하라
        animals.stream().filter(s1 -> s1.contains("man")).map(String::length).forEach(System.out::println);
        System.out.println("========================================");
        animals.stream().filter(s2-> s2.endsWith("man")).map(String::length).forEach(System.out::println); // 뒤의 문자열 검사
        animals.stream().filter(s1 -> s1.contains("man")).mapToInt(String::length).max().ifPresent(System.out::println); // 포함 검사
        animals.stream().filter(s2-> s2.endsWith("man")).filter(s2->s2.length() > 5).forEach(System.out::println);
        List<String> result =  animals.stream().filter(s2-> s2.endsWith("man")).toList(); // Collect.... 최종연산자
        System.out.println(result);
        result.forEach(System.out::println);

    }
}



