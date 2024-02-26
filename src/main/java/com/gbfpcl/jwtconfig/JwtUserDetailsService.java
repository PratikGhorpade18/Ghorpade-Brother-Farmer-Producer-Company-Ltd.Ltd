package com.gbfpcl.jwtconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gbfpcl.entities.AdminMaster;
import com.gbfpcl.repositories.AdminRepo;
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepo adminRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminMaster adminMaster =adminRepo.findByUsername(username).orElse(null);
		return adminMaster;
	}

}
