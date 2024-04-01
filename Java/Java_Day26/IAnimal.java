package Java_Day26;

public interface IAnimal {
    String move(); // 추상화 함수만 제공.(인터페이스)
    String run(); // public abstract 앞에 붙어있음
}

class AppUI {
    public static void main(String[] args) {
        IAnimal dog = new IAnimal() {
            @Override
            public String move() {
                return "개가 짖습니다잉";
            }

            @Override
            public String run() {
                return "개가 달립니다잉";
            } // 런타임 때 활성화 시켜서 실행 시킬 수 있는 장점이 있다..
        };
        System.out.println(dog.move());
        System.out.println(dog.run());
    }
}
