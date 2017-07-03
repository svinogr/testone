package ap.service;


import ap.model.User;
import java.util.List;

public interface UserService {
	User getUserById(int userId);
	List<User> getAllUsers();
	Integer createUser(User user);
	Integer updateUser(User user);
	Integer deleteUser(User user);
	Integer getCount();
	void createTable();
}
