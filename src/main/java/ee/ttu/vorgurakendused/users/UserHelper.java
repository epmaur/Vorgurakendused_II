package ee.ttu.vorgurakendused.users;

public class UserHelper {
    private String username;

    public UserHelper() {}

    public UserHelper (String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
