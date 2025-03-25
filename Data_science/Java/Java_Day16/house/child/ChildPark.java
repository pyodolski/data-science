package ch18.house.child;
import ch18.house.HousePark;

public class ChildPark extends HousePark
    // HousePark(부모)을 ChildPark(자식)이 상속한다.
    // 부모 것을 다 쓰겠다.
{
    public void test()
    {
        super.lastname = "kim";     // super : HousePark
        super.setHouse();
    }
}
