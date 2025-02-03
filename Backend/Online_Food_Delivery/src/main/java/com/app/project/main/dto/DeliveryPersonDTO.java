package com.app.project.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryPersonDTO {

    private String vehicleNumber;
    private int userId; // ID of the related User entity
    private int orderId; // ID of the related Order entity

}
