//package Java_Day22;
//
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SinhanCard {
//    private static SinhanCard INSTANCE;
//    private Map<User, List<Chargeable>> users;
//    private static Long userIdx;
//
//    private SinhanCard(){
//        users=new HashMap<>();
//        userIdx = 1L;
//    }
//    public User findUser(Long idx) {
//        return
//    }
//
//    public static synchronized SinhanCard getInstance(){
//        if(INSTANCE== null) INSTANCE=new SinhanCard();
//        return INSTANCE;
//    }
//    public void createUser(String email) {
//        users.put(new User(userIdx++,email), new ArrayList<Chargeable>());
//
//    }
//    public void createCard(Long idx, CardType cardType) {
//        var user = findUser(idx);
//        List<Chargeable> chargeables = null;
//        if(users.get(user) == null) {
//            users.put(user, new ArrayList<Chargeable>());
//        }
//        chargeables = users.get(user);
//
//        switch (cardType) {
//            case CREDIT -> chargeables.add(new CreditCard("1111-1111","2222-2222","2023-01-02"))
//
//        }
//    }
//
//}
