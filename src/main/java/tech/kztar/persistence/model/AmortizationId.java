package tech.kztar.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class AmortizationId implements Serializable {

	private static final long serialVersionUID = 1336776437289534820L;

	private UUID loanAccountId;

	private Date pymtDate;

	public AmortizationId() {

	}

	public AmortizationId(UUID loanAccountId, Date pymtDate) {
		this.loanAccountId = loanAccountId;
		this.pymtDate = pymtDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		AmortizationId amortSchId = (AmortizationId) obj;
		return loanAccountId.equals(amortSchId.loanAccountId) && pymtDate.equals(amortSchId.pymtDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanAccountId, pymtDate);
	}

}
