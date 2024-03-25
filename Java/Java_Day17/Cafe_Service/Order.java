package ch19.sol;

public class Order {
    private  Customer customer;
    private int amount;

    public  Order(Customer customer, int amount) {
        this.customer = customer;
        this.amount = amount;
    } // 주문에는 필수적으로 고객과 가격이 있어야 하기 때문에 생성자 오버로딩을 통해 정의

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", amount=" + amount +
                '}';
    }
}
