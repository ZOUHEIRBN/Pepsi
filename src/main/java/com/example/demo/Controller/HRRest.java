package com.example.demo.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.Entity.HR;
import com.example.demo.Enum.Role;
import com.example.demo.Services.HRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("hr")
public class HRRest {
    
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private HRService hr_service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	private Map<Long, String> users = new HashMap<Long, String>();

	@PostMapping("/")
	public void addUser(@RequestBody HR user){
		
		user.setPassword(encoder.encode(user.getPassword()));
		hr_service.addHR(user);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<String> login(@RequestBody HR user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// user.setPassword(encoder.encode(user.getPassword()));

		// for(var u: users.keySet()){
		// 	System.out.println(u + ":" + users.get(u));
		// }
		UsernamePasswordAuthenticationToken authUP = new UsernamePasswordAuthenticationToken(
					user.getUsername(), 
					user.getPassword());
		Authentication authObject = null;
		String sessionId = null;
		try {
			user = hr_service.findByUsername(user.getUsername());

			authObject = authenticationManager.authenticate(authUP);
	
		
			Collection<? extends GrantedAuthority> userAuthorities = user.getAuthorities();

			System.out.println("User authorites:" + userAuthorities);

			Authentication newAuth = new UsernamePasswordAuthenticationToken(
				authObject.getPrincipal(), authObject.getCredentials(), userAuthorities);

			SecurityContextHolder.getContext().setAuthentication(newAuth);
			
			sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();


			// System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
			users.putIfAbsent(user.getId(), sessionId);
			System.out.println("Connected with SSID: " + sessionId);
			
			// request.getSession().setAttribute("USER_"+user.getId()+"_SSID", user.getId());
			System.out.println("\n\n");



		} catch (BadCredentialsException e) {
			System.out.println("Bad credentials");
		}catch (Exception e) {
			System.out.println(e);
			throw(e);
		}
		final HttpHeaders httpHeaders= new HttpHeaders();
    	httpHeaders.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>(
			users.getOrDefault(user.getId(), null), httpHeaders, HttpStatus.OK);
	}
	private Long getUserBySessionId(String sessionId){
		for(Long uid: users.keySet()){
			if(users.get(uid).equals(sessionId)){
				return uid;
			}
		}
		return null;
	}
	
/* 	@GetMapping("/auth/roles/{sessionId}")
	public Role[] getRolesBySessionId(String sessionId){
		System.out.println("Roles of SSID: " + sessionId);
		List<Object> roles = hr_service.getUserRoles(getUserBySessionId(sessionId));
		System.out.println(roles);
		System.out.println("\n\n");
		return null;
	} */

	@DeleteMapping("/auth/{sessionId}")
	public void logout(@PathVariable String sessionId){
		System.out.println("Trying to remove:\t" + sessionId);
		users.remove(getUserBySessionId(sessionId));

	}
}
