package ch16;

import java.util.HashSet;
import java.util.Set;

final public class Repository {
    //final 이 붙으면 다른 객체에서 이 클래스를 상속받을 수 없음. 오버라이딩 되면 안되니까! 재정의 할 수 없음.
    private static Set<Customer> db;
    // 중요한 정보니까 다른 객체에서 사용하지 못하도록 private
    //
    static {
        db= new HashSet<>();
        db.add(new Customer("kavin@naver.com"));
        db.add(new Customer("dahee@naver.com"));
        db.add(new Customer("one@naver.com"));
        db.add(new Customer("two@naver.com"));
        db.add(new Customer("three@naver.com"));
    }
    // static 블럭에서 초기화 시켜줘야함.
    // 안하면 이 블럭을 빠져나가면 db 를 못찾기 때문에
    // 계속 생성되면 안됨.

    public static void addCustomer(String email){
        db.add(new Customer(email));
    }
    public static void addCustomer(String email,String name){
        db.add(new Customer(email,name));
    }

    public static Customer findCustomer(String email){
        // 시그니처가 email이 아니라 오브젝트였으면 db.contains 함수 사용 가능한데..
        for (var customer : db){
            if(customer.email.equals(email)) return customer;
        }return null;
    }
    // 모두 static 으로 바꾼 이유
    // 1. 인스턴스 변수가 없음 .(굳이 new Repository 할 필요가 없으니까)
    // 2. db에 접근할 때는 빨리빨리 처리가 되어야 하니까
}
