package com.vpd.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
 public static void main(String[] a) {
	 System.out.println((new BCryptPasswordEncoder()).encode("pravin"));
 }
	 
}
