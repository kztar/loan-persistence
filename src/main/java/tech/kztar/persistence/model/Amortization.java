package tech.kztar.persistence.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "amortization")
@IdClass(AmortizationId.class)
@Getter
@Setter
public class Amortization implements Comparable<Amortization> {

	@Id
	@Column(name = "loan_account_id")
	private UUID loanAccountId;

	@Id
	@Column(name = "pymt_date")
	private Date pymtDate;

	@Column(name = "installment")
	private Double installment;

	@Column(name = "principal")
	private Double principal;

	@Column(name = "interest")
	private Double interest;

	@Column(name = "grace_period")
	private Integer gracePeriod; // days

	@Column(name = "late_pymt_fee")
	private Float latePymtFee;

	@Override
	public int compareTo(Amortization amort) {
		return this.pymtDate.compareTo(amort.pymtDate);
	}

	/**
	 * Final payment date = Scheduled payment date + Grace period
	 * 
	 * @return final payment date
	 */
	public Date getFinalPymtDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(pymtDate);
		cal.add(Calendar.DAY_OF_MONTH, gracePeriod != null ? gracePeriod : 0);
		return cal.getTime();
	}

}
