package ch08;

class MyObj // package ch08에서만 사용할 수 있는 class가 됨( public이 없기 떄문)
{

}

public class ObjTest
{
    public static void main(String[] args)
    {
        var MyObj = new MyObj(); // 인스턴스를 통해서 접근 가능

        MyObj.toString(); // 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
        MyObj.hashCode(); // 객체를 식별하는 하나의 정수 값을 리턴하는 메소드
        // 부모에게 있는 메소드는 자식이 사용가능
    }
}
