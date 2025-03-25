package Java_Day25;

import Java_Day24.MyJson;

// Sport와 Guitar는 아무관계 없음
// 하지만 하나의 타입으로 관리할 수 있음
public class Sport implements Behavior {
    public void outTeam() {

    }

    @Override
    public void play() {

    }
}

class Guitar implements Behavior {
    public void electronic() {
    }

    @Override
    public void play() {

    }
}
interface Behavior {
    void play();
}

class Main {
    public static void main(String[] args) {
        play(new Sport());
        play(new Guitar());
    }
    public static void play(Behavior behavior) {
        behavior.play();;
    }
}