package My_project.Center;

import java.util.Scanner;
public class Center {
    Cafe cafe;
    Customer[] customerList;
    int customerCount;

    public Center() {
        this.customerList = new Customer[2];
        this.customerCount = 0;
    }

    public void registerCafe(Cafe cafe, String name) {
        cafe.name = name;
    }

    public void registerCustomer(Cafe cafe, String name, String email, String address, String nickname) {
        if (customerCount >= 2) {
            System.out.println("고객 등록은 최대 2명까지 가능합니다.");
            return;
        }

        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("이름과 이메일은 필수 입력 사항입니다. 회원가입이 불가능합니다.");
            return;
        }

        Customer customer = new Customer();
        customer.name = name;
        customer.email = email;
        customer.address = address;
        customer.nickname = nickname;

        cafe.registerCustomer(customer, name, email, address, nickname);
        customerList[customerCount++] = customer;

        System.out.println("회원가입이 완료되었습니다.");
    }

    public void placeOrder(Cafe cafe, Customer customer) {
        boolean registered = false;
        for (int i = 0; i < customerCount; i++) {
            if (customerList[i] == customer) {
                registered = true;
                break;
            }
        }

        if (!registered) {
            System.out.println("고객 등록이 필요합니다. 주문이 불가능합니다.");
            return;
        }

        // 주문 생성
        Order order = new Order(customer, customer.menu);

        // 주문 내역 출력
        cafe.printOrder(customer, order);
    }
}

enum Menu {
    AMERICANO,
    CAFELATTE;

    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Cafe {
    String name;
    public void setMenuPrice(Menu menu, int price) {
        // 메뉴의 가격을 카페에서 설정할 수 있음 ( 3번 조건)
        menu.setPrice(price);
    }

    public void registerCustomer(Customer customer, String name, String email, String address, String nickname) {
        customer.name = name;
        customer.email = email;
        customer.address = address;
        customer.nickname = nickname;
    }

    public void printOrder(Customer customer, Order order) {
        System.out.println("주문자: " + customer.name);
        System.out.println("주문 메뉴: " + order.menu);
        System.out.println("주문 금액: " + order.menu.getPrice() + "원");
    }
}

class Order {
    Customer customer;
    Menu menu;

    public Order(Customer customer, Menu menu) {
        this.customer = customer;
        this.menu = menu;
    }
}

class Customer {
    String name;
    String email;
    String address;
    String nickname;
    Menu menu;

    public void selectMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("메뉴를 선택하세요 (1. 아메리카노, 2. 카페라떼): ");
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                menu = Menu.AMERICANO;
                break;
            case 2:
                menu = Menu.CAFELATTE;
                break;
            default:
                System.out.println("잘못된 메뉴 선택입니다.");
        }
    }

    public void placeOrder(Cafe cafe,Center center) {
        center.placeOrder(cafe, this );
    }
}

class AppUI {
    public static void main(String[] args) {
        Center center = new Center();
        Cafe cafe = new Cafe();
        center.registerCafe(cafe, "스타벅스"); // 카페 등록
        cafe.setMenuPrice(Menu.AMERICANO, 2500);
        cafe.setMenuPrice(Menu.CAFELATTE,3000);


        // 고객 등록
        center.registerCustomer(cafe,"Pyo", "Pyo@naver.com", "ABC", "pyoju");

        // 고객이 주문
        Customer customer = center.customerList[0]; // 첫 번째로 등록된 고객
        customer.selectMenu(); // 아메리카노 선택

        // 고객이 주문을 처리
        customer.placeOrder( cafe, center);

        Customer customer1 = new Customer(); // 고객 등록을 하지 않은 Customer의 주문
        customer1.selectMenu();
        customer1.placeOrder(cafe, center);
    }
}
