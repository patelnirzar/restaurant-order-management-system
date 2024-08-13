package com.api.roms.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.roms.dto.UserDto;
import com.api.roms.entities.JwtRequest;
import com.api.roms.entities.JwtResponse;
import com.api.roms.entities.User;
import com.api.roms.exception.ApiException;
import com.api.roms.security.JwtHelper;
import com.api.roms.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

	@Autowired
	private JwtHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/auth/login")
	public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest request) throws Exception {
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtResponse response = new JwtResponse();
		response.setJwtToken("Bearer " + token);
		System.out.println("Bearer " + token);
		response.setUserDto(this.mapper.map((User) userDetails, UserDto.class));
		return new ResponseEntity<JwtResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.authenticationManager.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");
		}

	}

	

}
