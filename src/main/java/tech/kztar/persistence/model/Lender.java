package tech.kztar.persistence.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lenders")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Lender {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Setter
	@Column
	private String name;

	private String regNo;

	@Setter
	private String phoneNo;

	@Setter
	private String email;

	@Setter
	private String address;

	public Lender(String name, String regNo) {
		this.name = name;
		this.regNo = regNo;
	}

}
