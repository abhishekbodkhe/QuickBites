package com.app.project.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {
	private String city;
	private String postalCode;
	private String state;
	private String country;
	private int locationId; // ID of the related Location entity
}
