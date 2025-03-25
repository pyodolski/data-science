package ch21;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

public class ArrayT {
    public static void main(String[] args) {
        List<String> list1 = Collections.checkedList(
                new ArrayList<>(), String.class);
        // 아래와 같은 상황을 예방하기 위해서 콜렉션 체크리스트에
        // 한번 넣어서 확인해야함. for로 하나씩 꺼내지 않아도 바로 die
        // 컴파일 오류는 나지 않음 형변환을 해주었기 때문에
        list1.add("kavin");
        list1.add("david"); // String

        new ArrayT().makeSomething(list1);

//      Object obj = list1;

    }

    public void makeSomething(Object obj) {
//        ArrayList<Double> list2 = (ArrayList<Double>)obj;
//        list2.add(2.0);
//        list2.add(1.0);  // Double
//
//        System.out.println(list2); // 이러시면 안됩니다 큰일나요,
//
//        for(double d : list2) {
//            System.out.println(d); // die.. heap 폭파
//        }
    }
}
