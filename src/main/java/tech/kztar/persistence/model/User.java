package tech.kztar.persistence.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

	@Id
	private String username;

	private String password;

	@Setter
	private String role;

	@Setter
	private String name;

	@Setter
	@Column(name = "phone_no")
	private String phoneNo;

	@Setter
	private String email;

	@Setter
	@Column(name = "lender_id")
	private UUID lenderId;

	@Setter
	private String status;

	@Setter
	@Column(name = "auth_token")
	private String authToken;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
