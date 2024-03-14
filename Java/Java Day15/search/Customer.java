package ch16;

import java.util.Objects;

public class Customer {
    String name;
    String email;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.email,((Customer) obj).email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    public Customer(String email){
        this("no name",email);
    }
    public Customer(String name, String email){
        this.name=name;
        this.email=email;
    }
}
