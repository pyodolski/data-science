package Java_Day21.override_t;

public class Person {
    protected int age; // 상속받는 애가 본인 것 처럼 쓸 수 있음.
    protected String name;

    protected void sleep(){
        System.out.println("sleep from person obj");
    }

    protected void showPersonInfo(){
        System.out.println("show person info");
    }
}
class Superman extends Person{
    boolean isSuperPower;

    @Override
    public void sleep() { // private 불가능. 부모의 접근제어지시자보다 높거나 같아야한다. 그래야 오버라이드가 성립된다. public 왜 한다고 했더라..
        System.out.println("superman sleep()");

    }
}
class Sample {
    public void aaa(){
        System.out.println("sample aaa");
    }

}
class AppUI {
    public static void main(String[] args) {
        Person person = new Person();
        AppUI appUI = new AppUI(); // 같은 클래스 이지만 클래스 안이기 ㄸㅐ문에 생성자 인스턴스를 만들어서 접근가능하다.
        appUI.setSleep(person);

        Person superman = new Superman();
        superman.sleep(); // 우선 부모(Person)의 sleep이 메모리를 갖고. 다음에 오버라이드 되어서 SuperMan의 sleep이 메모리를 갖는다.

        appUI.setSleep(superman); // 부모로 upcasting

        var sample1 = new Sample();
        sample1.aaa();
        var sample2 = new Sample();
        sample2.aaa();
        // sample을 아무리 생성해도 aaa() 는 하나이다.
    }
    // 다형성 활용에 많이 굉장히 억수로 많이 사용됩니다.
    public void setSleep(Person person){ // 메인 클래스 안.
        person.sleep();
    }
}