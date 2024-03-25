import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Bank {
    private String name;
    private Set<Customer> customers;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Bank(){
        customers = new HashSet<>();

    }
    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(name + "에 고객등록이 완료 되었습니다.");
    }

    public void printAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객 정보가 없습니다.");
            return;
        }

        for (Customer customer : customers) {
            Account account = customer.getAccount();
            System.out.println("고객 이름: " + customer.getName());
            System.out.println("계좌 번호: " + account.getAccountNum());
            System.out.println("통장 잔고: " + account.getTotalmoney() + "원");
            System.out.println("--------------------");
        }
    }
    public void printCustomerAccount(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                Account account = customer.getAccount();
                System.out.println("고객 이름: " + customer.getName());
                System.out.println("계좌 번호: " + account.getAccountNum());
                System.out.println("통장 잔고: " + account.getTotalmoney() + "원");
            } else  System.out.println("일치하는 고객 정보가 없습니다.");
        }
    }
    public boolean checkCustomerRegistered(Customer customer) {
        return customers.contains(customer);
    }
    public boolean checkAccountNumberDuplicate(String accountNum) {
        for (Customer customer : customers) {
            if (customer.getAccount() != null && customer.getAccount().getAccountNum().equals(accountNum)) {
                return true;
            }
        }
        return false;
    }

}

class Account {
    private String accountNum;
    private int totalmoney = 0;

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNum='" + accountNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(accountNum, ((Account)obj).accountNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNum);
    }
}

class Customer {
    private String name; // Customer 이름
    private String idNumber; // Customer 주민번호
    private int money; // Customer 주머니 돈
    private Account account; // Customer의 계좌


    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }
    // Setter start
    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    // Setter end

    // Getter start
    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getMoney() {
        return money;
    }

    public Account getAccount() {
        return account;
    }
// Getter end


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", money=" + money +
                ", accountNum=" + account.getAccountNum() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.idNumber, ((Customer)obj).idNumber)
                && Objects.equals(this.name, ((Customer)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idNumber);
    }
    public void openAccount(String accountNum, Bank bank) {
        if (!bank.checkCustomerRegistered(this)) {
            System.out.println("Bank 회원으로 등록되어 있지 않습니다. 먼저 회원으로 등록해주세요.");
            return;
        }

        if (bank.checkAccountNumberDuplicate(accountNum)) {
            System.out.println("이미 존재하는 계좌 번호입니다. 계좌 생성에 실패했습니다.");
        }
        else {
            System.out.println("계좌가 개설 되었습니다. 통장 잔고 : 0원");
            Account account = new Account();
            account.setAccountNum(accountNum);
            this.setAccount(account);
            this.money -= 1000; // 계좌 개설 비용 1000원
            System.out.println("계좌 개설 비용 1000원이 차감되었습니다.");
            System.out.println("현재 주머니에 " + this.money + "원이 있습니다.");
        }

    }
    public void withdrawMoney(Account account,int money) { // 인출
        if (account.getTotalmoney() < money) {
            System.out.println("통장 잔고가 부족합니다. 통장 잔고 : " + account.getTotalmoney());
        }
        else {
            account.setTotalmoney(account.getTotalmoney() - money); // 인출한 금액만큼 계좌금액 감소
            this.money += money; // 인출한 만큼 money 증가
            System.out.println("계좌번호 " + account.getAccountNum() + "에서 " + money + "원 인출되었습니다.");
            System.out.println("남은 통장 잔고 : " + account.getTotalmoney() + "원");
            System.out.println();
            System.out.println("_____________________________");
        }
    }
    public  void depositMoney(Account account,int money) { // 입금
        if (this.money < money) {
            System.out.println("주머니의 돈이 부족합니다. 현재 주머니에는 " + this.money + "원이 있습니다.");
        }
        else {
            account.setTotalmoney(account.getTotalmoney() + money); // 입금한 금액만큼 계좌금액 증가
            this.money -= money; // 입금한 금액만 큼  money 감소
            System.out.println("계좌번호 " + account.getAccountNum() + "으로 " + money + "원 입금되었습니다.");
            System.out.println("남은 통장 잔고 : " + account.getTotalmoney() + "원");
            System.out.println();
            System.out.println("_____________________________");
        }
    }
    public void printMoney() {
        System.out.println("현재 내 주머니에는 " + money + "원이 있습니다"); // 현재 소지 금액 출력
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Bank 객체 생성
        bank.setName("한국은행");; // Bank 이름 "한국은행"
        Customer customer1 = new Customer("pyo", "123456-0000000"); // Customer 객체 생성
        bank.registerCustomer(customer1); // 고객등록
        customer1.setMoney(10000);
        customer1.openAccount("000-0000-0000", bank);
        customer1.depositMoney(customer1.getAccount(), 3000); // 입급
        customer1.withdrawMoney(customer1.getAccount(), 2000); // 출금
        customer1.printMoney(); // 주머니 속 돈 확인


        Customer customer2 = new Customer("kavin", "123456-0000001");





        // *************** Test ***************//

        //  Test1 - 고객등록은 되었지만 같은 계좌번호가 이미 있을 경우
        // bank.registerCustomer(customer2);
        // customer2.openAccount("000-0000-0000",bank);


        // Test 2 - 고객등록 되어있지 않을 경우
        // customer2.openAccount("000-0000-0001", bank);

        // Test 3 - 돈이 부족하거나 통잔잔고가 부족할 때
        // customer1.withdrawMoney(customer1.getAccount(), 1000000);
        // customer1.depositMoney(customer1.getAccount(), 1000000);


        // bank.printAllCustomers(); // 등록된 모든 고객정보 출력
        // bank.printCustomerAccount("pyo"); // 고객이름으로 등록 된 고객 중 원하는 고객의 정보 출력
    }
}
