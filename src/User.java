import java.util.ArrayList;
import java.util.Objects;

public class User {
    //user attributes
    private final String username;
    private final String password;
    private static final ArrayList<User> users = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void generateTestUsers() {
        //collection of all users
        users.add(new User("p1", "p1"));
        users.add(new User("p2", "p2"));
        users.add(new User("p3", "p3"));
        users.add(new User("m1", "m1"));
        users.add(new User("m2", "m2"));
    }

    public static boolean checkValidUser(String username, String password) {
        //loop through the user collection and return true if there is a matching username and password
        for (User user : users) {
            if (Objects.equals(user.username, username) && Objects.equals(user.password, password)) {
                return true;
            }
        }
        return false;
    }
}
