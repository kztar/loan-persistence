package tech.kztar.persistence.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_purpose")
@Getter
@Setter
@NoArgsConstructor
public class LoanPurpose {

	@Id
	@Column(name = "loan_account_id")
	private UUID loanAccountId;

	@Column(name = "loan_type", nullable = false)
	private String loanType;

	private String tag1;

	private String tag2;

	private String tag3;

	private String tag4;

	private String tag5;

}
