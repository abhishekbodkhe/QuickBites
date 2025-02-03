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
public class FoodDTO {

    private String itemName;
    private String description;
    private boolean available;
    private String category;
    private double price;
    private int menuId; // ID of the related Menu entity
    private List<Integer> orderItemIds; // List of OrderItem IDs related to this Food

}
