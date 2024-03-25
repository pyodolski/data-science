package ch12;

public class Aircon {
    int size;
    int price;
    String brand;
    int temp = 10;

    String power = "Off";


    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPower(String power) {
        this.power = power;
    }
}

class remoteC {
    // Aircon aircon;
    // set aircon을 해서 사요해야함
    public void powerSet() {
        var aircon = new Aircon(); // 틀림
        if (aircon.power == "Off")
            aircon.setPower("On");
        else
            aircon.setPower("Off");
    }
    public void tempSetUp(int i) {
        var aircon = new Aircon();
        aircon.temp += i;
    }
    public void tempSetDown(int i) {
        var aircon = new Aircon();
        aircon.temp -= i;
    }
}

class AppUI1 {
    public static void main(String[] args) {
        var aircon = new Aircon();
        aircon.setBrand("Samsung");
        aircon.setPrice(1000);


    }
}
