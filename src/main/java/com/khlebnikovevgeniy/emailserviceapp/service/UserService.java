package com.khlebnikovevgeniy.emailserviceapp.service;

import com.khlebnikovevgeniy.emailserviceapp.domain.User;

public interface UserService {
	User saveUser(User user);
	Boolean verifyToken(String token);
}
