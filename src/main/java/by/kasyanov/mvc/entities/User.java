package by.kasyanov.mvc.entities;

public class User {
    private String userName;
    private String password;
    private boolean enabled;
    private int id;

    public User() {
    }

    public User(String username, String password, boolean enabled, int id) {
        this.userName = username;
        this.password = password;
        this.enabled = enabled;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
