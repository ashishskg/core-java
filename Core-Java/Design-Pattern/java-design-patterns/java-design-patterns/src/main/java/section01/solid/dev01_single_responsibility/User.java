package section01.solid.dev01_single_responsibility;

import lombok.Data;

//User
@Data
public class User {

    private String name;

    private String email;

    private String address;

    public User() {

    }

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address=" + address + "]";
	}
}