<<<<<<< HEAD
package My_project.Payment;
=======
package Payment;
>>>>>>> db4b19fd9f82448b80dbf8b8abd33cf28da5f09a

import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class Customer {
    private String name;
    private List<Payment> payments; //  고객의 결제수단을 저장할 List
    private List<UseData> useDatas;


    public Customer(String name) {
        this.name = name;
        payments = new ArrayList<>(); // List 초기화
        useDatas = new ArrayList<>();
    }
    public void addPayment(CardCompany cardCompany, Cardtype cardtype) {
        Payment payment = new Payment(cardtype);
        switch (cardtype) {
            case CASH:
                payment = new CashCard(cardtype);
                break;
            case CREDIT:
                payment = new CreditCard(cardtype);
                break;
            case GIFT:
                payment = new GiftCard(cardtype);
                break;
        }
        payments.add(payment); // 고객의 결제수단 리스트에 저장
        if (cardCompany.getCustomerPaymentList().containsKey(this)) {
            cardCompany.getCustomerPaymentList().get(this).add(payment); // 해당 고객이 있으면 Value 값만 추가
        } else cardCompany.getCustomerPaymentList().put(this, payments); // 카드회사 고객관리리스트에도 저장
    }

    public void buyItem(int price, Cardtype cardtype,CardCompany cardCompany){
        boolean cardFound = false;
        for (Payment payment : payments) {
            if (payment.getCardtype() == cardtype) {
                cardFound = true;
                System.out.println("구매금액은 " + price + "원이며 발생 수수료는 " + (price) * cardtype.getFee() + "원입니다");
                if (cardtype == Cardtype.CREDIT) {
                    System.out.println("발생 수수료는 " + (price) * cardtype.getTax() + "원 입니다");
<<<<<<< HEAD


                }
                UseData usedata = new UseData(price, cardtype, LocalDateTime.now());
                cardCompany.addUseData(this, usedata);
                useDatas.add(usedata);
=======
                    UseData usedata = new UseData(price, cardtype, LocalDateTime.now());
                    useDatas.add(usedata);
                    cardCompany.addUseData(this, usedata);
                }
>>>>>>> db4b19fd9f82448b80dbf8b8abd33cf28da5f09a
                break; // 해당 카드를 찾으면 반복문 종료
            }
        }
        if (!cardFound) {
            System.out.println("해당 카드를 소유하고 있지 않습니다.");
        }
<<<<<<< HEAD
=======

>>>>>>> db4b19fd9f82448b80dbf8b8abd33cf28da5f09a
    }
    // getter
    public String getName() {
        return name;
    }
    public List<Payment> getPayments() {
        return payments;
    }

    public List<UseData> getUseDatas() {
        return useDatas;
    }
    //
}
class CardCompany{
    private String name;
    private Map<Customer, List<Payment>> customerPaymentList;
    private Map<Customer, List<UseData>> useDataList;
    public CardCompany(String name) {
        this.name = name;
        customerPaymentList = new HashMap<>(); // Map 초기화
        useDataList = new HashMap<>();
    }
    // getter
    public String getName() {
        return name;
    }
    public Map<Customer, List<Payment>> getCustomerPaymentList() {
        return customerPaymentList;
    }

    public Map<Customer, List<UseData>> getUseDatas() {
        return useDataList;
    }

    //
    public void printCustomerCardUsage(Customer customer) {
        if (useDataList.containsKey(customer)) {
            System.out.println(customer.getName() + "님의 카드 이용 내역:");
            for (UseData useData : useDataList.get(customer)) {
                System.out.println(useData);
            }
        } else {
            System.out.println("카드 이용 내역이 없습니다.");
        }
    }
    public void addUseData(Customer customer,UseData useData) {

        if (useDataList.containsKey(customer)) {
<<<<<<< HEAD
=======
            useDataList.get(customer).add(useData); // 해당 고객이 있으면 Value 값만 추가
>>>>>>> db4b19fd9f82448b80dbf8b8abd33cf28da5f09a
        } else useDataList.put(customer,customer.getUseDatas()); // 카드회사 고객관리리스트에도 저장
    }
}
enum Cardtype {
    CASH(0.02,0),
    CREDIT(0.05,0.1),
    GIFT(0.01,0);
    private final double fee;
    private final double tax;

    Cardtype(double fee, double tax) {
        this.fee = fee;
        this.tax = tax;
    }

    public double getFee() {
        return fee;
    }

    public double getTax() {
        return tax;
    }
}

class Payment {
    private Cardtype cardtype;

    public Payment(Cardtype cardtype) {
        this.cardtype = cardtype;
    }

    public Cardtype getCardtype() {
        return cardtype;
    }
}
class Card extends Payment{
    private String cardNum;
    private String validity;
    public Card(Cardtype cardtype) {
        super(cardtype);
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public void setValidity(String validity) {
        this.validity = validity;
    }
    public String getCardNum() {
        return cardNum;
    }
    public String getValidity() {
        return validity;
    }
}
class CashCard extends Card{
    public CashCard(Cardtype cardtype) {
        super(cardtype);
    }
}
class CreditCard extends Card{
    public CreditCard(Cardtype cardtype) {
        super(cardtype);
    }

}
class GiftCard extends Payment{
    public GiftCard(Cardtype cardtype) {
        super(cardtype);
    }
}
class UseData {
    private int price;
    private Cardtype cardtype;
    private LocalDateTime usetime;

    public UseData(int price,Cardtype cardtype, LocalDateTime usetime) {
        this.price = price;
        this.cardtype = cardtype;
        this.usetime = usetime;
    }
    public LocalDateTime getUsetime() {
        return usetime;
    }
    public Cardtype getCardtype() {
        return cardtype;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "가격 = " + price +
                "원, 카드 종류 = " + cardtype +
                ", 사용 시간 = " + usetime +
                '}';
    }

}
class Main {
    public static void main(String[] args) {
        CardCompany DaeguBank = new CardCompany("DaeguBank");
        Customer kavin = new Customer("kavin");
        kavin.addPayment(DaeguBank, Cardtype.CREDIT);
        kavin.buyItem(10000, Cardtype.CREDIT, DaeguBank);
<<<<<<< HEAD
        kavin.addPayment(DaeguBank, Cardtype.CASH);
        kavin.buyItem(10000, Cardtype.CASH,DaeguBank);
        kavin.buyItem(7777,Cardtype.CREDIT,DaeguBank);


=======
>>>>>>> db4b19fd9f82448b80dbf8b8abd33cf28da5f09a
        DaeguBank.printCustomerCardUsage(kavin);


    }
}