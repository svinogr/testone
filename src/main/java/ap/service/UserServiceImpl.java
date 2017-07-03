package ap.service;

import ap.dao.UserMapper;
import ap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("studentService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public User getUserById(int userId) {
		return  userMapper.getUser(userId);

	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	@Override
	public Integer createUser(User user) {
		return userMapper.createUser(user);
	}

	@Override
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public Integer deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

	@Override
	public Integer getCount() {
		return userMapper.getCount();
	}

	@Override
	public void createTable() {
		userMapper.createTable();
	}
}
