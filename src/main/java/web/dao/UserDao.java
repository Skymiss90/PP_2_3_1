package web.dao;
import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getUser(long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
