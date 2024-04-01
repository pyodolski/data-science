package Java_Day26.Java;

import javax.xml.namespace.QName;
import java.util.*;

public class Origin {
    private final String name;
    private final int age;

    public Origin(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        List<Origin> origins = new ArrayList<>();
        // alt enter
        origins.add(new Origin("kavin" , 19));
        origins.add(new Origin("david" , 25));
        origins.add(new Origin("jason" , 9));
        Collections.sort(origins, new Comparator<Origin>() { // 한개씩 꺼내서 Comparator 구조체로 보냄
            @Override
            public int compare(Origin o1, Origin o2) {
                // 0 : 위치 변동 없음.
                // -1 : 자리 바꿈을 하지 않음.
                // 1 : 자리 바꿈을 함.
                return o1.getName().compareTo(o2.getName())*(-1); // 내림차순
                // return o1.getAge() < o2.getAge() ?-1:((o1.getAge() == o2.getAge())? 0:1));
                // return integer.compareTo(o1.getAge,o2.getAge());
                // 오름차순
            }
        });

        for (var o : origins) {
            System.out.println(o);
        }




    }
}
