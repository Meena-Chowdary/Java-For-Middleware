package com.cts.swmvc.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.swmvc.dao.AppUserEntityRepository;
import com.cts.swmvc.model.AppUserEntity;
import com.cts.swmvc.model.AppUserModel;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserEntityRepository userDao; //dao interface object

	@Autowired
	private PasswordEncoder bcryptEncoder;  //encrypted password is stored in database for that reason we are using PasswordEncoder

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //retrieve user based on user name
		AppUserEntity user = userDao.findByUsername(username);
		if (user == null) {			//if user is not found then we throw predefined exception given by spring
			throw new UsernameNotFoundException("User not found with username: " + username); //if exception occurs then it goes to entry point where error msg is raised that you are not a authorized user
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(),    //user name,password,roles must be passed and as we don't have any role we are giving empty array
				new ArrayList<>());	//here pswd is encrypted as before storing only we are encrypting it
	}
	
	public AppUserEntity save(AppUserModel userDTO) {				//In model pswd is plain text but entity and database will always have encrypted format of pswd
		AppUserEntity user = new AppUserEntity();
		user.setUsername(userDTO.getUsername());
		user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userDao.save(user);
	}

}