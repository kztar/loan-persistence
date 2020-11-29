package tech.kztar.persistence.repo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.kztar.persistence.model.Amortization;
import tech.kztar.persistence.model.AmortizationId;

public interface AmortizationRepository extends JpaRepository<Amortization, AmortizationId> {

	List<Amortization> findAllByLoanAccountId(UUID loanAccountId);

	@Query("select a from Amortization a where a.loanAccountId in ?1")
	List<Amortization> findAllByLoanAccountIds(Iterable<UUID> loanAccountIds);

	@Query("select a from Amortization a where a.pymtDate >= ?1 and a.pymtDate < ?2")
	List<Amortization> findAllByPymtDateBetween(Date startDate, Date endDate);

}
