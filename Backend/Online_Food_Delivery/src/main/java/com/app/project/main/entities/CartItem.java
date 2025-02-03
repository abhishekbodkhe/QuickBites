package com.app.project.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Entity for CartItem
@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	private double totalPrice;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

// Getters and Setters
}
