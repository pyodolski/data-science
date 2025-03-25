package ch19.sol;

public class Main {
    public static void main(String[] args) {
        // CafeMgr
        var center = new CafeMgr();
        // Cafe
        var shop = new Cafe("starbucks");
        center.addCafe(shop);
        // 센터에 카페 등록

        // 커피숍 메뉴 등록
        shop.setMenuPrices(Menu.AMERICANO, 3000);
        shop.setMenuPrices(Menu.CAFELATTE, 4000);
        // 카페로그인

        // Customer
        var customer = new Customer("kavin@gmail.com", "kavin");
        Cafe findCafe = null;

        shop.setCustomers(customer);
        // login 후에 등록된 cafe의 리스트를 보여준다.
        var shops = center.allCafe();
        for (var s : shops) {
            if (s.equals(shop)) {
                findCafe = s;
                break;
            }
        }
        var menus = findCafe.getMenus();
        // 화면에 해당 카페가 가지고 있는 메뉴들이 모두 출력
        // 고객이 아메리카노를 주문했다면
        findCafe.makeSale(customer,menus.get(Menu.AMERICANO));
        findCafe.printOrder();

    }
}
