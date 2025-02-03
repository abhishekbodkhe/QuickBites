package com.app.project.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryPersonId;

	private String vehicleNumber;

	// Ensure only one user per delivery person
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", unique = true, nullable = false)
	private User user;

	// Ensure only one order per delivery person
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", unique = true, nullable = false)
	private Order order;

	@Override
	public String toString() {
		return "DeliveryPerson [deliveryPersonId=" + deliveryPersonId + ", vehicleNumber=" + vehicleNumber + ", user="
				+ user + ", order=" + order + "]";
	}
}
