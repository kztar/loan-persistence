package tech.kztar.persistence.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.IdentificationInfo;

public interface IdentificationInfoRepository extends JpaRepository<IdentificationInfo, UUID> {

	List<IdentificationInfo> findAllByBorrowerId(UUID borrowerId);

	List<IdentificationInfo> deleteByBorrowerId(UUID borrowerId);

}
