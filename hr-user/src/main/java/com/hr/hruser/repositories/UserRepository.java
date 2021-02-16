package com.hr.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hr.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
