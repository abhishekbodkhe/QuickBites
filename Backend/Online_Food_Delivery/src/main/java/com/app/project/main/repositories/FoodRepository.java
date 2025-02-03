package com.app.project.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.project.main.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    // Add custom query methods here if needed
}
