package com.app.project.main.services;

import com.app.project.main.dto.UserDTO;
import com.app.project.main.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

	// Retrieve all users as DTOs
	List<UserDTO> getAllUsers();

	// Retrieve a single user by ID as DTO
	Optional<UserDTO> getUserById(int id);

	Optional<User> getUserByEmail(String email);

	// Create a new user from a DTO
	UserDTO createUser(UserDTO userDTO);

	// Update an existing user by ID using a DTO
	Optional<UserDTO> updateUser(int id, UserDTO userDTO);

	// Delete a user by ID
	boolean deleteUser(int id);
}
