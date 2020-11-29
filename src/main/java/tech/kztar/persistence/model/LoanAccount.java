package tech.kztar.persistence.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LoanAccount implements Comparable<LoanAccount> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Setter
	@Column(name = "lender_id", nullable = false)
	private UUID lenderId;

	@Setter
	@Column(name = "borrower_id", nullable = false)
	private UUID borrowerId;

	@Column(name = "agreement_number", nullable = false)
	private String agreementNumber;

	@Column(name = "agreement_date", nullable = false)
	private Date agreementDate;

	@Column(name = "loan_amount", nullable = false)
	private Double loanAmount;

	@Column(name = "interest_rate", nullable = false)
	private Float interestRate;

	@Column(name = "duration_months", nullable = false)
	private Integer durationInMonths;

	@Column(name = "installment", nullable = false)
	private Double installment;

	@Setter
	@Column(name = "late_pymt_fee")
	private Float latePymtFee;

	@Setter
	@Column(name = "status")
	private String status;

	@Setter
	@Transient
	private LoanPurpose loanPurpose;

	public LoanAccount(String agreementNumber, Date agreementDate, double loanAmount, float interestRate,
			int durationInMonths, Double installment) {
		this.agreementNumber = agreementNumber;
		this.agreementDate = agreementDate;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.durationInMonths = durationInMonths;
		this.installment = installment;
	}

	@Override
	public int compareTo(LoanAccount loanAccount) {
		int result = agreementDate.compareTo(loanAccount.agreementDate);
		if (result == 0) {
			result = agreementNumber.compareTo(loanAccount.agreementNumber);
		}
		return result;
	}

	@Override
	public boolean equals(Object another) {
		if (!(another instanceof LoanAccount)) {
			return false;
		}

		LoanAccount anotherLoanAccount = (LoanAccount) another;

		if (id != null && anotherLoanAccount.id != null) {
			return id.equals(anotherLoanAccount.id);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
