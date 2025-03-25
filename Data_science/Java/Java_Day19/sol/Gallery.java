package ch22.sol;
// Alt + Enter
import java.util.*;


public class Gallery {
    private Long idx;
    private String email;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Gallery{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    private List<Comment> comments; // List <-> AarryList, Map <-> HashMap<> , Set <-> HashSet<>
    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Gallery(String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
        comments = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public void createComment(String email, String content) {
        comments.add(new Comment(email,content));
    }
}
class Board {
    private Set<User> users;
    private List<Gallery> galleries;
    private static Long idx = 1L;


    public static void createGallary(String email, String title, String content) {
        var gallery = new Gallery(email, title, content);
        gallery.setIdx(idx++);
    }

    public Gallery findGallery(Long galleryidx) {
        for (var gallery : galleries) {
            if (Objects.equals(gallery.getIdx(), idx)) return gallery;
        }
        return null;
    }

    public Board() {
        users = new HashSet<>();
        galleries = new ArrayList<>();
    }

    public void createUser(String email) {
        User user = new User(email);
        users.add(user);
    }

    public List<Gallery> findGalleryByEmail(String email) {
        List<Gallery> findMyGalleryWithComment = new ArrayList<>();
     return galleries;
    }
}


class User {
    private String email;
    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}
class Comment {
    private  String email;
    private String content;

    public Comment(String email, String content) {
        this.email = email;
        this.content = content;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }
}
class UI {
    public static void main(String[] args) {
        var board = new Board();
        board.createUser("k1");
        board.createUser("d1");

        board.createGallary("k1","T", "G");
        board.findGallery( 1L).createComment("d1","d");
        board.findGalleryByEmail("d1");

    }
}

