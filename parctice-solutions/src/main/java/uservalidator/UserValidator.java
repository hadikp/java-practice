package uservalidator;

import java.util.ArrayList;
import java.util.List;

public class UserValidator { //week1125

    private List<User> users;

    public UserValidator(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (user.getAge() < 0 || user.getAge() > 120) {
            throw new IllegalArgumentException("A felhasználó nem lehet ennyi idős!");
        } else {
            users.add(user);
        }
    }

    public void validate() {
        if (users.size() == 0) {
            throw new IllegalArgumentException("A Users lista nem lehet üres!");
        }
        for (User u: users) {
           if (u == null) {
                throw new IllegalArgumentException("A felhasználó sem lehet null!");
            }
            System.out.println(u);
           /* if (u.getName() == null || u.getName().isBlank()) {
                throw new IllegalArgumentException("A felhasználó neve nem lehet üres!");
            }*/
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
