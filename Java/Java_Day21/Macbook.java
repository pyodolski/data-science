package Java_Day21.override_t;

public class Macbook {
    private String brand;
    private String model;

    public Macbook(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public void turnOn() {
        System.out.println(brand + "device is turn on!");
    }
    public void turnOff() {
        System.out.println(brand + "device is turn off!");
    }
    public void open() {
        System.out.println(brand+" " + model + "is open");
    }
    public void close() {
        System.out.println(brand + " " + model + "is close");
    }
    public void runMacOS() {
        System.out.println("Running macOS on" + brand + " " + model);
    }
}
class GalaxyBook {
    private String brand;
    private String model;

    public GalaxyBook(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public void turnOn() {
        System.out.println(brand + "device is turn on!");
    }
    public void turnOff() {
        System.out.println(brand + "device is turn off!");
    }
    public void open() {
        System.out.println(brand+" " + model + "is open");
    }
    public void close() {
        System.out.println(brand + " " + model + "is close");
    }
    public void runAndroidOS() {
        System.out.println("Running macOS on" + brand + " " + model);
    }
}
class AppleWatch {
    private String brand;
    private String model;

    public AppleWatch(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public void turnOn() {
        System.out.println(brand + "device is turn on!");
    }
    public void turnOff() {
        System.out.println(brand + "device is turn off!");
    }

}

