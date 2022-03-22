package zaropot.message;

public class User {

    private Long id;
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public User(Long id, String userName) {
        this(userName);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
