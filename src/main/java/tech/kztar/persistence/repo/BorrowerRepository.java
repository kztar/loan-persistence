package tech.kztar.persistence.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.kztar.persistence.model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {

	/**
	 * Get a list of {@link Borrower} whose name contains the given keyword. <br>
	 * Note: the given keyword should be in small-case.
	 * 
	 * @param keyword
	 * @return {@link List} of {@link Borrower}s
	 */
	@Query("select b from Borrower b where lower(b.name) like %?1%")
	List<Borrower> searchForBorrowerName(String keyword);

	@Query(nativeQuery = true, value = "SELECT b.* FROM borrowers b"
			+ " WHERE b.id IN (SELECT distinct la.borrower_id FROM loan_accounts la WHERE la.id IN ?1)")
	List<Borrower> findAllByLoanAccountIds(Iterable<UUID> loanAccountIds);

}
