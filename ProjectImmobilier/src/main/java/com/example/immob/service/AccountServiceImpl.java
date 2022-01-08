package com.example.immob.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.immob.dao.ActivityLogEntityRepo;
import com.example.immob.dao.BlockUserRepository;
import com.example.immob.dao.RoleRepository;
import com.example.immob.dao.UserRepository;
import com.example.immob.entities.AppRole;
import com.example.immob.entities.AppUser;
import com.example.immob.entities.BlockUserEntity;

/*
 * 
 * 			ce service création des utilisateurs et des roles
 * */
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private final ActivityLogEntityRepo activityLogEntityRepo;
	private final BlockUserRepository blockedUserRepo;
	
	public AccountServiceImpl(ActivityLogEntityRepo activityLogEntityRepo, BlockUserRepository blockedUserRepo) {
		super();
		this.activityLogEntityRepo = activityLogEntityRepo;
		this.blockedUserRepo = blockedUserRepo;
	}

	@Autowired
	@Lazy
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		//crypter le password d'abord avant l'enregistrer dans la base de données
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser user = userRepository.findByUsername(username);
		AppRole role = roleRepository.findByRoleName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public Boolean block(String angryName, String blockedName) {
		AppUser angry = userRepository.findByUsername(angryName);
		AppUser blocked = userRepository.findByUsername(blockedName);
		if(angry.getId() != null && blocked.getId() != null) {
			BlockUserEntity blockEntity = new BlockUserEntity();
			blockEntity.setAngryId(angry.getId());
			blockEntity.setBlockedId(blocked.getId());
			blockedUserRepo.save(blockEntity);
			return true;
		}	
		return false;
	}

	@Override
	public Boolean unblock(String angryName, String blockedName) {
		AppUser angry = userRepository.findByUsername(angryName);
		AppUser blocked = userRepository.findByUsername(blockedName);
		
		if(angry.getId() != null && blocked.getId()!= null) {
			try {
				blockedUserRepo.unblock(angry.getId(), blocked.getId());
			} 
			catch(Exception e){
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Boolean blockControl(String angryName, String blockedName) {
		AppUser angry = userRepository.findByUsername(angryName);
		AppUser blocked = userRepository.findByUsername(blockedName);
		List<BlockUserEntity> listOfBlock = blockedUserRepo.findAllByAngryId(angry.getId());
		ArrayList<Long> blockedIds = new ArrayList<Long>();
		int loop = listOfBlock.size();
		for(int flag = 0; flag<loop;flag++) {
			blockedIds.add(listOfBlock.get(flag).getBlockedId());
		}
		if(blockedIds.contains(blocked.getId())) {
			return true;
		}
		return false;
	}
	
	/*
	 * return All usernames from all users in the database
	 * */
	@Override
	public Set<String> findAllByName() {
		List<AppUser> listUsers = userRepository.findAll();
		Set<String> response = new HashSet<String>();
		listUsers.forEach(user ->{
			String name = user.getUsername();
			response.add(name);
		});
		
		return response;
	}
}
