package com.app.project.main.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.project.main.dto.FoodDTO;
import com.app.project.main.entities.Food;
import com.app.project.main.repositories.FoodRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Convert entity to DTO
	private FoodDTO convertToDTO(Food food) {
		return modelMapper.map(food, FoodDTO.class);
	}

	// Convert DTO to entity
	private Food convertToEntity(FoodDTO foodDTO) {
		return modelMapper.map(foodDTO, Food.class);
	}

	// Get all food items
	@GetMapping
	public List<FoodDTO> getAllFoods() {
		List<Food> foods = foodRepository.findAll();
		return foods.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// Get a single food item by ID
	@GetMapping("/{id}")
	public ResponseEntity<FoodDTO> getFoodById(@PathVariable int id) {
		return foodRepository.findById(id).map(food -> ResponseEntity.ok(convertToDTO(food)))
				.orElse(ResponseEntity.notFound().build());
	}

	// Add a new food item
	@PostMapping
	public FoodDTO createFood(@RequestBody FoodDTO foodDTO) {
		Food food = convertToEntity(foodDTO);
		Food savedFood = foodRepository.save(food);
		return convertToDTO(savedFood);
	}

	// Update a food item
	@PutMapping("/{id}")
	public ResponseEntity<FoodDTO> updateFood(@PathVariable int id, @RequestBody FoodDTO foodDetails) {
		return foodRepository.findById(id).map(food -> {
			food.setItemName(foodDetails.getItemName());
			food.setDescription(foodDetails.getDescription());
			food.setAvailable(foodDetails.isAvailable());
			food.setCategory(foodDetails.getCategory());
			food.setPrice(foodDetails.getPrice());
			return ResponseEntity.ok(convertToDTO(foodRepository.save(food)));
		}).orElse(ResponseEntity.notFound().build());
	}

	// Delete a food item
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFood(@PathVariable int id) {
		Optional<Food> optionalFood = foodRepository.findById(id);

		if (optionalFood.isPresent()) {
			foodRepository.delete(optionalFood.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
