package lt.paulius.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.paulius.users.dao.UserDAO;
import lt.paulius.users.model.User;
import lt.paulius.users.post.CreateUserCommand;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private final UserDAO userDao;

	@Autowired
	public UserController(UserDAO userDao) {

		this.userDao = userDao;
		userDao.createUser(new User("testusername1", "John", "surname1", "test@test.lt"));

	}

	@GetMapping
	@ApiOperation(value = "Get users", notes = "Returns registered users.")
	public List<User> getUsers() {
		return userDao.getUsers();

	}

	@GetMapping(path = "/{username}")
	@ApiOperation(value = "Get user", notes = "Returns user by username.")
	public User getUser(@ApiParam(value = "User ID", required = true) @PathVariable final String username) {
		System.out.println(userDao.getUser(username));
		return userDao.getUser(username);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody final CreateUserCommand postReceivedUserData) {

		System.out.println(postReceivedUserData);
		User newUserFromPost = new User();
		newUserFromPost.setUsername(postReceivedUserData.getUsername().toUpperCase());
		newUserFromPost.setFirstName(postReceivedUserData.getFirstName().toUpperCase());
		newUserFromPost.setLastName(postReceivedUserData.getLastName().toUpperCase());
		newUserFromPost.setEmail(postReceivedUserData.getEmail());
		userDao.createUser(newUserFromPost);
		return newUserFromPost;

	}

	@DeleteMapping(path = "/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable final String username) {
		System.out.println("Deleting user: " + username);
		userDao.deleteUser(username);

	}

}