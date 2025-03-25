package ch18.house;
public class HousePark
{
    protected String lastname = "park";

    public void setHouse() {

    }

    public static void main(String[] args)
    {
        var kim = new HouseKim();
        kim.lastname = "kam"; // protect로 선언했지만 같은 패키지이기 때문에 오류 X
        System.out.println(kim.lastname);
    }

}
