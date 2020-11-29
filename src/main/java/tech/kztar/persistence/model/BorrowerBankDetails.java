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
@Table(name = "borrower_bank_details")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BorrowerBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Setter
	@Column(name = "borrower_id", nullable = false)
	private UUID borrowerId;

	@Setter
	@Column(name = "bank_name", nullable = false)
	private String bankName;

	@Setter
	@Column(name = "branch_name")
	private String branchName;

	@Setter
	@Column(name = "ifsc_code")
	private String ifscCode;

	@Setter
	@Column(name = "cheques")
	private String cheques;

	public BorrowerBankDetails(String bankName) {
		this.bankName = bankName;
	}

}
