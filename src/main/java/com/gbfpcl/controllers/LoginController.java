package com.gbfpcl.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.entities.AdminMaster;
import com.gbfpcl.jwtconfig.JwtAuthRequest;
import com.gbfpcl.jwtconfig.JwtTokenHelper;
import com.gbfpcl.jwtconfig.JwtUserDetailsService;
import com.gbfpcl.repositories.AdminRepo;

@RestController
@RequestMapping("auth/")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired 
	private AdminRepo adminRepo;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired 
	AuthenticationManager authenticationManager;
	
	@PostMapping("logIn")
	public ResponseEntity<Map<String,Object>> logInSuperAdmin(@RequestBody  JwtAuthRequest request){
		Map<String,Object> map= new HashMap<>();
		try {
			AdminMaster adminMaster=this.adminRepo.findByUsername(request.getUsername())
					.orElseThrow(null);
			
			UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
			this.authenticationManager.authenticate(authenticationToken);
			UserDetails userByName=	this.userDetailsService.loadUserByUsername(request.getUsername());
				String token=this.jwtTokenHelper.generateToken(userByName);
				if(token!=null) {
				map.put("jwtToken", token);
				//map.put("user",adminMaster );
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("Message", "Invalid Credentials");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);	
		
	}
	
	
	

}
