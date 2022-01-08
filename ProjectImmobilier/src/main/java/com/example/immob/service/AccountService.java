package com.example.immob.service;


import java.util.Set;

import com.example.immob.entities.AppRole;
import com.example.immob.entities.AppUser;


//ce service est dédié au création des utilisateurs :

public interface AccountService {
	//Créer un user :
	public AppUser saveUser(AppUser user);
	//Créer un role :
	public AppRole saveRole(AppRole role);
	//Ajouter un role à la liste des roles d'un user 
	public void addRoleToUser(String username, String roleName);
	//chercher un utilisateur par son username :
	public AppUser findUserByUsername(String username);
	
	Boolean block(String angry, String blocked);
	
	Boolean unblock(String angry, String blocked);
	
	Boolean blockControl(String angry, String blocked);
	
	public Set<String> findAllByName();
}
