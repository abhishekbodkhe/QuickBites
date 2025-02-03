package com.app.project.main.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private double total;

	// A Cart can only belong to one User (one-to-one)
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	// A Cart can only belong to one Order (one-to-one)
	@OneToOne
	@JoinColumn(name = "order_id") // This links to order table
	private Order order;

	// Cart can have multiple CartItems
	@OneToMany(mappedBy = "cart")
	private List<CartItem> cartItems;

}
