package com.example.immob.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.immob.entities.AppUser;
import com.example.immob.service.AccountService;
import com.example.immob.service.RegisterForm;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm registerForm) {
		return accountService.registerUser(registerForm);
	}
	@GetMapping("/fetchAllUsers")
	@ResponseBody
	public Set<String> fetchAll(){
		return accountService.findAllByName();
	}
	
	@GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
		accountService.registrationActivityLog(userName);
        return ResponseEntity.ok().build();
    
    }
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		accountService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping("{id}")
	public ResponseEntity<AppUser> updateUser(@PathVariable("id") Long id, AppUser newUser){
		AppUser user = accountService.updateUser(id, newUser);
		return ResponseEntity.ok(user);
	}
}
