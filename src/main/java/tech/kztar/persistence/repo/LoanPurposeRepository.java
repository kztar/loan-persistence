package tech.kztar.persistence.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.LoanPurpose;

public interface LoanPurposeRepository extends JpaRepository<LoanPurpose, UUID> {

}
