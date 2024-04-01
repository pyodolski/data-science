package Java_Day25;
interface ClubStore{
    int getNum();
}

public class MapStore implements ClubStore{
    private int num = 10;
    public int getNum() {
        return num;
    }
}

class ServiceLogic{
    // ServiceLogic 클래스는 Mapstore클래스에 의존적
    public void  printInt(ClubStore cls){
        int num = cls.getNum() * 2;
        System.out.println(num);
    }
}

