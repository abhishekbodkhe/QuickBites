package com.app.project.main.services;

import com.app.project.main.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
	List<RestaurantDTO> getAllRestaurants();

	Optional<RestaurantDTO> getRestaurantById(int id);

	void createRestaurant(RestaurantDTO restaurantDTO);

	Optional<RestaurantDTO> updateRestaurant(int id, RestaurantDTO restaurantDTO);

	boolean deleteRestaurant(int id);
}
