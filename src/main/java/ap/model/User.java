package ap.model;

public class User {
    private int userId;
    private String name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {

        this.userId = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
