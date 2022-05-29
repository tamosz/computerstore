import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class User {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //user attributes
    private int id;
    private Boolean manager; //true = has management privileges
    private String username;
    private String password;
    private static ArrayList<User> users = new ArrayList<User>();

    public User(int id, Boolean manager, String username, String password) {
        this.id = id;
        this.manager = manager;
        this.username = username;
        this.password = password;
    }

    public void generateTestUsers(){
        //collection of all users
        users.add( new User(1, false, "p1", "p1"));
        users.add( new User(2, false, "p2", "p2"));
        users.add( new User(3, false, "p3", "p3"));
        users.add( new User(4, true, "m1", "m1"));
        users.add( new User(5, true, "m2", "m2"));
    }

    public static boolean checkValidUser(String username, String password){
        //loop through the user collection and return true if there is a matching username and password
        for (User user : users) {
            if (Objects.equals(user.username, username) && Objects.equals(user.password, password)) {
                return true;
            }
        }
        return false;
    }
}
