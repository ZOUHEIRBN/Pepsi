package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Entity.HR;
import com.example.demo.Repostory.IHR;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	private IHR hrrepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	private Map<Long, String> users = new HashMap<Long, String>();

	@PostMapping("/")
	public void addUser(@RequestBody HR user){
		
		user.setPassword(encoder.encode(user.getPassword()));
		hrrepo.save(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody HR user, HttpServletRequest request) throws Exception {
		
		// user.setPassword(encoder.encode(user.getPassword()));

		for(var u: users.keySet()){
			System.out.println(u + ":" + users.get(u));
		}
		UsernamePasswordAuthenticationToken authUP = new UsernamePasswordAuthenticationToken(
					user.getUsername(), 
					user.getPassword());
		Authentication authObject = null;
		String sessionId = null;
		try {
			authObject = authenticationManager.authenticate(authUP);
			// System.out.println(authObject.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authObject);
			sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
			// System.out.println(sessionId);
			// user.setSessionId(sessionId);
			
			System.out.println("User ID (line 75): " + user.getId());
			
			user = hrrepo.findByUsername(user.getUsername());
			users.putIfAbsent(user.getId(), sessionId);
			System.out.println("Connected!");
			
			request.getSession().setAttribute("USER_"+user.getId()+"_SSID", user.getId());
			System.out.println("\n\n\n\n\n");



		} catch (BadCredentialsException e) {
			System.out.println("Bad credentials");
		}catch (Exception e) {
			System.out.println(e);
			throw(e);
		}
		return sessionId;
	}
	

}
