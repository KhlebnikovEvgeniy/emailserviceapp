package com.khlebnikovevgeniy.emailserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khlebnikovevgeniy.emailserviceapp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailIgnireCase(String email);
	Boolean existsByEmail(String email);
}
