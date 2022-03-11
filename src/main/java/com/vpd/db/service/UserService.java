package com.vpd.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpd.db.entity.UserEntity;
import com.vpd.db.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	 UserRepository userRepository;
	 public List<UserEntity> getUserList() {
		 List<UserEntity> userlist = new ArrayList<UserEntity>(); 
		 userRepository.findAll().forEach(userlist :: add);
		 userlist.forEach(u->System.out.println("userlist---->>>>"+u.toString()));
         return userlist;
		 
		 
	 }
	 public UserEntity  saveUser(UserEntity user) {
		 user=userRepository.save(user);
         return user;
         
	 }
	 public  Optional<UserEntity> getUserbyId(long id) {
		 List<UserEntity> user=userRepository.findByUserId(id);
		 Optional<UserEntity> x=null;
		 if(user.size()>0) x= Optional.of(user.get(0));
         return x;
		 
		 
	 }
	 public  List<UserEntity>   getUserbyNames(List<String> names) {
		 List<UserEntity> users=userRepository.findByMultipleUserName(names);
         return users;
	 }
	 public   List<UserEntity> getUserbyName(String name) {
		 List<UserEntity> users=userRepository.findByUserName(name);
         return users;
	 }
	 public  List<UserEntity> findByUserEmpNqo(long id) {
		 List<UserEntity> users=userRepository.findByUserEmpNo(id);
         return users;
	 }
	 public  List<UserEntity> findByUserEmpNoLessThen(long id) {
		 List<UserEntity> users=userRepository.findByUserEmpNoLessThan(id);
         return users;
	 }
}
