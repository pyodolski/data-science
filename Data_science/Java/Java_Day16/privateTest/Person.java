package ch18.privateTest;

import ch18.house.HouseKim;

public class Person
{
    private int age; // private 사용 의무화
    private String name; // 내 객체의 내 속성은 은닉하는 것이 기본 원칙!

    public void setAge(int age) // public 사용으로 외보로 이어지는 통로 설정
    {
        if (age < 150)
            this.age = age;
        else System.out.println("wrong value");
    }

    public int getAge() {
        return age; // 통로를 마련해주면 가져갈 수 있는 getter도 있는 것이 진리(캡슐화)
    }
}

class Main
{
    public static void main(String[] args)
    {
        var person = new Person();
        // person.을 했을 때 Person의 속성이 보이지 않음 -> private
        person.setAge(25); // public인 setter을 사용해서 속성에 접근

        var kim = new HouseKim();
        // 객체 생성은 되지만 package가 다르기 때문에 kim. 의 속성은 접근할 수 없음

    }

}
