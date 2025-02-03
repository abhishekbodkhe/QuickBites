package com.app.project.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.project.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom queries if needed
	Optional<User> findByEmail(String email); // Example of a custom query
}
