package com.app.project.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.project.main.custom_exceptions.ResourceNotFoundException;
import com.app.project.main.dto.ApiResponse;
import com.app.project.main.dto.AuthRequest;
import com.app.project.main.dto.AuthResp;
import com.app.project.main.dto.UserDTO;
import com.app.project.main.security.JwtUtils;
import com.app.project.main.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager; // For authentication

	@Autowired
	private JwtUtils jwtUtils; // For JWT generation

	// Get All Users
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> users = userService.getAllUsers();
		return ResponseEntity.ok(users); // 200 OK
	}
	//http/host:port/api/users/3
	// Get User by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
		UserDTO userDTO = userService.getUserById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
		return ResponseEntity.ok(userDTO); // 200 OK
	}

	// Create a new User
	@PostMapping
	public ResponseEntity<ApiResponse> createUser(@RequestBody UserDTO userDTO) {
		try {
			userService.createUser(userDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User created successfully")); // 201
																													// Created
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse("An error occurred while creating the user")); // 500 Internal Server Error
		}
	}

	// Update an existing User
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
		return userService.updateUser(id, userDTO)
				.map(updatedUser -> ResponseEntity.ok(new ApiResponse("User updated successfully"))) // 200 OK
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse("User not found with ID: " + id))); // 404 Not Found
	}

	// Delete a User by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {
		boolean isDeleted = userService.deleteUser(id);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("User deleted successfully")); // 204
																													// No
																													// Content
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found with ID: " + id)); // 404
																														// Not
																														// Found
		}
	}

	// User Sign In (Authentication and JWT generation)
//	@PostMapping("/login")
//	public ResponseEntity<?> userLogin(@RequestBody AuthRequest dto) {
//		try {
//			System.out.println("in login in "+dto);
//			// Step 1: Create authentication token using email and password
//			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//					dto.getEmail(), dto.getPassword());
//			System.out.println("Username pass =====" + dto.getEmail() + dto.getPassword());
//			// Step 2: Authenticate using AuthenticationManager
//			Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//			// Step 3: Generate JWT token
//			String jwtToken = jwtUtils.generateJwtToken(authentication);
//
//			// Step 4: Return response with JWT token
//			return ResponseEntity.status(HttpStatus.OK).body(new AuthResp("Successful Authentication!", jwtToken));
//
//		} catch (Exception e) {
//			// Handle exception: Invalid credentials or any other issue
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//					.body(new ApiResponse("Authentication failed: " + e.getMessage()));
//		}
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userSignIn(@RequestBody 
			AuthRequest dto) {
		System.out.println("in sign in "+dto);
		//1. Create auth token using suser supplied em n pwd
		UsernamePasswordAuthenticationToken 
		authenticationToken = new UsernamePasswordAuthenticationToken
		(dto.getEmail(),dto.getPassword());
		System.out.println(authenticationToken.isAuthenticated());//f
		//2. invoke Spring sec supplied auth mgr's authenticate method
		Authentication authToken = 
				authenticationManager.authenticate(authenticationToken);
		//=> auth success
		System.out.println(authToken.isAuthenticated());//t
		//3 . Send auth respone to the client containing JWTS
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AuthResp("Successful Auth !",
						jwtUtils.generateJwtToken(authToken)));		
		
	}
}
