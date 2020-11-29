package tech.kztar.persistence.repo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.kztar.persistence.model.LoanRepayment;

public interface LoanRepaymentRepository extends JpaRepository<LoanRepayment, UUID> {

	List<LoanRepayment> findAllByLoanAccountId(UUID loanAccountId);

	@Query("select r from LoanRepayment r where r.loanAccountId in ?1")
	List<LoanRepayment> findAllByLoanAccountIds(Iterable<UUID> loanAccountIds);

	@Query(nativeQuery = true, value = "SELECT lr.* FROM loan_repymts lr"
			+ " JOIN loan_accounts la ON lr.loan_account_id = la.id" + " WHERE la.lender_id = ?1 AND lr.repymt_ts >= ?2")
	List<LoanRepayment> findAllAfter(UUID lenderId, Date startDate);

	/**
	 * Find {@link LoanRepayment} objects whose repayment time is between given startDate (inclusive) and endDate
	 * (inclusive)
	 * 
	 * @param lenderId
	 * @param startDate
	 * @param endDate
	 * @return list of {@link LoanRepayment}
	 */
	@Query(nativeQuery = true, value = "SELECT lr.* FROM loan_repymts lr"
			+ " JOIN loan_accounts la ON lr.loan_account_id = la.id"
			+ " WHERE la.lender_id = ?1 AND lr.repymt_ts >= ?2 AND lr.repymt_ts <= ?3")
	List<LoanRepayment> findAllBetween(UUID lenderId, Date startDate, Date endDate);

	@Query(nativeQuery = true, value = "SELECT case when count(*) > 0 then true else false end FROM loan_repymts lr"
			+ " JOIN loan_accounts la ON lr.loan_account_id = la.id WHERE la.lender_id = ?1 AND lr.rcpt_no = ?2")
	boolean isRcptNoUsed(UUID lenderId, String rcptNo);

}
