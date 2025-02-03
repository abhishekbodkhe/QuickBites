package com.app.project.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private String orderStatus;
    private String orderDate;
    private double totalPrice;
    private int quantity;
    private int userId; // ID of the related User entity
    private int restaurantId; // ID of the related Restaurant entity
    private int addressId; // ID of the related Address entity
    private int cartId; // ID of the related Cart entity
    private List<Integer> orderItemIds; // List of OrderItem IDs related to this Order

}
