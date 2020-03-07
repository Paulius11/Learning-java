package lt.paulius.users.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import lt.paulius.users.model.User;

@Repository
public class InMemoryUserDAO implements UserDAO {
	private final List<User> userList = new CopyOnWriteArrayList<>();

	@Override
	public List<User> getUsers() {

		return Collections.unmodifiableList(userList);

	}

	@Override
	public void createUser(User user) {
		userList.add(user);

	}

	@Override
	public void deleteUser(String username) {
		for (User user : userList) {

			if (username.equals(user.getUsername())) {
				userList.remove(user);
				break;

			}

		}

	}

	@Override
	public User getUser(String username) {
		return userList.stream().filter(x -> x.getUsername().equals(username)).findAny().orElse(null);
	}
}
