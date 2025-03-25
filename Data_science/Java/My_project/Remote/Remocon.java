package My_project;

public class Remocon<T> {
    private T device;

    public Remocon(T device) {
        this.device = device;
    }

    public T getDevice() {
        return device;
    }

    public void setDevice(T device) {
        this.device = device;
    }
}

class TV {
    private String brand;

    public TV(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void turnOn() {
        System.out.println("Tv On!!!");
    }
}
class Main__ {
    public static void main(String[] args) {
        TV tv = new TV("LG");
        Remocon<TV> tvRemocon = new Remocon<>(tv);
        var o = tvRemocon.getDevice().getBrand();
        System.out.println(o);
        tvRemocon.getDevice().turnOn();
    }
}
