package Java_Day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Member implements Comparable<Member> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Member o) {
        return this.name.compareTo(o.getName())*(-1); // equals와 동일한 기능을 가진다.
    }


}
class Main___ {
    public static void main(String[] args) {
        var members = new ArrayList<Member>();
        members.add(new Member("kim"));
        members.add(new Member("kavin"));
        members.add(new Member("david"));
        Collections.sort(members, new Comparator<Member>() {
            @Override// 타입이 ArrayList이기 때문에 Collection을 사용한다.
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName())*(-1);
            }
        });
        for (var m : members) {
            System.out.println(m);
        }

    }
}
