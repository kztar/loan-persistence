package tech.kztar.persistence.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tech.kztar.persistence.model.LoanAccount;

@Repository
@Transactional
public class LoanAccountRepositoryImpl implements LoanAccountRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Map<UUID, UUID> getBorrowerIdMappedByLoanAccountId(Iterable<UUID> loanAccountIds) {
		TypedQuery<LoanAccount> query = entityManager.createQuery("select la from LoanAccount la where la.id in (?1)",
				LoanAccount.class); // TODO Optimize to not load all the columns

		List<LoanAccount> resultList = query.setParameter(1, loanAccountIds).getResultList();

		Map<UUID, UUID> loanAccountIdToBorrowerIdMap = new HashMap<UUID, UUID>();
		for (LoanAccount la : resultList) {
			loanAccountIdToBorrowerIdMap.put(la.getId(), la.getBorrowerId());
		}

		return loanAccountIdToBorrowerIdMap;
	}

}
