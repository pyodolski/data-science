package Java_Day25;
interface Machine{};
public class GoundUint {
}
class Marine extends GoundUint{

}
class Scv extends GoundUint implements Machine{

}
class Tank extends GoundUint implements Machine{

}
class Main_ {
    public static void main(String[] args) {
        repair(new Tank());
     //   repair(new Marine());
    }
    // 다형성을 통해 메소드를 활용할 때
//    static void repair(GoundUint goundUint){
       // 마린은 기계가 아니다. 수리가?
//        if (goundUint instanceof Marine){
//            System.out.println("사람이야.. 정신차려");
//      }
    static void repair(Machine machine){
    }

}
