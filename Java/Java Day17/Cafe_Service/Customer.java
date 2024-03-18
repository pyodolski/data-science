package ch19.sol;

import java.util.Objects;

public class Customer {
    private String email;
    private String name;
    private String addr;
    private String nickname;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
        this.nickname = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddr() {
        return addr;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.email, ((Customer)obj).email)
                && Objects.equals(this.name, ((Customer)obj).name);
    }
}
