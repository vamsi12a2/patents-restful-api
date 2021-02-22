package com.springpro.rest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByUsername(String username);
}
