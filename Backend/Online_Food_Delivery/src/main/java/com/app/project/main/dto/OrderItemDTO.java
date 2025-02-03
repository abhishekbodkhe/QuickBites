package com.app.project.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemDTO {

    private int quantity;
    private double price;
    private int orderId; // ID of the related Order entity
    private int foodId; // ID of the related Food entity

}
