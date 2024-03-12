package ch09.msg;

public class AppUI {
    public static void main(String[] args) {
        var customer = new Customer();
        var phone = new Phone();
        customer.setPhone(phone);
        customer.sendMsg("Hello~");
    }
}
