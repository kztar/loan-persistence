package tech.kztar.persistence.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.BorrowerBankDetails;

public interface BorrowerBankDetailsRepository extends JpaRepository<BorrowerBankDetails, UUID> {

	List<BorrowerBankDetails> findAllByBorrowerId(UUID borrowerId);

}
