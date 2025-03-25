package ch12;

public class Person {
    String name;
    int money;
    static int TBcnt = 0;
    static int TScnt = 0;


    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void TB(Bus bus){
        money -= bus.bill;
        TBcnt++;
    }
    public void TS(Subway subway){
        money -= subway.bill;
        TScnt++;
    }
    public void BprintInfo(){
        System.out.println(name +"은 BUS를 " + TBcnt + "번 이용했고 남은 돈은 " + money + "원 입니다" );
    }
    public void SprintInfo(){
        System.out.println(name +"은 SUBWAY를 " + TScnt + "번 이용했고 남은 돈은 " + money + "원 입니다" );
    }
}

class Bus{
    int bill = 1000;
}
class Subway{
    int bill = 1500;

}
class AppUI2 {
    public static void main(String[] args) {
        var bus = new Bus();
        var subway = new Subway();
        var person1 =new Person();
        person1.setName("james");
        person1.setMoney(5000);

        var person2 = new Person();
        person2.setMoney(4000);
        person2.setName("tomas");

        person1.TB(bus);
        person1.TB(bus);
        person1.TB(bus);

        person2.TS(subway);
        person2.TS(subway);


        person1.BprintInfo();
        person2.SprintInfo();

    }

}
