package com.example.immob.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.immob.dao.ActivityLogEntityRepo;
import com.example.immob.entities.ActivityLogEntity;
import com.example.immob.entities.ActivityType;
import com.example.immob.entities.AppRole;
import com.example.immob.entities.AppUser;
import com.example.immob.service.AccountService;
import com.example.immob.service.RegisterForm;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private ActivityLogEntityRepo activityLogEntityRepo;

	
	/*
	 * 
	 * 
	 * 		Créer un nouveau Utilisateur
	 * 
	 * */
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm registerForm) {
		if (!registerForm.getPassword().equals(registerForm.getRepassword())) {
			throw new RuntimeException("You must confirm your password");
		}
		AppUser appUser = accountService.findUserByUsername(registerForm.getUsername());
		if (appUser != null)
			throw new RuntimeException("this username already exist");
		AppUser user = new AppUser();
		user.setUsername(registerForm.getUsername());
		user.setPassword(registerForm.getPassword());
		user.setEmail(registerForm.getEmail());
		user.setNumTele(registerForm.getNumTele());
		user.setVille(registerForm.getVille());
		accountService.saveUser(user);
		accountService.addRoleToUser(registerForm.getUsername(), "USER");
		return user;
	}
	@GetMapping("/fetchAllUsers")
	@ResponseBody
	public Set<String> fetchAll(){
		return accountService.findAllByName();
	}
	
	@GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
		System.out.println("handling register user request: " + userName);
        AppUser user = accountService.findUserByUsername(userName);
        ActivityLogEntity entity = new ActivityLogEntity();
		entity.setUserName(user.getUsername());
		entity.setActivity(ActivityType.LOGIN);
		activityLogEntityRepo.save(entity);
        return ResponseEntity.ok().build();
    
    }
}
