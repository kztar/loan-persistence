package tech.kztar.persistence.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_repymts")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LoanRepayment implements Comparable<LoanRepayment> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "loan_account_id")
	private UUID loanAccountId;

	@Setter
	@Column(name = "repymt_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date repymtTs;

	@Setter
	@Column(name = "repymt_amt")
	private Double repymtAmt;

	@Setter
	@Column(name = "principal_part")
	private Double principalPart;

	@Setter
	@Column(name = "interest_part")
	private Double interestPart;

	@Setter
	@Column(name = "fine_amt")
	private Double fineAmt;

	@Setter
	@Column(name = "pymt_mode")
	private String pymtMode;

	@Setter
	@Column(name = "ref_no")
	private String refNo;

	@Setter
	@Column(name = "rcpt_no")
	private String rcptNo;

	@Setter
	private String comment;

	public LoanRepayment(UUID loanAccountId) {
		this.loanAccountId = loanAccountId;
	}

	@Override
	public int compareTo(LoanRepayment loanRepymt) {
		return this.repymtTs.compareTo(loanRepymt.repymtTs);
	}

}
