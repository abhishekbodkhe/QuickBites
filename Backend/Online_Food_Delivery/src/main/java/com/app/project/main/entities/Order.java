package com.app.project.main.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders") 
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private String orderStatus;
	private String orderDate;
	private double totalPrice;
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	
	@OneToOne(mappedBy = "order") 
	private Cart cart;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

}
