package com.app.project.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantDTO {

    private String name;
    private String email;
    private String mobileNo;
    private String description;
    private double ratings;
    private int menuId; 
    private int addressId; 
    private int ownerId; 

}
