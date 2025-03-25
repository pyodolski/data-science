package ch12;
import java.util.Date;
public class Customer {
    String name;
    int age;
    String sex;
    int childrenCnt;
    Cafe cafe;
    Date today = new Date();

    public void setChildrenCnt(int childrenCnt) {
        this.childrenCnt = childrenCnt;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo() {
        System.out.println("이름 : " + name + " 나이 : " + age + " 성별 : " + sex + " 자녀 수 : " + childrenCnt);
    }

    public void orderMenu (Menu menu) {
        System.out.println(name + "님 " + menu.name + " 주문 완료!\n" + "주문날짜 : " + today);
        cafe.printOrderInfo(menu); // 수
    }
}

class Cafe {
    String name;
    Menu[] menus = new Menu[3];

    Customer[] customers = new Customer[3];
    int customeridx = 0;
    int menuidx = 0;

    public void setName(String name) {
        this.name = name;
    }
    public void registerCustomer(Customer customer){
        System.out.println(customer.name + "님 " + name + "에 회원가입이 완료되었습니다.");
        if (customers.length > customeridx)
        {
            customers[customeridx++] = customer;
        }
    }
    public void registerMenu(Menu menu) {
        if (menus.length > menuidx)
        {
            menus[menuidx++] = menu;
        }
    }
    public void registerMenuInfo()
    {
        for (var meun: menus) {
            if (meun != null)
                meun.printInfo();
        }
    }
    public void registerCustomerInfo()
    {
        for (var customer: customers) {
            if (customer != null)
                customer.printInfo();
        }
    }
    static public void printOrderInfo(Menu menu) {
        System.out.println( "주문 메뉴 : " + menu.name + " 가격 : " + menu.price);
    }


}
class Menu {
    String name;
    int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo()
    {
        System.out.println("메뉴이름 : " + name + " 가격 : " + price );
    }
}

class AppUI3 {
    public static void main(String[] args) {
        var customer1 = new Customer();
        var customer2 = new Customer();
        customer1.setName("james");
        customer2.setName("tomas");
        customer1.setAge(20);
        customer2.setAge(30);
        customer1.setSex("Man");
        customer2.setSex("Man");
        customer1.setChildrenCnt(1);
        customer2.setChildrenCnt(2);
        System.out.println("              ");
        System.out.println("[고객 정보 확인]");
        customer1.printInfo();
        customer2.printInfo();
        // 고객정보 등록

        var cafe = new Cafe();
        cafe.setName("스타벅스");
        System.out.println("             ");
        System.out.println("[회원 가입 확인]");
        cafe.registerCustomer(customer1);
        cafe.registerCustomer(customer2);
        System.out.println("                             ");
        System.out.println("[고객 등록 정보 및 메뉴 등록 정보]");
        cafe.registerCustomerInfo();
        cafe.registerMenuInfo();

        var menu1 = new Menu();
        var menu2 = new Menu();
        var menu3 = new Menu();
        menu1.setName("아이스아메리카노");
        menu1.setPrice(3000);
        menu2.setName("카페라떼");
        menu2.setPrice(3500);
        menu3.setName("초코라떼");
        menu3.setPrice(4500);

        System.out.println("             ");
        System.out.println("[주문 정보 출력]");
        cafe.registerMenu(menu1);
        cafe.registerMenu(menu2);
        cafe.registerMenu(menu3);

        customer1.orderMenu(menu1);
        customer1.orderMenu(menu2);
        customer2.orderMenu(menu3);
    }
}