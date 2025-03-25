package ch19.sol;
import java.util.*;

public class Cafe {
    private String name;
    //private Menu[] menus;
    private Map<Menu, Integer> menuPrices; // 메뉴가격
    // todo : Order객체를 만들어서 배열로 처리하세요 , 같은 고객이 주문을 여러 번할 수 없는 상태임 Map
    private Set<Customer> customers;
    private Set<Order> customerOrders;
    private int totalSales; // 총 주문 금액
    public Cafe(String name) {
        this.name = name;
        menuPrices = new HashMap<>();
        customerOrders = new HashSet<>();
        customers = new HashSet<>();


    }
    public void setCustomers(Customer customer) {
        customers.add(customer);
    }
    public void setMenuPrices(Menu menu, int price) {
        menuPrices.put(menu, price); // 메뉴에 가격을 설정하는 방법

    }
    public Map<Menu, Integer>getMenus() {
        return menuPrices;
    }
    public void makeSale(Customer customer, int amount) {
        if(customers.contains(customer)) {
            customerOrders.add(new Order(customer, amount)); // hashset에 값 넣는 법
            totalSales += amount;
        }
        else System.out.println("비회원은 주문 불가합니다");
    }
    public void printOrder() {
        for (var customer : customerOrders) {
            System.out.println(customer.getCustomer().getName()
                    + " 주문금액 : " + customer.getAmount());
            // Set, Map(key)도 중복을 허용하지 않는다.
            // get(Key)를 하면 Value값이 나옴 -> 주문 금액이 출력
        }
    }
    public int getTotalSales() {
        return totalSales;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.name, ((Cafe)obj).name);
    }
}
