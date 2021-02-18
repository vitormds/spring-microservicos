package com.hr.oauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.oauth.entities.User;
import com.hr.oauth.feignclients.UserFeignClient;


@Service
public class UserService implements UserDetailsService {
	
 @Autowired
 private UserFeignClient client;
  private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
 public User findByEmail (String email) {
	 User user = client.findByEmail(email).getBody();
	 if(user == null) {
		 logger.error("Email not found"+ email);
		 throw new IllegalArgumentException("Email not found"+ email);
	 }
	 logger.info("Email found: "+ email);
	 return user;
 }
@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	 User user = client.findByEmail(email).getBody();
	 if(user == null) {
		 logger.error("Email not found"+ email);
		 throw new UsernameNotFoundException("Email not found"+ email);
	 }
	 logger.info("Email found: "+ email);
	 return user;
}

}
