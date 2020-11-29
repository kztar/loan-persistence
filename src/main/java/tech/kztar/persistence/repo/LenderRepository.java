package tech.kztar.persistence.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.Lender;

public interface LenderRepository extends JpaRepository<Lender, UUID> {
	
}
