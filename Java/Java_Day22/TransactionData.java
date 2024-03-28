package Java_Day22;


import java.util.Date;
import java.util.List;

public class TransactionData {
    private Date date;
    private int price;

    public TransactionData(Date date, int price){
        this.date=date;
        this.price=price;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // tostring은 그냥 디버깅 용도
    @Override
    public String toString() {
        return "TransactionData{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
