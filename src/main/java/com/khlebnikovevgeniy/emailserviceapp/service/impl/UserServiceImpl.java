package com.khlebnikovevgeniy.emailserviceapp.service.impl;

import org.springframework.stereotype.Service;

import com.khlebnikovevgeniy.emailserviceapp.domain.Confirmation;
import com.khlebnikovevgeniy.emailserviceapp.domain.User;
import com.khlebnikovevgeniy.emailserviceapp.repository.ConfirmationRepository;
import com.khlebnikovevgeniy.emailserviceapp.repository.UserRepository;
import com.khlebnikovevgeniy.emailserviceapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final ConfirmationRepository confirmationRepository;

	@Override
	public User saveUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("User with this email already exists");
		}
		user.setEnabled(false);
		userRepository.save(user);
		Confirmation confirmation = new Confirmation(user);
		confirmationRepository.save(confirmation);
		
		//TODO Send email with token to the user.
		return user;
	}

	@Override
	public Boolean verifyToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
