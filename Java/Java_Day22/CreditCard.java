package Java_Day22;


public class CreditCard extends Card{
    private String accountNumber;
    CreditCard(String accountNumber, String expireDate, String cardNumber  ){
        super(CardType.CREDIT,cardNumber,expireDate);
        this.accountNumber=accountNumber;

    }

}
