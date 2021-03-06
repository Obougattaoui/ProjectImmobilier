package com.example.immob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.immob.entities.AppRole;
import com.example.immob.entities.AppUser;
import com.example.immob.service.AccountService;

@SpringBootApplication
public class ProjectImmobilierApplication implements CommandLineRunner{
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectImmobilierApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null, "admin", "1234", null));
		accountService.saveUser(new AppUser(null, "user", "1234", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
	
	}

}
