package tech.kztar.persistence.repo;

import java.util.Map;
import java.util.UUID;

public interface LoanAccountRepositoryCustom {

	/**
	 * 
	 * @param loanAccountIds
	 * @return a map of loanAccountId to borrowerId
	 */
	Map<UUID, UUID> getBorrowerIdMappedByLoanAccountId(Iterable<UUID> loanAccountIds);

}
