package Java_Day22;



public class Card extends Chargeable{
    protected String cardNumber;
    protected String expireDate;
    protected Card(CardType cardType, String cardNumber, String expireDate){
        super(cardType);
        this.cardNumber=cardNumber;
        this.expireDate=expireDate;
    }

}
