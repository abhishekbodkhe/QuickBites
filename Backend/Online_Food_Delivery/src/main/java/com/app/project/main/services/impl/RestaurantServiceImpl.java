package com.app.project.main.services.impl;

import com.app.project.main.dto.RestaurantDTO;
import com.app.project.main.entities.Restaurant;
import com.app.project.main.repositories.RestaurantRepository;
import com.app.project.main.services.RestaurantService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RestaurantDTO> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants.stream().map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<RestaurantDTO> getRestaurantById(int id) {
		return restaurantRepository.findById(id).map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class));
	}

	@Override
	public void createRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = modelMapper.map(restaurantDTO, Restaurant.class);
		restaurantRepository.save(restaurant);
	}

	@Override
	public Optional<RestaurantDTO> updateRestaurant(int id, RestaurantDTO restaurantDTO) {
		Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
		if (existingRestaurant.isPresent()) {
			Restaurant restaurant = existingRestaurant.get();
			restaurant.setName(restaurantDTO.getName());
			restaurant.setEmail(restaurantDTO.getEmail());
			restaurant.setMobileNo(restaurantDTO.getMobileNo());
			restaurant.setDescription(restaurantDTO.getDescription());
			restaurant.setRatings(restaurantDTO.getRatings());
			restaurantRepository.save(restaurant);
			return Optional.of(modelMapper.map(restaurant, RestaurantDTO.class));
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteRestaurant(int id) {
		if (restaurantRepository.existsById(id)) {
			restaurantRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
