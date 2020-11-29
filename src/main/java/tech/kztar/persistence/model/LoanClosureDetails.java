package tech.kztar.persistence.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_closure_details")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LoanClosureDetails {

	@Id
	@Column(name = "loan_account_id")
	private UUID loanAccountId;

	@Setter
	@Column(name = "noc_issued", nullable = false)
	private boolean nocIssued;

	@Setter
	@Column(name = "noc_issued_on")
	private Date nocIssuedOn;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public LoanClosureDetails(UUID loanAccountId) {
		this.loanAccountId = loanAccountId;
	}

	@PrePersist
	void doBeforePersist() {
		createdAt = new Date();
	}

	@PreUpdate
	void doBeforeUpdate() {
		updatedAt = new Date();
	}

}
