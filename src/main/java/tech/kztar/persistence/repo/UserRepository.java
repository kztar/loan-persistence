package tech.kztar.persistence.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.kztar.persistence.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

	List<User> findByLenderId(UUID lenderId);

	List<User> findByLenderIdAndStatus(UUID lenderId, String status);

	User findByAuthToken(String authToken);

}
