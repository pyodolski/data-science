package Java_Day26;

public class book {
    private String title;
    private Author author;
    public void something() {

    }
    public static class Author {
        // inner outer를 정의할 때 서로간의 인접관계를 따져서 적절하게 사용
        private String name;
        private String addr;
        public void something() {
        }
    }
}

class Main__{
    public static void main(String[] args) {
        book.Author author = new book.Author();
        // 객체이기 떄문에 new를 사용해야 함
        author.something();
    }
}