package ch09.msg;

public class Customer {
    public String name;

    public String addr;

    public Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void sendMsg(String msg)
    {
        phone.sendMsg(msg);
    }
}
