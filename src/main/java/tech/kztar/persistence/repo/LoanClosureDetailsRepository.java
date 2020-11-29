package tech.kztar.persistence.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.LoanClosureDetails;

public interface LoanClosureDetailsRepository extends JpaRepository<LoanClosureDetails, UUID> {

}
