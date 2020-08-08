package cn.itcast.User;

public class User {
    private String username;
    private String passward;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public User(String username, String passward) {
        this.username = username;
        this.passward = passward;
    }
}
