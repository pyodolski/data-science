package myproject;


import java.time.LocalDateTime;
import java.util.*;

public class User {
    private String name;
    private String email;
    private String address;
    private String nickname;
    private List<Post> posts;
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.posts = new ArrayList<>();
    }
    // setter Start
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    //setter End
    //getter Start
    public String getNickname() {
        return nickname;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public List<Post> getPost() { return posts; }
    //getter end
    public void addPost(Community community, String title, String content) {
        if (community.getUsers().contains(this)) {
            Post post = new Post(title, content);
            community.addPost(post); // 커뮤니티에 글 등록
            posts.add(post);
        } else {
            System.out.println("회원가입 X");
        }
    }
    public void addComment(Post post, String content) {
        Comment comment = new Comment(content, this);
        post.addComment(comment); // 해당 게시글이 댓글을 가지고 있다
    }
}
class Post{
    private int idIdx = 0;
    private int id;
    private String title;
    private String content;
    private LocalDateTime createdTime;
    private List<Comment> comments; // 각 게시글은 댓글을 가지고 있어야 함.
    public Post(String title, String content) {
        this.id += idIdx++;
        this.title = title;
        this.content = content;
        this.createdTime = LocalDateTime.now(); // 생성 시간
        this.comments = new ArrayList<>();
    }
    //getter Start
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
    public List<Comment> getComments() {
        return comments;
    }
    //getter End
    public void addComment(Comment comment){
        comments.add(comment);
    }
}
class Comment{
    private String content;
    private LocalDateTime createdTime;
    public Comment(String content, User commenter) {
        this.content = content;
        this.createdTime = LocalDateTime.now();
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
class Community{
    private List<Post> posts;
    private List<User> users;

    public Community() {
        this.posts = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public void addPost(Post post) {
        posts.add(post);
    }
    public void addUser(User user) {
        users.add(user);
    }
    public List<Post> getPosts() {
        return posts;
    }
    public List<User> getUsers() {
        return users;
    }
    public void printPostInfo(String email) {
        for (User user : this.getUsers())
        {
            if (user.getEmail() == email) {
                for (Post post : user.getPost()) {
                    System.out.println(post.getTitle() + " : " + post.getContent());
                }
                return ;
            } else {
                System.out.println("해당 이메일의 글이 없습니다.");
            }
        }
    }

}
class Main1 {
    public static void main(String[] args) {

        Community community = new Community(); // 커뮤니티 생성
        User pyo = new User("pyo", "pjwp0928w@gmail.com"); // User 1
        User kavin = new User("kavin", "kavin@gmail.com"); // User 2
        // 회원가입
        community.addUser(pyo);
        community.addUser(kavin);

        pyo.addPost(community,"Hello","My name is pyo");
        kavin.addComment(community.getPosts().get(0), "My name is kavin");
        community.printPostInfo("pjwp0928w@gmail.com");
    }
}
