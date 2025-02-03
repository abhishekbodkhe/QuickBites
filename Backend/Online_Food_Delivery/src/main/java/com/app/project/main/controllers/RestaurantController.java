package com.app.project.main.controllers;

import com.app.project.main.custom_exceptions.ResourceNotFoundException;
import com.app.project.main.dto.ApiResponse;
import com.app.project.main.dto.RestaurantDTO;
import com.app.project.main.services.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// Get All Restaurants
	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
		List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
		return ResponseEntity.ok(restaurants); // 200 OK
	}

	// Get Restaurant by ID
	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable int id) {
		RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
		return ResponseEntity.ok(restaurantDTO); // 200 OK
	}

	// Create a new Restaurant
	@PostMapping
	public ResponseEntity<ApiResponse> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		restaurantService.createRestaurant(restaurantDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Restaurant created successfully")); // 201
	}

	// Update an existing Restaurant
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateRestaurant(@PathVariable int id,
			@RequestBody RestaurantDTO restaurantDTO) {
		return restaurantService.updateRestaurant(id, restaurantDTO)
				.map(updated -> ResponseEntity.ok(new ApiResponse("Restaurant updated successfully"))) // 200 OK
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse("Restaurant not found with ID: " + id))); // 404 Not Found
	}

	// Delete a Restaurant by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteRestaurant(@PathVariable int id) {
		boolean isDeleted = restaurantService.deleteRestaurant(id);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(new ApiResponse("Restaurant deleted successfully")); // 204
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse("Restaurant not found with ID: " + id)); // 404
		}
	}
}
