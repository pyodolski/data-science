package Java_Day22;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chargeable {
    // 우린 똑똑한 개발자니까 protected 쓰자~
    protected CardType cardType;
    protected List<TransactionData> datas; // 강사님은 굳이 왜 이렇게 하냐면 SDK가 이렇게 되어 있음. 그래서 간지나니까 이렇게 하심
    // 누가 물어본다면 대답은 할 줄 알아야하니까 설명할 줄 알면 좋겟쥬 virtual table의 속성때무넹 최근에 구현한 속성으로 점프

    public Chargeable(CardType cardType){
        this.cardType=cardType;
        datas=new ArrayList<>();
    }

    protected void payment(int price){
        datas.add(new TransactionData(new Date(),3000));
    }
    protected void show() {
        System.out.println(datas);
    }

}
