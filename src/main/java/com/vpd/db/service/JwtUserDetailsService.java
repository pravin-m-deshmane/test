package com.vpd.db.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vpd.db.entity.UserEntity;
 

public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		long id=Long.parseLong(username);
		if(id==1) {
			return new User(username,"$2a$10$sbm3AzZ4szi6JQhgQrMd5OOvEQXuWwg4UV4g35KQqtzTNxzk9NOaC",new ArrayList<>());
		}else {
		 Optional<UserEntity> opt=userService.getUserbyId(id);
		 if(opt.isPresent()) {
			   UserEntity userEntity =opt.get();
			   if (userEntity.getUserId() ==  id) {
					return new User(username,userEntity.getUserPassword(),new ArrayList<>());
				} else {
					throw new UsernameNotFoundException("User not found with username: " + username);
				}
		 } else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	}
}