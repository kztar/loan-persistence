package tech.kztar.persistence.repo;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.kztar.persistence.model.LoanAccount;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, UUID>, LoanAccountRepositoryCustom {

	LoanAccount findByLenderIdAndAgreementNumber(UUID lenderId, String agreementNumber);

	List<LoanAccount> findAllByLenderIdAndStatus(UUID lenderId, String status);

	Page<LoanAccount> findAllByLenderIdAndStatus(UUID lenderId, String status, Pageable pageable);

	@Query("select la from LoanAccount la where la.borrowerId in (?1)")
	List<LoanAccount> findByBorrowerIds(Set<UUID> borrowerIds);

	List<LoanAccount> deleteByBorrowerId(UUID borrowerId);

	/**
	 * Get a list of {@link LoanAccount} whose agreement number contains the given keyword. <br>
	 * Note: the given keyword should be in small-case.
	 * 
	 * @param keyword
	 * @return {@link List} of {@link LoanAccount}s
	 */
	@Query("select la from LoanAccount la where lower(la.agreementNumber) like %?1%")
	List<LoanAccount> searchForAgreementNumber(String keyword);

}
