package lt.paulius.users.post;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateUserCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String username;
	@NotNull
	@Length(min = 1, max = 100)
	private String firstName;
	@NotNull
	@Length(min = 1, max = 100)
	private String lastName;
	@NotNull
	@Length(min = 1, max = 200)
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

}
