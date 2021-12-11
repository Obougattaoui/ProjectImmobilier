package com.example.immob.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.immob.entities.AppUser;

/*
 * Aprés attempt authentication:
 * 		Spring SecurityFilterChain ::: loadByUserName to UserDetailsServce Implementation to get
 * 		username + roles
 * */
@Service
public class UserDeatilsServiceImpl implements UserDetailsService{
	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//chercher si cet user existe ou non
		AppUser user = accountService.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		//GranteAuthority(dans le filre de spring security) = les roles
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(r ->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
