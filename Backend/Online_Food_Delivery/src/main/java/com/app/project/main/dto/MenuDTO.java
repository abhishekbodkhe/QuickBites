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
public class MenuDTO {

    private List<Integer> foodIds; // List of Food IDs related to the Menu
    private int restaurantId; // ID of the related Restaurant entity

}
