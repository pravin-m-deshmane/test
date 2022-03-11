package com.vpd.db.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpd.db.entity.UserEntity;
import com.vpd.db.service.UserService;

@RestController
public class RequestController {
	@Autowired
	UserService userService;

   @Autowired
   PasswordEncoder passwordEncoder;

	
   @RequestMapping(value = "/helo")
   public String helo() {
	   return "gelp";
   }
   @RequestMapping(value = "/userlist")
   public List<UserEntity> userList() { 
	   return userService.getUserList();
   }
   @RequestMapping(value = "/saveUser")
   public  List<UserEntity> saveuser(@RequestBody UserEntity userEntity) {
	   System.out.println("----saveUser---");
	   userEntity.setUserPassword(passwordEncoder.encode(userEntity.getUserPassword()));
	   userService.saveUser(userEntity);
	   UserEntity en=new UserEntity(); 
	   en.setUserName("pravin");
	   en.setUserPassword(passwordEncoder.encode("pravin"));
	   en.setUserEmpNo(1);
	   en.setUserAddress("Pune");
	   userService.saveUser(en);
	   en=new UserEntity();
	   en.setUserName("sachin");
	   en.setUserPassword(passwordEncoder.encode("sachin"));
	   en.setUserEmpNo(2);
	   en.setUserAddress("Mumbai");
	   userService.saveUser(en);
	   en=new UserEntity();
	   en.setUserName("vijaya");
	   en.setUserPassword(passwordEncoder.encode("vijaya"));
	   en.setUserEmpNo(3);
	   en.setUserAddress("Abad");
	   userService.saveUser(en);
	   
	   return userService.getUserList();
   }
   @RequestMapping(value = "/userEmp/{empId}")
   public List<UserEntity> userList(@PathVariable long empId) { 
	   return userService.findByUserEmpNqo(empId);
   }
   @RequestMapping(value = "/userEmpCom/{empId}")
   public List<UserEntity> userEmpCom(@PathVariable long empId) { 
	   return userService.findByUserEmpNoLessThen(empId);
   }
   @RequestMapping(value = "/userEmpCos")
   public List<UserEntity> userbyNames() { 
	   List<String> st=new ArrayList<String>();
	   st.add("pravin");
	   st.add("sachin");
	   return userService.getUserbyNames(st);
   }
}
