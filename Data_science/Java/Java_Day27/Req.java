package Java_Day27;

public class Req<T> {
    private Header header;
    private T reqBody;
    public static class Header {
        private String responseCode;

        public Header(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseCode() {
            return responseCode;
        }
    }
}
class User{
    private String name;

}
class Main_ {
    public static void main(String[] args) {
        var req = new Req<User>();
        var header = new Req<Req.Header>();
    }
}
