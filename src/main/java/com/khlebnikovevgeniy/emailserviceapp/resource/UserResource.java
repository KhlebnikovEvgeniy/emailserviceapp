package com.khlebnikovevgeniy.emailserviceapp.resource;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khlebnikovevgeniy.emailserviceapp.domain.HttpResponse;
import com.khlebnikovevgeniy.emailserviceapp.domain.User;
import com.khlebnikovevgeniy.emailserviceapp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<HttpResponse> createUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return ResponseEntity.created(URI.create("")).body(
							HttpResponse.builder()
										.timeStamp(LocalDateTime.now().toString())
										.data(Map.of("user", newUser))
										.message("User created")
										.httpStatus(HttpStatus.CREATED)
										.statusCode(HttpStatus.CREATED.value())
										.build()
		);
	}
	
	@GetMapping
	public ResponseEntity<HttpResponse> confirmUserAccount(@RequestParam("token") String token) {
		Boolean isSuccess = userService.verifyToken(token);
		return ResponseEntity.ok().body(
							HttpResponse.builder()
										.timeStamp(LocalDateTime.now().toString())
										.data(Map.of("success", isSuccess))
										.message("Account verified")
										.httpStatus(HttpStatus.OK)
										.statusCode(HttpStatus.OK.value())
										.build()
		);
	}
	
}
