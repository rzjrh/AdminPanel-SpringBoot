package com.rezaak.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rezaak.server.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
}
