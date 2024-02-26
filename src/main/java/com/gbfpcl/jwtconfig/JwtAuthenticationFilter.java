package com.gbfpcl.jwtconfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//1.get token
		String tokenRequest=request.getHeader("Authorization");
		String Username=null;
		String token=null;
		
		if(tokenRequest!=null && tokenRequest.startsWith("Bearer")) {
			System.out.println("total  "+tokenRequest);
			
			 token= tokenRequest.substring(7);
			 System.out.println("token "+token);
			 try {
				 Username= this.jwtTokenHelper.getUsernameFromToken(token);
				 System.out.println("name "+Username);
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get jwt token");
			}
			 catch(ExpiredJwtException e){
				 System.out.println("token expires!!!");
			} catch(MalformedJwtException e){
				 System.out.println("Invalid jwt!!!");
			}
			 
		}else {
			System.out.println("jwt token does not start with  bearer");
		}
		
		
		////2.Validate token
		
		if(Username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
	UserDetails userDetails=this.jwtUserDetailsService.loadUserByUsername(Username);
			
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				//Authenticate karaych aahe
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities() );
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);		
						}else {
							System.out.println("Invalid jwt token!!");
						}
			
		}else {
			System.out.println("Username is null and context is not null");
		}
		
		filterChain.doFilter(request, response);
	}
		

}
