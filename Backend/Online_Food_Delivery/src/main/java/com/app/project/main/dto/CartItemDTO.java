package com.app.project.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemDTO {

    private int cartItemId;
    private double totalPrice;
    private int quantity;
    private int foodId; // ID of the related Food entity
    private int cartId; // ID of the related Cart entity

}
