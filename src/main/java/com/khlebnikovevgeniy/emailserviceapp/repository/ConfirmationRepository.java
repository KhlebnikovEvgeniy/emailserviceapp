package com.khlebnikovevgeniy.emailserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khlebnikovevgeniy.emailserviceapp.domain.Confirmation;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
	Confirmation findByToken(String token);
}
