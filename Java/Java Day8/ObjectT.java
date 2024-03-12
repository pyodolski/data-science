package ch08;

public class ObjectT
{

    int instanceVar; // 인스턴스 변수, 멤버 변수
    static int staticVar; // ObjectT.staticVar로 호출 가능하나 관련은 없음
    // static 변수, 정적 변수

    public static void main(String[] args)
    {// main는 ObjectT와 관련이 없음 (같은 파일에 있어도)
        ObjectT.staticVar = 9;
    //  ObjectT.(instanceVar) -> 불가능 (객체를 통해서 사용)
        var objectT = new ObjectT(); // 메모리에 올라감
        objectT.instanceVar = 70; // new를 통해서 객체 생성 후 사용

        System.out.println(ObjectT.staticVar);
        System.out.println(objectT.instanceVar);
    }
}
