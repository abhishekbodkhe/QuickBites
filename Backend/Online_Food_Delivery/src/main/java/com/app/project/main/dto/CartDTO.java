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
public class CartDTO {

    private double total;
    private int userId; // Representing the user reference by its ID
    private int orderId; // Representing the order reference by its ID
    private List<Integer> cartItemIds; // Representing the list of CartItem IDs

}
