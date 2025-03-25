package Java_Day22;


enum CardType {
    CREDIT(0.1,0.05), // 본인의 클래스를 생성했다. static final이라서 cardType.CREDIT으로 접근 가능하다.
    CASH(0.0,0.03),
    GIFT(0.0,0.01);

    private double tax;
    private double fee;

    CardType(double tax, double fee){
        this.tax=tax;
        this.fee=fee;
    }

    public double getTax() {
        return tax;
    }
    public double getFee() {
        return fee;
    }

}
