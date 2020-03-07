package lt.paulius.users.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lt.paulius.users.model.User;

@Repository
public interface UserDAO {

	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);

	User getUser(String username);
}
