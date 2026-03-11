package com.foro.hub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.foro.hub.models.User;
import com.foro.hub.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class HubApplication implements CommandLineRunner {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setUsername("sure");
		user.setPassword(passwordEncoder.encode("0000"));

		var add = repository.save(user);
	}

}
