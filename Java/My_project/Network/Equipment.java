package Day_20.Network;

import java.util.ArrayList;
import java.util.*;

class Network {
    private List<Equipment> equipments;
    private Connect connect;

    public Network() {
       this.equipments = new ArrayList<>();
    }
    public void connectEquipment(Equipment equipment) { equipment.connect(); } // 장비 추가
    public void connect(Connect connect) { connect.connect();}
}

public class Equipment {

    public Equipment() {
    }


    public void connect() {
        System.out.println("connect Network()");
    }


}
class Computer extends Equipment{
    boolean on = false;
    @Override
    public void connect() {
        super.connect();
        System.out.println("computer connect!");
    }
    public void keyboard(Boolean on) {
        System.out.println("keyboard on!");
    }
}
class Radio extends Equipment{

    @Override
    public void connect() {
        super.connect();
        System.out.println("radio connect!");
    }
}
class Printer {
    private Equipment equipment;

    public Printer(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
class Connect {
    private Printer printer;

    public Connect(Printer printer) {
        this.printer = printer;
        System.out.println("printer connect!");
    }
    public void connect() {
        System.out.println("connect Network()");
    }

    public Printer getPrinter() {
        return printer;
    }
}
class Main {
    public static void main(String[] args) {
        Network network = new Network();
        network.connectEquipment(new Computer());
        network.connectEquipment(new Radio());
        network.connect(new Connect(new Printer(new Equipment())));
        // 합성으로 등록 출력 순서가 안맞음 상속으로 하는게 맞는듯
        Equipment equipment = new Computer();
        equipment.connect();

        if (equipment instanceof Computer) {
            ((Computer)equipment).keyboard(true);
        }

    }
}
