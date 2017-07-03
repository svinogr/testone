package ap.dao;

import ap.model.User;
import java.util.List;

public interface UserMapper {
    void createTable();
    User getUser(int userId);
    List<User> getAllUsers();
    Integer createUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(User user);
    Integer getCount();
}
