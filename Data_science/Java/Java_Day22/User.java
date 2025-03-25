package Java_Day22;



public class User {
    private Long idx;
    private String email;
    public User(Long idx, String email){
        this.idx=idx;
        this.email=email;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                '}';
    }
}
