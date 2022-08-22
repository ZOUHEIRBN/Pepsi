package com.example.demo.Controller;

import com.example.demo.Entity.HR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("hr")
public class HRRest {
    
	@Autowired
	private AuthenticationManager authenticationManager;

	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody HR user) throws Exception {
		
		// user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		Authentication authObject = null;
		try {
			authObject = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
			);
			System.out.println(authObject.getAuthorities());
			
			// SecurityContextHolder.getContext().setAuthentication(authObject);
		} catch (BadCredentialsException e) {
			
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	

}
