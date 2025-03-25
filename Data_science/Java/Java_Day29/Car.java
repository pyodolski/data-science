package Java_Day29;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car {
    private int idx;
    private String brand;
    private String model;
    private String color;
    private int dateYear;
    private int price;

    public Car(int idx, String brand, String model,String color, int dateYear, int price){
        this.idx=idx;
        this.brand=brand;
        this.model=model;
        this.color=color;
        this.dateYear=dateYear;
        this.price=price;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDateYear() {
        return dateYear;
    }

    public void setDateYear(int dateYear) {
        this.dateYear = dateYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idx=" + idx +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", dateYear=" + dateYear +
                ", price=" + price +
                '}';
    }
}

class Main{
    public static void main(String[] args) {
        List<Car> carList = Arrays.asList(
                new Car(1,"LG","L-282","W",1992,3000),
                new Car(1,"LG-1","L-101","W",1992,1000),
                new Car(1,"SMS","SM-282","R",1999,2000),
                new Car(1,"LG-4","L-182","W",1995,1000),
                new Car(1,"LG-4","L-105","W",1995,100)
        );

        // for 문을 쓰기전에 stream으로 처리가능한지 생각해보기
        //중간 연산자(map, filter, sort, ...), 최종 연산자(foreach, reduce, toList,...)를 잘 사용하기
        // Q1. 자동차 가격이 2000보다 작고 컬러가 화이트인 차들의 정보를 출력하라.
        carList.stream().filter(p->p.getPrice()<2000).filter(p-> Objects.equals(p.getColor(), "W")).forEach(System.out::println);

        // 강사님코드
        carList.stream()
                .filter(c->c.getPrice()<200)
                .filter(c->c.getColor().equals("W"))
                .toList().forEach(System.out::println); // .stream().forEach() 는 stream() 생략가능.

        // Q2. 제조년이 1995년 이하인 화이트 차들의 총 합계 가격을 출력
        carList.stream().filter(c->c.getDateYear()<=1995).filter(car -> Objects.equals(car.getColor(), "W")).mapToInt(Car::getPrice).sum();

        // Q3. 3000이하 차들 중에 브랜드가 LG로 시작하는 차량에 세금 14% 더한 차들의 정보를 출력
        carList.stream().filter(car -> car.getPrice()<=3000).filter(car -> car.getBrand().startsWith("LG")).mapToInt(c->(int)(c.getPrice()*1.14)).forEach(System.out::println);

        carList.stream().filter(car -> car.getPrice() <= 3000)
                .filter(car -> car.getBrand().startsWith("LG")).mapToInt(t->(int)(t.getPrice()*1.14)).forEach(System.out::println);


        carList.stream()
                .filter(c->c.getPrice() <= 3000)
                .filter(c -> c.getBrand().startsWith("LG"))
                .map(c -> {
                    c.setPrice((int) (c.getPrice() * (1.14)));
                    return c;
                }).toList().forEach(System.out::println);

        carList.stream()
                .filter(c->c.getPrice() <= 3000)
                .filter(c -> c.getBrand().startsWith("LG"))
                .peek(c -> c.setPrice((int) (c.getPrice() * (1.14)))).toList().forEach(System.out::println);

        System.out.println("Q4. 차량색상이 화이트인 차들중에 가격순으로 내림차순으로 출력");

        carList.stream()
                .filter(c->c.getColor().equals("W"))
                .sorted((c1, c2) ->Integer.compare(c1.getPrice(), c2.getPrice())*(-1))
                .toList().forEach(System.out::println);
    }
}