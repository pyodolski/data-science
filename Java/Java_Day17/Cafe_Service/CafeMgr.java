package ch19.sol;
import java.util.HashSet;
import java.util.Set;
public class CafeMgr {
    Set<Cafe> shops; // Map은 키 value 사용 나머진 동일
    public CafeMgr() {
        shops = new HashSet<>();
    }
    public void addCafe(Cafe cafe) {
        shops.add(cafe);
    }
    public Set<Cafe> allCafe() {
        return shops;
    }
}
