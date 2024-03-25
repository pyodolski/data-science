package Java_Day20.Grade;

 class Customer {
    long id;
    double bonus;
    String name;
    Grade grade;
    Customer(int id ,String name){
        this.id = id;
        this.name = name;
        this.grade = Grade.NORMAL;
    }
    public Grade getGrade() {
        return grade;
    }
    public void myGrade(){
        System.out.println(this.grade);
    }
    public void myPoint(){
        System.out.println(this.bonus);
    }
    private void lvUp(double price){
        if(price > 100000) {
            this.grade = Grade.ROYAL;
        }
    }
    public void buyProduct (Product product){
        bonus += product.howMuch(this.grade);
        lvUp(product.getPrice());
        System.out.println("내 보너스: "+ this.bonus);
    }
}
public enum Grade{
    NORMAL(0.0,0.01),
    ROYAL(0.05,0.05);
    private final double salesRatio;

    private final double bonusRatio;

    Grade(double salesRatio, double bonusRatio) {
        this.salesRatio = salesRatio;
        this.bonusRatio = bonusRatio;
    }

    public double getBonusRatio() {
        return bonusRatio;
    }

    public double getSalesRatio() {
        return salesRatio;
    }
}


class Product{
    String name;
    double price;

    Product(String name, long price){
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    private double discount(Grade grade) {

        return price*grade.getSalesRatio();
    }

    private double bonusPoint(Grade grade) {
        return price*grade.getBonusRatio();
    }

    public double howMuch(Grade grade){
        double discount = price*grade.getSalesRatio();
        double bonus = price*grade.getBonusRatio();
        var p = price - price*(discount);
        System.out.println(
                "상품명 : " + getName()+"\n" +
                        "원가: " + getPrice()+'\n'+
                        "할인: " + discount+ '\n'+
                        "가격: " + p+"\n"+
                        "보너스: "+bonus
        );
        return bonus;
    }
}


class Main__ {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1,"a");
        Customer customer2 = new Customer(2,"b");

        Product apple = new Product("사과", 500);
        Product orange = new Product("오랜지", 100);
        Product tv = new Product("테레비", 1000000);

        customer1.myGrade();
        customer1.myPoint();
        customer2.myGrade();
        customer2.myPoint();

        customer1.buyProduct(tv);
        customer1.myGrade();
        customer1.myPoint();

        customer1.buyProduct(apple);
        customer1.myGrade();


        customer2.buyProduct(apple);
        customer2.myGrade();
    }
}