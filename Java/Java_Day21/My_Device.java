package Java_Day21.override_t;
import java.util.*;
public class My_Device {
    List<Device> devices;

    public My_Device() {
        devices = new ArrayList<>();
    }
    public void addDevice(Device device) {
        devices.add(device);
    }
    public void runNow(Device device) {
        if (device instanceof MacBook) {
            ((MacBook) device).turnOn();
        }
        else if(device instanceof Galaxybook)
        {
            ((Galaxybook)devices).turnOff();
        }
        else ((Applewatch)devices).trackingWatch();
    }

    public List<Device> getDevices() {
        return devices;
    }
}
class Device {
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {

    }
    public void turnOff() {

    }


}
class NoteBook extends Device{
    private String model;
    public NoteBook(String brand, String model) {
        super(brand);
        this.model = model;
    }

    public void open() {

    }
    public void close() {

    }
}

class Watch extends Device{
    private String model;
    public Watch(String brand, String model) {
        super(brand);
        this.model = model;
    }

    public void trackingWatch() {

    }
}
class MacBook extends NoteBook{ // 다중 상속을 통해서 클래스 고유 기능에 집중할 수 있음
    public MacBook(String brand, String model) {
        super(brand, model);
    }
}
class Galaxybook extends NoteBook{
    public Galaxybook(String brand, String model) {
        super(brand, model);
    }
}
class Applewatch extends Watch{
    public Applewatch(String brand, String model) {
        super(brand, model);
    }
}

class MAin {
    public static void main(String[] args) {
        var my_Device = new My_Device();
        Device device = new MacBook("Samsung", "book pro");
        my_Device.addDevice(device);
    }
}

