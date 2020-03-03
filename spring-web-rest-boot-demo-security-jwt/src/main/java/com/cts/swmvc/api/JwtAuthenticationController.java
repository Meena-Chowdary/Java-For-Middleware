package com.cts.swmvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swmvc.config.JwtTokenUtil;
import com.cts.swmvc.model.AppSecurityToken;
import com.cts.swmvc.model.AppUserEntity;
import com.cts.swmvc.model.AppUserModel;
import com.cts.swmvc.service.AppUserDetailsService;

@RestController			//RESTfull web services
@CrossOrigin			//for giving others to access to our middle ware
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AppUserDetailsService userDetailsService;
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AppUserModel user) throws Exception{
		authenticate(user.getUsername(),user.getPassword());	//if user is authenticated then this will go to next line or else it will go to entrypoint and raise exception
		final UserDetails userDetails=userDetailsService.loadUserByUsername(user.getUsername()); //storing user details 
		final String token=jwtTokenUtil.generateToken(userDetails);//storing token
		return ResponseEntity.ok(new AppSecurityToken(token));
	}
	
	private void authenticate(String username,String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<AppUserEntity> save(@RequestBody AppUserModel user) throws Exception{
		return ResponseEntity.ok(userDetailsService.save(user));
	}
}
